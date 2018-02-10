package com.recrosoftware.api.telegram.bot.request.sticker;

import com.fasterxml.jackson.core.type.TypeReference;
import com.recrosoftware.api.telegram.bot.annotation.Serialize;
import com.recrosoftware.api.telegram.bot.annotation.UseMediaType;
import com.recrosoftware.api.telegram.bot.model.api.ApiResponse;
import com.recrosoftware.api.telegram.bot.model.sticker.MaskPosition;
import com.recrosoftware.api.telegram.bot.request.AbstractRequestItem;
import com.recrosoftware.utils.validation.ValidationError;
import com.recrosoftware.utils.validation.annotation.Range;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;
import org.glassfish.jersey.media.multipart.file.StreamDataBodyPart;

import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.StringUtils.isEmpty;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public abstract class AbstractAddSticker<T extends AbstractAddSticker> extends AbstractRequestItem<Boolean> {
    private static final String FIELD_USER_ID = "user_id";
    private static final String FIELD_NAME = "name";
    private static final String FIELD_PNG_STICKER = "png_sticker";
    private static final String FIELD_EMOJIS = "emojis";
    private static final String FIELD_MASK_POSITION = "mask_position";

    @Required
    @Validate(as = FIELD_USER_ID)
    @Serialize(as = FIELD_USER_ID)
    private Integer userId;

    @Range(from = 1, to = 64)
    @Required
    @Validate(as = FIELD_NAME)
    @Serialize(as = FIELD_NAME)
    private String name;

    private String stickerIdentifier;
    private File stickerFile;
    private InputStream stickerStream;

    @Range(from = 1)
    @Required
    @Validate(as = FIELD_EMOJIS)
    @Serialize(as = FIELD_EMOJIS)
    private String emojis;

    @Serialize(as = FIELD_MASK_POSITION)
    @UseMediaType(MediaType.APPLICATION_JSON)
    private MaskPosition maskPosition;

    protected AbstractAddSticker(String method) {
        super(method, new TypeReference<ApiResponse<Boolean>>() {
        });
    }

    public Integer getUserId() {
        return userId;
    }

    @SuppressWarnings("unchecked")
    public T setUserId(Integer userId) {
        this.userId = userId;
        return (T) this;
    }

    public String getName() {
        return name;
    }

    @SuppressWarnings("unchecked")
    public T setName(String name) {
        this.name = name;
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T setPngSticker(String pngSticker) {
        this.stickerIdentifier = pngSticker;
        this.stickerFile = null;
        this.stickerStream = null;
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T setPngSticker(File pngSticker) {
        this.stickerIdentifier = null;
        this.stickerFile = pngSticker;
        this.stickerStream = null;
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T setPngSticker(InputStream pngSticker) {
        this.stickerIdentifier = null;
        this.stickerFile = null;
        this.stickerStream = pngSticker;
        return (T) this;
    }

    public String getEmojis() {
        return emojis;
    }

    @SuppressWarnings("unchecked")
    public T setEmojis(String emojis) {
        this.emojis = emojis;
        return (T) this;
    }

    public MaskPosition getMaskPosition() {
        return maskPosition;
    }

    @SuppressWarnings("unchecked")
    public T setMaskPosition(MaskPosition maskPosition) {
        this.maskPosition = maskPosition;
        return (T) this;
    }

    protected FormDataMultiPart prepareRequestEntity() {
        FormDataMultiPart request = super.prepareRequestEntity();

        if (stickerFile != null)
            request.bodyPart(new FileDataBodyPart(FIELD_PNG_STICKER, stickerFile));
        else if (stickerStream != null)
            request.bodyPart(new StreamDataBodyPart(FIELD_PNG_STICKER, stickerStream));
        else
            request.field(FIELD_PNG_STICKER, stickerIdentifier);

        return request;
    }

    public List<ValidationError> validate(String prefix) {
        List<ValidationError> errors = new ArrayList<>();

        if (isEmpty(stickerIdentifier) && stickerFile == null && stickerIdentifier == null) {
            errors.add(new ValidationError(prefix + FIELD_PNG_STICKER, "Required field."));
        }
        if (stickerFile != null && (!stickerFile.exists() || !stickerFile.canRead())) {
            errors.add(new ValidationError(prefix + FIELD_PNG_STICKER, "The provided file does not exists or has invalid permissions."));
        }

        return errors;
    }
}
