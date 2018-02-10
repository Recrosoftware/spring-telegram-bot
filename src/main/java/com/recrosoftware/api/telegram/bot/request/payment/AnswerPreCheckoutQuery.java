package com.recrosoftware.api.telegram.bot.request.payment;

import com.fasterxml.jackson.core.type.TypeReference;
import com.recrosoftware.api.telegram.bot.annotation.Serialize;
import com.recrosoftware.api.telegram.bot.model.api.ApiResponse;
import com.recrosoftware.api.telegram.bot.request.AbstractRequestItem;
import com.recrosoftware.utils.validation.ValidationError;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public class AnswerPreCheckoutQuery extends AbstractRequestItem<Boolean> {
    private static final String FIELD_PRE_CHECKOUT_QUERY_ID = "pre_checkout_query_id";
    private static final String FIELD_OK = "ok";
    private static final String FIELD_ERROR_MESSAGE = "error_message";

    @Required
    @Validate(as = FIELD_PRE_CHECKOUT_QUERY_ID)
    @Serialize(as = FIELD_PRE_CHECKOUT_QUERY_ID)
    private String preCheckoutQueryId;

    @Required
    @Validate(as = FIELD_OK)
    @Serialize(as = FIELD_OK)
    private Boolean ok;

    @Serialize(as = FIELD_ERROR_MESSAGE)
    private String errorMessage;

    public AnswerPreCheckoutQuery() {
        super("answerPreCheckoutQuery", new TypeReference<ApiResponse<Boolean>>() {
        });
    }

    public String getPreCheckoutQueryId() {
        return preCheckoutQueryId;
    }

    public AnswerPreCheckoutQuery setPreCheckoutQueryId(String preCheckoutQueryId) {
        this.preCheckoutQueryId = preCheckoutQueryId;
        return this;
    }

    public Boolean getOk() {
        return ok;
    }

    public AnswerPreCheckoutQuery setOk(Boolean ok) {
        this.ok = ok;
        return this;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public AnswerPreCheckoutQuery setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    @Override
    public List<ValidationError> validate(String prefix) {
        if (ok != null && !ok && errorMessage == null) {
            return Collections.singletonList(new ValidationError(prefix + FIELD_ERROR_MESSAGE, "Required field, (if 'ok' field is false)."));
        }
        return null;
    }
}
