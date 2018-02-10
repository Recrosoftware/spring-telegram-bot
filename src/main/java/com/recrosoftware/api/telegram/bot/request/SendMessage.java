package com.recrosoftware.api.telegram.bot.request;

import com.fasterxml.jackson.annotation.JsonValue;
import com.recrosoftware.api.telegram.bot.annotation.Serialize;
import com.recrosoftware.api.telegram.bot.model.KeyboardMarkup;
import com.recrosoftware.utils.validation.annotation.Range;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public class SendMessage extends AbstractSendMethod<SendMessage, KeyboardMarkup> {
    public enum ParseMode {
        MARKDOWN("Markdown"),
        HTML("HTML");

        private final String mode;

        ParseMode(String mode) {
            this.mode = mode;
        }

        @JsonValue
        public String getMode() {
            return mode;
        }
    }

    private static final String FIELD_TEXT = "text";
    private static final String FIELD_PARSE_MODE = "parse_mode";
    private static final String FIELD_DISABLE_WEB_PAGE_PREVIEW = "disable_web_page_preview";

    @Range(from = 1, to = 4096)
    @Required
    @Validate(as = FIELD_TEXT)
    @Serialize(as = FIELD_TEXT)
    private String text;

    @Serialize(as = FIELD_PARSE_MODE)
    private ParseMode parseMode;

    @Serialize(as = FIELD_DISABLE_WEB_PAGE_PREVIEW)
    private Boolean disableWebPagePreview;

    public SendMessage() {
        super("sendMessage");
    }


    public String getText() {
        return text;
    }

    public SendMessage setText(String text) {
        this.text = text;
        return this;
    }

    public ParseMode getParseMode() {
        return parseMode;
    }

    public SendMessage setParseMode(ParseMode parseMode) {
        this.parseMode = parseMode;
        return this;
    }

    public Boolean getDisableWebPagePreview() {
        return disableWebPagePreview;
    }

    public SendMessage setDisableWebPagePreview(Boolean disableWebPagePreview) {
        this.disableWebPagePreview = disableWebPagePreview;
        return this;
    }
}
