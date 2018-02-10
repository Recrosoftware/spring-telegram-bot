package com.recrosoftware.api.telegram.bot.model.sticker;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * This object describes the position on faces where a mask should be placed by default.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class MaskPosition implements Serializable {
    public static final long serialVersionUID = 3005000L;

    /**
     * The part of the face relative to which the mask should be placed.
     * One of “forehead”, “eyes”, “mouth”, or “chin”.
     */
    @JsonProperty("point")
    private String point;

    /**
     * Shift by X-axis measured in widths of the mask scaled to the face size, from left to right. For example, choosing -1.0 will place mask just to the left of the default mask position.
     */
    @JsonProperty("x_shift")
    private Float xShift;

    /**
     * Shift by Y-axis measured in heights of the mask scaled to the face size, from top to bottom. For example, 1.0 will place the mask just below the default mask position.
     */
    @JsonProperty("y_shift")
    private Float yShift;

    /**
     * Mask scaling coefficient.
     * For example, 2.0 means double size.
     */
    @JsonProperty("scale")
    private Float scale;

    public String getPoint() {
        return point;
    }

    public MaskPosition setPoint(String point) {
        this.point = point;
        return this;
    }

    public Float getxShift() {
        return xShift;
    }

    public MaskPosition setxShift(Float xShift) {
        this.xShift = xShift;
        return this;
    }

    public Float getyShift() {
        return yShift;
    }

    public MaskPosition setyShift(Float yShift) {
        this.yShift = yShift;
        return this;
    }

    public Float getScale() {
        return scale;
    }

    public MaskPosition setScale(Float scale) {
        this.scale = scale;
        return this;
    }
}
