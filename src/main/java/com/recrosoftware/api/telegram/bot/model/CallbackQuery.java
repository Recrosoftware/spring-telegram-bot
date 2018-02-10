package com.recrosoftware.api.telegram.bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * This object represents an incoming callback query from a callback button in an inline keyboard.
 * If the button that originated the query was attached to a message sent by the bot, the field message will be present.
 * If the button was attached to a message sent via the bot (in inline mode), the field inline_message_id will be present.
 * Exactly one of the fields data or game_short_name will be present.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class CallbackQuery implements Serializable {
    public static final long serialVersionUID = 3005000L;

    /**
     * Unique identifier for this query.
     */
    @JsonProperty("id")
    String id;

    /**
     * Sender.
     */
    @JsonProperty("from")
    User from;

    /**
     * Optional.
     * Message with the callback button that originated the query.
     * Note that message content and message date will not be available if the message is too old.
     */
    @JsonProperty("message")
    Message message;

    /**
     * Optional.
     * Identifier of the message sent via the bot in inline mode, that originated the query.
     */
    @JsonProperty("inline_message_id")
    String inlineMessageId;

    /**
     * Global identifier, uniquely corresponding to the chat to which the message with the callback button was sent.
     * Useful for high scores in games.
     */
    @JsonProperty("chat_instance")
    String chatInstance;

    /**
     * Optional.
     * Data associated with the callback button.
     * Be aware that a bad client can send arbitrary data in this field.
     */
    @JsonProperty("data")
    String data;

    /**
     * Optional.
     * Short name of a Game to be returned, serves as the unique identifier for the game.
     */
    @JsonProperty("game_short_name")
    String gameShortName;

    public String getId() {
        return id;
    }

    public CallbackQuery setId(String id) {
        this.id = id;
        return this;
    }

    public User getFrom() {
        return from;
    }

    public CallbackQuery setFrom(User from) {
        this.from = from;
        return this;
    }

    public Message getMessage() {
        return message;
    }

    public CallbackQuery setMessage(Message message) {
        this.message = message;
        return this;
    }

    public String getInlineMessageId() {
        return inlineMessageId;
    }

    public CallbackQuery setInlineMessageId(String inlineMessageId) {
        this.inlineMessageId = inlineMessageId;
        return this;
    }

    public String getChatInstance() {
        return chatInstance;
    }

    public CallbackQuery setChatInstance(String chatInstance) {
        this.chatInstance = chatInstance;
        return this;
    }

    public String getData() {
        return data;
    }

    public CallbackQuery setData(String data) {
        this.data = data;
        return this;
    }

    public String getGameShortName() {
        return gameShortName;
    }

    public CallbackQuery setGameShortName(String gameShortName) {
        this.gameShortName = gameShortName;
        return this;
    }
}
