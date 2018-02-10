package com.recrosoftware.api.telegram.bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * This object represent a user's profile pictures.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class UserProfilePhotos implements Serializable {
    public static final long serialVersionUID = 3005000L;

    /**
     * Total number of profile pictures the target user has.
     */
    @JsonProperty("total_count")
    private Integer totalCount;

    /**
     * Requested profile pictures (in up to 4 sizes each).
     */
    @JsonProperty("photos")
    private List<List<PhotoSize>> photos;

    public Integer getTotalCount() {
        return totalCount;
    }

    public UserProfilePhotos setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    public List<List<PhotoSize>> getPhotos() {
        return photos;
    }

    public UserProfilePhotos setPhotos(List<List<PhotoSize>> photos) {
        this.photos = photos;
        return this;
    }
}
