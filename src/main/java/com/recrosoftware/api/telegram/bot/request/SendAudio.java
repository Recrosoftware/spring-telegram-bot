package com.recrosoftware.api.telegram.bot.request;

import com.recrosoftware.api.telegram.bot.annotation.Serialize;
import com.recrosoftware.utils.validation.annotation.Range;
import com.recrosoftware.utils.validation.annotation.Validate;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public class SendAudio extends AbstractSendFile<SendAudio> {
    private static final String FIELD_CAPTION = "caption";
    private static final String FIELD_DURATION = "duration";
    private static final String FIELD_PERFORMER = "performer";
    private static final String FIELD_TITLE = "title";

    @Range(to = 200)
    @Validate(as = FIELD_CAPTION)
    @Serialize(as = FIELD_CAPTION)
    private String caption;

    @Serialize(as = FIELD_DURATION)
    private Integer duration;

    @Serialize(as = FIELD_PERFORMER)
    private String performer;

    @Serialize(as = FIELD_TITLE)
    private String title;

    public SendAudio() {
        super("sendAudio", "audio");
    }

    public String getCaption() {
        return caption;
    }

    public SendAudio setCaption(String caption) {
        this.caption = caption;
        return this;
    }

    public Integer getDuration() {
        return duration;
    }

    public SendAudio setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public String getPerformer() {
        return performer;
    }

    public SendAudio setPerformer(String performer) {
        this.performer = performer;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public SendAudio setTitle(String title) {
        this.title = title;
        return this;
    }
}
