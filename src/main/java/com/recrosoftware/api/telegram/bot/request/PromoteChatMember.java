package com.recrosoftware.api.telegram.bot.request;

import com.fasterxml.jackson.core.type.TypeReference;
import com.recrosoftware.api.telegram.bot.annotation.Serialize;
import com.recrosoftware.api.telegram.bot.model.api.ApiResponse;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public class PromoteChatMember extends AbstractRequestItem<Boolean> {
    private static final String FIELD_CHAT_ID = "chat_id";
    private static final String FIELD_USER_ID = "user_id";
    private static final String FIELD_CAN_CHANGE_INFO = "can_change_info";
    private static final String FIELD_CAN_POST_MESSAGES = "can_post_messages";
    private static final String FIELD_CAN_EDIT_MESSAGES = "can_edit_messages";
    private static final String FIELD_CAN_DELETE_MESSAGES = "can_delete_messages";
    private static final String FIELD_CAN_INVITE_USERS = "can_invite_users";
    private static final String FIELD_CAN_RESTRICT_MEMBERS = "can_restrict_members";
    private static final String FIELD_CAN_PIN_MESSAGES = "can_pin_messages";
    private static final String FIELD_CAN_PROMOTE_MEMBERS = "can_promote_members";

    @Required
    @Validate(as = FIELD_CHAT_ID)
    @Serialize(as = FIELD_CHAT_ID)
    private String chatId;

    @Required
    @Validate(as = FIELD_USER_ID)
    @Serialize(as = FIELD_USER_ID)
    private Integer userId;

    @Serialize(as = FIELD_CAN_CHANGE_INFO)
    private Boolean canChangeInfo;

    @Serialize(as = FIELD_CAN_POST_MESSAGES)
    private Boolean canPostMessages;

    @Serialize(as = FIELD_CAN_EDIT_MESSAGES)
    private Boolean canEditMessages;

    @Serialize(as = FIELD_CAN_DELETE_MESSAGES)
    private Boolean canDeleteMessages;

    @Serialize(as = FIELD_CAN_INVITE_USERS)
    private Boolean canInviteUsers;

    @Serialize(as = FIELD_CAN_RESTRICT_MEMBERS)
    private Boolean canRestrictMembers;

    @Serialize(as = FIELD_CAN_PIN_MESSAGES)
    private Boolean canPinMessages;

    @Serialize(as = FIELD_CAN_PROMOTE_MEMBERS)
    private Boolean canPromoteMembers;

    public PromoteChatMember() {
        super("promoteChatMember", new TypeReference<ApiResponse<Boolean>>() {
        });
    }

    public String getChatId() {
        return chatId;
    }

    public PromoteChatMember setChatId(String chatId) {
        this.chatId = chatId;
        return this;
    }

    public PromoteChatMember setChatId(Long chatId) {
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

    public PromoteChatMember setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Boolean getCanChangeInfo() {
        return canChangeInfo;
    }

    public PromoteChatMember setCanChangeInfo(Boolean canChangeInfo) {
        this.canChangeInfo = canChangeInfo;
        return this;
    }

    public Boolean getCanPostMessages() {
        return canPostMessages;
    }

    public PromoteChatMember setCanPostMessages(Boolean canPostMessages) {
        this.canPostMessages = canPostMessages;
        return this;
    }

    public Boolean getCanEditMessages() {
        return canEditMessages;
    }

    public PromoteChatMember setCanEditMessages(Boolean canEditMessages) {
        this.canEditMessages = canEditMessages;
        return this;
    }

    public Boolean getCanDeleteMessages() {
        return canDeleteMessages;
    }

    public PromoteChatMember setCanDeleteMessages(Boolean canDeleteMessages) {
        this.canDeleteMessages = canDeleteMessages;
        return this;
    }

    public Boolean getCanInviteUsers() {
        return canInviteUsers;
    }

    public PromoteChatMember setCanInviteUsers(Boolean canInviteUsers) {
        this.canInviteUsers = canInviteUsers;
        return this;
    }

    public Boolean getCanRestrictMembers() {
        return canRestrictMembers;
    }

    public PromoteChatMember setCanRestrictMembers(Boolean canRestrictMembers) {
        this.canRestrictMembers = canRestrictMembers;
        return this;
    }

    public Boolean getCanPinMessages() {
        return canPinMessages;
    }

    public PromoteChatMember setCanPinMessages(Boolean canPinMessages) {
        this.canPinMessages = canPinMessages;
        return this;
    }

    public Boolean getCanPromoteMembers() {
        return canPromoteMembers;
    }

    public PromoteChatMember setCanPromoteMembers(Boolean canPromoteMembers) {
        this.canPromoteMembers = canPromoteMembers;
        return this;
    }
}
