package com.recrosoftware.api.telegram.bot.request;

import com.recrosoftware.api.telegram.bot.annotation.Serialize;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public class SendVideoNote extends AbstractSendFile<SendVideoNote> {
    private static final String FIELD_DURATION = "duration";
    private static final String FIELD_LENGTH = "length";

    @Serialize(as = FIELD_DURATION)
    private Integer duration;

    @Serialize(as = FIELD_LENGTH)
    private Integer length;

    public SendVideoNote() {
        super("sendVideoNote", "video_note");
    }

    public Integer getDuration() {
        return duration;
    }

    public SendVideoNote setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public Integer getLength() {
        return length;
    }

    public SendVideoNote setLength(Integer length) {
        this.length = length;
        return this;
    }
}
