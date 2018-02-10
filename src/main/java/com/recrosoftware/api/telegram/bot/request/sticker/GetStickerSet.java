package com.recrosoftware.api.telegram.bot.request.sticker;

import com.fasterxml.jackson.core.type.TypeReference;
import com.recrosoftware.api.telegram.bot.annotation.Serialize;
import com.recrosoftware.api.telegram.bot.model.api.ApiResponse;
import com.recrosoftware.api.telegram.bot.model.sticker.StickerSet;
import com.recrosoftware.api.telegram.bot.request.AbstractRequestItem;
import com.recrosoftware.utils.validation.annotation.Range;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public class GetStickerSet extends AbstractRequestItem<StickerSet> {
    private static final String FIELD_NAME = "name";

    @Range(from = 1, to = 64)
    @Required
    @Validate(as = FIELD_NAME)
    @Serialize(as = FIELD_NAME)
    private String name;

    public GetStickerSet() {
        super("getStickerSet", new TypeReference<ApiResponse<StickerSet>>() {
        });
    }

    public String getName() {
        return name;
    }

    public GetStickerSet setName(String name) {
        this.name = name;
        return this;
    }
}
