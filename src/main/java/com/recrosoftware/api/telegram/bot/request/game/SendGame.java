package com.recrosoftware.api.telegram.bot.request.game;

import com.recrosoftware.api.telegram.bot.annotation.Serialize;
import com.recrosoftware.api.telegram.bot.model.InlineKeyboardMarkup;
import com.recrosoftware.api.telegram.bot.request.AbstractSendMethod;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

/**
 * Use this method to send a game.
 * On success, the sent Message is returned.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public class SendGame extends AbstractSendMethod<SendGame, InlineKeyboardMarkup> {
    private static final String FIELD_GAME_SHORT_NAME = "game_short_name";
    /**
     * Required.
     * Short name of the game, serves as the unique identifier for the game.
     */
    @Required
    @Validate(as = FIELD_GAME_SHORT_NAME)
    @Serialize(as = FIELD_GAME_SHORT_NAME)
    private String gameShortName;

    public SendGame() {
        super("sendGame");
    }

    public String getGameShortName() {
        return gameShortName;
    }

    public SendGame setGameShortName(String gameShortName) {
        this.gameShortName = gameShortName;
        return this;
    }
}
