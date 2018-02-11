package com.recrosoftware.api.telegram.bot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class WebhookProcessingException extends RuntimeException {
    public WebhookProcessingException(Throwable cause) {
        super(cause);
    }
}
