package com.recrosoftware.api.telegram.bot.model.inline;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.recrosoftware.utils.validation.annotation.Range;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

import java.io.Serializable;

/**
 * Represents a venue.
 * By default, the venue will be sent by the user.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the venue.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class InlineQueryResultVenue extends InlineQueryResult<InlineQueryResultVenue> implements Serializable {
    public static final long serialVersionUID = 3005000L;

    private final static String FIELD_LATITUDE = "latitude";
    private final static String FIELD_LONGITUDE = "longitude";
    private final static String FIELD_TITLE = "title";
    private final static String FIELD_ADDRESS = "address";
    private final static String FIELD_FOURSQUARE_ID = "foursquare_id";
    private final static String FIELD_THUMB_URL = "thumb_url";
    private final static String FIELD_THUMB_WIDTH = "thumb_width";
    private final static String FIELD_THUMB_HEIGHT = "thumb_height";

    /**
     * Latitude of the venue location in degrees.
     */
    @Required
    @Range(from = -90, to = 90)
    @Validate(as = FIELD_LATITUDE)
    @JsonProperty(FIELD_LATITUDE)
    private Float latitude;

    /**
     * Longitude of the venue location in degrees.
     */
    @Required
    @Range(from = -180, to = 180)
    @Validate(as = FIELD_LONGITUDE)
    @JsonProperty(FIELD_LONGITUDE)
    private Float longitude;

    /**
     * Title of the venue.
     */
    @Required
    @Validate(as = FIELD_TITLE)
    @JsonProperty(FIELD_TITLE)
    private String title;

    /**
     * Address of the venue.
     */
    @Required
    @Validate(as = FIELD_ADDRESS)
    @JsonProperty(FIELD_ADDRESS)
    private String address;

    /**
     * Optional.
     * Foursquare identifier of the venue if known.
     */
    @JsonProperty(FIELD_FOURSQUARE_ID)
    private String foursquareId;

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

    public InlineQueryResultVenue() {
        super(InlineQueryResult.TYPE_VENUE);
    }

    public Float getLatitude() {
        return latitude;
    }

    public InlineQueryResultVenue setLatitude(Float latitude) {
        this.latitude = latitude;
        return this;
    }

    public Float getLongitude() {
        return longitude;
    }

    public InlineQueryResultVenue setLongitude(Float longitude) {
        this.longitude = longitude;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public InlineQueryResultVenue setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public InlineQueryResultVenue setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getFoursquareId() {
        return foursquareId;
    }

    public InlineQueryResultVenue setFoursquareId(String foursquareId) {
        this.foursquareId = foursquareId;
        return this;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public InlineQueryResultVenue setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
        return this;
    }

    public Integer getThumbWidth() {
        return thumbWidth;
    }

    public InlineQueryResultVenue setThumbWidth(Integer thumbWidth) {
        this.thumbWidth = thumbWidth;
        return this;
    }

    public Integer getThumbHeight() {
        return thumbHeight;
    }

    public InlineQueryResultVenue setThumbHeight(Integer thumbHeight) {
        this.thumbHeight = thumbHeight;
        return this;
    }
}
