package com.recrosoftware.api.telegram.bot.request.sticker;

import com.fasterxml.jackson.core.type.TypeReference;
import com.recrosoftware.api.telegram.bot.annotation.Serialize;
import com.recrosoftware.api.telegram.bot.model.api.ApiResponse;
import com.recrosoftware.api.telegram.bot.request.AbstractRequestItem;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public class DeleteStickerFromSet extends AbstractRequestItem<Boolean> {
    private static final String FIELD_STICKER = "sticker";

    @Required
    @Validate(as = FIELD_STICKER)
    @Serialize(as = FIELD_STICKER)
    private String sticker;

    public DeleteStickerFromSet() {
        this("deleteStickerFromSet");
    }

    protected DeleteStickerFromSet(String method) {
        super(method, new TypeReference<ApiResponse<Boolean>>() {
        });
    }

    public String getSticker() {
        return sticker;
    }

    public DeleteStickerFromSet setSticker(String sticker) {
        this.sticker = sticker;
        return this;
    }
}
