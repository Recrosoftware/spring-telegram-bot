package com.recrosoftware.api.telegram.bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * This object represents a Telegram user or bot.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class User implements Serializable {
    public static final long serialVersionUID = 3005000L;

    /**
     * Unique identifier for this user or bot.
     */
    @JsonProperty("id")
    private Integer id;

    /**
     * True, if this user is a bot.
     */
    @JsonProperty("is_bot")
    private Boolean isBot;

    /**
     * User‘s or bot’s first name.
     */
    @JsonProperty("first_name")
    private String firstName;

    /**
     * Optional.
     * User‘s or bot’s last name.
     */
    @JsonProperty("last_name")
    private String lastName;

    /**
     * Optional.
     * User‘s or bot’s username.
     */
    @JsonProperty("username")
    private String username;

    /**
     * Optional.
     * IETF language tag of the user's language.
     */
    @JsonProperty("language_code")
    private String languageCode;

    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public Boolean getIsBot() {
        return isBot;
    }

    public User setIsBot(Boolean bot) {
        isBot = bot;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public User setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
        return this;
    }
}
