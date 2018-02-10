package com.recrosoftware.api.telegram.bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * This object represents a phone contact.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class Contact implements Serializable {
    public static final long serialVersionUID = 3005000L;

    /**
     * Contact's phone number.
     */
    @JsonProperty("phone_number")
    private String phoneNumber;

    /**
     * Contact's first name.
     */
    @JsonProperty("first_name")
    private String firstName;

    /**
     * Optional.
     * Contact's last name.
     */
    @JsonProperty("last_name")
    private String lastName;

    /**
     * Optional.
     * Contact's user identifier in Telegram.
     */
    @JsonProperty("user_id")
    private Integer userId;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Contact setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Contact setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Contact setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public Contact setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }
}
