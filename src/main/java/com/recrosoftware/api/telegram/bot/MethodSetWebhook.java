package com.recrosoftware.api.telegram.bot;

import com.fasterxml.jackson.core.type.TypeReference;
import com.recrosoftware.api.telegram.bot.annotation.Serialize;
import com.recrosoftware.api.telegram.bot.model.api.ApiResponse;
import com.recrosoftware.api.telegram.bot.request.AbstractRequestItem;
import com.recrosoftware.utils.validation.ValidationError;
import com.recrosoftware.utils.validation.annotation.Range;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;
import org.glassfish.jersey.media.multipart.file.StreamDataBodyPart;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
class MethodSetWebhook extends AbstractRequestItem<Boolean> {
    private static final String FIELD_URL = "url";
    private static final String FIELD_CERTIFICATE = "certificate";
    private static final String FIELD_MAX_CONNECTIONS = "max_connections";

    @Required
    @Validate(as = FIELD_URL)
    @Serialize(as = FIELD_URL)
    private String url;

    private File certificateFile;
    private InputStream certificateStream;

    @Range(from = 1, to = 100)
    @Validate(as = FIELD_MAX_CONNECTIONS)
    @Serialize(as = FIELD_MAX_CONNECTIONS)
    private Integer maxConnections;

    MethodSetWebhook() {
        super("setWebhook", new TypeReference<ApiResponse<Boolean>>() {
        });
    }

    public String getUrl() {
        return url;
    }

    public MethodSetWebhook setUrl(String url) {
        this.url = url;
        return this;
    }

    public File getCertificate() {
        return certificateFile;
    }

    public MethodSetWebhook setCertificate(Object certificate) {
        this.certificateFile = null;
        this.certificateStream = null;

        if (certificate instanceof File)
            return setCertificate((File) certificate);
        if (certificate instanceof InputStream)
            return setCertificate((InputStream) certificate);

        return this;
    }

    public MethodSetWebhook setCertificate(File certificate) {
        this.certificateFile = certificate;
        this.certificateStream = null;
        return this;
    }

    public MethodSetWebhook setCertificate(InputStream certificate) {
        this.certificateFile = null;
        this.certificateStream = certificate;
        return this;
    }

    public Integer getMaxConnections() {
        return maxConnections;
    }

    public MethodSetWebhook setMaxConnections(Integer maxConnections) {
        this.maxConnections = maxConnections;
        return this;
    }

    @Override
    protected FormDataMultiPart prepareRequestEntity() {
        FormDataMultiPart request = super.prepareRequestEntity();

        if (certificateFile != null)
            request.bodyPart(new FileDataBodyPart(FIELD_CERTIFICATE, certificateFile));
        else if (certificateStream != null)
            request.bodyPart(new StreamDataBodyPart(FIELD_CERTIFICATE, certificateStream));

        return request;
    }

    @Override
    public List<ValidationError> validate(String prefix) {
        List<ValidationError> errors = new ArrayList<>();


        if (certificateStream == null && (certificateFile == null || (!certificateFile.exists() || !certificateFile.canRead()))) {
            errors.add(new ValidationError(prefix + FIELD_CERTIFICATE, "The provided file does not exists or has invalid permissions."));
        }

        return errors;
    }
}
