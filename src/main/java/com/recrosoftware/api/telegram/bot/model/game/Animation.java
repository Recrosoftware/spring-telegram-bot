package com.recrosoftware.api.telegram.bot.model.game;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.recrosoftware.api.telegram.bot.model.PhotoSize;

import java.io.Serializable;

/**
 * This object represents an animation file to be displayed in the message containing a game.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class Animation implements Serializable {
    public static final long serialVersionUID = 3005000L;

    /**
     * Unique file identifier.
     */
    @JsonProperty("file_id")
    private String fileId;

    /**
     * Optional.
     * Animation thumbnail as defined by sender.
     */
    @JsonProperty("thumb")
    private PhotoSize thumb;

    /**
     * Optional.
     * Original animation filename as defined by sender.
     */
    @JsonProperty("file_name")
    private String fileName;

    /**
     * Optional.
     * MIME type of the file as defined by sender.
     */
    @JsonProperty("mime_type")
    private String mimeType;

    /**
     * Optional.
     * File size.
     */
    @JsonProperty("file_size")
    private Integer fileSize;

    public String getFileId() {
        return fileId;
    }

    public Animation setFileId(String fileId) {
        this.fileId = fileId;
        return this;
    }

    public PhotoSize getThumb() {
        return thumb;
    }

    public Animation setThumb(PhotoSize thumb) {
        this.thumb = thumb;
        return this;
    }

    public String getFileName() {
        return fileName;
    }

    public Animation setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public String getMimeType() {
        return mimeType;
    }

    public Animation setMimeType(String mimeType) {
        this.mimeType = mimeType;
        return this;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public Animation setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
        return this;
    }
}
