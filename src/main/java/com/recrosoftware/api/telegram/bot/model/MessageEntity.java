package com.recrosoftware.api.telegram.bot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

import static org.springframework.util.StringUtils.isEmpty;

/**
 * This object represents one special entity in a text message.
 * For example, hashtags, usernames, URLs, etc.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class MessageEntity implements Serializable {
    public static final long serialVersionUID = 3005000L;

    public static final String TYPE_HASHTAG = "hashtag";
    public static final String TYPE_BOT_COMMAND = "bot_command";
    public static final String TYPE_URL = "url";
    public static final String TYPE_EMAIL = "email";
    public static final String TYPE_BOLD = "bold";
    public static final String TYPE_ITALIC = "italic";
    public static final String TYPE_CODE = "code";
    public static final String TYPE_PRE = "pre";
    public static final String TYPE_TEXT_LINK = "text_link";
    public static final String TYPE_TEXT_MENTION = "text_mention";

    /**
     * Type of the entity.
     * Can be mention (@username), hashtag, bot_command, url, email, bold (bold text), italic (italic text), code (monowidth string), pre (monowidth block), text_link (for clickable text URLs), text_mention (for users without usernames).
     */
    @JsonProperty("type")
    private String type;

    /**
     * Offset in UTF-16 code units to the start of the entity.
     */
    @JsonProperty("offset")
    private Integer offset;

    /**
     * Length of the entity in UTF-16 code units.
     */
    @JsonProperty("length")
    private Integer length;

    /**
     * Optional.
     * For “text_link” only, url that will be opened after user taps on the text.
     */
    @JsonProperty("url")
    private String url;

    /**
     * Optional.
     * For “text_mention” only, the mentioned user.
     */
    @JsonProperty("user")
    private User user;

    public String getType() {
        return type;
    }

    public MessageEntity setType(String type) {
        this.type = type;
        return this;
    }

    public Integer getOffset() {
        return offset;
    }

    public MessageEntity setOffset(Integer offset) {
        this.offset = offset;
        return this;
    }

    public Integer getLength() {
        return length;
    }

    public MessageEntity setLength(Integer length) {
        this.length = length;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public MessageEntity setUrl(String url) {
        this.url = url;
        return this;
    }

    public User getUser() {
        return user;
    }

    public MessageEntity setUser(User user) {
        this.user = user;
        return this;
    }

    @JsonIgnore
    public Boolean isUsernameType() {
        return !isEmpty(this.type) && this.type.startsWith("@");
    }
}
