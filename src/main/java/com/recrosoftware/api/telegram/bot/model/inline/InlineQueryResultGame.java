package com.recrosoftware.api.telegram.bot.model.inline;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

import java.io.Serializable;

/**
 * Represents a Game.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class InlineQueryResultGame extends InlineQueryResult<InlineQueryResultGame> implements Serializable {
    public static final long serialVersionUID = 3005000L;

    private final static String FIELD_GAME_SHORT_NAME = "game_short_name";
    /**
     * Short name of the game.
     */
    @Required
    @Validate(as = FIELD_GAME_SHORT_NAME)
    @JsonProperty(FIELD_GAME_SHORT_NAME)
    private String gameShortName;

    public InlineQueryResultGame() {
        super(InlineQueryResult.TYPE_GAME);
    }

    public String getGameShortName() {
        return gameShortName;
    }

    public InlineQueryResultGame setGameShortName(String gameShortName) {
        this.gameShortName = gameShortName;
        return this;
    }

    @JsonIgnore
    @Override
    public InputMessageContent getInputMessageContent() {
        throw new IllegalStateException("Method not accessible on the current type.");
    }

    @Override
    public InlineQueryResultGame setInputMessageContent(InputMessageContent inputMessageContent) {
        throw new IllegalStateException("Method not accessible on the current type.");
    }
}
