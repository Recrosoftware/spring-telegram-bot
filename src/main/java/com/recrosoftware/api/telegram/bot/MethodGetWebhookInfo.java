package com.recrosoftware.api.telegram.bot;

import com.fasterxml.jackson.core.type.TypeReference;
import com.recrosoftware.api.telegram.bot.model.api.ApiResponse;
import com.recrosoftware.api.telegram.bot.request.AbstractRequestItem;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
class MethodGetWebhookInfo extends AbstractRequestItem<Boolean> {
    MethodGetWebhookInfo() {
        super("getWebhookInfo", new TypeReference<ApiResponse<Boolean>>() {
        });
    }
}
