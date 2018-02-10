package com.recrosoftware.api.telegram.bot.model.inline;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.recrosoftware.utils.validation.annotation.Range;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

import java.io.Serializable;

/**
 * Represents a link to a video animation (H.264/MPEG-4 AVC video without sound).
 * By default, this animated MPEG-4 file will be sent by the user with optional caption.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the animation.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class InlineQueryResultMpeg4Gif extends InlineQueryResult<InlineQueryResultMpeg4Gif> implements Serializable {
    public static final long serialVersionUID = 3005000L;

    private final static String FIELD_MPEG4_URL = "mpeg4_url";
    private final static String FIELD_MPEG4_WIDTH = "mpeg4_width";
    private final static String FIELD_MPEG4_HEIGHT = "mpeg4_height";
    private final static String FIELD_MPEG4_DURATION = "mpeg4_duration";
    private final static String FIELD_THUMB_URL = "thumb_url";
    private final static String FIELD_TITLE = "title";
    private final static String FIELD_CAPTION = "caption";

    /**
     * A valid URL for the MP4 file.
     * File size must not exceed 1MB.
     */
    @Required
    @Validate(as = FIELD_MPEG4_URL)
    @JsonProperty(FIELD_MPEG4_URL)
    private String mpeg4Url;

    /**
     * Optional.
     * Video width.
     */
    @JsonProperty(FIELD_MPEG4_WIDTH)
    private Integer mpeg4Width;

    /**
     * Optional.
     * Video height.
     */
    @JsonProperty(FIELD_MPEG4_HEIGHT)
    private Integer mpeg4Height;

    /**
     * Optional.
     * Video duration.
     */
    @JsonProperty(FIELD_MPEG4_DURATION)
    private Integer mpeg4Duration;

    /**
     * URL of the static thumbnail (jpeg or gif) for the result.
     */
    @Required
    @Validate(as = FIELD_THUMB_URL)
    @JsonProperty(FIELD_THUMB_URL)
    private String thumbUrl;

    /**
     * Optional.
     * Title for the result.
     */
    @JsonProperty(FIELD_TITLE)
    private String title;

    /**
     * Optional.
     * Caption of the MPEG-4 file to be sent, 0-200 characters.
     */
    @Range(to = 200)
    @Validate(as = FIELD_CAPTION)
    @JsonProperty(FIELD_CAPTION)
    private String caption;

    public InlineQueryResultMpeg4Gif() {
        super(InlineQueryResult.TYPE_MPEG4_GIF);
    }

    public String getMpeg4Url() {
        return mpeg4Url;
    }

    public InlineQueryResultMpeg4Gif setMpeg4Url(String mpeg4Url) {
        this.mpeg4Url = mpeg4Url;
        return this;
    }

    public Integer getMpeg4Width() {
        return mpeg4Width;
    }

    public InlineQueryResultMpeg4Gif setMpeg4Width(Integer mpeg4Width) {
        this.mpeg4Width = mpeg4Width;
        return this;
    }

    public Integer getMpeg4Height() {
        return mpeg4Height;
    }

    public InlineQueryResultMpeg4Gif setMpeg4Height(Integer mpeg4Height) {
        this.mpeg4Height = mpeg4Height;
        return this;
    }

    public Integer getMpeg4Duration() {
        return mpeg4Duration;
    }

    public InlineQueryResultMpeg4Gif setMpeg4Duration(Integer mpeg4Duration) {
        this.mpeg4Duration = mpeg4Duration;
        return this;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public InlineQueryResultMpeg4Gif setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public InlineQueryResultMpeg4Gif setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getCaption() {
        return caption;
    }

    public InlineQueryResultMpeg4Gif setCaption(String caption) {
        this.caption = caption;
        return this;
    }
}
