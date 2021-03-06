package com.recrosoftware.api.telegram.bot.request;

import com.fasterxml.jackson.core.type.TypeReference;
import com.recrosoftware.api.telegram.bot.annotation.Serialize;
import com.recrosoftware.api.telegram.bot.model.api.ApiResponse;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

import java.util.Date;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public class KickChatMember extends AbstractRequestItem<Boolean> {
    private static final String FIELD_CHAT_ID = "chat_id";
    private static final String FIELD_USER_ID = "user_id";
    private static final String FIELD_UNTIL_DATE = "until_date";

    @Required
    @Validate(as = FIELD_CHAT_ID)
    @Serialize(as = FIELD_CHAT_ID)
    private String chatId;

    @Required
    @Validate(as = FIELD_USER_ID)
    @Serialize(as = FIELD_USER_ID)
    private Integer userId;

    @Serialize(as = FIELD_UNTIL_DATE)
    private Long untilDate;

    public KickChatMember() {
        super("kickChatMember", new TypeReference<ApiResponse<Boolean>>() {
        });
    }

    public String getChatId() {
        return chatId;
    }

    public KickChatMember setChatId(String chatId) {
        this.chatId = chatId;
        return this;
    }

    public KickChatMember setChatId(Long chatId) {
        if (chatId == null) {
            this.chatId = null;
        } else {
            this.chatId = chatId.toString();
        }
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public KickChatMember setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Long getUntilDate() {
        return untilDate;
    }

    public KickChatMember setUntilDate(Long untilDate) {
        this.untilDate = untilDate;
        return this;
    }

    public KickChatMember setUntilDate(Date untilDate) {
        if (untilDate == null) {
            this.untilDate = null;
        } else {
            this.untilDate = untilDate.getTime() / 1000;
        }
        return this;
    }
}
