package com.recrosoftware.api.telegram.bot.model.inline;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.recrosoftware.utils.validation.annotation.Range;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

import java.io.Serializable;

/**
 * Represents a link to a voice recording in an .ogg container encoded with OPUS.
 * By default, this voice recording will be sent by the user.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the the voice message.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class InlineQueryResultVoice extends InlineQueryResult<InlineQueryResultVoice> implements Serializable {
    public static final long serialVersionUID = 3005000L;

    private static final String FIELD_VOICE_URL = "voice_url";
    private static final String FIELD_TITLE = "title";
    private static final String FIELD_CAPTION = "caption";
    private static final String FIELD_VOICE_DURATION = "voice_duration";

    /**
     * A valid URL for the voice recording.
     */
    @Required
    @Validate(as = FIELD_VOICE_URL)
    @JsonProperty(FIELD_VOICE_URL)
    private String voiceUrl;

    /**
     * Recording title.
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

    /**
     * Optional.
     * Recording duration in seconds.
     */
    @JsonProperty(FIELD_VOICE_DURATION)
    private Integer voiceDuration;

    public InlineQueryResultVoice() {
        super(InlineQueryResult.TYPE_VOICE);
    }

    public String getVoiceUrl() {
        return voiceUrl;
    }

    public InlineQueryResultVoice setVoiceUrl(String voiceUrl) {
        this.voiceUrl = voiceUrl;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public InlineQueryResultVoice setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getCaption() {
        return caption;
    }

    public InlineQueryResultVoice setCaption(String caption) {
        this.caption = caption;
        return this;
    }

    public Integer getVoiceDuration() {
        return voiceDuration;
    }

    public InlineQueryResultVoice setVoiceDuration(Integer voiceDuration) {
        this.voiceDuration = voiceDuration;
        return this;
    }
}
