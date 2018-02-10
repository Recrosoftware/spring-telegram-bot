package com.recrosoftware.api.telegram.bot.request;

import com.fasterxml.jackson.core.type.TypeReference;
import com.recrosoftware.api.telegram.bot.annotation.Serialize;
import com.recrosoftware.api.telegram.bot.model.Message;
import com.recrosoftware.api.telegram.bot.model.api.ApiResponse;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public class ForwardMessage extends AbstractRequestItem<Message> {
    private static final String FIELD_CHAT_ID = "chat_id";
    private static final String FIELD_FROM_CHAT_ID = "from_chat_id";
    private static final String FIELD_MESSAGE_ID = "message_id";
    private static final String FIELD_DISABLE_NOTIFICATION = "disable_notification";

    @Required
    @Validate(as = FIELD_CHAT_ID)
    @Serialize(as = FIELD_CHAT_ID)
    private String chatId;

    @Required
    @Validate(as = FIELD_FROM_CHAT_ID)
    @Serialize(as = FIELD_FROM_CHAT_ID)
    private String fromChatId;

    @Required
    @Validate(as = FIELD_MESSAGE_ID)
    @Serialize(as = FIELD_MESSAGE_ID)
    private Integer messageId;

    @Serialize(as = FIELD_DISABLE_NOTIFICATION)
    private Boolean disableNotification;

    public ForwardMessage() {
        super("forwardMessage", new TypeReference<ApiResponse<Message>>() {
        });
    }

    public String getChatId() {
        return chatId;
    }

    public ForwardMessage setChatId(String chatId) {
        this.chatId = chatId;
        return this;
    }

    public ForwardMessage setChatId(Long chatId) {
        if (chatId == null) {
            this.chatId = null;
        } else {
            this.chatId = chatId.toString();
        }
        return this;
    }

    public String getFromChatId() {
        return fromChatId;
    }

    public ForwardMessage setFromChatId(String fromChatId) {
        this.fromChatId = fromChatId;
        return this;
    }

    public ForwardMessage setFromChatId(Long fromChatId) {
        if (fromChatId == null) {
            this.fromChatId = null;
        } else {
            this.fromChatId = fromChatId.toString();
        }
        return this;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public ForwardMessage setMessageId(Integer messageId) {
        this.messageId = messageId;
        return this;
    }

    public Boolean getDisableNotification() {
        return disableNotification;
    }

    public ForwardMessage setDisableNotification(Boolean disableNotification) {
        this.disableNotification = disableNotification;
        return this;
    }
}
