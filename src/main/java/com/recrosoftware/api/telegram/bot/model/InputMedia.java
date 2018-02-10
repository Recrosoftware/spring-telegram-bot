package com.recrosoftware.api.telegram.bot.model;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.recrosoftware.utils.validation.Validable;
import com.recrosoftware.utils.validation.annotation.Range;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;
import org.glassfish.jersey.media.multipart.BodyPart;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;
import org.glassfish.jersey.media.multipart.file.StreamDataBodyPart;

import java.io.File;
import java.io.InputStream;

/**
 * This object represents the content of a media message to be sent.
 * It should be one of:
 * <ul>
 * <li>{@link InputMediaPhoto}
 * <li>{@link InputMediaVideo}
 * </ul>
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public abstract class InputMedia<T extends InputMedia> implements Validable {
    protected final static String FIELD_TYPE = "type";
    protected final static String FIELD_MEDIA = "media";
    protected final static String FIELD_CAPTION = "caption";

    /**
     * Type of the result, depends on InputMedia type.
     */
    @Required
    @Validate(as = FIELD_TYPE)
    private final String type;

    /**
     * File to send.
     * Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass "attach://&lt;file_attach_name&gt;" to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name.
     */
    @Required
    @Validate(as = FIELD_MEDIA)
    private String media;

    /**
     * Optional.
     * Caption of the photo to be sent, 0-200 characters.
     */
    @Range(to = 200)
    @Validate(as = FIELD_CAPTION)
    private String caption;

    private File mediaFile;
    private InputStream mediaStream;
    private String mediaFileName;

    protected InputMedia(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getMediaAsString() {
        return media;
    }

    public File getMediaAsFile() {
        return mediaFile;
    }

    public InputStream getMediaAsStream() {
        return mediaStream;
    }

    @SuppressWarnings("unchecked")
    public T setMedia(String media) {
        this.media = media;
        this.mediaFile = null;
        this.mediaStream = null;
        this.mediaFileName = null;
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T setMedia(File media, String fileName) {
        this.mediaFile = media;
        this.mediaStream = null;
        if (media == null) {
            this.media = null;
            this.mediaFileName = null;
        } else {
            if (fileName == null) {
                mediaFileName = media.getName();
            } else {
                mediaFileName = fileName;
            }
            this.media = "attach://" + mediaFileName;
        }
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T setMedia(InputStream media, String fileName) {
        this.mediaFile = null;
        if (media != null && fileName != null) {
            this.mediaStream = media;
            this.mediaFileName = fileName;
            this.media = "attach://" + this.mediaFileName;
        } else {
            this.mediaStream = null;
            this.mediaFileName = null;
            this.media = null;
        }
        return (T) this;
    }

    public String getCaption() {
        return caption;
    }

    @SuppressWarnings("unchecked")
    public T setCaption(String caption) {
        this.caption = caption;
        return (T) this;
    }

    @JsonValue
    public JsonNode getRequestBody() {
        ObjectMapper m = new ObjectMapper();

        ObjectNode node = m.createObjectNode();
        node.put(FIELD_TYPE, type);
        node.put(FIELD_MEDIA, media);
        if (caption != null)
            node.put(FIELD_CAPTION, caption);

        return node;
    }

    public BodyPart getFileBody() {
        if (this.mediaStream != null) {
            return new StreamDataBodyPart(mediaFileName, mediaStream);
        } else if (this.mediaFile != null) {
            return new FileDataBodyPart(mediaFileName, mediaFile);
        }
        return null;
    }
}
