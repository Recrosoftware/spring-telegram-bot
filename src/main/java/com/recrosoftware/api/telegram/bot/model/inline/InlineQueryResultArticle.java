package com.recrosoftware.api.telegram.bot.model.inline;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.recrosoftware.utils.validation.ValidationError;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a link to an article or web page.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class InlineQueryResultArticle extends InlineQueryResult<InlineQueryResultArticle> implements Serializable {
    public static final long serialVersionUID = 3005000L;

    private static final String FIELD_TITLE = "title";
    private static final String FIELD_URL = "url";
    private static final String FIELD_HIDE_URL = "hide_url";
    private static final String FIELD_DESCRIPTION = "description";
    private static final String FIELD_THUMB_URL = "thumb_url";
    private static final String FIELD_THUMB_WIDTH = "thumb_width";
    private static final String FIELD_THUMB_HEIGHT = "thumb_height";

    /**
     * Title of the result.
     */
    @Required
    @Validate(as = FIELD_TITLE)
    @JsonProperty(FIELD_TITLE)
    private String title;

    /**
     * Optional.
     * URL of the result.
     */
    @JsonProperty(FIELD_URL)
    private String url;

    /**
     * Optional.
     * Pass True, if you don't want the URL to be shown in the message.
     */
    @JsonProperty(FIELD_HIDE_URL)
    private Boolean hideUrl;

    /**
     * Optional.
     * Short description of the result.
     */
    @JsonProperty(FIELD_DESCRIPTION)
    private String description;

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

    public InlineQueryResultArticle() {
        super(InlineQueryResult.TYPE_ARTICLE);
    }

    public String getTitle() {
        return title;
    }

    public InlineQueryResultArticle setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public InlineQueryResultArticle setUrl(String url) {
        this.url = url;
        return this;
    }

    public Boolean getHideUrl() {
        return hideUrl;
    }

    public InlineQueryResultArticle setHideUrl(Boolean hideUrl) {
        this.hideUrl = hideUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public InlineQueryResultArticle setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public InlineQueryResultArticle setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
        return this;
    }

    public Integer getThumbWidth() {
        return thumbWidth;
    }

    public InlineQueryResultArticle setThumbWidth(Integer thumbWidth) {
        this.thumbWidth = thumbWidth;
        return this;
    }

    public Integer getThumbHeight() {
        return thumbHeight;
    }

    public InlineQueryResultArticle setThumbHeight(Integer thumbHeight) {
        this.thumbHeight = thumbHeight;
        return this;
    }

    @Override
    public List<ValidationError> validate(String prefix) {
        List<ValidationError> errors = new ArrayList<>();

        if (inputMessageContent == null) {
            errors.add(new ValidationError(prefix + FIELD_INPUT_MESSAGE_CONTENT, "Required field."));
        }

        return errors;
    }
}
