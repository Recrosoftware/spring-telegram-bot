package com.recrosoftware.api.telegram.bot.request.update;

import com.recrosoftware.api.telegram.bot.annotation.Serialize;
import com.recrosoftware.api.telegram.bot.model.InlineKeyboardMarkup;
import com.recrosoftware.api.telegram.bot.request.AbstractBooleanOrMessage;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public abstract class AbstractEditMessage<T extends AbstractEditMessage> extends AbstractBooleanOrMessage {
    private static final String FIELD_CHAT_ID = "chat_id";
    private static final String FIELD_MESSAGE_ID = "message_id";
    private static final String FIELD_INLINE_MESSAGE_ID = "inline_message_id";
    private static final String FIELD_REPLY_MARKUP = "reply_markup";

    @Required(with = FIELD_MESSAGE_ID, or = FIELD_INLINE_MESSAGE_ID)
    @Validate(as = FIELD_CHAT_ID)
    @Serialize(as = FIELD_CHAT_ID)
    private String chatId;

    @Required
    @Validate(as = FIELD_MESSAGE_ID)
    @Serialize(as = FIELD_MESSAGE_ID)
    private Integer messageId;

    @Required(or = FIELD_CHAT_ID)
    @Validate(as = FIELD_INLINE_MESSAGE_ID)
    @Serialize(as = FIELD_INLINE_MESSAGE_ID)
    private String inlineMessageId;

    @Serialize(as = FIELD_REPLY_MARKUP)
    private InlineKeyboardMarkup replyMarkup;

    protected AbstractEditMessage(String method) {
        super(method);
    }

    public String getChatId() {
        return chatId;
    }

    @SuppressWarnings("unchecked")
    public T setChatId(String chatId) {
        this.inlineMessageId = null;
        this.chatId = chatId;
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T setChatId(Long chatId) {
        this.inlineMessageId = null;
        if (chatId == null) {
            this.chatId = null;
        } else {
            this.chatId = chatId.toString();
        }
        return (T) this;
    }

    public Integer getMessageId() {
        return messageId;
    }

    @SuppressWarnings("unchecked")
    public T setMessageId(Integer messageId) {
        this.inlineMessageId = null;
        this.messageId = messageId;
        return (T) this;
    }

    public String getInlineMessageId() {
        return inlineMessageId;
    }

    @SuppressWarnings("unchecked")
    public T setInlineMessageId(String inlineMessageId) {
        this.chatId = null;
        this.messageId = null;
        this.inlineMessageId = inlineMessageId;
        return (T) this;
    }

    public InlineKeyboardMarkup getReplyMarkup() {
        return replyMarkup;
    }

    @SuppressWarnings("unchecked")
    public T setReplyMarkup(InlineKeyboardMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
        return (T) this;
    }
}
