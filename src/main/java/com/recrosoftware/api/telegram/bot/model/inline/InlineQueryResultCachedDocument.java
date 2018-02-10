package com.recrosoftware.api.telegram.bot.model.inline;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.recrosoftware.utils.validation.annotation.Range;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

import java.io.Serializable;

/**
 * Represents a link to a file stored on the Telegram servers.
 * By default, this file will be sent by the user with an optional caption.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the file.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class InlineQueryResultCachedDocument extends InlineQueryResult<InlineQueryResultCachedDocument> implements Serializable {
    public static final long serialVersionUID = 3005000L;

    private final static String FIELD_TITLE = "title";
    private final static String FIELD_DOCUMENT_FILE_ID = "document_file_id";
    private final static String FIELD_DESCRIPTION = "description";
    private final static String FIELD_CAPTION = "caption";

    /**
     * Title for the result.
     */
    @Required
    @Validate(as = FIELD_TITLE)
    @JsonProperty(FIELD_TITLE)
    private String title;

    /**
     * A valid file identifier for the file.
     */
    @Required
    @Validate(as = FIELD_DOCUMENT_FILE_ID)
    @JsonProperty(FIELD_DOCUMENT_FILE_ID)
    private String documentFileId;

    /**
     * Optional.
     * Short description of the result.
     */
    @JsonProperty(FIELD_DESCRIPTION)
    private String description;

    /**
     * Optional.
     * Caption of the document to be sent, 0-200 characters.
     */
    @Range(to = 200)
    @Validate(as = FIELD_CAPTION)
    @JsonProperty(FIELD_CAPTION)
    private String caption;

    public InlineQueryResultCachedDocument() {
        super(InlineQueryResult.TYPE_DOCUMENT);
    }

    public String getTitle() {
        return title;
    }

    public InlineQueryResultCachedDocument setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDocumentFileId() {
        return documentFileId;
    }

    public InlineQueryResultCachedDocument setDocumentFileId(String documentFileId) {
        this.documentFileId = documentFileId;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public InlineQueryResultCachedDocument setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCaption() {
        return caption;
    }

    public InlineQueryResultCachedDocument setCaption(String caption) {
        this.caption = caption;
        return this;
    }
}
