package com.recrosoftware.api.telegram.bot.model.payment;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * This object represents one shipping option.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class ShippingOption implements Serializable {
    public static final long serialVersionUID = 3005000L;

    /**
     * Shipping option identifier.
     */
    @JsonProperty("id")
    private String id;

    /**
     * Option title.
     */
    @JsonProperty("title")
    private String title;

    /**
     * List of price portions.
     */
    @JsonProperty("prices")
    private List<LabeledPrice> prices;

    public String getId() {
        return id;
    }

    public ShippingOption setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ShippingOption setTitle(String title) {
        this.title = title;
        return this;
    }

    public List<LabeledPrice> getPrices() {
        return prices;
    }

    public ShippingOption setPrices(List<LabeledPrice> prices) {
        this.prices = prices;
        return this;
    }
}
