package com.recrosoftware.api.telegram.bot.request;

import com.recrosoftware.api.telegram.bot.annotation.Serialize;
import com.recrosoftware.api.telegram.bot.annotation.UseMediaType;
import com.recrosoftware.api.telegram.bot.model.InlineKeyboardMarkup;
import com.recrosoftware.utils.validation.annotation.Range;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

import javax.ws.rs.core.MediaType;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public class EditMessageLiveLocation extends AbstractBooleanOrMessage {
    private static final String FIELD_CHAT_ID = "chat_id";
    private static final String FIELD_MESSAGE_ID = "message_id";
    private static final String FIELD_INLINE_MESSAGE_ID = "inline_message_id";
    private static final String FIELD_LATITUDE = "latitude";
    private static final String FIELD_LONGITUDE = "longitude";
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

    @Required
    @Range(from = -90, to = 90)
    @Validate(as = FIELD_LATITUDE)
    @Serialize(as = FIELD_LATITUDE)
    private Float latitude;

    @Required
    @Range(from = -180, to = 180)
    @Validate(as = FIELD_LONGITUDE)
    @Serialize(as = FIELD_LONGITUDE)
    private Float longitude;

    @Serialize(as = FIELD_REPLY_MARKUP)
    @UseMediaType(MediaType.APPLICATION_JSON)
    private InlineKeyboardMarkup replyMarkup;

    public EditMessageLiveLocation() {
        super("editMessageLiveLocation");
    }

    public String getChatId() {
        return chatId;
    }

    public EditMessageLiveLocation setChatId(String chatId) {
        this.chatId = chatId;
        this.inlineMessageId = null;
        return this;
    }

    public EditMessageLiveLocation setChatId(Long chatId) {
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

    public EditMessageLiveLocation setMessageId(Integer messageId) {
        this.messageId = messageId;
        this.inlineMessageId = null;
        return this;
    }

    public String getInlineMessageId() {
        return inlineMessageId;
    }

    public EditMessageLiveLocation setInlineMessageId(String inlineMessageId) {
        this.chatId = null;
        this.messageId = null;
        this.inlineMessageId = inlineMessageId;
        return this;
    }

    public Float getLatitude() {
        return latitude;
    }

    public EditMessageLiveLocation setLatitude(Float latitude) {
        this.latitude = latitude;
        return this;
    }

    public Float getLongitude() {
        return longitude;
    }

    public EditMessageLiveLocation setLongitude(Float longitude) {
        this.longitude = longitude;
        return this;
    }

    public InlineKeyboardMarkup getReplyMarkup() {
        return replyMarkup;
    }

    public EditMessageLiveLocation setReplyMarkup(InlineKeyboardMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
        return this;
    }
}
