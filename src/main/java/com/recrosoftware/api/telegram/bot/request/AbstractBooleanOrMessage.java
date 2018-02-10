package com.recrosoftware.api.telegram.bot.request;

import com.fasterxml.jackson.core.type.TypeReference;
import com.recrosoftware.api.telegram.bot.model.Message;
import com.recrosoftware.api.telegram.bot.model.api.ApiResponse;

import javax.ws.rs.core.Response;

public abstract class AbstractBooleanOrMessage extends AbstractRequestItem<Object> {
    protected AbstractBooleanOrMessage(String method) {
        super(method, null);
    }

    @Override
    public ApiResponse<Object> parseResponse(Response response) {
        Object parsedResult = null;
        ApiResponse parsed = this.getApiResponse(response, new TypeReference<ApiResponse<Boolean>>() {
        });

        if (parsed != null && parsed.getResult() != null) {
            parsedResult = parsed.getResult();
        }

        if (parsed == null) {
            parsed = this.getApiResponse(response, new TypeReference<ApiResponse<Message>>() {
            });

            if (parsed != null && parsed.getResult() != null) {
                parsedResult = parsed.getResult();
            }
        }

        if (parsed != null) {
            return new ApiResponse<>()
                    .setOk(parsed.getOk())
                    .setResult(parsedResult)
                    .setDescription(parsed.getDescription())
                    .setErrorCode(parsed.getErrorCode())
                    .setParameters(parsed.getParameters());
        }

        return null;
    }
}
