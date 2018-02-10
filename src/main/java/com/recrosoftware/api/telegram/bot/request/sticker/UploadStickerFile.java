package com.recrosoftware.api.telegram.bot.request.sticker;

import com.fasterxml.jackson.core.type.TypeReference;
import com.recrosoftware.api.telegram.bot.annotation.Serialize;
import com.recrosoftware.api.telegram.bot.model.File;
import com.recrosoftware.api.telegram.bot.model.api.ApiResponse;
import com.recrosoftware.api.telegram.bot.request.AbstractRequestItem;
import com.recrosoftware.utils.validation.ValidationError;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;
import org.glassfish.jersey.media.multipart.file.StreamDataBodyPart;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public class UploadStickerFile extends AbstractRequestItem<File> {
    private static final String FIELD_USER_ID = "user_id";

    @Required
    @Validate(as = FIELD_USER_ID)
    @Serialize(as = FIELD_USER_ID)
    private Integer userId;

    private java.io.File stickerFile;
    private InputStream stickerStream;

    public UploadStickerFile() {
        super("uploadStickerFile", new TypeReference<ApiResponse<File>>() {
        });
    }

    public Integer getUserId() {
        return userId;
    }

    public UploadStickerFile setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public UploadStickerFile setPngSticker(java.io.File pngSticker) {
        this.stickerFile = pngSticker;
        this.stickerStream = null;
        return this;
    }

    public UploadStickerFile setPngSticker(InputStream pngSticker) {
        this.stickerFile = null;
        this.stickerStream = pngSticker;
        return this;
    }

    @Override
    public FormDataMultiPart prepareRequestEntity() {
        FormDataMultiPart request = super.prepareRequestEntity();

        if (stickerFile != null)
            request.bodyPart(new FileDataBodyPart("png_sticker", stickerFile));
        else
            request.bodyPart(new StreamDataBodyPart("png_sticker", stickerStream));

        return request;
    }

    @Override
    public List<ValidationError> validate(String prefix) {
        List<ValidationError> errors = new ArrayList<>();

        if (stickerFile == null && stickerStream == null) {
            errors.add(new ValidationError(prefix + "png_sticker", "Required field."));
        }
        if (stickerFile != null && (!stickerFile.exists() || !stickerFile.canRead())) {
            errors.add(new ValidationError(prefix + "png_sticker", "The provided file does not exists or has invalid permissions."));
        }

        return errors;
    }
}
