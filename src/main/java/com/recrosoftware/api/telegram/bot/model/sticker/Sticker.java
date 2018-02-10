package com.recrosoftware.api.telegram.bot.model.sticker;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.recrosoftware.api.telegram.bot.model.PhotoSize;

import java.io.Serializable;

/**
 * This object represents a sticker.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class Sticker implements Serializable {
    public static final long serialVersionUID = 3005000L;

    /**
     * Unique identifier for this file.
     */
    @JsonProperty("file_id")
    private String file_id;

    /**
     * Sticker width.
     */
    @JsonProperty("width")
    private Integer width;

    /**
     * Sticker height.
     */
    @JsonProperty("height")
    private Integer height;

    /**
     * Optional.
     * Sticker thumbnail in the .webp or .jpg format.
     */
    @JsonProperty("thumb")
    private PhotoSize thumb;

    /**
     * Optional.
     * Emoji associated with the sticker.
     */
    @JsonProperty("emoji")
    private String emoji;

    /**
     * Optional.
     * Name of the sticker set to which the sticker belongs.
     */
    @JsonProperty("set_name")
    private String setName;

    /**
     * Optional.
     * For mask stickers, the position where the mask should be placed.
     */
    @JsonProperty("mask_position")
    private MaskPosition maskPosition;

    /**
     * Optional.
     * File size.
     */
    @JsonProperty("file_size")
    private Integer fileSize;

    public String getFile_id() {
        return file_id;
    }

    public Sticker setFile_id(String file_id) {
        this.file_id = file_id;
        return this;
    }

    public Integer getWidth() {
        return width;
    }

    public Sticker setWidth(Integer width) {
        this.width = width;
        return this;
    }

    public Integer getHeight() {
        return height;
    }

    public Sticker setHeight(Integer height) {
        this.height = height;
        return this;
    }

    public PhotoSize getThumb() {
        return thumb;
    }

    public Sticker setThumb(PhotoSize thumb) {
        this.thumb = thumb;
        return this;
    }

    public String getEmoji() {
        return emoji;
    }

    public Sticker setEmoji(String emoji) {
        this.emoji = emoji;
        return this;
    }

    public String getSetName() {
        return setName;
    }

    public Sticker setSetName(String setName) {
        this.setName = setName;
        return this;
    }

    public MaskPosition getMaskPosition() {
        return maskPosition;
    }

    public Sticker setMaskPosition(MaskPosition maskPosition) {
        this.maskPosition = maskPosition;
        return this;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public Sticker setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
        return this;
    }
}
