package com.recrosoftware.api.telegram.bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * This object represents one button of the reply keyboard.
 * For simple text buttons String can be used instead of this object to specify text of the button.
 * Optional fields are mutually exclusive.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class KeyboardButton implements Serializable {
    public static final long serialVersionUID = 3005000L;

    /**
     * Text of the button.
     * If none of the optional fields are used, it will be sent as a message when the button is pressed.
     */
    @JsonProperty("text")
    private String text;

    /**
     * Optional.
     * If True, the user's phone number will be sent as a contact when the button is pressed.
     * Available in private chats only.
     */
    @JsonProperty("request_contact")
    private Boolean requestContact;

    /**
     * Optional.
     * If True, the user's current location will be sent when the button is pressed.
     * Available in private chats only.
     */
    @JsonProperty("request_location")
    private Boolean requestLocation;

    public String getText() {
        return text;
    }

    public KeyboardButton setText(String text) {
        this.text = text;
        return this;
    }

    public Boolean getRequestContact() {
        return requestContact;
    }

    public KeyboardButton setRequestContact(Boolean requestContact) {
        this.requestContact = requestContact;
        return this;
    }

    public Boolean getRequestLocation() {
        return requestLocation;
    }

    public KeyboardButton setRequestLocation(Boolean requestLocation) {
        this.requestLocation = requestLocation;
        return this;
    }
}
