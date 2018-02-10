package com.recrosoftware.api.telegram.bot.request.game;

import com.recrosoftware.api.telegram.bot.annotation.Serialize;
import com.recrosoftware.api.telegram.bot.request.AbstractBooleanOrMessage;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public class SetGameScore extends AbstractBooleanOrMessage {
    private static final String FIELD_USER_ID = "user_id";
    private static final String FIELD_SCORE = "score";
    private static final String FIELD_FORCE = "force";
    private static final String FIELD_DISABLE_EDIT_MESSAGE = "disable_edit_message";
    private static final String FIELD_CHAT_ID = "chat_id";
    private static final String FIELD_MESSAGE_ID = "message_id";
    private static final String FIELD_INLINE_MESSAGE_ID = "inline_message_id";

    @Required
    @Validate(as = FIELD_USER_ID)
    @Serialize(as = FIELD_USER_ID)
    private Integer userId;

    @Required
    @Validate(as = FIELD_SCORE)
    @Serialize(as = FIELD_SCORE)
    private Integer score;

    @Serialize(as = FIELD_FORCE)
    private Boolean force;

    @Serialize(as = FIELD_DISABLE_EDIT_MESSAGE)
    private Boolean disableEditMessage;

    @Required(with = FIELD_MESSAGE_ID, or = FIELD_INLINE_MESSAGE_ID)
    @Validate(as = FIELD_CHAT_ID)
    @Serialize(as = FIELD_CHAT_ID)
    private Long chatId;

    @Required
    @Validate(as = FIELD_MESSAGE_ID)
    @Serialize(as = FIELD_MESSAGE_ID)
    private Integer messageId;

    @Required(or = FIELD_CHAT_ID)
    @Validate(as = FIELD_INLINE_MESSAGE_ID)
    @Serialize(as = FIELD_INLINE_MESSAGE_ID)
    private String inlineMessageId;

    public SetGameScore() {
        super("setGameScore");
    }

    public Integer getUserId() {
        return userId;
    }

    public SetGameScore setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getScore() {
        return score;
    }

    public SetGameScore setScore(Integer score) {
        this.score = score;
        return this;
    }

    public Boolean getForce() {
        return force;
    }

    public SetGameScore setForce(Boolean force) {
        this.force = force;
        return this;
    }

    public Boolean getDisableEditMessage() {
        return disableEditMessage;
    }

    public SetGameScore setDisableEditMessage(Boolean disableEditMessage) {
        this.disableEditMessage = disableEditMessage;
        return this;
    }

    public Long getChatId() {
        return chatId;
    }

    public SetGameScore setChatId(Long chatId) {
        this.chatId = chatId;
        this.inlineMessageId = null;
        return this;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public SetGameScore setMessageId(Integer messageId) {
        this.messageId = messageId;
        this.inlineMessageId = null;
        return this;
    }

    public String getInlineMessageId() {
        return inlineMessageId;
    }

    public SetGameScore setInlineMessageId(String inlineMessageId) {
        this.chatId = null;
        this.messageId = null;
        this.inlineMessageId = inlineMessageId;
        return this;
    }
}
