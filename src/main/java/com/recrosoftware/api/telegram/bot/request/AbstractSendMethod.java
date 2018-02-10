package com.recrosoftware.api.telegram.bot.request;

import com.fasterxml.jackson.core.type.TypeReference;
import com.recrosoftware.api.telegram.bot.annotation.Serialize;
import com.recrosoftware.api.telegram.bot.annotation.UseMediaType;
import com.recrosoftware.api.telegram.bot.model.KeyboardMarkup;
import com.recrosoftware.api.telegram.bot.model.Message;
import com.recrosoftware.api.telegram.bot.model.api.ApiResponse;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

import javax.ws.rs.core.MediaType;

/**
 * This is the abstract method used to send messages to a specific chat.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public abstract class AbstractSendMethod<T extends AbstractSendMethod<T, Q>, Q extends KeyboardMarkup> extends AbstractRequestItem<Message> {
    private static final String FIELD_CHAT_ID = "chat_id";
    private static final String FIELD_DISABLE_NOTIFICATION = "disable_notification";
    private static final String FIELD_REPLY_TO_MESSAGE_ID = "reply_to_message_id";
    private static final String FIELD_REPLY_MARKUP = "reply_markup";

    /**
     * Unique identifier for the target chat.
     */
    @Required
    @Validate(as = FIELD_CHAT_ID)
    @Serialize(as = FIELD_CHAT_ID)
    private String chatId;

    /**
     * Optional.
     * Sends the message silently. Users will receive a notification with no sound.
     */
    @Serialize(as = FIELD_DISABLE_NOTIFICATION)
    private Boolean disableNotification;

    /**
     * If the message is a reply, ID of the original message.
     */
    @Serialize(as = FIELD_REPLY_TO_MESSAGE_ID)
    private Integer replyToMessageId;

    /**
     * Additional interface options.
     * A JSON-serialized object for an inline keyboard, custom reply keyboard, instructions to remove reply keyboard or to force a reply from the user.
     */
    @Serialize(as = FIELD_REPLY_MARKUP)
    @UseMediaType(MediaType.APPLICATION_JSON)
    private Q replyMarkup;

    protected AbstractSendMethod(String method) {
        super(method, new TypeReference<ApiResponse<Message>>() {
        });
    }

    public String getChatId() {
        return chatId;
    }

    @SuppressWarnings("unchecked")
    public T setChatId(String chatId) {
        this.chatId = chatId;
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T setChatId(Long chatId) {
        if (chatId == null) {
            this.chatId = null;
        } else {
            this.chatId = chatId.toString();
        }
        return (T) this;
    }

    public Boolean getDisableNotification() {
        return disableNotification;
    }

    @SuppressWarnings("unchecked")
    public T setDisableNotification(Boolean disableNotification) {
        this.disableNotification = disableNotification;
        return (T) this;
    }

    public Integer getReplyToMessageId() {
        return replyToMessageId;
    }

    @SuppressWarnings("unchecked")
    public T setReplyToMessageId(Integer replyToMessageId) {
        this.replyToMessageId = replyToMessageId;
        return (T) this;
    }

    public Q getReplyMarkup() {
        return replyMarkup;
    }

    @SuppressWarnings("unchecked")
    public T setReplyMarkup(Q replyMarkup) {
        this.replyMarkup = replyMarkup;
        return (T) this;
    }
}
