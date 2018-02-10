package com.recrosoftware.api.telegram.bot.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Contains information about why a request was unsuccessful.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class ResponseParameters implements Serializable {
    public static final long serialVersionUID = 3005000L;

    /**
     * The group has been migrated to a supergroup with the specified identifier.
     * This number may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it.
     * But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier.
     */
    @JsonProperty("migrate_to_chat_id")
    private Long migrateToChatId;

    /**
     * In case of exceeding flood control, the number of seconds left to wait before the request can be repeated.
     */
    @JsonProperty("retry_after")
    private Integer retryAfter;

    public Long getMigrateToChatId() {
        return migrateToChatId;
    }

    public ResponseParameters setMigrateToChatId(Long migrateToChatId) {
        this.migrateToChatId = migrateToChatId;
        return this;
    }

    public Integer getRetryAfter() {
        return retryAfter;
    }

    public ResponseParameters setRetryAfter(Integer retryAfter) {
        this.retryAfter = retryAfter;
        return this;
    }
}
