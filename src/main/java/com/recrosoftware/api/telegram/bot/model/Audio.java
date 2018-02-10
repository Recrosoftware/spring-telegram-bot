package com.recrosoftware.api.telegram.bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * This object represents an audio file to be treated as music by the Telegram clients.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class Audio extends File implements Serializable {
    public static final long serialVersionUID = 3005000L;

    /**
     * Duration of the audio in seconds as defined by sender.
     */
    @JsonProperty("duration")
    private Integer duration;

    /**
     * Optional.
     * Performer of the audio as defined by sender or by audio tags.
     */
    @JsonProperty("performer")
    private String performer;

    /**
     * Optional.
     * Title of the audio as defined by sender or by audio tags.
     */
    @JsonProperty("title")
    private String title;

    /**
     * Optional.
     * MIME type of the file as defined by sender.
     */
    @JsonProperty("mime_type")
    private String mimeType;

    public Integer getDuration() {
        return duration;
    }

    public Audio setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public String getPerformer() {
        return performer;
    }

    public Audio setPerformer(String performer) {
        this.performer = performer;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Audio setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getMimeType() {
        return mimeType;
    }

    public Audio setMimeType(String mimeType) {
        this.mimeType = mimeType;
        return this;
    }
}
