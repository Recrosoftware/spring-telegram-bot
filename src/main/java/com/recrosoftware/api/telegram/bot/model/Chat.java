package com.recrosoftware.api.telegram.bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * This object represents a chat.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class Chat implements Serializable {
    public static final long serialVersionUID = 3005000L;

    /**
     * Unique identifier for this chat.
     * This number may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it.
     * But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier.
     */
    @JsonProperty("id")
    private Long id;

    /**
     * Type of chat, can be either “private”, “group”, “supergroup” or “channel”.
     */
    @JsonProperty("type")
    private String type;

    /**
     * Optional.
     * Title, for supergroups, channels and group chats.
     */
    @JsonProperty("title")
    private String title;

    /**
     * Optional.
     * Username, for private chats, supergroups and channels if available.
     */
    @JsonProperty("username")
    private String username;

    /**
     * Optional.
     * First name of the other party in a private chat.
     */
    @JsonProperty("first_name")
    private String firstName;

    /**
     * Optional.
     * Last name of the other party in a private chat.
     */
    @JsonProperty("last_name")
    private String lastName;

    /**
     * Optional.
     * True if a group has ‘All Members Are Admins’ enabled.
     */
    @JsonProperty("all_members_are_administrators")
    private Boolean allMembersAreAdministrators;

    /**
     * Optional.
     * Chat photo.
     * Returned only in {@link com.recrosoftware.api.telegram.bot.request.GetChat}.
     */
    @JsonProperty("photo")
    private ChatPhoto photo;

    /**
     * Optional.
     * Description, for supergroups and channel chats.
     * Returned only in {@link com.recrosoftware.api.telegram.bot.request.GetChat}.
     */
    @JsonProperty("description")
    private String description;

    /**
     * Optional.
     * Chat invite link, for supergroups and channel chats.
     * Returned only in {@link com.recrosoftware.api.telegram.bot.request.GetChat}.
     */
    @JsonProperty("invite_link")
    private String inviteLink;

    /**
     * Optional.
     * Pinned message, for supergroups and channel chats.
     * Returned only in {@link com.recrosoftware.api.telegram.bot.request.GetChat}.
     */
    @JsonProperty("pinned_message")
    private Message pinnedMessage;

    /**
     * Optional.
     * For supergroups, name of group sticker set.
     * Returned only in {@link com.recrosoftware.api.telegram.bot.request.GetChat}.
     */
    @JsonProperty("sticker_set_name")
    private String stickerSetName;

    /**
     * Optional.
     * True, if the bot can change the group sticker set.
     * Returned only in {@link com.recrosoftware.api.telegram.bot.request.GetChat}.
     */
    @JsonProperty("can_set_sticker_set")
    private Boolean canSetStickerSet;

    public Long getId() {
        return id;
    }

    public Chat setId(Long id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public Chat setType(String type) {
        this.type = type;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Chat setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Chat setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Chat setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Chat setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Boolean getAllMembersAreAdministrators() {
        return allMembersAreAdministrators;
    }

    public Chat setAllMembersAreAdministrators(Boolean allMembersAreAdministrators) {
        this.allMembersAreAdministrators = allMembersAreAdministrators;
        return this;
    }

    public ChatPhoto getPhoto() {
        return photo;
    }

    public Chat setPhoto(ChatPhoto photo) {
        this.photo = photo;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Chat setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getInviteLink() {
        return inviteLink;
    }

    public Chat setInviteLink(String inviteLink) {
        this.inviteLink = inviteLink;
        return this;
    }

    public Message getPinnedMessage() {
        return pinnedMessage;
    }

    public Chat setPinnedMessage(Message pinnedMessage) {
        this.pinnedMessage = pinnedMessage;
        return this;
    }

    public String getStickerSetName() {
        return stickerSetName;
    }

    public Chat setStickerSetName(String stickerSetName) {
        this.stickerSetName = stickerSetName;
        return this;
    }

    public Boolean getCanSetStickerSet() {
        return canSetStickerSet;
    }

    public Chat setCanSetStickerSet(Boolean canSetStickerSet) {
        this.canSetStickerSet = canSetStickerSet;
        return this;
    }
}
