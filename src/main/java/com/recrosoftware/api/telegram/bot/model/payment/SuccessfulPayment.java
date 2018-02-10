package com.recrosoftware.api.telegram.bot.model.payment;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * This object contains basic information about a successful payment.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class SuccessfulPayment implements Serializable {
    public static final long serialVersionUID = 3005000L;

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

    /**
     * Telegram payment identifier.
     */
    @JsonProperty("telegram_payment_charge_id")
    private String telegramPaymentChargeId;

    /**
     * Provider payment identifier.
     */
    @JsonProperty("provider_payment_charge_id")
    private String providerPaymentChargeId;

    public String getCurrency() {
        return currency;
    }

    public SuccessfulPayment setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public SuccessfulPayment setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public String getInvoicePayload() {
        return invoicePayload;
    }

    public SuccessfulPayment setInvoicePayload(String invoicePayload) {
        this.invoicePayload = invoicePayload;
        return this;
    }

    public String getShippingOptionId() {
        return shippingOptionId;
    }

    public SuccessfulPayment setShippingOptionId(String shippingOptionId) {
        this.shippingOptionId = shippingOptionId;
        return this;
    }

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public SuccessfulPayment setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
        return this;
    }

    public String getTelegramPaymentChargeId() {
        return telegramPaymentChargeId;
    }

    public SuccessfulPayment setTelegramPaymentChargeId(String telegramPaymentChargeId) {
        this.telegramPaymentChargeId = telegramPaymentChargeId;
        return this;
    }

    public String getProviderPaymentChargeId() {
        return providerPaymentChargeId;
    }

    public SuccessfulPayment setProviderPaymentChargeId(String providerPaymentChargeId) {
        this.providerPaymentChargeId = providerPaymentChargeId;
        return this;
    }
}
