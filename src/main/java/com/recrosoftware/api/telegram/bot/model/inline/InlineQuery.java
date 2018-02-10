package com.recrosoftware.api.telegram.bot.model.inline;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.recrosoftware.api.telegram.bot.model.Location;
import com.recrosoftware.api.telegram.bot.model.User;

import java.io.Serializable;

/**
 * This object represents an incoming inline query.
 * When the user sends an empty query, your bot could return some default or trending results.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class InlineQuery implements Serializable {
    public static final long serialVersionUID = 3005000L;

    /**
     * Unique identifier for this query.
     */
    @JsonProperty("id")
    private String id;

    /**
     * Sender.
     */
    @JsonProperty("from")
    private User from;

    /**
     * Optional.
     * Sender location, only for bots that request user location.
     */
    @JsonProperty("location")
    private Location location;

    /**
     * Text of the query (up to 512 characters).
     */
    @JsonProperty("query")
    private String query;

    /**
     * Offset of the results to be returned, can be controlled by the bot.
     */
    @JsonProperty("offset")
    private String offset;

    public String getId() {
        return id;
    }

    public InlineQuery setId(String id) {
        this.id = id;
        return this;
    }

    public User getFrom() {
        return from;
    }

    public InlineQuery setFrom(User from) {
        this.from = from;
        return this;
    }

    public Location getLocation() {
        return location;
    }

    public InlineQuery setLocation(Location location) {
        this.location = location;
        return this;
    }

    public String getQuery() {
        return query;
    }

    public InlineQuery setQuery(String query) {
        this.query = query;
        return this;
    }

    public String getOffset() {
        return offset;
    }

    public InlineQuery setOffset(String offset) {
        this.offset = offset;
        return this;
    }
}
