package com.recrosoftware.api.telegram.bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * This object represents a voice note.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class Voice extends File implements Serializable {
    public static final long serialVersionUID = 3005000L;

    /**
     * Duration of the audio in seconds as defined by sender.
     */
    @JsonProperty("duration")
    Integer duration;

    /**
     * Optional.
     * MIME type of the file as defined by sender.
     */
    @JsonProperty("mime_type")
    String mimeType;

    public Integer getDuration() {
        return duration;
    }

    public Voice setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public String getMimeType() {
        return mimeType;
    }

    public Voice setMimeType(String mimeType) {
        this.mimeType = mimeType;
        return this;
    }
}
