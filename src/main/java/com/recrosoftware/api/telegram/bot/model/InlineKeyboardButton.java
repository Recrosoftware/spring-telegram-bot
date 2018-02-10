package com.recrosoftware.api.telegram.bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.recrosoftware.api.telegram.bot.model.game.CallbackGame;

import java.io.Serializable;

/**
 * This object represents one button of an inline keyboard.
 * You <b>must</b> use exactly one of the optional fields.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class InlineKeyboardButton implements Serializable {
    public static final long serialVersionUID = 3005000L;

    /**
     * Label text on the button.
     */
    @JsonProperty("text")
    private String text;

    /**
     * Optional.
     * HTTP url to be opened when button is pressed.
     */
    @JsonProperty("url")
    private String url;

    /**
     * Optional.
     * Data to be sent in a callback query to the bot when button is pressed, 1-64 bytes.
     */
    @JsonProperty("callback_data")
    private String callbackData;

    /**
     * Optional.
     * If set, pressing the button will prompt the user to select one of their chats, open that chat and insert the bot‘s username and the specified inline query in the input field.
     * Can be empty, in which case just the bot’s username will be inserted.
     * <p>
     * <b>Note:</b> This offers an easy way for users to start using your bot in inline mode when they are currently in a private chat with it.
     * Especially useful when combined with switch_pm… actions – in this case the user will be automatically returned to the chat they switched from, skipping the chat selection screen.
     */
    @JsonProperty("switch_inline_query")
    private String switchInlineQuery;

    /**
     * Optional.
     * If set, pressing the button will insert the bot‘s username and the specified inline query in the current chat's input field.
     * Can be empty, in which case only the bot’s username will be inserted.
     */
    @JsonProperty("switch_inline_query_current_chat")
    private String switchInlineQueryCurrentChat;

    /**
     * Optional.
     * Description of the game that will be launched when the user presses the button.
     * <p>
     * <b>NOTE:</b> This type of button must always be the first button in the first row.
     */
    @JsonProperty("callback_game")
    private CallbackGame callbackGame;

    /**
     * Optional.
     * Specify True, to send a Pay button.
     * <p>
     * <b>NOTE:</b> This type of button must always be the first button in the first row.
     */
    @JsonProperty("pay")
    private Boolean pay;

    public String getText() {
        return text;
    }

    public InlineKeyboardButton setText(String text) {
        this.text = text;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public InlineKeyboardButton setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getCallbackData() {
        return callbackData;
    }

    public InlineKeyboardButton setCallbackData(String callbackData) {
        this.callbackData = callbackData;
        return this;
    }

    public String getSwitchInlineQuery() {
        return switchInlineQuery;
    }

    public InlineKeyboardButton setSwitchInlineQuery(String switchInlineQuery) {
        this.switchInlineQuery = switchInlineQuery;
        return this;
    }

    public String getSwitchInlineQueryCurrentChat() {
        return switchInlineQueryCurrentChat;
    }

    public InlineKeyboardButton setSwitchInlineQueryCurrentChat(String switchInlineQueryCurrentChat) {
        this.switchInlineQueryCurrentChat = switchInlineQueryCurrentChat;
        return this;
    }

    public CallbackGame getCallbackGame() {
        return callbackGame;
    }

    public InlineKeyboardButton setCallbackGame(CallbackGame callbackGame) {
        this.callbackGame = callbackGame;
        return this;
    }

    public Boolean getPay() {
        return pay;
    }

    public InlineKeyboardButton setPay(Boolean pay) {
        this.pay = pay;
        return this;
    }
}
