package com.recrosoftware.api.telegram.bot.request;

import com.recrosoftware.api.telegram.bot.annotation.Serialize;
import com.recrosoftware.api.telegram.bot.model.InlineKeyboardMarkup;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public class StopMessageLiveLocation extends AbstractBooleanOrMessage {
    private static final String FIELD_CHAT_ID = "chat_id";
    private static final String FIELD_MESSAGE_ID = "message_id";
    private static final String FIELD_INLINE_MESSAGE_ID = "inline_message_id";

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
    private InlineKeyboardMarkup replyMarkup;

    public StopMessageLiveLocation() {
        super("stopMessageLiveLocation");
    }

    public String getChatId() {
        return chatId;
    }

    public StopMessageLiveLocation setChatId(String chatId) {
        this.chatId = chatId;
        this.inlineMessageId = null;
        return this;
    }

    public StopMessageLiveLocation setChatId(Long chatId) {
        if (chatId == null) {
            this.chatId = null;
        } else {
            this.chatId = chatId.toString();
        }
        this.inlineMessageId = null;
        return this;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public StopMessageLiveLocation setMessageId(Integer messageId) {
        this.messageId = messageId;
        this.inlineMessageId = null;
        return this;
    }

    public String getInlineMessageId() {
        return inlineMessageId;
    }

    public StopMessageLiveLocation setInlineMessageId(String inlineMessageId) {
        this.chatId = null;
        this.messageId = null;
        this.inlineMessageId = inlineMessageId;
        return this;
    }

    public InlineKeyboardMarkup getReplyMarkup() {
        return replyMarkup;
    }

    public StopMessageLiveLocation setReplyMarkup(InlineKeyboardMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
        return this;
    }
}
