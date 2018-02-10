package com.recrosoftware.api.telegram.bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.recrosoftware.api.telegram.bot.model.inline.ChosenInlineResult;
import com.recrosoftware.api.telegram.bot.model.inline.InlineQuery;
import com.recrosoftware.api.telegram.bot.model.payment.PreCheckoutQuery;
import com.recrosoftware.api.telegram.bot.model.payment.ShippingQuery;

import java.io.Serializable;

/**
 * This object represents an incoming update.
 * At most <b>one</b> of the optional parameters can be present in any given update.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class Update implements Serializable {
    public static final long serialVersionUID = 3005000L;

    /**
     * The update‘s unique identifier.
     * Update identifiers start from a certain positive number and increase sequentially.
     * This ID becomes especially handy if you’re using Webhooks, since it allows you to ignore repeated updates or to restore the correct update sequence, should they get out of order.
     * If there are no new updates for at least a week, then identifier of the next update will be chosen randomly instead of sequentially.
     */
    @JsonProperty("update_id")
    private Integer updateId;

    /**
     * Optional.
     * New incoming message of any kind — text, photo, sticker, etc.
     */
    @JsonProperty("message")
    private Message message;

    /**
     * Optional.
     * New version of a message that is known to the bot and was edited.
     */
    @JsonProperty("edited_message")
    private Message editedMessage;

    /**
     * Optional.
     * New incoming channel post of any kind — text, photo, sticker, etc.
     */
    @JsonProperty("channel_post")
    private Message channelPost;

    /**
     * Optional.
     * New version of a channel post that is known to the bot and was edited.
     */
    @JsonProperty("edited_channel_post")
    private Message editedChannelPost;

    /**
     * Optional.
     * New incoming inline query.
     */
    @JsonProperty("inline_query")
    private InlineQuery inlineQuery;

    /**
     * Optional.
     * The result of an inline query that was chosen by a user and sent to their chat partner.
     * Please see our documentation on the <a href="https://core.telegram.org/bots/inline#collecting-feedback">feedback collecting</a> for details on how to enable these updates for your bot.
     */
    @JsonProperty("chosen_inline_result")
    private ChosenInlineResult chosenInlineResult;

    /**
     * Optional.
     * New incoming callback query.
     */
    @JsonProperty("callback_query")
    private CallbackQuery callbackQuery;

    /**
     * Optional.
     * New incoming shipping query.
     * Only for invoices with flexible price.
     */
    @JsonProperty("shipping_query")
    private ShippingQuery shippingQuery;

    /**
     * Optional.
     * New incoming pre-checkout query.
     * Contains full information about checkout
     */
    @JsonProperty("pre_checkout_query")
    private PreCheckoutQuery preCheckoutQuery;

    public Integer getUpdateId() {
        return updateId;
    }

    public Update setUpdateId(Integer updateId) {
        this.updateId = updateId;
        return this;
    }

    public Message getMessage() {
        return message;
    }

    public Update setMessage(Message message) {
        this.message = message;
        return this;
    }

    public Message getEditedMessage() {
        return editedMessage;
    }

    public Update setEditedMessage(Message editedMessage) {
        this.editedMessage = editedMessage;
        return this;
    }

    public Message getChannelPost() {
        return channelPost;
    }

    public Update setChannelPost(Message channelPost) {
        this.channelPost = channelPost;
        return this;
    }

    public Message getEditedChannelPost() {
        return editedChannelPost;
    }

    public Update setEditedChannelPost(Message editedChannelPost) {
        this.editedChannelPost = editedChannelPost;
        return this;
    }

    public InlineQuery getInlineQuery() {
        return inlineQuery;
    }

    public Update setInlineQuery(InlineQuery inlineQuery) {
        this.inlineQuery = inlineQuery;
        return this;
    }

    public ChosenInlineResult getChosenInlineResult() {
        return chosenInlineResult;
    }

    public Update setChosenInlineResult(ChosenInlineResult chosenInlineResult) {
        this.chosenInlineResult = chosenInlineResult;
        return this;
    }

    public CallbackQuery getCallbackQuery() {
        return callbackQuery;
    }

    public Update setCallbackQuery(CallbackQuery callbackQuery) {
        this.callbackQuery = callbackQuery;
        return this;
    }

    public ShippingQuery getShippingQuery() {
        return shippingQuery;
    }

    public Update setShippingQuery(ShippingQuery shippingQuery) {
        this.shippingQuery = shippingQuery;
        return this;
    }

    public PreCheckoutQuery getPreCheckoutQuery() {
        return preCheckoutQuery;
    }

    public Update setPreCheckoutQuery(PreCheckoutQuery preCheckoutQuery) {
        this.preCheckoutQuery = preCheckoutQuery;
        return this;
    }
}
