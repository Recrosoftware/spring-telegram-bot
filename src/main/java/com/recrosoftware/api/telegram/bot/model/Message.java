package com.recrosoftware.api.telegram.bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.recrosoftware.api.telegram.bot.model.game.Game;
import com.recrosoftware.api.telegram.bot.model.payment.Invoice;
import com.recrosoftware.api.telegram.bot.model.payment.SuccessfulPayment;
import com.recrosoftware.api.telegram.bot.model.sticker.Sticker;

import java.io.Serializable;
import java.util.List;

/**
 * This object represents a message.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class Message implements Serializable {
    public static final long serialVersionUID = 3005000L;

    /**
     * Unique message identifier inside this chat.
     */
    @JsonProperty("message_id")
    private Integer messageId;

    /**
     * Optional.
     * Sender, empty for messages sent to channels.
     */
    @JsonProperty("from")
    private User from;

    /**
     * Date the message was sent in Unix time.
     */
    @JsonProperty("date")
    private Long date;

    /**
     * Conversation the message belongs to.
     */
    @JsonProperty("chat")
    private Chat chat;

    /**
     * Optional.
     * For forwarded messages, sender of the original message.
     */
    @JsonProperty("forward_from")
    private User forwardFrom;

    /**
     * Optional.
     * For messages forwarded from channels, information about the original channel.
     */
    @JsonProperty("forward_from_chat")
    private Chat forwardFromChat;

    /**
     * Optional.
     * For messages forwarded from channels, identifier of the original message in the channel.
     */
    @JsonProperty("forward_from_message_id")
    private Integer forwardFromMessageId;

    /**
     * Optional.
     * For messages forwarded from channels, signature of the post author if present.
     */
    @JsonProperty("forward_signature")
    private String forwardSignature;

    /**
     * Optional.
     * For forwarded messages, date the original message was sent in Unix time.
     */
    @JsonProperty("forward_date")
    private Long forwardDate;

    /**
     * Optional.
     * For replies, the original message.
     * Note that the Message object in this field will not contain further reply_to_message fields even if it itself is a reply.
     */
    @JsonProperty("reply_to_message")
    private Message replyToMessage;

    /**
     * Optional.
     * Date the message was last edited in Unix time.
     */
    @JsonProperty("edit_date")
    private Long editDate;

    /**
     * Optional.
     * The unique identifier of a media message group this message belongs to.
     */
    @JsonProperty("media_group_id")
    private String mediaGroupId;

    /**
     * Optional.
     * Signature of the post author for messages in channels.
     */
    @JsonProperty("author_signature")
    private String authorSignature;

    /**
     * Optional.
     * For text messages, the actual UTF-8 text of the message, 0-4096 characters.
     */
    @JsonProperty("text")
    private String text;

    /**
     * Optional.
     * For text messages, special entities like usernames, URLs, bot commands, etc. that appear in the text.
     */
    @JsonProperty("entities")
    private List<MessageEntity> entities;

    /**
     * Optional.
     * For messages with a caption, special entities like usernames, URLs, bot commands, etc. that appear in the caption.
     */
    @JsonProperty("caption_entities")
    private List<MessageEntity> captionEntities;

    /**
     * Optional.
     * Message is an audio file, information about the file.
     */
    @JsonProperty("audio")
    private Audio audio;

    /**
     * Optional.
     * Message is a general file, information about the file.
     */
    @JsonProperty("document")
    private Document document;

    /**
     * Optional.
     * Message is a game, information about the game.
     */
    @JsonProperty("game")
    private Game game;

    /**
     * Optional.
     * Message is a photo, available sizes of the photo.
     */
    @JsonProperty("photo")
    private List<PhotoSize> photo;

    /**
     * Optional.
     * Message is a sticker, information about the sticker.
     */
    @JsonProperty("sticker")
    private Sticker sticker;

    /**
     * Optional.
     * Message is a video, information about the video.
     */
    @JsonProperty("video")
    private Video video;

    /**
     * Optional.
     * Message is a voice message, information about the file.
     */
    @JsonProperty("voice")
    private Voice voice;

    /**
     * Optional.
     * Message is a video note, information about the video message.
     */
    @JsonProperty("video_note")
    private VideoNote videoNote;

    /**
     * Optional.
     * Caption for the audio, document, photo, video or voice, 0-200 characters.
     */
    @JsonProperty("caption")
    private String caption;

    /**
     * Optional.
     * Message is a shared contact, information about the contact.
     */
    @JsonProperty("contact")
    private Contact contact;

    /**
     * Optional.
     * Message is a shared location, information about the location.
     */
    @JsonProperty("location")
    private Location location;

    /**
     * Optional.
     * Message is a venue, information about the venue.
     */
    @JsonProperty("venue")
    private Venue venue;

    /**
     * Optional.
     * New members that were added to the group or supergroup and information about them (the bot itself may be one of these members).
     */
    @JsonProperty("new_chat_members")
    private List<User> newChatMembers;

    /**
     * Optional.
     * A member was removed from the group, information about them (this member may be the bot itself.
     */
    @JsonProperty("left_chat_member")
    private User leftChatMember;

    /**
     * Optional.
     * A chat title was changed to this value.
     */
    @JsonProperty("new_chat_title")
    private String newChatTitle;

    /**
     * Optional.
     * A chat photo was change to this value.
     */
    @JsonProperty("new_chat_photo")
    private List<PhotoSize> newChatPhoto;

    /**
     * Optional.
     * Service message: the chat photo was deleted.
     */
    @JsonProperty("delete_chat_photo")
    private Boolean deleteChatPhoto;

    /**
     * Optional.
     * Service message: the group has been created.
     */
    @JsonProperty("group_chat_created")
    private Boolean groupChatCreated;

    /**
     * Optional.
     * Service message: the supergroup has been created.
     * This field can‘t be received in a message coming through updates, because bot can’t be a member of a supergroup when it is created.
     * It can only be found in reply_to_message if someone replies to a very first message in a directly created supergroup.
     */
    @JsonProperty("supergroup_chat_created")
    private Boolean supergroupChatCreated;

    /**
     * Optional.
     * Service message: the channel has been created.
     * This field can‘t be received in a message coming through updates, because bot can’t be a member of a channel when it is created.
     * It can only be found in reply_to_message if someone replies to a very first message in a channel.
     */
    @JsonProperty("channel_chat_created")
    private Boolean channelChatCreated;

    /**
     * Optional.
     * The group has been migrated to a supergroup with the specified identifier.
     * This number may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it.
     * But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier.
     */
    @JsonProperty("migrate_to_chat_id")
    private Long migrateToChatId;

    /**
     * Optional.
     * The supergroup has been migrated from a group with the specified identifier.
     * This number may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it.
     * But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier.
     */
    @JsonProperty("migrate_from_chat_id")
    private Long migrateFromChatId;

    /**
     * Optional.
     * Specified message was pinned.
     * Note that the Message object in this field will not contain further reply_to_message fields even if it is itself a reply.
     */
    @JsonProperty("pinned_message")
    private Message pinnedMessage;

    /**
     * Optional.
     * Message is an invoice for a payment, information about the invoice.
     */
    @JsonProperty("invoice")
    private Invoice invoice;

    /**
     * Optional.
     * Message is a service message about a successful payment, information about the payment.
     */
    @JsonProperty("successful_payment")
    private SuccessfulPayment successfulPayment;

    public Integer getMessageId() {
        return messageId;
    }

    public Message setMessageId(Integer messageId) {
        this.messageId = messageId;
        return this;
    }

    public User getFrom() {
        return from;
    }

    public Message setFrom(User from) {
        this.from = from;
        return this;
    }

    public Long getDate() {
        return date;
    }

    public Message setDate(Long date) {
        this.date = date;
        return this;
    }

    public Chat getChat() {
        return chat;
    }

    public Message setChat(Chat chat) {
        this.chat = chat;
        return this;
    }

    public User getForwardFrom() {
        return forwardFrom;
    }

    public Message setForwardFrom(User forwardFrom) {
        this.forwardFrom = forwardFrom;
        return this;
    }

    public Chat getForwardFromChat() {
        return forwardFromChat;
    }

    public Message setForwardFromChat(Chat forwardFromChat) {
        this.forwardFromChat = forwardFromChat;
        return this;
    }

    public Integer getForwardFromMessageId() {
        return forwardFromMessageId;
    }

    public Message setForwardFromMessageId(Integer forwardFromMessageId) {
        this.forwardFromMessageId = forwardFromMessageId;
        return this;
    }

    public String getForwardSignature() {
        return forwardSignature;
    }

    public Message setForwardSignature(String forwardSignature) {
        this.forwardSignature = forwardSignature;
        return this;
    }

    public Long getForwardDate() {
        return forwardDate;
    }

    public Message setForwardDate(Long forwardDate) {
        this.forwardDate = forwardDate;
        return this;
    }

    public Message getReplyToMessage() {
        return replyToMessage;
    }

    public Message setReplyToMessage(Message replyToMessage) {
        this.replyToMessage = replyToMessage;
        return this;
    }

    public Long getEditDate() {
        return editDate;
    }

    public Message setEditDate(Long editDate) {
        this.editDate = editDate;
        return this;
    }

    public String getMediaGroupId() {
        return mediaGroupId;
    }

    public Message setMediaGroupId(String mediaGroupId) {
        this.mediaGroupId = mediaGroupId;
        return this;
    }

    public String getAuthorSignature() {
        return authorSignature;
    }

    public Message setAuthorSignature(String authorSignature) {
        this.authorSignature = authorSignature;
        return this;
    }

    public String getText() {
        return text;
    }

    public Message setText(String text) {
        this.text = text;
        return this;
    }

    public List<MessageEntity> getEntities() {
        return entities;
    }

    public Message setEntities(List<MessageEntity> entities) {
        this.entities = entities;
        return this;
    }

    public List<MessageEntity> getCaptionEntities() {
        return captionEntities;
    }

    public Message setCaptionEntities(List<MessageEntity> captionEntities) {
        this.captionEntities = captionEntities;
        return this;
    }

    public Audio getAudio() {
        return audio;
    }

    public Message setAudio(Audio audio) {
        this.audio = audio;
        return this;
    }

    public Document getDocument() {
        return document;
    }

    public Message setDocument(Document document) {
        this.document = document;
        return this;
    }

    public Game getGame() {
        return game;
    }

    public Message setGame(Game game) {
        this.game = game;
        return this;
    }

    public List<PhotoSize> getPhoto() {
        return photo;
    }

    public Message setPhoto(List<PhotoSize> photo) {
        this.photo = photo;
        return this;
    }

    public Sticker getSticker() {
        return sticker;
    }

    public Message setSticker(Sticker sticker) {
        this.sticker = sticker;
        return this;
    }

    public Video getVideo() {
        return video;
    }

    public Message setVideo(Video video) {
        this.video = video;
        return this;
    }

    public Voice getVoice() {
        return voice;
    }

    public Message setVoice(Voice voice) {
        this.voice = voice;
        return this;
    }

    public VideoNote getVideoNote() {
        return videoNote;
    }

    public Message setVideoNote(VideoNote videoNote) {
        this.videoNote = videoNote;
        return this;
    }

    public String getCaption() {
        return caption;
    }

    public Message setCaption(String caption) {
        this.caption = caption;
        return this;
    }

    public Contact getContact() {
        return contact;
    }

    public Message setContact(Contact contact) {
        this.contact = contact;
        return this;
    }

    public Location getLocation() {
        return location;
    }

    public Message setLocation(Location location) {
        this.location = location;
        return this;
    }

    public Venue getVenue() {
        return venue;
    }

    public Message setVenue(Venue venue) {
        this.venue = venue;
        return this;
    }

    public List<User> getNewChatMembers() {
        return newChatMembers;
    }

    public Message setNewChatMembers(List<User> newChatMembers) {
        this.newChatMembers = newChatMembers;
        return this;
    }

    public User getLeftChatMember() {
        return leftChatMember;
    }

    public Message setLeftChatMember(User leftChatMember) {
        this.leftChatMember = leftChatMember;
        return this;
    }

    public String getNewChatTitle() {
        return newChatTitle;
    }

    public Message setNewChatTitle(String newChatTitle) {
        this.newChatTitle = newChatTitle;
        return this;
    }

    public List<PhotoSize> getNewChatPhoto() {
        return newChatPhoto;
    }

    public Message setNewChatPhoto(List<PhotoSize> newChatPhoto) {
        this.newChatPhoto = newChatPhoto;
        return this;
    }

    public Boolean getDeleteChatPhoto() {
        return deleteChatPhoto;
    }

    public Message setDeleteChatPhoto(Boolean deleteChatPhoto) {
        this.deleteChatPhoto = deleteChatPhoto;
        return this;
    }

    public Boolean getGroupChatCreated() {
        return groupChatCreated;
    }

    public Message setGroupChatCreated(Boolean groupChatCreated) {
        this.groupChatCreated = groupChatCreated;
        return this;
    }

    public Boolean getSupergroupChatCreated() {
        return supergroupChatCreated;
    }

    public Message setSupergroupChatCreated(Boolean supergroupChatCreated) {
        this.supergroupChatCreated = supergroupChatCreated;
        return this;
    }

    public Boolean getChannelChatCreated() {
        return channelChatCreated;
    }

    public Message setChannelChatCreated(Boolean channelChatCreated) {
        this.channelChatCreated = channelChatCreated;
        return this;
    }

    public Long getMigrateToChatId() {
        return migrateToChatId;
    }

    public Message setMigrateToChatId(Long migrateToChatId) {
        this.migrateToChatId = migrateToChatId;
        return this;
    }

    public Long getMigrateFromChatId() {
        return migrateFromChatId;
    }

    public Message setMigrateFromChatId(Long migrateFromChatId) {
        this.migrateFromChatId = migrateFromChatId;
        return this;
    }

    public Message getPinnedMessage() {
        return pinnedMessage;
    }

    public Message setPinnedMessage(Message pinnedMessage) {
        this.pinnedMessage = pinnedMessage;
        return this;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public Message setInvoice(Invoice invoice) {
        this.invoice = invoice;
        return this;
    }

    public SuccessfulPayment getSuccessfulPayment() {
        return successfulPayment;
    }

    public Message setSuccessfulPayment(SuccessfulPayment successfulPayment) {
        this.successfulPayment = successfulPayment;
        return this;
    }
}
