package com.recrosoftware.api.telegram.bot;

import com.fasterxml.jackson.core.type.TypeReference;
import com.recrosoftware.api.telegram.bot.model.api.ApiResponse;
import com.recrosoftware.api.telegram.bot.request.AbstractRequestItem;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
class MethodDeleteWebhook extends AbstractRequestItem<Boolean> {
    MethodDeleteWebhook() {
        super("deleteWebhook", new TypeReference<ApiResponse<Boolean>>() {
        });
    }
}
