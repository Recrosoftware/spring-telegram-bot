package com.recrosoftware.api.telegram.bot.request.inline;

import com.fasterxml.jackson.core.type.TypeReference;
import com.recrosoftware.api.telegram.bot.annotation.Serialize;
import com.recrosoftware.api.telegram.bot.model.api.ApiResponse;
import com.recrosoftware.api.telegram.bot.model.inline.InlineQueryResult;
import com.recrosoftware.api.telegram.bot.request.AbstractRequestItem;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public class AnswerInlineQuery extends AbstractRequestItem<Boolean> {
    private static final String FIELD_INLINE_QUERY_ID = "inline_query_id";
    private static final String FIELD_RESULTS = "results";
    private static final String FIELD_CACHE_TIME = "cache_time";
    private static final String FIELD_IS_PERSONAL = "is_personal";
    private static final String FIELD_NEXT_OFFSET = "next_offset";
    private static final String FIELD_SWITCH_PM_TEXT = "switch_pm_text";
    private static final String FIELD_SWITCH_PM_PARAMETER = "switch_pm_parameter";

    @Required
    @Validate(as = FIELD_INLINE_QUERY_ID)
    @Serialize(as = FIELD_INLINE_QUERY_ID)
    private String inlineQueryId;

    @Required
    @Validate(as = FIELD_RESULTS)
    @Serialize(as = FIELD_RESULTS)
    private List<InlineQueryResult<?>> results;

    @Serialize(as = FIELD_CACHE_TIME)
    private Integer cacheTime;

    @Serialize(as = FIELD_IS_PERSONAL)
    private Boolean isPersonal;

    @Serialize(as = FIELD_NEXT_OFFSET)
    private String nextOffset;

    @Serialize(as = FIELD_SWITCH_PM_TEXT)
    private String switchPmText;

    @Serialize(as = FIELD_SWITCH_PM_PARAMETER)
    private String switchPmParameter;

    public AnswerInlineQuery() {
        super("answerInlineQuery", new TypeReference<ApiResponse<Boolean>>() {
        });
    }

    public String getInlineQueryId() {
        return inlineQueryId;
    }

    public AnswerInlineQuery setInlineQueryId(String inlineQueryId) {
        this.inlineQueryId = inlineQueryId;
        return this;
    }

    public List<InlineQueryResult<?>> getResults() {
        if (results == null) {
            results = new ArrayList<>();
        }
        return results;
    }

    public AnswerInlineQuery setResults(List<InlineQueryResult<?>> results) {
        this.results = results;
        return this;
    }

    public Integer getCacheTime() {
        return cacheTime;
    }

    public AnswerInlineQuery setCacheTime(Integer cacheTime) {
        this.cacheTime = cacheTime;
        return this;
    }

    public Boolean getIsPersonal() {
        return isPersonal;
    }

    public AnswerInlineQuery setIsPersonal(Boolean personal) {
        isPersonal = personal;
        return this;
    }

    public String getNextOffset() {
        return nextOffset;
    }

    public AnswerInlineQuery setNextOffset(String nextOffset) {
        this.nextOffset = nextOffset;
        return this;
    }

    public String getSwitchPmText() {
        return switchPmText;
    }

    public AnswerInlineQuery setSwitchPmText(String switchPmText) {
        this.switchPmText = switchPmText;
        return this;
    }

    public String getSwitchPmParameter() {
        return switchPmParameter;
    }

    public AnswerInlineQuery setSwitchPmParameter(String switchPmParameter) {
        this.switchPmParameter = switchPmParameter;
        return this;
    }
}
