package com.recrosoftware.api.telegram.bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * This object represents a general file (as opposed to photos, voice messages and audio files).
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class Document extends File implements Serializable {
    public static final long serialVersionUID = 3005000L;

    /**
     * Optional.
     * Document thumbnail as defined by sender.
     */
    @JsonProperty("thumb")
    private PhotoSize thumb;

    /**
     * Optional.
     * Original filename as defined by sender.
     */
    @JsonProperty("file_name")
    private String fileName;

    /**
     * Optional.
     * MIME type of the file as defined by sender.
     */
    @JsonProperty("mime_type")
    private String mimeType;

    public PhotoSize getThumb() {
        return thumb;
    }

    public Document setThumb(PhotoSize thumb) {
        this.thumb = thumb;
        return this;
    }

    public String getFileName() {
        return fileName;
    }

    public Document setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public String getMimeType() {
        return mimeType;
    }

    public Document setMimeType(String mimeType) {
        this.mimeType = mimeType;
        return this;
    }
}
