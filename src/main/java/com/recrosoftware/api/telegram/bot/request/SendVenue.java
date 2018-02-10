package com.recrosoftware.api.telegram.bot.request;

import com.recrosoftware.api.telegram.bot.annotation.Serialize;
import com.recrosoftware.api.telegram.bot.model.KeyboardMarkup;
import com.recrosoftware.utils.validation.annotation.Range;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public class SendVenue extends AbstractSendMethod<SendVenue, KeyboardMarkup> {
    private static final String FIELD_LATITUDE = "latitude";
    private static final String FIELD_LONGITUDE = "longitude";
    private static final String FIELD_TITLE = "title";
    private static final String FIELD_ADDRESS = "address";
    private static final String FIELD_FOURSQUARE_ID = "foursquare_id";

    @Range(from = -90, to = 90)
    @Required
    @Validate(as = FIELD_LATITUDE)
    @Serialize(as = FIELD_LATITUDE)
    private Float latitude;

    @Range(from = -180, to = 180)
    @Required
    @Validate(as = FIELD_LONGITUDE)
    @Serialize(as = FIELD_LONGITUDE)
    private Float longitude;

    @Required
    @Validate(as = FIELD_TITLE)
    @Serialize(as = FIELD_TITLE)
    private String title;

    @Required
    @Validate(as = FIELD_ADDRESS)
    @Serialize(as = FIELD_ADDRESS)
    private String address;

    @Serialize(as = FIELD_FOURSQUARE_ID)
    private String foursquareId;

    public SendVenue() {
        super("sendVenue");
    }

    public Float getLatitude() {
        return latitude;
    }

    public SendVenue setLatitude(Float latitude) {
        this.latitude = latitude;
        return this;
    }

    public Float getLongitude() {
        return longitude;
    }

    public SendVenue setLongitude(Float longitude) {
        this.longitude = longitude;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public SendVenue setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public SendVenue setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getFoursquareId() {
        return foursquareId;
    }

    public SendVenue setFoursquareId(String foursquareId) {
        this.foursquareId = foursquareId;
        return this;
    }
}
