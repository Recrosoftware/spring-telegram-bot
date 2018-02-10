package com.recrosoftware.api.telegram.bot.request;

import com.recrosoftware.api.telegram.bot.annotation.Serialize;
import com.recrosoftware.api.telegram.bot.model.KeyboardMarkup;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public class SendContact extends AbstractSendMethod<SendContact, KeyboardMarkup> {
    private static final String FIELD_PHONE_NUMBER = "phone_number";
    private static final String FIELD_FIRST_NAME = "first_name";
    private static final String FIELD_LAST_NAME = "last_name";

    @Required
    @Validate(as = FIELD_PHONE_NUMBER)
    @Serialize(as = FIELD_PHONE_NUMBER)
    private String phoneNumber;

    @Required
    @Validate(as = FIELD_FIRST_NAME)
    @Serialize(as = FIELD_FIRST_NAME)
    private String firstName;

    @Serialize(as = FIELD_LAST_NAME)
    private String lastName;

    public SendContact() {
        super("sendContact");
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public SendContact setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public SendContact setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public SendContact setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
