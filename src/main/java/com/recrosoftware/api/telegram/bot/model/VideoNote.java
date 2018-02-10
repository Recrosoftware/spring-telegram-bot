package com.recrosoftware.api.telegram.bot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * This object represents a video message.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class VideoNote extends File implements Serializable {
    public static final long serialVersionUID = 3005000L;

    /**
     * Video width and height as defined by sender.
     */
    @JsonProperty("length")
    private Integer length;

    /**
     * Duration of the video in seconds as defined by sender.
     */
    @JsonProperty("duration")
    private Integer duration;

    /**
     * Optional. Video thumbnail.
     */
    @JsonProperty("thumb")
    private PhotoSize thumb;

    public Integer getLength() {
        return length;
    }

    public VideoNote setLength(Integer length) {
        this.length = length;
        return this;
    }

    public Integer getDuration() {
        return duration;
    }

    public VideoNote setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public PhotoSize getThumb() {
        return thumb;
    }

    public VideoNote setThumb(PhotoSize thumb) {
        this.thumb = thumb;
        return this;
    }

    @JsonIgnore
    public Integer getWidth() {
        return length;
    }

    @JsonIgnore
    public Integer getHeight() {
        return length;
    }
}
