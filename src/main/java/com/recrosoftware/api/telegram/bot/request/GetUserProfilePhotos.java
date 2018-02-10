package com.recrosoftware.api.telegram.bot.request;

import com.fasterxml.jackson.core.type.TypeReference;
import com.recrosoftware.api.telegram.bot.annotation.Serialize;
import com.recrosoftware.api.telegram.bot.model.UserProfilePhotos;
import com.recrosoftware.api.telegram.bot.model.api.ApiResponse;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public class GetUserProfilePhotos extends AbstractRequestItem<UserProfilePhotos> {
    private static final String FIELD_USER_ID = "user_id";
    private static final String FIELD_OFFSET = "offset";
    private static final String FIELD_LIMIT = "limit";

    @Required
    @Validate(as = FIELD_USER_ID)
    @Serialize(as = FIELD_USER_ID)
    private Integer userId;

    @Serialize(as = FIELD_OFFSET)
    private Integer offset;

    @Serialize(as = FIELD_LIMIT)
    private Integer limit;

    public GetUserProfilePhotos() {
        super("getUserProfilePhotos", new TypeReference<ApiResponse<UserProfilePhotos>>() {
        });
    }

    public Integer getUserId() {
        return userId;
    }

    public GetUserProfilePhotos setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getOffset() {
        return offset;
    }

    public GetUserProfilePhotos setOffset(Integer offset) {
        this.offset = offset;
        return this;
    }

    public Integer getLimit() {
        return limit;
    }

    public GetUserProfilePhotos setLimit(Integer limit) {
        this.limit = limit;
        return this;
    }
}
