package com.recrosoftware.api.telegram.bot.request;

import com.fasterxml.jackson.core.type.TypeReference;
import com.recrosoftware.api.telegram.bot.annotation.Serialize;
import com.recrosoftware.api.telegram.bot.model.api.ApiResponse;
import com.recrosoftware.utils.validation.ValidationError;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;
import org.glassfish.jersey.media.multipart.file.StreamDataBodyPart;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.StringUtils.isEmpty;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public class SetChatPhoto extends AbstractRequestItem<Boolean> {
    private static final String FIELD_CHAT_ID = "chat_id";
    private static final String FIELD_PHOTO = "photo";

    @Required
    @Validate(as = FIELD_CHAT_ID)
    @Serialize(as = FIELD_CHAT_ID)
    private String chatId;

    private String elementIdentifier;
    private File elementFile;
    private InputStream elementStream;

    public SetChatPhoto() {
        super("setChatPhoto", new TypeReference<ApiResponse<Boolean>>() {
        });
    }

    public String getChatId() {
        return chatId;
    }

    public SetChatPhoto setChatId(String chatId) {
        this.chatId = chatId;
        return this;
    }

    public SetChatPhoto setChatId(Long chatId) {
        if (chatId == null) {
            this.chatId = null;
        } else {
            this.chatId = chatId.toString();
        }
        return this;
    }

    public SetChatPhoto setFile(String file) {
        this.elementIdentifier = file;
        this.elementFile = null;
        this.elementStream = null;
        return this;
    }

    public SetChatPhoto setFile(File file) {
        this.elementIdentifier = null;
        this.elementFile = file;
        this.elementStream = null;
        return this;
    }

    public SetChatPhoto setFile(InputStream file) {
        this.elementIdentifier = null;
        this.elementFile = null;
        this.elementStream = file;
        return this;
    }

    @Override
    protected FormDataMultiPart prepareRequestEntity() {
        FormDataMultiPart request = super.prepareRequestEntity();

        if (this.elementIdentifier != null)
            request.field(FIELD_PHOTO, this.elementIdentifier);
        else if (this.elementFile != null)
            request.bodyPart(new FileDataBodyPart(FIELD_PHOTO, this.elementFile));
        else
            request.bodyPart(new StreamDataBodyPart(FIELD_PHOTO, this.elementStream));

        return request;
    }

    @Override
    public List<ValidationError> validate(String prefix) {
        List<ValidationError> errors = new ArrayList<>();

        if (isEmpty(elementIdentifier) && elementFile == null && elementStream == null) {
            errors.add(new ValidationError(prefix + FIELD_PHOTO, "Required field"));
        }
        if (elementFile != null && (!elementFile.exists() || !elementFile.canRead())) {
            errors.add(new ValidationError(prefix + FIELD_PHOTO, "The provided file does not exists or has invalid permissions."));
        }

        return errors;
    }
}
