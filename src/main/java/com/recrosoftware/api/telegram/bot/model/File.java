package com.recrosoftware.api.telegram.bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * This object represents a file ready to be downloaded.
 * The file can be downloaded via the link <code>https://api.telegram.org/file/bot&lt;token&gt;/&lt;file_path&gt;</code>.
 * It is guaranteed that the link will be valid for at least 1 hour.
 * When the link expires, a new one can be requested by calling {@link com.recrosoftware.api.telegram.bot.request.GetFile}.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class File implements Serializable {
    public static final long serialVersionUID = 3005000L;

    /**
     * Unique identifier for this file.
     */
    @JsonProperty("file_id")
    private String fileId;

    /**
     * Optional. File size, if known.
     */
    @JsonProperty("file_size")
    private Integer fileSize;

    /**
     * Optional.
     * File path.
     * Use <code>https://api.telegram.org/file/bot&lt;token&gt;/&lt;file_path&gt;</code> to get the file.
     */
    @JsonProperty("file_path")
    private String filePath;

    public String getFileId() {
        return fileId;
    }

    public File setFileId(String fileId) {
        this.fileId = fileId;
        return this;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public File setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
        return this;
    }

    public String getFilePath() {
        return filePath;
    }

    public File setFilePath(String filePath) {
        this.filePath = filePath;
        return this;
    }
}
