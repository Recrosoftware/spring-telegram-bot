package com.recrosoftware.api.telegram.bot.model.payment;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * This object contains basic information about an invoice.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class Invoice implements Serializable {
    public static final long serialVersionUID = 3005000L;

    /**
     * Product name.
     */
    @JsonProperty("title")
    private String title;

    /**
     * Product description.
     */
    @JsonProperty("description")
    private String description;

    /**
     * Unique bot deep-linking parameter that can be used to generate this invoice.
     */
    @JsonProperty("start_parameter")
    private String startParameter;

    /**
     * Three-letter ISO 4217 currency code.
     */
    @JsonProperty("currency")
    private String currency;

    /**
     * Total price in the smallest units of the currency (integer, <b>not</b> float/double).
     * For example, for a price of <code>US$ 1.45</code> pass <code>amount = 145</code>.
     * See the exp parameter in <a href="https://core.telegram.org/bots/payments/currencies.json">currencies.json</a>,
     * it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
     */
    @JsonProperty("total_amount")
    private Integer totalAmount;

    public String getTitle() {
        return title;
    }

    public Invoice setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Invoice setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getStartParameter() {
        return startParameter;
    }

    public Invoice setStartParameter(String startParameter) {
        this.startParameter = startParameter;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public Invoice setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public Invoice setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }
}
