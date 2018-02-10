package com.recrosoftware.api.telegram.bot.request.sticker;

import com.recrosoftware.api.telegram.bot.annotation.Serialize;
import com.recrosoftware.utils.validation.annotation.Range;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public class CreateNewStickerSet extends AbstractAddSticker<CreateNewStickerSet> {
    private static final String FIELD_TITLE = "title";
    private static final String FIELD_CONTAINS_MASKS = "contains_masks";

    @Range(from = 1, to = 64)
    @Required
    @Validate(as = FIELD_TITLE)
    @Serialize(as = FIELD_TITLE)
    private String title;

    @Serialize(as = FIELD_CONTAINS_MASKS)
    private Boolean containsMasks;

    public CreateNewStickerSet() {
        super("createNewStickerSet");
    }

    public String getTitle() {
        return title;
    }

    public CreateNewStickerSet setTitle(String title) {
        this.title = title;
        return this;
    }

    public Boolean getContainsMasks() {
        return containsMasks;
    }

    public CreateNewStickerSet setContainsMasks(Boolean containsMasks) {
        this.containsMasks = containsMasks;
        return this;
    }
}
