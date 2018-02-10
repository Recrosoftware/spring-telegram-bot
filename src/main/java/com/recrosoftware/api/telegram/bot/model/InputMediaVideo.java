package com.recrosoftware.api.telegram.bot.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * Represents a video to be sent.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class InputMediaVideo extends InputMedia<InputMediaVideo> {
    private final static String FIELD_WIDTH = "width";
    private final static String FIELD_HEIGHT = "height";
    private final static String FIELD_DURATION = "duration";

    /**
     * Optional.
     * Video width.
     */
    private Integer width;

    /**
     * Optional.
     * Video height.
     */
    private Integer height;

    /**
     * Optional.
     * Video duration.
     */
    private Integer duration;

    public InputMediaVideo() {
        super("video");
    }

    public Integer getWidth() {
        return width;
    }

    public InputMediaVideo setWidth(Integer width) {
        this.width = width;
        return this;
    }

    public Integer getHeight() {
        return height;
    }

    public InputMediaVideo setHeight(Integer height) {
        this.height = height;
        return this;
    }

    public Integer getDuration() {
        return duration;
    }

    public InputMediaVideo setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    @Override
    public JsonNode getRequestBody() {
        ObjectNode node = (ObjectNode) super.getRequestBody();

        if (width != null)
            node.put(FIELD_WIDTH, width);
        if (height != null)
            node.put(FIELD_HEIGHT, height);
        if (duration != null)
            node.put(FIELD_DURATION, duration);

        return node;
    }
}
