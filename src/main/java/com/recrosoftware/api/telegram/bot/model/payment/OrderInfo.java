package com.recrosoftware.api.telegram.bot.model.payment;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * This object represents information about an order.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class OrderInfo implements Serializable {
    public static final long serialVersionUID = 3005000L;

    /**
     * Optional.
     * User name.
     */
    @JsonProperty("name")
    private String name;

    /**
     * Optional.
     * User's phone number.
     */
    @JsonProperty("phone_number")
    private String phoneNumber;

    /**
     * Optional.
     * User email.
     */
    @JsonProperty("email")
    private String email;

    /**
     * Optional.
     * User shipping address.
     */
    @JsonProperty("shipping_address")
    private ShippingAddress shippingAddress;

    public String getName() {
        return name;
    }

    public OrderInfo setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public OrderInfo setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public OrderInfo setEmail(String email) {
        this.email = email;
        return this;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public OrderInfo setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
        return this;
    }
}
