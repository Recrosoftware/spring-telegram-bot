package com.recrosoftware.api.telegram.bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * This object contains information about one member of a chat.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class ChatMember implements Serializable {
    public static final long serialVersionUID = 3005000L;

    /**
     * Information about the user.
     */
    @JsonProperty("user")
    private User user;

    /**
     * The member's status in the chat.
     * Can be “creator”, “administrator”, “member”, “restricted”, “left” or “kicked”.
     */
    @JsonProperty("status")
    private String status;

    /**
     * Optional.
     * Restricted and kicked only.
     * Date when restrictions will be lifted for this user, unix time.
     */
    @JsonProperty("until_date")
    private Long untilDate;

    /**
     * Optional.
     * Administrators only.
     * True, if the bot is allowed to edit administrator privileges of that user.
     */
    @JsonProperty("can_be_edited")
    private Boolean canBeEdited;

    /**
     * Optional.
     * Administrators only.
     * True, if the administrator can change the chat title, photo and other settings.
     */
    @JsonProperty("can_change_info")
    private Boolean canChangeInfo;

    /**
     * Optional.
     * Administrators only.
     * True, if the administrator can post in the channel, channels only.
     */
    @JsonProperty("can_post_messages")
    private Boolean canPostMessages;

    /**
     * Optional.
     * Administrators only.
     * True, if the administrator can edit messages of other users and can pin messages, channels only.
     */
    @JsonProperty("can_edit_messages")
    private Boolean canEditMessages;

    /**
     * Optional.
     * Administrators only.
     * True, if the administrator can delete messages of other users.
     */
    @JsonProperty("can_delete_messages")
    private Boolean canDeleteMessages;

    /**
     * Optional.
     * Administrators only.
     * True, if the administrator can invite new users to the chat.
     */
    @JsonProperty("can_invite_users")
    private Boolean canInviteUsers;

    /**
     * Optional.
     * Administrators only.
     * True, if the administrator can restrict, ban or unban chat members.
     */
    @JsonProperty("can_restrict_members")
    private Boolean canRestrictMembers;

    /**
     * Optional.
     * Administrators only.
     * True, if the administrator can pin messages, supergroups only.
     */
    @JsonProperty("can_pin_messages")
    private Boolean canPinMessages;

    /**
     * Optional.
     * Administrators only.
     * True, if the administrator can add new administrators with a subset of his own privileges or demote administrators that he has promoted, directly or indirectly (promoted by administrators that were appointed by the user).
     */
    @JsonProperty("can_promote_members")
    private Boolean canPromoteMembers;

    /**
     * Optional.
     * Restricted only.
     * True, if the user can send text messages, contacts, locations and venues.
     */
    @JsonProperty("can_send_messages")
    private Boolean canSendMessages;

    /**
     * Optional.
     * Restricted only.
     * True, if the user can send audios, documents, photos, videos, video notes and voice notes, implies can_send_messages.
     */
    @JsonProperty("can_send_media_messages")
    private Boolean canSendMediaMessages;

    /**
     * Optional.
     * Restricted only.
     * True, if the user can send animations, games, stickers and use inline bots, implies can_send_media_messages.
     */
    @JsonProperty("can_send_other_messages")
    private Boolean canSendOtherMessages;

    /**
     * Optional.
     * Restricted only.
     * True, if user may add web page previews to his messages, implies can_send_media_messages.
     */
    @JsonProperty("can_add_web_page_previews")
    private Boolean canAddWebPagePreviews;

    public User getUser() {
        return user;
    }

    public ChatMember setUser(User user) {
        this.user = user;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public ChatMember setStatus(String status) {
        this.status = status;
        return this;
    }

    public Long getUntilDate() {
        return untilDate;
    }

    public ChatMember setUntilDate(Long untilDate) {
        this.untilDate = untilDate;
        return this;
    }

    public Boolean getCanBeEdited() {
        return canBeEdited;
    }

    public ChatMember setCanBeEdited(Boolean canBeEdited) {
        this.canBeEdited = canBeEdited;
        return this;
    }

    public Boolean getCanChangeInfo() {
        return canChangeInfo;
    }

    public ChatMember setCanChangeInfo(Boolean canChangeInfo) {
        this.canChangeInfo = canChangeInfo;
        return this;
    }

    public Boolean getCanPostMessages() {
        return canPostMessages;
    }

    public ChatMember setCanPostMessages(Boolean canPostMessages) {
        this.canPostMessages = canPostMessages;
        return this;
    }

    public Boolean getCanEditMessages() {
        return canEditMessages;
    }

    public ChatMember setCanEditMessages(Boolean canEditMessages) {
        this.canEditMessages = canEditMessages;
        return this;
    }

    public Boolean getCanDeleteMessages() {
        return canDeleteMessages;
    }

    public ChatMember setCanDeleteMessages(Boolean canDeleteMessages) {
        this.canDeleteMessages = canDeleteMessages;
        return this;
    }

    public Boolean getCanInviteUsers() {
        return canInviteUsers;
    }

    public ChatMember setCanInviteUsers(Boolean canInviteUsers) {
        this.canInviteUsers = canInviteUsers;
        return this;
    }

    public Boolean getCanRestrictMembers() {
        return canRestrictMembers;
    }

    public ChatMember setCanRestrictMembers(Boolean canRestrictMembers) {
        this.canRestrictMembers = canRestrictMembers;
        return this;
    }

    public Boolean getCanPinMessages() {
        return canPinMessages;
    }

    public ChatMember setCanPinMessages(Boolean canPinMessages) {
        this.canPinMessages = canPinMessages;
        return this;
    }

    public Boolean getCanPromoteMembers() {
        return canPromoteMembers;
    }

    public ChatMember setCanPromoteMembers(Boolean canPromoteMembers) {
        this.canPromoteMembers = canPromoteMembers;
        return this;
    }

    public Boolean getCanSendMessages() {
        return canSendMessages;
    }

    public ChatMember setCanSendMessages(Boolean canSendMessages) {
        this.canSendMessages = canSendMessages;
        return this;
    }

    public Boolean getCanSendMediaMessages() {
        return canSendMediaMessages;
    }

    public ChatMember setCanSendMediaMessages(Boolean canSendMediaMessages) {
        this.canSendMediaMessages = canSendMediaMessages;
        return this;
    }

    public Boolean getCanSendOtherMessages() {
        return canSendOtherMessages;
    }

    public ChatMember setCanSendOtherMessages(Boolean canSendOtherMessages) {
        this.canSendOtherMessages = canSendOtherMessages;
        return this;
    }

    public Boolean getCanAddWebPagePreviews() {
        return canAddWebPagePreviews;
    }

    public ChatMember setCanAddWebPagePreviews(Boolean canAddWebPagePreviews) {
        this.canAddWebPagePreviews = canAddWebPagePreviews;
        return this;
    }
}
