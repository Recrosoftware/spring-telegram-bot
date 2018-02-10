package com.recrosoftware.api.telegram.bot.model.inline;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.recrosoftware.utils.validation.annotation.Range;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

import java.io.Serializable;

/**
 * Represents the content of a location message to be sent as the result of an inline query.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class InputLocationMessageContent implements InputMessageContent, Serializable {
    public static final long serialVersionUID = 3005000L;

    private final static String FIELD_LATITUDE = "latitude";
    private final static String FIELD_LONGITUDE = "longitude";
    private final static String FIELD_LIVE_PERIOD = "live_period";

    /**
     * Latitude of the location in degrees.
     */
    @Required
    @Range(from = -90, to = 90)
    @Validate(as = FIELD_LATITUDE)
    @JsonProperty(FIELD_LATITUDE)
    private Float latitude;

    /**
     * Longitude of the location in degrees.
     */
    @Required
    @Range(from = -180, to = 180)
    @Validate(as = FIELD_LONGITUDE)
    @JsonProperty(FIELD_LONGITUDE)
    private Float longitude;

    /**
     * Optional.
     * Period in seconds for which the location can be updated, should be between 60 and 86400.
     */
    @Range(from = 60, to = 86400)
    @Validate(as = FIELD_LIVE_PERIOD)
    @JsonProperty(FIELD_LIVE_PERIOD)
    private Integer livePeriod;

    public Float getLatitude() {
        return latitude;
    }

    public InputLocationMessageContent setLatitude(Float latitude) {
        this.latitude = latitude;
        return this;
    }

    public Float getLongitude() {
        return longitude;
    }

    public InputLocationMessageContent setLongitude(Float longitude) {
        this.longitude = longitude;
        return this;
    }

    public Integer getLivePeriod() {
        return livePeriod;
    }

    public InputLocationMessageContent setLivePeriod(Integer livePeriod) {
        this.livePeriod = livePeriod;
        return this;
    }
}
