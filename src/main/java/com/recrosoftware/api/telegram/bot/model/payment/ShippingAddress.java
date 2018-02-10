package com.recrosoftware.api.telegram.bot.model.payment;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * This object represents a shipping address.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class ShippingAddress implements Serializable {
    public static final long serialVersionUID = 3005000L;

    /**
     * ISO 3166-1 alpha-2 country code.
     */
    @JsonProperty("country_code")
    private String countryCode;

    /**
     * State, if applicable.
     */
    @JsonProperty("state")
    private String state;

    /**
     * City.
     */
    @JsonProperty("city")
    private String city;

    /**
     * First line for the address.
     */
    @JsonProperty("street_line1")
    private String streetLine1;

    /**
     * Second line for the address.
     */
    @JsonProperty("street_line2")
    private String streetLine2;

    /**
     * Address post code.
     */
    @JsonProperty("post_code")
    private String postCode;

    public String getCountryCode() {
        return countryCode;
    }

    public ShippingAddress setCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public String getState() {
        return state;
    }

    public ShippingAddress setState(String state) {
        this.state = state;
        return this;
    }

    public String getCity() {
        return city;
    }

    public ShippingAddress setCity(String city) {
        this.city = city;
        return this;
    }

    public String getStreetLine1() {
        return streetLine1;
    }

    public ShippingAddress setStreetLine1(String streetLine1) {
        this.streetLine1 = streetLine1;
        return this;
    }

    public String getStreetLine2() {
        return streetLine2;
    }

    public ShippingAddress setStreetLine2(String streetLine2) {
        this.streetLine2 = streetLine2;
        return this;
    }

    public String getPostCode() {
        return postCode;
    }

    public ShippingAddress setPostCode(String postCode) {
        this.postCode = postCode;
        return this;
    }
}
