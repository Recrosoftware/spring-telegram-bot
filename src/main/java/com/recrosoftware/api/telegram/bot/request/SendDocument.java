package com.recrosoftware.api.telegram.bot.request;

import com.recrosoftware.api.telegram.bot.annotation.Serialize;
import com.recrosoftware.utils.validation.annotation.Range;
import com.recrosoftware.utils.validation.annotation.Validate;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public class SendDocument extends AbstractSendFile<SendDocument> {
    private static final String FIELD_CAPTION = "caption";

    @Range(to = 200)
    @Validate(as = FIELD_CAPTION)
    @Serialize(as = FIELD_CAPTION)
    private String caption;

    public SendDocument() {
        super("sendDocument", "document");
    }

    public String getCaption() {
        return caption;
    }

    public SendDocument setCaption(String caption) {
        this.caption = caption;
        return this;
    }
}
