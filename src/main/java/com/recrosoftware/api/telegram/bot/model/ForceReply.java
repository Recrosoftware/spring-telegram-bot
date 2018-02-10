package com.recrosoftware.api.telegram.bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Upon receiving a message with this object, Telegram clients will display a reply interface to the user (act as if the user has selected the bot‘s message and tapped ’Reply').
 * This can be extremely useful if you want to create user-friendly step-by-step interfaces without having to sacrifice privacy mode.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class ForceReply implements KeyboardMarkup, Serializable {
    public static final long serialVersionUID = 3005000L;

    /**
     * Shows reply interface to the user, as if they manually selected the bot‘s message and tapped ’Reply'.
     */
    @JsonProperty("force_reply")
    private final Boolean forceReply;

    /**
     * Optional.
     * Use this parameter if you want to force reply from specific users only.
     * Targets:
     * 1) users that are @mentioned in the text of the Message object;
     * 2) if the bot's message is a reply (has reply_to_message_id), sender of the original message.
     */
    @JsonProperty("selective")
    private Boolean selective;

    public ForceReply() {
        this.forceReply = true;
    }

    public Boolean getForceReply() {
        return forceReply;
    }

    public ForceReply setForceReply(Boolean forceReply) {
        // No operations
        return this;
    }

    public Boolean getSelective() {
        return selective;
    }

    public ForceReply setSelective(Boolean selective) {
        this.selective = selective;
        return this;
    }
}
