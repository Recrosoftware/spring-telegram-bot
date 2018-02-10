package com.recrosoftware.api.telegram.bot.model.inline;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.recrosoftware.utils.validation.annotation.Range;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

import java.io.Serializable;

/**
 * Represents a location on a map.
 * By default, the location will be sent by the user.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the location.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class InlineQueryResultLocation extends InlineQueryResult<InlineQueryResultLocation> implements Serializable {
    public static final long serialVersionUID = 3005000L;

    private final static String FIELD_LATITUDE = "latitude";
    private final static String FIELD_LONGITUDE = "longitude";
    private final static String FIELD_TITLE = "title";
    private final static String FIELD_LIVE_PERIOD = "live_period";
    private final static String FIELD_THUMB_URL = "thumb_url";
    private final static String FIELD_THUMB_WIDTH = "thumb_width";
    private final static String FIELD_THUMB_HEIGHT = "thumb_height";

    /**
     * Location latitude in degrees.
     */
    @Required
    @Range(from = -90, to = 90)
    @Validate(as = FIELD_LATITUDE)
    @JsonProperty(FIELD_LATITUDE)
    private Float latitude;

    /**
     * Location longitude in degrees.
     */
    @Required
    @Range(from = -180, to = 180)
    @Validate(as = FIELD_LONGITUDE)
    @JsonProperty(FIELD_LONGITUDE)
    private Float longitude;

    /**
     * Location title.
     */
    @Required
    @Validate(as = FIELD_TITLE)
    @JsonProperty(FIELD_TITLE)
    private String title;

    /**
     * Optional.
     * Period in seconds for which the location can be updated, should be between 60 and 86400.
     */
    @Range(from = 60, to = 86400)
    @Validate(as = FIELD_LIVE_PERIOD)
    @JsonProperty(FIELD_LIVE_PERIOD)
    private Integer livePeriod;

    /**
     * Optional.
     * Url of the thumbnail for the result.
     */
    @JsonProperty(FIELD_THUMB_URL)
    private String thumbUrl;

    /**
     * Optional.
     * Thumbnail width.
     */
    @JsonProperty(FIELD_THUMB_WIDTH)
    private Integer thumbWidth;

    /**
     * Optional.
     * Thumbnail height.
     */
    @JsonProperty(FIELD_THUMB_HEIGHT)
    private Integer thumbHeight;

    public InlineQueryResultLocation() {
        super(InlineQueryResult.TYPE_LOCATION);
    }

    public Float getLatitude() {
        return latitude;
    }

    public InlineQueryResultLocation setLatitude(Float latitude) {
        this.latitude = latitude;
        return this;
    }

    public Float getLongitude() {
        return longitude;
    }

    public InlineQueryResultLocation setLongitude(Float longitude) {
        this.longitude = longitude;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public InlineQueryResultLocation setTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getLivePeriod() {
        return livePeriod;
    }

    public InlineQueryResultLocation setLivePeriod(Integer livePeriod) {
        this.livePeriod = livePeriod;
        return this;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public InlineQueryResultLocation setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
        return this;
    }

    public Integer getThumbWidth() {
        return thumbWidth;
    }

    public InlineQueryResultLocation setThumbWidth(Integer thumbWidth) {
        this.thumbWidth = thumbWidth;
        return this;
    }

    public Integer getThumbHeight() {
        return thumbHeight;
    }

    public InlineQueryResultLocation setThumbHeight(Integer thumbHeight) {
        this.thumbHeight = thumbHeight;
        return this;
    }
}
