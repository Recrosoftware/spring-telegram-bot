package com.recrosoftware.api.telegram.bot.request.sticker;

import com.fasterxml.jackson.core.type.TypeReference;
import com.recrosoftware.api.telegram.bot.annotation.Serialize;
import com.recrosoftware.api.telegram.bot.model.api.ApiResponse;
import com.recrosoftware.api.telegram.bot.request.AbstractRequestItem;
import com.recrosoftware.utils.validation.annotation.Range;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public class SetStickerPositionInSet extends AbstractRequestItem<Boolean> {
    private static final String FIELD_STICKER = "sticker";
    private static final String FIELD_POSITION = "position";

    @Required
    @Validate(as = FIELD_STICKER)
    @Serialize(as = FIELD_STICKER)
    private String sticker;

    @Range(from = 0)
    @Validate(as = FIELD_POSITION)
    @Serialize(as = FIELD_POSITION)
    private Integer position;

    public SetStickerPositionInSet() {
        this("setStickerPositionInSet");
    }

    protected SetStickerPositionInSet(String method) {
        super(method, new TypeReference<ApiResponse<Boolean>>() {
        });
    }

    public String getSticker() {
        return sticker;
    }

    public SetStickerPositionInSet setSticker(String sticker) {
        this.sticker = sticker;
        return this;
    }

    public Integer getPosition() {
        return position;
    }

    public SetStickerPositionInSet setPosition(Integer position) {
        this.position = position;
        return this;
    }
}
