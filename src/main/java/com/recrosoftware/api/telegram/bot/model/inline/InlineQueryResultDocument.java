package com.recrosoftware.api.telegram.bot.model.inline;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.recrosoftware.utils.validation.annotation.Range;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

import java.io.Serializable;

/**
 * Represents a link to a file.
 * By default, this file will be sent by the user with an optional caption.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the file.
 * Currently, only .PDF and .ZIP files can be sent using this method.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class InlineQueryResultDocument extends InlineQueryResult<InlineQueryResultDocument> implements Serializable {
    public static final long serialVersionUID = 3005000L;

    private final static String FIELD_TITLE = "title";
    private final static String FIELD_CAPTION = "caption";
    private final static String FIELD_DOCUMENT_URL = "document_url";
    private final static String FIELD_MIME_TYPE = "mime_type";
    private final static String FIELD_DESCRIPTION = "description";
    private final static String FIELD_THUMB_URL = "thumb_url";
    private final static String FIELD_THUMB_WIDTH = "thumb_width";
    private final static String FIELD_THUMB_HEIGHT = "thumb_height";
    /**
     * Title for the result.
     */
    @Required
    @Validate(as = FIELD_TITLE)
    @JsonProperty(FIELD_TITLE)
    private String title;

    /**
     * Optional.
     * Caption of the document to be sent, 0-200 characters.
     */
    @Range(to = 200)
    @Validate(as = FIELD_CAPTION)
    @JsonProperty(FIELD_CAPTION)
    private String caption;

    /**
     * A valid URL for the file.
     */
    @Required
    @Validate(as = FIELD_DOCUMENT_URL)
    @JsonProperty(FIELD_DOCUMENT_URL)
    private String documentUrl;

    /**
     * Mime type of the content of the file, either “application/pdf” or “application/zip”.
     */
    @Required
    @Validate(as = FIELD_MIME_TYPE)
    @JsonProperty(FIELD_MIME_TYPE)
    private String mimeType;

    /**
     * Optional.
     * Short description of the result.
     */
    @JsonProperty(FIELD_DESCRIPTION)
    private String description;

    /**
     * Optional.
     * URL of the thumbnail (jpeg only) for the file.
     */
    @JsonProperty(FIELD_THUMB_URL)
    private String thumbUrl;

    /**
     * Optional.
     * Thumbnail width.
     */
    @JsonProperty(FIELD_THUMB_WIDTH)
    private Integer thumbWidth;

    /**
     * Optional.
     * Thumbnail height.
     */
    @JsonProperty(FIELD_THUMB_HEIGHT)
    private Integer thumbHeight;

    public InlineQueryResultDocument() {
        super(InlineQueryResult.TYPE_DOCUMENT);
    }

    public String getTitle() {
        return title;
    }

    public InlineQueryResultDocument setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getCaption() {
        return caption;
    }

    public InlineQueryResultDocument setCaption(String caption) {
        this.caption = caption;
        return this;
    }

    public String getDocumentUrl() {
        return documentUrl;
    }

    public InlineQueryResultDocument setDocumentUrl(String documentUrl) {
        this.documentUrl = documentUrl;
        return this;
    }

    public String getMimeType() {
        return mimeType;
    }

    public InlineQueryResultDocument setMimeType(String mimeType) {
        this.mimeType = mimeType;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public InlineQueryResultDocument setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public InlineQueryResultDocument setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
        return this;
    }

    public Integer getThumbWidth() {
        return thumbWidth;
    }

    public InlineQueryResultDocument setThumbWidth(Integer thumbWidth) {
        this.thumbWidth = thumbWidth;
        return this;
    }

    public Integer getThumbHeight() {
        return thumbHeight;
    }

    public InlineQueryResultDocument setThumbHeight(Integer thumbHeight) {
        this.thumbHeight = thumbHeight;
        return this;
    }
}
