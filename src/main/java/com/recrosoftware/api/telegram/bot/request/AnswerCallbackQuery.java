package com.recrosoftware.api.telegram.bot.request;

import com.fasterxml.jackson.core.type.TypeReference;
import com.recrosoftware.api.telegram.bot.annotation.Serialize;
import com.recrosoftware.api.telegram.bot.model.api.ApiResponse;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public class AnswerCallbackQuery extends AbstractRequestItem<Boolean> {
    private static final String FIELD_CALLBACK_QUERY_ID = "callback_query_id";
    private static final String FIELD_TEXT = "text";
    private static final String FIELD_SHOW_ALERT = "show_alert";
    private static final String FIELD_URL = "url";
    private static final String FIELD_CACHE_TIME = "cache_time";

    @Required
    @Validate(as = FIELD_CALLBACK_QUERY_ID)
    @Serialize(as = FIELD_CALLBACK_QUERY_ID)
    private String callbackQueryId;

    @Serialize(as = FIELD_TEXT)
    private String text;

    @Serialize(as = FIELD_SHOW_ALERT)
    private Boolean showAlert;

    @Serialize(as = FIELD_URL)
    private String url;

    @Serialize(as = FIELD_CACHE_TIME)
    private Integer cacheTime;

    public AnswerCallbackQuery() {
        super("answerCallbackQuery", new TypeReference<ApiResponse<Boolean>>() {
        });
    }

    public String getCallbackQueryId() {
        return callbackQueryId;
    }

    public AnswerCallbackQuery setCallbackQueryId(String callbackQueryId) {
        this.callbackQueryId = callbackQueryId;
        return this;
    }

    public String getText() {
        return text;
    }

    public AnswerCallbackQuery setText(String text) {
        this.text = text;
        return this;
    }

    public Boolean getShowAlert() {
        return showAlert;
    }

    public AnswerCallbackQuery setShowAlert(Boolean showAlert) {
        this.showAlert = showAlert;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public AnswerCallbackQuery setUrl(String url) {
        this.url = url;
        return this;
    }

    public Integer getCacheTime() {
        return cacheTime;
    }

    public AnswerCallbackQuery setCacheTime(Integer cacheTime) {
        this.cacheTime = cacheTime;
        return this;
    }
}
