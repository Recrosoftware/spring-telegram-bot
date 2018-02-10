package com.recrosoftware.api.telegram.bot.request.update;

import com.recrosoftware.api.telegram.bot.annotation.Serialize;
import com.recrosoftware.api.telegram.bot.request.SendMessage;
import com.recrosoftware.utils.validation.annotation.Range;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public class EditMessageText extends AbstractEditMessage<EditMessageText> {
    private static final String FIELD_TEXT = "text";
    private static final String FIELD_PARSE_MODE = "parse_mode";
    private static final String FIELD_DISABLE_WEB_PAGE_PREVIEW = "disable_web_page_preview";

    @Range(from = 1, to = 4096)
    @Required
    @Validate(as = FIELD_TEXT)
    @Serialize(as = FIELD_TEXT)
    private String text;

    @Serialize(as = FIELD_PARSE_MODE)
    private SendMessage.ParseMode parseMode;

    @Serialize(as = FIELD_DISABLE_WEB_PAGE_PREVIEW)
    private Boolean disableWebPagePreview;

    public EditMessageText() {
        super("editMessageText");
    }

    public String getText() {
        return text;
    }

    public EditMessageText setText(String text) {
        this.text = text;
        return this;
    }

    public SendMessage.ParseMode getParseMode() {
        return parseMode;
    }

    public EditMessageText setParseMode(SendMessage.ParseMode parseMode) {
        this.parseMode = parseMode;
        return this;
    }

    public Boolean getDisableWebPagePreview() {
        return disableWebPagePreview;
    }

    public EditMessageText setDisableWebPagePreview(Boolean disableWebPagePreview) {
        this.disableWebPagePreview = disableWebPagePreview;
        return this;
    }
}
