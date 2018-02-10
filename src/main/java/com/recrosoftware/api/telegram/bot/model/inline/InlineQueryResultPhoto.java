package com.recrosoftware.api.telegram.bot.model.inline;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.recrosoftware.utils.validation.annotation.Range;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

import java.io.Serializable;

/**
 * Represents a link to a photo.
 * By default, this photo will be sent by the user with optional caption.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the photo.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class InlineQueryResultPhoto extends InlineQueryResult<InlineQueryResultPhoto> implements Serializable {
    public static final long serialVersionUID = 3005000L;

    private final static String FIELD_PHOTO_URL = "photo_url";
    private final static String FIELD_THUMB_URL = "thumb_url";
    private final static String FIELD_PHOTO_WIDTH = "photo_width";
    private final static String FIELD_PHOTO_HEIGHT = "photo_height";
    private final static String FIELD_TITLE = "title";
    private final static String FIELD_DESCRIPTION = "description";
    private final static String FIELD_CAPTION = "caption";

    /**
     * A valid URL of the photo.
     * Photo must be in <b>jpeg</b> format.
     * Photo size must not exceed 5MB.
     */
    @Required
    @Validate(as = FIELD_PHOTO_URL)
    @JsonProperty(FIELD_PHOTO_URL)
    private String photoUrl;

    /**
     * URL of the thumbnail for the photo.
     */
    @Required
    @Validate(as = FIELD_THUMB_URL)
    @JsonProperty(FIELD_THUMB_URL)
    private String thumbUrl;

    /**
     * Optional.
     * Width of the photo.
     */
    @JsonProperty(FIELD_PHOTO_WIDTH)
    private Integer photoWidth;

    /**
     * Optional.
     * Height of the photo.
     */
    @JsonProperty(FIELD_PHOTO_URL)
    private Integer photoHeight;

    /**
     * Optional.
     * Title for the result.
     */
    @JsonProperty(FIELD_TITLE)
    private String title;

    /**
     * Optional.
     * Short description of the result.
     */
    @JsonProperty(FIELD_DESCRIPTION)
    private String description;

    /**
     * Optional.
     * Caption of the photo to be sent, 0-200 characters.
     */
    @Range(to = 200)
    @Validate(as = FIELD_CAPTION)
    @JsonProperty(FIELD_CAPTION)
    private String caption;

    public InlineQueryResultPhoto() {
        super(InlineQueryResult.TYPE_PHOTO);
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public InlineQueryResultPhoto setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
        return this;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public InlineQueryResultPhoto setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
        return this;
    }

    public Integer getPhotoWidth() {
        return photoWidth;
    }

    public InlineQueryResultPhoto setPhotoWidth(Integer photoWidth) {
        this.photoWidth = photoWidth;
        return this;
    }

    public Integer getPhotoHeight() {
        return photoHeight;
    }

    public InlineQueryResultPhoto setPhotoHeight(Integer photoHeight) {
        this.photoHeight = photoHeight;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public InlineQueryResultPhoto setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public InlineQueryResultPhoto setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCaption() {
        return caption;
    }

    public InlineQueryResultPhoto setCaption(String caption) {
        this.caption = caption;
        return this;
    }
}
