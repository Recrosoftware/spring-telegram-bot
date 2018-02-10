package com.recrosoftware.api.telegram.bot.model.payment;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.recrosoftware.api.telegram.bot.model.User;

import java.io.Serializable;

/**
 * This object contains information about an incoming shipping query.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class ShippingQuery implements Serializable {
    public static final long serialVersionUID = 3005000L;

    /**
     * Unique query identifier.
     */
    @JsonProperty("id")
    private String id;

    /**
     * User who sent the query.
     */
    @JsonProperty("from")
    private User from;

    /**
     * Bot specified invoice payload.
     */
    @JsonProperty("invoice_payload")
    private String invoicePayload;

    /**
     * User specified shipping address.
     */
    @JsonProperty("shipping_address")
    private ShippingAddress shippingAddress;

    public String getId() {
        return id;
    }

    public ShippingQuery setId(String id) {
        this.id = id;
        return this;
    }

    public User getFrom() {
        return from;
    }

    public ShippingQuery setFrom(User from) {
        this.from = from;
        return this;
    }

    public String getInvoicePayload() {
        return invoicePayload;
    }

    public ShippingQuery setInvoicePayload(String invoicePayload) {
        this.invoicePayload = invoicePayload;
        return this;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public ShippingQuery setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
        return this;
    }
}
