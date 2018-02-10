package com.recrosoftware.api.telegram.bot.exception;

import com.recrosoftware.utils.validation.ValidationError;

import java.util.List;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public class TelegramBotValidationException extends RuntimeException {
    private final List<ValidationError> validationErrors;

    public TelegramBotValidationException(List<ValidationError> validationErrors) {
        this.validationErrors = validationErrors;
    }

    public List<ValidationError> getValidationErrors() {
        return validationErrors;
    }
}
