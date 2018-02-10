package com.recrosoftware.api.telegram.bot.request;

import com.recrosoftware.api.telegram.bot.annotation.Serialize;
import com.recrosoftware.utils.validation.annotation.Range;
import com.recrosoftware.utils.validation.annotation.Validate;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public class SendVideo extends AbstractSendFile<SendVideo> {
    private static final String FIELD_DURATION = "duration";
    private static final String FIELD_WIDTH = "width";
    private static final String FIELD_HEIGHT = "height";
    private static final String FIELD_CAPTION = "caption";

    @Serialize(as = FIELD_DURATION)
    private Integer duration;

    @Serialize(as = FIELD_WIDTH)
    private Integer width;

    @Serialize(as = FIELD_HEIGHT)
    private Integer height;

    @Range(to = 200)
    @Validate(as = FIELD_CAPTION)
    @Serialize(as = FIELD_CAPTION)
    private String caption;

    public SendVideo() {
        super("sendVideo", "video");
    }

    public Integer getDuration() {
        return duration;
    }

    public SendVideo setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public Integer getWidth() {
        return width;
    }

    public SendVideo setWidth(Integer width) {
        this.width = width;
        return this;
    }

    public Integer getHeight() {
        return height;
    }

    public SendVideo setHeight(Integer height) {
        this.height = height;
        return this;
    }

    public String getCaption() {
        return caption;
    }

    public SendVideo setCaption(String caption) {
        this.caption = caption;
        return this;
    }
}
