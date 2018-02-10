package com.recrosoftware.api.telegram.bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * This object represents a chat photo.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class ChatPhoto implements Serializable {
    public static final long serialVersionUID = 3005000L;

    /**
     * Unique file identifier of small (160x160) chat photo.
     * This file_id can be used only for photo download.
     */
    @JsonProperty("small_file_id")
    private String smallFileId;

    /**
     * Unique file identifier of big (640x640) chat photo.
     * This file_id can be used only for photo download.
     */
    @JsonProperty("big_file_id")
    private String bigFileId;

    public String getSmallFileId() {
        return smallFileId;
    }

    public ChatPhoto setSmallFileId(String smallFileId) {
        this.smallFileId = smallFileId;
        return this;
    }

    public String getBigFileId() {
        return bigFileId;
    }

    public ChatPhoto setBigFileId(String bigFileId) {
        this.bigFileId = bigFileId;
        return this;
    }
}
