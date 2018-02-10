package com.recrosoftware.api.telegram.bot.request.update;

import com.recrosoftware.api.telegram.bot.annotation.Serialize;
import com.recrosoftware.utils.validation.annotation.Range;
import com.recrosoftware.utils.validation.annotation.Validate;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public class EditMessageCaption extends AbstractEditMessage<EditMessageCaption> {
    private static final String FIELD_CAPTION = "caption";

    @Range(to = 200)
    @Validate(as = FIELD_CAPTION)
    @Serialize(as = FIELD_CAPTION)
    private String caption;

    public EditMessageCaption() {
        super("editMessageCaption");
    }

    public String getCaption() {
        return caption;
    }

    public EditMessageCaption setCaption(String caption) {
        this.caption = caption;
        return this;
    }
}
