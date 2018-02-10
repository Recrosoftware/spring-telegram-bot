package com.recrosoftware.api.telegram.bot.request;

import com.fasterxml.jackson.core.type.TypeReference;
import com.recrosoftware.api.telegram.bot.annotation.Serialize;
import com.recrosoftware.api.telegram.bot.model.ChatMember;
import com.recrosoftware.api.telegram.bot.model.api.ApiResponse;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public class GetChatMember extends AbstractRequestItem<ChatMember> {
    private static final String FIELD_CHAT_ID = "chat_id";
    private static final String FIELD_USER_ID = "user_id";

    @Required
    @Validate(as = FIELD_CHAT_ID)
    @Serialize(as = FIELD_CHAT_ID)
    private String chatId;

    @Required
    @Validate(as = FIELD_USER_ID)
    @Serialize(as = FIELD_USER_ID)
    private Integer userId;

    public GetChatMember() {
        super("getChatMember", new TypeReference<ApiResponse<ChatMember>>() {
        });
    }

    public String getChatId() {
        return chatId;
    }

    public GetChatMember setChatId(String chatId) {
        this.chatId = chatId;
        return this;
    }

    public GetChatMember setChatId(Long chatId) {
        if (chatId == null) {
            this.chatId = null;
        } else {
            this.chatId = chatId.toString();
        }
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public GetChatMember setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }
}
