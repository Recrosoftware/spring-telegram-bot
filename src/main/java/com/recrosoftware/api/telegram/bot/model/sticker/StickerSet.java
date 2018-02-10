package com.recrosoftware.api.telegram.bot.model.sticker;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * This object represents a sticker set.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class StickerSet implements Serializable {
    public static final long serialVersionUID = 3005000L;

    /**
     * Sticker set name.
     */
    @JsonProperty("name")
    private String name;

    /**
     * Sticker set title.
     */
    @JsonProperty("title")
    private String title;

    /**
     * True, if the sticker set contains masks.
     */
    @JsonProperty("contains_masks")
    private Boolean containsMasks;

    /**
     * List of all set stickers.
     */
    @JsonProperty("stickers")
    private List<Sticker> stickers;

    public String getName() {
        return name;
    }

    public StickerSet setName(String name) {
        this.name = name;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public StickerSet setTitle(String title) {
        this.title = title;
        return this;
    }

    public Boolean getContainsMasks() {
        return containsMasks;
    }

    public StickerSet setContainsMasks(Boolean containsMasks) {
        this.containsMasks = containsMasks;
        return this;
    }

    public List<Sticker> getStickers() {
        return stickers;
    }

    public StickerSet setStickers(List<Sticker> stickers) {
        this.stickers = stickers;
        return this;
    }
}
