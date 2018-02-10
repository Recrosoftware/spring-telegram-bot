package com.recrosoftware.api.telegram.bot.request;

import com.fasterxml.jackson.core.type.TypeReference;
import com.recrosoftware.api.telegram.bot.annotation.Serialize;
import com.recrosoftware.api.telegram.bot.model.api.ApiResponse;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public class PinChatMessage extends AbstractRequestItem<Boolean> {
    private static final String FIELD_CHAT_ID = "chat_id";
    private static final String FIELD_MESSAGE_ID = "message_id";
    private static final String FIELD_DISABLE_NOTIFICATION = "disable_notification";

    @Required
    @Validate(as = FIELD_CHAT_ID)
    @Serialize(as = FIELD_CHAT_ID)
    private String chatId;

    @Required
    @Validate(as = FIELD_MESSAGE_ID)
    @Serialize(as = FIELD_MESSAGE_ID)
    private Integer messageId;

    @Serialize(as = FIELD_DISABLE_NOTIFICATION)
    private Boolean disableNotification;

    public PinChatMessage() {
        super("pinChatMessage", new TypeReference<ApiResponse<Boolean>>() {
        });
    }

    public String getChatId() {
        return chatId;
    }

    public PinChatMessage setChatId(String chatId) {
        this.chatId = chatId;
        return this;
    }

    public PinChatMessage setChatId(Long chatId) {
        if (chatId == null) {
            this.chatId = null;
        } else {
            this.chatId = chatId.toString();
        }
        return this;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public PinChatMessage setMessageId(Integer messageId) {
        this.messageId = messageId;
        return this;
    }

    public Boolean getDisableNotification() {
        return disableNotification;
    }

    public PinChatMessage setDisableNotification(Boolean disableNotification) {
        this.disableNotification = disableNotification;
        return this;
    }
}
