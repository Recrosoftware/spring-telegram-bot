package com.recrosoftware.api.telegram.bot.model.game;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.recrosoftware.api.telegram.bot.model.User;

import java.io.Serializable;

/**
 * This object represents one row of the high scores table for a game.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class GameHighScore implements Serializable {
    public static final long serialVersionUID = 3005000L;

    /**
     * Position in high score table for the game.
     */
    @JsonProperty("position")
    private Integer position;

    /**
     * User.
     */
    @JsonProperty("user")
    private User user;

    /**
     * Score.
     */
    @JsonProperty("score")
    private Integer score;

    public Integer getPosition() {
        return position;
    }

    public GameHighScore setPosition(Integer position) {
        this.position = position;
        return this;
    }

    public User getUser() {
        return user;
    }

    public GameHighScore setUser(User user) {
        this.user = user;
        return this;
    }

    public Integer getScore() {
        return score;
    }

    public GameHighScore setScore(Integer score) {
        this.score = score;
        return this;
    }
}
