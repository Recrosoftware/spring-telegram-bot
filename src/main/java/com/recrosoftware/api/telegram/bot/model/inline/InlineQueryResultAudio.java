package com.recrosoftware.api.telegram.bot.model.inline;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.recrosoftware.utils.validation.annotation.Range;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

import java.io.Serializable;

/**
 * Represents a link to an mp3 audio file.
 * By default, this audio file will be sent by the user.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the audio.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class InlineQueryResultAudio extends InlineQueryResult<InlineQueryResultAudio> implements Serializable {
    public static final long serialVersionUID = 3005000L;

    private final static String FIELD_AUDIO_URL = "audio_url";
    private final static String FIELD_TITLE = "title";
    private final static String FIELD_CAPTION = "caption";
    private final static String FIELD_PERFORMER = "performer";
    private final static String FIELD_AUDIO_DURATION = "audio_duration";

    /**
     * A valid URL for the audio file.
     */
    @Required
    @Validate(as = FIELD_AUDIO_URL)
    @JsonProperty(FIELD_AUDIO_URL)
    private String audioUrl;

    /**
     * Title.
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
     * Performer.
     */
    @JsonProperty(FIELD_PERFORMER)
    private String performer;

    /**
     * Optional.
     * Audio duration in seconds.
     */
    @JsonProperty(FIELD_AUDIO_DURATION)
    private Integer audioDuration;

    public InlineQueryResultAudio() {
        super(InlineQueryResult.TYPE_AUDIO);
    }

    public String getAudioUrl() {
        return audioUrl;
    }

    public InlineQueryResultAudio setAudioUrl(String audioUrl) {
        this.audioUrl = audioUrl;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public InlineQueryResultAudio setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getCaption() {
        return caption;
    }

    public InlineQueryResultAudio setCaption(String caption) {
        this.caption = caption;
        return this;
    }

    public String getPerformer() {
        return performer;
    }

    public InlineQueryResultAudio setPerformer(String performer) {
        this.performer = performer;
        return this;
    }

    public Integer getAudioDuration() {
        return audioDuration;
    }

    public InlineQueryResultAudio setAudioDuration(Integer audioDuration) {
        this.audioDuration = audioDuration;
        return this;
    }
}
