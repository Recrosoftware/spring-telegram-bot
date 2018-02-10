package com.recrosoftware.api.telegram.bot.request;

import com.recrosoftware.api.telegram.bot.model.KeyboardMarkup;
import com.recrosoftware.utils.validation.ValidationError;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;
import org.glassfish.jersey.media.multipart.file.StreamDataBodyPart;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.StringUtils.isEmpty;

@SuppressWarnings({"unused", "unchecked", "WeakerAccess", "UnusedReturnValue"})
public abstract class AbstractSendFile<T extends AbstractSendFile<T>> extends AbstractSendMethod<T, KeyboardMarkup> {
    private String fileFieldName;

    private String elementIdentifier;
    private File elementFile;
    private InputStream elementStream;

    protected AbstractSendFile(String method, String fileFieldName) {
        super(method);

        this.fileFieldName = fileFieldName;
    }

    public T setFile(String file) {
        this.elementIdentifier = file;
        this.elementFile = null;
        this.elementStream = null;
        return (T) this;
    }

    public T setFile(File file) {
        this.elementIdentifier = null;
        this.elementFile = file;
        this.elementStream = null;
        return (T) this;
    }

    public T setFile(InputStream file, String fileName) {
        if (file != null && fileName != null) {
            this.elementIdentifier = fileName;
            this.elementFile = null;
            this.elementStream = file;
        } else {
            this.elementIdentifier = null;
            this.elementFile = null;
            this.elementStream = null;
        }
        return (T) this;
    }

    @Override
    protected FormDataMultiPart prepareRequestEntity() {
        FormDataMultiPart request = super.prepareRequestEntity();

        if (this.elementStream != null)
            request.bodyPart(new StreamDataBodyPart(fileFieldName, elementStream, elementIdentifier));
        else if (elementFile != null)
            request.bodyPart(new FileDataBodyPart(fileFieldName, elementFile));
        else
            request.field(fileFieldName, elementIdentifier);

        return request;
    }

    @Override
    public List<ValidationError> validate(String prefix) {
        List<ValidationError> errors = new ArrayList<>();

        if (isEmpty(elementIdentifier) && elementFile == null && elementStream == null) {
            errors.add(new ValidationError(prefix + fileFieldName, "Required field"));
        }
        if (elementFile != null && (!elementFile.exists() || !elementFile.canRead())) {
            errors.add(new ValidationError(prefix + fileFieldName, "The provided file does not exists or has invalid permissions."));
        }

        return errors;
    }
}
