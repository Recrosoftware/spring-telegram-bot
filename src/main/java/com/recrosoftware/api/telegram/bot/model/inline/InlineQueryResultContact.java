package com.recrosoftware.api.telegram.bot.model.inline;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

import java.io.Serializable;

/**
 * Represents a contact with a phone number.
 * By default, this contact will be sent by the user.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the contact.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class InlineQueryResultContact extends InlineQueryResult<InlineQueryResultContact> implements Serializable {
    public static final long serialVersionUID = 3005000L;

    private final static String FIELD_PHONE_NUMBER = "phone_number";
    private final static String FIELD_FIRST_NAME = "first_name";
    private final static String FIELD_LAST_NAME = "last_name";
    private final static String FIELD_THUMB_URL = "thumb_url";
    private final static String FIELD_THUMB_WIDTH = "thumb_width";
    private final static String FIELD_THUMB_HEIGHT = "thumb_height";

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

    /**
     * Optional.
     * Url of the thumbnail for the result.
     */
    @JsonProperty(FIELD_THUMB_URL)
    private String thumbUrl;

    /**
     * Optional.
     * Thumbnail width.
     */
    @JsonProperty(FIELD_THUMB_WIDTH)
    private Integer thumbWidth;

    /**
     * Optional.
     * Thumbnail height.
     */
    @JsonProperty(FIELD_THUMB_HEIGHT)
    private Integer thumbHeight;

    public InlineQueryResultContact() {
        super(InlineQueryResult.TYPE_CONTACT);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public InlineQueryResultContact setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public InlineQueryResultContact setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public InlineQueryResultContact setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public InlineQueryResultContact setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
        return this;
    }

    public Integer getThumbWidth() {
        return thumbWidth;
    }

    public InlineQueryResultContact setThumbWidth(Integer thumbWidth) {
        this.thumbWidth = thumbWidth;
        return this;
    }

    public Integer getThumbHeight() {
        return thumbHeight;
    }

    public InlineQueryResultContact setThumbHeight(Integer thumbHeight) {
        this.thumbHeight = thumbHeight;
        return this;
    }
}
