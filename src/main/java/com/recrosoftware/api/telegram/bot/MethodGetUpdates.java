package com.recrosoftware.api.telegram.bot;

import com.fasterxml.jackson.core.type.TypeReference;
import com.recrosoftware.api.telegram.bot.model.Update;
import com.recrosoftware.api.telegram.bot.model.api.ApiResponse;
import com.recrosoftware.api.telegram.bot.request.AbstractRequestItem;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;

import java.util.List;
import java.util.Objects;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
class MethodGetUpdates extends AbstractRequestItem<List<Update>> {
    private int lastUpdate;

    MethodGetUpdates() {
        super("getUpdates", new TypeReference<ApiResponse<List<Update>>>() {
        });

        this.lastUpdate = -1;
    }

    void setLastUpdate(int lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    int getLastUpdate() {
        return lastUpdate;
    }

    @Override
    protected FormDataMultiPart prepareRequestEntity() {
        FormDataMultiPart request = new FormDataMultiPart();

        request.field("timeout", ((Integer) ((TelegramBotApi.REQUEST_TIMEOUT * 3) / 4)).toString());
        if (this.lastUpdate > 0)
            request.field("offset", Objects.toString(lastUpdate));

        return request;
    }
}
