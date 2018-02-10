package com.recrosoftware.api.telegram.bot.request;

import com.fasterxml.jackson.core.type.TypeReference;
import com.recrosoftware.api.telegram.bot.annotation.Serialize;
import com.recrosoftware.api.telegram.bot.model.api.ApiResponse;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public class RestrictChatMember extends AbstractRequestItem<Boolean> {
    private static final String FIELD_CHAT_ID = "chat_id";
    private static final String FIELD_USER_ID = "user_id";
    private static final String FIELD_UNTIL_DATE = "until_date";
    private static final String FIELD_CAN_SEND_MESSAGES = "can_send_messages";
    private static final String FIELD_CAN_SEND_MEDIA_MESSAGES = "can_send_media_messages";
    private static final String FIELD_CAN_SEND_OTHER_MESSAGES = "can_send_other_messages";
    private static final String FIELD_CAN_ADD_WEB_PAGE_PREVIEWS = "can_add_web_page_previews";

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

    @Serialize(as = FIELD_CAN_SEND_MESSAGES)
    private Boolean canSendMessages;

    @Serialize(as = FIELD_CAN_SEND_MEDIA_MESSAGES)
    private Boolean canSendMediaMessages;

    @Serialize(as = FIELD_CAN_SEND_OTHER_MESSAGES)
    private Boolean canSendOtherMessages;

    @Serialize(as = FIELD_CAN_ADD_WEB_PAGE_PREVIEWS)
    private Boolean canAddWebPagePreviews;

    public RestrictChatMember() {
        super("restrictChatMember", new TypeReference<ApiResponse<Boolean>>() {
        });
    }

    public String getChatId() {
        return chatId;
    }

    public RestrictChatMember setChatId(String chatId) {
        this.chatId = chatId;
        return this;
    }

    public RestrictChatMember setChatId(Long chatId) {
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

    public RestrictChatMember setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Long getUntilDate() {
        return untilDate;
    }

    public RestrictChatMember setUntilDate(Long untilDate) {
        this.untilDate = untilDate;
        return this;
    }

    public Boolean getCanSendMessages() {
        return canSendMessages;
    }

    public RestrictChatMember setCanSendMessages(Boolean canSendMessages) {
        this.canSendMessages = canSendMessages;
        return this;
    }

    public Boolean getCanSendMediaMessages() {
        return canSendMediaMessages;
    }

    public RestrictChatMember setCanSendMediaMessages(Boolean canSendMediaMessages) {
        this.canSendMediaMessages = canSendMediaMessages;
        return this;
    }

    public Boolean getCanSendOtherMessages() {
        return canSendOtherMessages;
    }

    public RestrictChatMember setCanSendOtherMessages(Boolean canSendOtherMessages) {
        this.canSendOtherMessages = canSendOtherMessages;
        return this;
    }

    public Boolean getCanAddWebPagePreviews() {
        return canAddWebPagePreviews;
    }

    public RestrictChatMember setCanAddWebPagePreviews(Boolean canAddWebPagePreviews) {
        this.canAddWebPagePreviews = canAddWebPagePreviews;
        return this;
    }
}
