package com.recrosoftware.api.telegram.bot.model.inline;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.recrosoftware.api.telegram.bot.model.Location;
import com.recrosoftware.api.telegram.bot.model.User;

import java.io.Serializable;

/**
 * Represents a result of an inline query that was chosen by the user and sent to their chat partner.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class ChosenInlineResult implements Serializable {
    public static final long serialVersionUID = 3005000L;

    /**
     * The unique identifier for the result that was chosen.
     */
    @JsonProperty("result_id")
    private String resultId;

    /**
     * The user that chose the result.
     */
    @JsonProperty("from")
    private User from;

    /**
     * Optional.
     * Sender location, only for bots that require user location.
     */
    @JsonProperty("location")
    private Location location;

    /**
     * Optional.
     * Identifier of the sent inline message.
     * Available only if there is an inline keyboard attached to the message.
     * Will be also received in callback queries and can be used to edit the message.
     */
    @JsonProperty("inline_message_id")
    private String inlineMessageId;

    /**
     * The query that was used to obtain the result.
     */
    @JsonProperty("query")
    private String query;

    public String getResultId() {
        return resultId;
    }

    public ChosenInlineResult setResultId(String resultId) {
        this.resultId = resultId;
        return this;
    }

    public User getFrom() {
        return from;
    }

    public ChosenInlineResult setFrom(User from) {
        this.from = from;
        return this;
    }

    public Location getLocation() {
        return location;
    }

    public ChosenInlineResult setLocation(Location location) {
        this.location = location;
        return this;
    }

    public String getInlineMessageId() {
        return inlineMessageId;
    }

    public ChosenInlineResult setInlineMessageId(String inlineMessageId) {
        this.inlineMessageId = inlineMessageId;
        return this;
    }

    public String getQuery() {
        return query;
    }

    public ChosenInlineResult setQuery(String query) {
        this.query = query;
        return this;
    }
}
