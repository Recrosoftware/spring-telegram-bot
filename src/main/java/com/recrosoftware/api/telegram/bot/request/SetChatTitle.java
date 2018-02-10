package com.recrosoftware.api.telegram.bot.request;

import com.fasterxml.jackson.core.type.TypeReference;
import com.recrosoftware.api.telegram.bot.annotation.Serialize;
import com.recrosoftware.api.telegram.bot.model.api.ApiResponse;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public class SetChatTitle extends AbstractRequestItem<Boolean> {
    private static final String FIELD_CHAT_ID = "chat_id";
    private static final String FIELD_TITLE = "title";

    @Required
    @Validate(as = FIELD_CHAT_ID)
    @Serialize(as = FIELD_CHAT_ID)
    private String chatId;

    @Required
    @Validate(as = FIELD_TITLE)
    @Serialize(as = FIELD_TITLE)
    private String title;

    public SetChatTitle() {
        super("setChatTitle", new TypeReference<ApiResponse<Boolean>>() {
        });
    }

    public String getChatId() {
        return chatId;
    }

    public SetChatTitle setChatId(String chatId) {
        this.chatId = chatId;
        return this;
    }

    public SetChatTitle setChatId(Long chatId) {
        if (chatId == null) {
            this.chatId = null;
        } else {
            this.chatId = chatId.toString();
        }
        return this;
    }

    public String getTitle() {
        return title;
    }

    public SetChatTitle setTitle(String title) {
        this.title = title;
        return this;
    }
}
