package com.recrosoftware.api.telegram.bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * This object represents one size of a photo or a file / sticker thumbnail.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class PhotoSize extends File implements Serializable {
    public static final long serialVersionUID = 3005000L;

    /**
     * Photo width.
     */
    @JsonProperty("width")
    private Integer width;

    /**
     * Photo height.
     */
    @JsonProperty("height")
    private Integer height;

    public Integer getWidth() {
        return width;
    }

    public PhotoSize setWidth(Integer width) {
        this.width = width;
        return this;
    }

    public Integer getHeight() {
        return height;
    }

    public PhotoSize setHeight(Integer height) {
        this.height = height;
        return this;
    }
}
