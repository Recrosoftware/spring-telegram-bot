package com.recrosoftware.api.telegram.bot.request.payment;

import com.fasterxml.jackson.core.type.TypeReference;
import com.recrosoftware.api.telegram.bot.annotation.Serialize;
import com.recrosoftware.api.telegram.bot.model.api.ApiResponse;
import com.recrosoftware.api.telegram.bot.model.payment.ShippingOption;
import com.recrosoftware.api.telegram.bot.request.AbstractRequestItem;
import com.recrosoftware.utils.validation.ValidationError;
import com.recrosoftware.utils.validation.annotation.Range;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public class AnswerShippingQuery extends AbstractRequestItem<Boolean> {
    private static final String FIELD_SHIPPING_QUERY_ID = "shipping_query_id";
    private static final String FIELD_OK = "ok";
    private static final String FIELD_SHIPPING_OPTIONS = "shipping_options";
    private static final String FIELD_ERROR_MESSAGE = "error_message";

    @Required
    @Validate(as = FIELD_SHIPPING_QUERY_ID)
    @Serialize(as = FIELD_SHIPPING_QUERY_ID)
    private String shippingQueryId;

    @Required
    @Validate(as = FIELD_OK)
    @Serialize(as = FIELD_OK)
    private Boolean ok;

    @Range(from = 1)
    @Validate(as = FIELD_SHIPPING_OPTIONS)
    @Serialize(as = FIELD_SHIPPING_OPTIONS)
    private List<ShippingOption> shippingOptions;

    @Serialize(as = FIELD_ERROR_MESSAGE)
    private String errorMessage;

    public AnswerShippingQuery() {
        super("answerShippingQuery", new TypeReference<ApiResponse<Boolean>>() {
        });
    }

    public String getShippingQueryId() {
        return shippingQueryId;
    }

    public AnswerShippingQuery setShippingQueryId(String shippingQueryId) {
        this.shippingQueryId = shippingQueryId;
        return this;
    }

    public Boolean getOk() {
        return ok;
    }

    public AnswerShippingQuery setOk(Boolean ok) {
        this.ok = ok;
        return this;
    }

    public List<ShippingOption> getShippingOptions() {
        return shippingOptions;
    }

    public AnswerShippingQuery setShippingOptions(List<ShippingOption> shippingOptions) {
        this.shippingOptions = shippingOptions;
        return this;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public AnswerShippingQuery setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    @Override
    public List<ValidationError> validate(String prefix) {
        if (ok != null) {
            if (ok && shippingOptions == null) {
                return Collections.singletonList(new ValidationError(prefix + FIELD_SHIPPING_OPTIONS, "Required field, (if 'ok' field is true)."));
            }
            if (!ok && errorMessage == null) {
                return Collections.singletonList(new ValidationError(prefix + FIELD_ERROR_MESSAGE, "Required field, (if 'ok' field is false)."));
            }
        }
        return null;
    }
}
