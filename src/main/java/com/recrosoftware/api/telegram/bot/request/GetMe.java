package com.recrosoftware.api.telegram.bot.request;

import com.fasterxml.jackson.core.type.TypeReference;
import com.recrosoftware.api.telegram.bot.model.User;
import com.recrosoftware.api.telegram.bot.model.api.ApiResponse;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public class GetMe extends AbstractRequestItem<User> {
    public GetMe() {
        super("getMe", new TypeReference<ApiResponse<User>>() {
        });
    }
}
