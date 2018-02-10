package com.recrosoftware.api.telegram.bot.request.game;

import com.fasterxml.jackson.core.type.TypeReference;
import com.recrosoftware.api.telegram.bot.annotation.Serialize;
import com.recrosoftware.api.telegram.bot.model.api.ApiResponse;
import com.recrosoftware.api.telegram.bot.model.game.GameHighScore;
import com.recrosoftware.api.telegram.bot.request.AbstractRequestItem;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

import java.util.List;

/**
 * Use this method to get data for high score tables.
 * Will return the score of the specified user and several of his neighbors in a game.
 * On success, returns an Array of GameHighScore objects.
 * <p>
 * This method will currently return scores for the target user, plus two of his closest neighbors on each side.
 * Will also return the top three users if the user and his neighbors are not among them.
 * Please note that this behavior is subject to change.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public class GetGameHighScores extends AbstractRequestItem<List<GameHighScore>> {
    private static final String FIELD_USER_ID = "user_id";
    private static final String FIELD_CHAT_ID = "chat_id";
    private static final String FIELD_MESSAGE_ID = "message_id";
    private static final String FIELD_INLINE_MESSAGE_ID = "inline_message_id";
    /**
     * Required.
     * Target user id.
     */
    @Required
    @Validate(as = FIELD_USER_ID)
    @Serialize(as = FIELD_USER_ID)
    private Integer userId;
    /**
     * Required if inline_message_id is not specified.
     * Unique identifier for the target chat.
     */
    @Required(with = FIELD_MESSAGE_ID, or = FIELD_INLINE_MESSAGE_ID)
    @Validate(as = FIELD_CHAT_ID)
    @Serialize(as = FIELD_CHAT_ID)
    private Long chatId;
    /**
     * Required if inline_message_id is not specified.
     * Identifier of the sent message.
     */
    @Required
    @Validate(as = FIELD_MESSAGE_ID)
    @Serialize(as = FIELD_MESSAGE_ID)
    private Integer messageId;
    /**
     * Required if chat_id and message_id are not specified. Identifier of the inline message.
     */
    @Required(or = FIELD_CHAT_ID)
    @Validate(as = FIELD_INLINE_MESSAGE_ID)
    @Serialize(as = FIELD_INLINE_MESSAGE_ID)
    private String inlineMessageId;

    public GetGameHighScores() {
        super("getGameHighScores", new TypeReference<ApiResponse<List<GameHighScore>>>() {
        });
    }

    public Integer getUserId() {
        return userId;
    }

    public GetGameHighScores setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Long getChatId() {
        return chatId;
    }

    public GetGameHighScores setChatId(Long chatId) {
        this.chatId = chatId;
        this.inlineMessageId = null;
        return this;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public GetGameHighScores setMessageId(Integer messageId) {
        this.messageId = messageId;
        this.inlineMessageId = null;
        return this;
    }

    public String getInlineMessageId() {
        return inlineMessageId;
    }

    public GetGameHighScores setInlineMessageId(String inlineMessageId) {
        this.chatId = null;
        this.messageId = null;
        this.inlineMessageId = inlineMessageId;
        return this;
    }
}
