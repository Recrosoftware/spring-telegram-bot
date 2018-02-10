package com.recrosoftware.api.telegram.bot.model.game;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.recrosoftware.api.telegram.bot.model.MessageEntity;
import com.recrosoftware.api.telegram.bot.model.PhotoSize;

import java.io.Serializable;
import java.util.List;

/**
 * This object represents a game.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class Game implements Serializable {
    public static final long serialVersionUID = 3005000L;

    /**
     * Title of the game.
     */
    @JsonProperty("title")
    private String title;

    /**
     * Description of the game.
     */
    @JsonProperty("description")
    private String description;

    /**
     * Photo that will be displayed in the game message in chats.
     */
    @JsonProperty("photo")
    private List<PhotoSize> photo;

    /**
     * Optional.
     * Brief description of the game or high scores included in the game message.
     * Can be automatically edited to include current high scores for the game when the bot calls setGameScore, or manually edited using editMessageText. 0-4096 characters.
     */
    @JsonProperty("text")
    private String text;

    /**
     * Optional.
     * Special entities that appear in text, such as usernames, URLs, bot commands, etc.
     */
    @JsonProperty("text_entities")
    private List<MessageEntity> textEntities;

    /**
     * Optional.
     * Animation that will be displayed in the game message in chats.
     */
    @JsonProperty("animation")
    private Animation animation;

    public String getTitle() {
        return title;
    }

    public Game setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Game setDescription(String description) {
        this.description = description;
        return this;
    }

    public List<PhotoSize> getPhoto() {
        return photo;
    }

    public Game setPhoto(List<PhotoSize> photo) {
        this.photo = photo;
        return this;
    }

    public String getText() {
        return text;
    }

    public Game setText(String text) {
        this.text = text;
        return this;
    }

    public List<MessageEntity> getTextEntities() {
        return textEntities;
    }

    public Game setTextEntities(List<MessageEntity> textEntities) {
        this.textEntities = textEntities;
        return this;
    }

    public Animation getAnimation() {
        return animation;
    }

    public Game setAnimation(Animation animation) {
        this.animation = animation;
        return this;
    }
}
