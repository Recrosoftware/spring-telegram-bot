package com.recrosoftware.api.telegram.bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * This object represents a venue.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class Venue implements Serializable {
    public static final long serialVersionUID = 3005000L;

    /**
     * Venue location.
     */
    @JsonProperty("location")
    private Location location;

    /**
     * Name of the venue.
     */
    @JsonProperty("title")
    private String title;

    /**
     * Address of the venue.
     */
    @JsonProperty("address")
    private String address;

    /**
     * Optional.
     * Foursquare identifier of the venue.
     */
    @JsonProperty("foursquare_id")
    private String foursquareId;

    public Location getLocation() {
        return location;
    }

    public Venue setLocation(Location location) {
        this.location = location;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Venue setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Venue setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getFoursquareId() {
        return foursquareId;
    }

    public Venue setFoursquareId(String foursquareId) {
        this.foursquareId = foursquareId;
        return this;
    }
}
