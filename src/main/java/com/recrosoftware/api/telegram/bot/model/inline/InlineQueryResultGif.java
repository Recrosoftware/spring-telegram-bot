package com.recrosoftware.api.telegram.bot.model.inline;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.recrosoftware.utils.validation.annotation.Range;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

import java.io.Serializable;

/**
 * Represents a link to an animated GIF file.
 * By default, this animated GIF file will be sent by the user with optional caption.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the animation.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class InlineQueryResultGif extends InlineQueryResult<InlineQueryResultGif> implements Serializable {
    public static final long serialVersionUID = 3005000L;

    private final static String FIELD_GIF_URL = "gif_url";
    private final static String FIELD_GIF_WIDTH = "gif_width";
    private final static String FIELD_GIF_HEIGHT = "gif_height";
    private final static String FIELD_GIF_DURATION = "gif_duration";
    private final static String FIELD_THUMB_URL = "thumb_url";
    private final static String FIELD_TITLE = "title";
    private final static String FIELD_CAPTION = "caption";

    /**
     * A valid URL for the GIF file.
     * File size must not exceed 1MB.
     */
    @Required
    @Validate(as = FIELD_GIF_URL)
    @JsonProperty(FIELD_GIF_URL)
    private String gifUrl;

    /**
     * Optional.
     * Width of the GIF.
     */
    @JsonProperty(FIELD_GIF_WIDTH)
    private Integer gifWidth;

    /**
     * Optional.
     * Height of the GIF.
     */
    @JsonProperty(FIELD_GIF_HEIGHT)
    private Integer gifHeight;

    /**
     * Optional.
     * Duration of the GIF.
     */
    @JsonProperty(FIELD_GIF_DURATION)
    private Integer gifDuration;

    /**
     * URL of the static thumbnail for the result (jpeg or gif).
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
     * Caption of the GIF file to be sent, 0-200 characters.
     */
    @Range(to = 200)
    @Validate(as = FIELD_CAPTION)
    @JsonProperty(FIELD_CAPTION)
    private String caption;

    public InlineQueryResultGif() {
        super(InlineQueryResult.TYPE_GIF);
    }

    public String getGifUrl() {
        return gifUrl;
    }

    public InlineQueryResultGif setGifUrl(String gifUrl) {
        this.gifUrl = gifUrl;
        return this;
    }

    public Integer getGifWidth() {
        return gifWidth;
    }

    public InlineQueryResultGif setGifWidth(Integer gifWidth) {
        this.gifWidth = gifWidth;
        return this;
    }

    public Integer getGifHeight() {
        return gifHeight;
    }

    public InlineQueryResultGif setGifHeight(Integer gifHeight) {
        this.gifHeight = gifHeight;
        return this;
    }

    public Integer getGifDuration() {
        return gifDuration;
    }

    public InlineQueryResultGif setGifDuration(Integer gifDuration) {
        this.gifDuration = gifDuration;
        return this;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public InlineQueryResultGif setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public InlineQueryResultGif setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getCaption() {
        return caption;
    }

    public InlineQueryResultGif setCaption(String caption) {
        this.caption = caption;
        return this;
    }
}
