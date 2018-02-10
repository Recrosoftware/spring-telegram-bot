package com.recrosoftware.api.telegram.bot.model.inline;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.recrosoftware.utils.validation.annotation.Range;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

import java.io.Serializable;

/**
 * Represents a link to a video animation (H.264/MPEG-4 AVC video without sound) stored on the Telegram servers.
 * By default, this animated MPEG-4 file will be sent by the user with an optional caption.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the animation.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class InlineQueryResultCachedMpeg4Gif extends InlineQueryResult<InlineQueryResultCachedMpeg4Gif> implements Serializable {
    public static final long serialVersionUID = 3005000L;

    private final static String FIELD_MPEG4_FILE_ID = "mpeg4_file_id";
    private final static String FIELD_TITLE = "title";
    private final static String FIELD_CAPTION = "caption";

    /**
     * A valid file identifier for the MP4 file.
     */
    @Required
    @Validate(as = FIELD_MPEG4_FILE_ID)
    @JsonProperty(FIELD_MPEG4_FILE_ID)
    private String mpeg4FileId;

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

    public InlineQueryResultCachedMpeg4Gif() {
        super(InlineQueryResult.TYPE_MPEG4_GIF);
    }

    public String getMpeg4FileId() {
        return mpeg4FileId;
    }

    public InlineQueryResultCachedMpeg4Gif setMpeg4FileId(String mpeg4FileId) {
        this.mpeg4FileId = mpeg4FileId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public InlineQueryResultCachedMpeg4Gif setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getCaption() {
        return caption;
    }

    public InlineQueryResultCachedMpeg4Gif setCaption(String caption) {
        this.caption = caption;
        return this;
    }
}
