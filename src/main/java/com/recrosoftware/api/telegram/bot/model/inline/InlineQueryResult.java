package com.recrosoftware.api.telegram.bot.model.inline;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.recrosoftware.api.telegram.bot.model.InlineKeyboardMarkup;
import com.recrosoftware.utils.validation.Validable;
import com.recrosoftware.utils.validation.annotation.Range;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

/**
 * This object represents one result of an inline query.
 * Telegram clients currently support results of the following 20 types:
 * <ul>
 * <li>{@link InlineQueryResultCachedAudio}
 * <li>{@link InlineQueryResultCachedDocument}
 * <li>{@link InlineQueryResultCachedGif}
 * <li>{@link InlineQueryResultCachedMpeg4Gif}
 * <li>{@link InlineQueryResultCachedPhoto}
 * <li>{@link InlineQueryResultCachedSticker}
 * <li>{@link InlineQueryResultCachedVideo}
 * <li>{@link InlineQueryResultCachedVoice}
 * <li>{@link InlineQueryResultArticle}
 * <li>{@link InlineQueryResultAudio}
 * <li>{@link InlineQueryResultContact}
 * <li>{@link InlineQueryResultGame}
 * <li>{@link InlineQueryResultDocument}
 * <li>{@link InlineQueryResultGif}
 * <li>{@link InlineQueryResultLocation}
 * <li>{@link InlineQueryResultMpeg4Gif}
 * <li>{@link InlineQueryResultPhoto}
 * <li>{@link InlineQueryResultVenue}
 * <li>{@link InlineQueryResultVideo}
 * <li>{@link InlineQueryResultVoice}
 * </ul>
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "unchecked", "WeakerAccess", "UnusedReturnValue"})
public abstract class InlineQueryResult<T extends InlineQueryResult> implements Validable {
    public static final String TYPE_AUDIO = "audio";
    public static final String TYPE_DOCUMENT = "document";
    public static final String TYPE_GIF = "gif";
    public static final String TYPE_MPEG4_GIF = "mpeg4_gif";
    public static final String TYPE_PHOTO = "photo";
    public static final String TYPE_STICKER = "sticker";
    public static final String TYPE_VIDEO = "video";
    public static final String TYPE_VOICE = "voice";
    public static final String TYPE_ARTICLE = "article";
    public static final String TYPE_CONTACT = "contact";
    public static final String TYPE_GAME = "game";
    public static final String TYPE_LOCATION = "location";
    public static final String TYPE_VENUE = "venue";

    protected static final String FIELD_TYPE = "type";
    protected static final String FIELD_ID = "id";
    protected static final String FIELD_INPUT_MESSAGE_CONTENT = "input_message_content";
    protected static final String FIELD_REPLY_MARKUP = "reply_markup";

    /**
     * Type of the result, depend on the response type.
     */
    @Required
    @Validate(as = FIELD_TYPE)
    @JsonProperty(FIELD_TYPE)
    protected final String type;

    /**
     * Unique identifier for this result, 1-64 Bytes.
     */
    @Required
    @Range(from = 1, to = 64)
    @Validate(as = FIELD_ID)
    @JsonProperty(FIELD_ID)
    protected String id;

    /**
     * Optional (depend on the response type).
     * Content of the message to be sent.
     */
    @Validate(as = FIELD_INPUT_MESSAGE_CONTENT)
    @JsonProperty(FIELD_INPUT_MESSAGE_CONTENT)
    protected InputMessageContent inputMessageContent;

    /**
     * Optional.
     * Inline keyboard attached to the message.
     */
    @JsonProperty(FIELD_REPLY_MARKUP)
    protected InlineKeyboardMarkup replyMarkup;


    public InlineQueryResult(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public T setType(String type) {
        // No operations
        return (T) this;
    }

    public String getId() {
        return id;
    }

    public T setId(String id) {
        this.id = id;
        return (T) this;
    }

    public InputMessageContent getInputMessageContent() {
        return inputMessageContent;
    }

    public T setInputMessageContent(InputMessageContent inputMessageContent) {
        this.inputMessageContent = inputMessageContent;
        return (T) this;
    }

    public InlineKeyboardMarkup getReplyMarkup() {
        return replyMarkup;
    }

    public T setReplyMarkup(InlineKeyboardMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
        return (T) this;
    }
}
