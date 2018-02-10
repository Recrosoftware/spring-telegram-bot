package com.recrosoftware.api.telegram.bot.model.payment;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.recrosoftware.api.telegram.bot.model.User;

import java.io.Serializable;

/**
 * This object contains information about an incoming pre-checkout query.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class PreCheckoutQuery implements Serializable {
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

    /**
     * Bot specified invoice payload.
     */
    @JsonProperty("invoice_payload")
    private String invoicePayload;

    /**
     * Optional.
     * Identifier of the shipping option chosen by the user.
     */
    @JsonProperty("shipping_option_id")
    private String shippingOptionId;

    /**
     * Optional.
     * Order info provided by the user.
     */
    @JsonProperty("order_info")
    private OrderInfo orderInfo;

    public String getId() {
        return id;
    }

    public PreCheckoutQuery setId(String id) {
        this.id = id;
        return this;
    }

    public User getFrom() {
        return from;
    }

    public PreCheckoutQuery setFrom(User from) {
        this.from = from;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public PreCheckoutQuery setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public PreCheckoutQuery setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public String getInvoicePayload() {
        return invoicePayload;
    }

    public PreCheckoutQuery setInvoicePayload(String invoicePayload) {
        this.invoicePayload = invoicePayload;
        return this;
    }

    public String getShippingOptionId() {
        return shippingOptionId;
    }

    public PreCheckoutQuery setShippingOptionId(String shippingOptionId) {
        this.shippingOptionId = shippingOptionId;
        return this;
    }

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public PreCheckoutQuery setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
        return this;
    }
}
