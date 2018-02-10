package com.recrosoftware.api.telegram.bot.model.inline;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.recrosoftware.utils.validation.annotation.Range;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

import java.io.Serializable;

/**
 * Represents a link to a page containing an embedded video player or a video file.
 * By default, this video file will be sent by the user with an optional caption.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the video. *
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class InlineQueryResultVideo extends InlineQueryResult<InlineQueryResultVideo> implements Serializable {
    public static final long serialVersionUID = 3005000L;

    private static final String FIELD_VIDEO_URL = "video_url";
    private static final String FIELD_MIME_TYPE = "mime_type";
    private static final String FIELD_THUMB_URL = "thumb_url";
    private static final String FIELD_TITLE = "title";
    private static final String FIELD_CAPTION = "caption";
    private static final String FIELD_VIDEO_WIDTH = "video_width";
    private static final String FIELD_VIDEO_HEIGHT = "video_height";
    private static final String FIELD_VIDEO_DURATION = "video_duration";
    private static final String FIELD_DESCRIPTION = "description";

    /**
     * A valid URL for the embedded video player or video file.
     */
    @Required
    @Validate(as = FIELD_VIDEO_URL)
    @JsonProperty(FIELD_VIDEO_URL)
    private String videoUrl;

    /**
     * Mime type of the content of video url, “text/html” or “video/mp4”.
     */
    @Required
    @Validate(as = FIELD_MIME_TYPE)
    @JsonProperty(FIELD_MIME_TYPE)
    private String mimeYype;

    /**
     * URL of the thumbnail (jpeg only) for the video.
     */
    @Required
    @Validate(as = FIELD_THUMB_URL)
    @JsonProperty(FIELD_THUMB_URL)
    private String thumbUrl;

    /**
     * Title for the result.
     */
    @Required
    @Validate(as = FIELD_TITLE)
    @JsonProperty(FIELD_TITLE)
    private String title;

    /**
     * Optional.
     * Caption of the video to be sent, 0-200 characters.
     */
    @Range(to = 200)
    @Validate(as = FIELD_CAPTION)
    @JsonProperty(FIELD_CAPTION)
    private String caption;

    /**
     * Optional.
     * Video width.
     */
    @JsonProperty(FIELD_VIDEO_WIDTH)
    private Integer videoWidth;

    /**
     * Optional.
     * Video height.
     */
    @JsonProperty(FIELD_VIDEO_HEIGHT)
    private Integer videoHeight;

    /**
     * Optional.
     * Video duration in seconds.
     */
    @JsonProperty(FIELD_VIDEO_DURATION)
    private Integer videoDuration;

    /**
     * Optional.
     * Short description of the result.
     */
    @JsonProperty(FIELD_DESCRIPTION)
    private String description;

    public InlineQueryResultVideo() {
        super(InlineQueryResult.TYPE_VIDEO);
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public InlineQueryResultVideo setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public String getMimeYype() {
        return mimeYype;
    }

    public InlineQueryResultVideo setMimeYype(String mimeYype) {
        this.mimeYype = mimeYype;
        return this;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public InlineQueryResultVideo setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public InlineQueryResultVideo setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getCaption() {
        return caption;
    }

    public InlineQueryResultVideo setCaption(String caption) {
        this.caption = caption;
        return this;
    }

    public Integer getVideoWidth() {
        return videoWidth;
    }

    public InlineQueryResultVideo setVideoWidth(Integer videoWidth) {
        this.videoWidth = videoWidth;
        return this;
    }

    public Integer getVideoHeight() {
        return videoHeight;
    }

    public InlineQueryResultVideo setVideoHeight(Integer videoHeight) {
        this.videoHeight = videoHeight;
        return this;
    }

    public Integer getVideoDuration() {
        return videoDuration;
    }

    public InlineQueryResultVideo setVideoDuration(Integer videoDuration) {
        this.videoDuration = videoDuration;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public InlineQueryResultVideo setDescription(String description) {
        this.description = description;
        return this;
    }
}
