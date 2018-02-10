package com.recrosoftware.api.telegram.bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * This object represents a video file.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class Video extends File implements Serializable {
    public static final long serialVersionUID = 3005000L;

    /**
     * Video width as defined by sender.
     */
    @JsonProperty("width")
    private Integer width;

    /**
     * Video height as defined by sender.
     */
    @JsonProperty("height")
    private Integer height;

    /**
     * Duration of the video in seconds as defined by sender.
     */
    @JsonProperty("duration")
    private Integer duration;

    /**
     * Optional.
     * Video thumbnail.
     */
    @JsonProperty("thumb")
    private PhotoSize thumb;

    /**
     * Optional.
     * Mime type of a file as defined by sender.
     */
    @JsonProperty("mime_type")
    private String mimeType;

    public Integer getWidth() {
        return width;
    }

    public Video setWidth(Integer width) {
        this.width = width;
        return this;
    }

    public Integer getHeight() {
        return height;
    }

    public Video setHeight(Integer height) {
        this.height = height;
        return this;
    }

    public Integer getDuration() {
        return duration;
    }

    public Video setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public PhotoSize getThumb() {
        return thumb;
    }

    public Video setThumb(PhotoSize thumb) {
        this.thumb = thumb;
        return this;
    }

    public String getMimeType() {
        return mimeType;
    }

    public Video setMimeType(String mimeType) {
        this.mimeType = mimeType;
        return this;
    }
}
