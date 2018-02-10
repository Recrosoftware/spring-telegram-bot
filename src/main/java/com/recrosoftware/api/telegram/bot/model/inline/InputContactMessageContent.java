package com.recrosoftware.api.telegram.bot.model.inline;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

import java.io.Serializable;

/**
 * Represents the content of a contact message to be sent as the result of an inline query.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class InputContactMessageContent implements InputMessageContent, Serializable {
    public static final long serialVersionUID = 3005000L;

    private final static String FIELD_PHONE_NUMBER = "phone_number";
    private final static String FIELD_FIRST_NAME = "first_name";
    private final static String FIELD_LAST_NAME = "last_name";

    /**
     * Contact's phone number.
     */
    @Required
    @Validate(as = FIELD_PHONE_NUMBER)
    @JsonProperty(FIELD_PHONE_NUMBER)
    private String phoneNumber;

    /**
     * Contact's first name.
     */
    @Required
    @Validate(as = FIELD_FIRST_NAME)
    @JsonProperty(FIELD_FIRST_NAME)
    private String firstName;

    /**
     * Optional.
     * Contact's last name.
     */
    @JsonProperty(FIELD_LAST_NAME)
    private String lastName;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public InputContactMessageContent setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public InputContactMessageContent setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public InputContactMessageContent setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
