package com.recrosoftware.api.telegram.bot.model.inline;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.recrosoftware.utils.validation.annotation.Range;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

import java.io.Serializable;

/**
 * Represents a link to a photo stored on the Telegram servers.
 * By default, this photo will be sent by the user with an optional caption.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the photo.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class InlineQueryResultCachedPhoto extends InlineQueryResult<InlineQueryResultCachedPhoto> implements Serializable {
    public static final long serialVersionUID = 3005000L;

    private final static String FIELD_PHOTO_FILE_ID = "photo_file_id";
    private final static String FIELD_TITLE = "title";
    private final static String FIELD_DESCRIPTION = "description";
    private final static String FIELD_CAPTION = "caption";

    /**
     * A valid file identifier of the photo.
     */
    @Required
    @Validate(as = FIELD_PHOTO_FILE_ID)
    @JsonProperty(FIELD_PHOTO_FILE_ID)
    private String photoFileId;

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

    public InlineQueryResultCachedPhoto() {
        super(InlineQueryResult.TYPE_PHOTO);
    }

    public String getPhotoFileId() {
        return photoFileId;
    }

    public InlineQueryResultCachedPhoto setPhotoFileId(String photoFileId) {
        this.photoFileId = photoFileId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public InlineQueryResultCachedPhoto setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public InlineQueryResultCachedPhoto setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCaption() {
        return caption;
    }

    public InlineQueryResultCachedPhoto setCaption(String caption) {
        this.caption = caption;
        return this;
    }
}
