package com.recrosoftware.api.telegram.bot.model.inline;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.recrosoftware.utils.validation.annotation.Range;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

import java.io.Serializable;

/**
 * Represents a link to an animated GIF file stored on the Telegram servers.
 * By default, this animated GIF file will be sent by the user with an optional caption.
 * Alternatively, you can use input_message_content to send a message with specified content instead of the animation.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class InlineQueryResultCachedGif extends InlineQueryResult<InlineQueryResultCachedGif> implements Serializable {
    public static final long serialVersionUID = 3005000L;

    private final static String FIELD_GIF_FILE_ID = "gif_file_id";
    private final static String FIELD_TITLE = "title";
    private final static String FIELD_CAPTION = "caption";

    /**
     * A valid file identifier for the GIF file.
     */
    @Required
    @Validate(as = FIELD_GIF_FILE_ID)
    @JsonProperty(FIELD_GIF_FILE_ID)
    private String gifFileId;

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

    public InlineQueryResultCachedGif() {
        super(InlineQueryResult.TYPE_GIF);
    }

    public String getGifFileId() {
        return gifFileId;
    }

    public InlineQueryResultCachedGif setGifFileId(String gifFileId) {
        this.gifFileId = gifFileId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public InlineQueryResultCachedGif setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getCaption() {
        return caption;
    }

    public InlineQueryResultCachedGif setCaption(String caption) {
        this.caption = caption;
        return this;
    }
}
