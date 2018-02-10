package com.recrosoftware.api.telegram.bot.request;

import com.fasterxml.jackson.core.type.TypeReference;
import com.recrosoftware.api.telegram.bot.annotation.Serialize;
import com.recrosoftware.api.telegram.bot.model.File;
import com.recrosoftware.api.telegram.bot.model.api.ApiResponse;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public class GetFile extends AbstractRequestItem<File> {
    private static final String FIELD_FILE_ID = "file_id";

    @Required
    @Validate(as = FIELD_FILE_ID)
    @Serialize(as = FIELD_FILE_ID)
    private String fileId;

    public GetFile() {
        super("getFile", new TypeReference<ApiResponse<File>>() {
        });
    }

    public String getFileId() {
        return fileId;
    }

    public GetFile setFileId(String fileId) {
        this.fileId = fileId;
        return this;
    }
}
