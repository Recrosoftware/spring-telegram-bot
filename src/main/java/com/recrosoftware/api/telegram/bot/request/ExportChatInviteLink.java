package com.recrosoftware.api.telegram.bot.request;

import com.fasterxml.jackson.core.type.TypeReference;
import com.recrosoftware.api.telegram.bot.annotation.Serialize;
import com.recrosoftware.api.telegram.bot.model.api.ApiResponse;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public class ExportChatInviteLink extends AbstractRequestItem<String> {
    private static final String FIELD_CHAT_ID = "chat_id";

    @Required
    @Validate(as = FIELD_CHAT_ID)
    @Serialize(as = FIELD_CHAT_ID)
    private String chatId;

    public ExportChatInviteLink() {
        super("exportChatInviteLink", new TypeReference<ApiResponse<String>>() {
        });
    }

    public String getChatId() {
        return chatId;
    }

    public ExportChatInviteLink setChatId(String chatId) {
        this.chatId = chatId;
        return this;
    }

    public ExportChatInviteLink setChatId(Long chatId) {
        if (chatId == null) {
            this.chatId = null;
        } else {
            this.chatId = chatId.toString();
        }
        return this;
    }
}
