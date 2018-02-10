package com.recrosoftware.api.telegram.bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * This object represents a point on the map.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class Location implements Serializable {
    public static final long serialVersionUID = 3005000L;

    /**
     * Longitude as defined by sender.
     */
    @JsonProperty("longitude")
    private Float longitude;

    /**
     * Latitude as defined by sender.
     */
    @JsonProperty("latitude")
    private Float latitude;

    public Float getLongitude() {
        return longitude;
    }

    public Location setLongitude(Float longitude) {
        this.longitude = longitude;
        return this;
    }

    public Float getLatitude() {
        return latitude;
    }

    public Location setLatitude(Float latitude) {
        this.latitude = latitude;
        return this;
    }
}
