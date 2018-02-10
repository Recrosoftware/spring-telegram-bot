package com.recrosoftware.api.telegram.bot.model.inline;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.recrosoftware.utils.validation.annotation.Range;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

import java.io.Serializable;

/**
 * Represents the content of a venue message to be sent as the result of an inline query.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class InputVenueMessageContent implements InputMessageContent, Serializable {
    public static final long serialVersionUID = 3005000L;

    private final static String FIELD_LATITUDE = "latitude";
    private final static String FIELD_LONGITUDE = "longitude";
    private final static String FIELD_TITLE = "title";
    private final static String FIELD_ADDRESS = "address";
    private final static String FIELD_FOURSQUARE_ID = "foursquare_id";

    /**
     * Latitude of the venue in degrees.
     */
    @Required
    @Range(from = -90, to = 90)
    @Validate(as = FIELD_LATITUDE)
    @JsonProperty(FIELD_LATITUDE)
    private Float latitude;

    /**
     * Longitude of the venue in degrees.
     */
    @Required
    @Range(from = -180, to = 180)
    @Validate(as = FIELD_LONGITUDE)
    @JsonProperty(FIELD_LONGITUDE)
    private Float longitude;

    /**
     * Name of the venue.
     */
    @Required
    @Validate(as = FIELD_TITLE)
    @JsonProperty(FIELD_TITLE)
    private String title;

    /**
     * Address of the venue.
     */
    @Required
    @Validate(as = FIELD_ADDRESS)
    @JsonProperty(FIELD_ADDRESS)
    private String address;

    /**
     * Optional.
     * Foursquare identifier of the venue, if known.
     */
    @JsonProperty(FIELD_FOURSQUARE_ID)
    private String foursquareId;

    public Float getLatitude() {
        return latitude;
    }

    public InputVenueMessageContent setLatitude(Float latitude) {
        this.latitude = latitude;
        return this;
    }

    public Float getLongitude() {
        return longitude;
    }

    public InputVenueMessageContent setLongitude(Float longitude) {
        this.longitude = longitude;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public InputVenueMessageContent setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public InputVenueMessageContent setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getFoursquareId() {
        return foursquareId;
    }

    public InputVenueMessageContent setFoursquareId(String foursquareId) {
        this.foursquareId = foursquareId;
        return this;
    }
}
