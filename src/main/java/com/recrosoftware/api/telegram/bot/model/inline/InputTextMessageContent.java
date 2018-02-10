package com.recrosoftware.api.telegram.bot.model.inline;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.recrosoftware.api.telegram.bot.request.SendMessage;
import com.recrosoftware.utils.validation.annotation.Range;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

import java.io.Serializable;

/**
 * Represents the content of a text message to be sent as the result of an inline query.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class InputTextMessageContent implements InputMessageContent, Serializable {
    public static final long serialVersionUID = 3005000L;

    private static final String FIELD_MESSAGE_TEXT = "message_text";
    private static final String FIELD_PARSE_MODE = "parse_mode";
    private static final String FIELD_DISABLE_WEB_PAGE_PREVIEW = "disable_web_page_preview";

    /**
     * Text of the message to be sent, 1-4096 characters.
     */
    @Required
    @Range(from = 1, to = 4096)
    @Validate(as = FIELD_MESSAGE_TEXT)
    @JsonProperty(FIELD_MESSAGE_TEXT)
    private String messageText;

    /**
     * Optional.
     * Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text or inline URLs in your bot's message.
     */
    @JsonProperty(FIELD_PARSE_MODE)
    private SendMessage.ParseMode parseMode;

    /**
     * Optional.
     * Disables link previews for links in the sent message.
     */
    @JsonProperty(FIELD_DISABLE_WEB_PAGE_PREVIEW)
    private Boolean disableWebPagePreview;

    public String getMessageText() {
        return messageText;
    }

    public InputTextMessageContent setMessageText(String messageText) {
        this.messageText = messageText;
        return this;
    }

    public SendMessage.ParseMode getParseMode() {
        return parseMode;
    }

    public InputTextMessageContent setParseMode(SendMessage.ParseMode parseMode) {
        this.parseMode = parseMode;
        return this;
    }

    public Boolean getDisableWebPagePreview() {
        return disableWebPagePreview;
    }

    public InputTextMessageContent setDisableWebPagePreview(Boolean disableWebPagePreview) {
        this.disableWebPagePreview = disableWebPagePreview;
        return this;
    }
}
