package com.recrosoftware.api.telegram.bot.model.payment;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * This object represents a portion of the price for goods or services.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class LabeledPrice implements Serializable {
    public static final long serialVersionUID = 3005000L;

    /**
     * Portion label.
     */
    @JsonProperty("label")
    private String label;

    /**
     * Price of the product in the smallest units of the currency (integer, <b>not</b> float/double).
     * For example, for a price of <code>US$ 1.45</code> pass <code>amount = 145</code>.
     * See the exp parameter in <a href="https://core.telegram.org/bots/payments/currencies.json">currencies.json</a>,
     * it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
     */
    @JsonProperty("amount")
    private Integer amount;

    public String getLabel() {
        return label;
    }

    public LabeledPrice setLabel(String label) {
        this.label = label;
        return this;
    }

    public Integer getAmount() {
        return amount;
    }

    public LabeledPrice setAmount(Integer amount) {
        this.amount = amount;
        return this;
    }
}
