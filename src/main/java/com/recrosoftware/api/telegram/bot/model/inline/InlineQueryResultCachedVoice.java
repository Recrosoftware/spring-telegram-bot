package com.recrosoftware.api.telegram.bot.model.inline;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.recrosoftware.utils.validation.annotation.Range;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

import java.io.Serializable;

/**
 * Represents a link to a voice message stored on the Telegram servers.
 * By default, this voice message will be sent by the user.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the voice message.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class InlineQueryResultCachedVoice extends InlineQueryResult<InlineQueryResultCachedVoice> implements Serializable {
    public static final long serialVersionUID = 3005000L;

    private final static String FIELD_VOICE_FILE_ID = "voice_file_id";
    private final static String FIELD_TITLE = "title";
    private final static String FIELD_CAPTION = "caption";

    /**
     * A valid file identifier for the voice message.
     */
    @Required
    @Validate(as = FIELD_VOICE_FILE_ID)
    @JsonProperty(FIELD_VOICE_FILE_ID)
    private String voiceFileId;

    /**
     * Voice message title.
     */
    @Required
    @Validate(as = FIELD_TITLE)
    @JsonProperty(FIELD_TITLE)
    private String title;

    /**
     * Optional.
     * Caption, 0-200 characters.
     */
    @Range(to = 200)
    @Validate(as = FIELD_CAPTION)
    @JsonProperty(FIELD_CAPTION)
    private String caption;

    public InlineQueryResultCachedVoice() {
        super(InlineQueryResult.TYPE_VOICE);
    }

    public String getVoiceFileId() {
        return voiceFileId;
    }

    public InlineQueryResultCachedVoice setVoiceFileId(String voiceFileId) {
        this.voiceFileId = voiceFileId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public InlineQueryResultCachedVoice setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getCaption() {
        return caption;
    }

    public InlineQueryResultCachedVoice setCaption(String caption) {
        this.caption = caption;
        return this;
    }

}
