package com.recrosoftware.api.telegram.bot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.SERVICE_UNAVAILABLE,
        reason = "No bot descriptor attached on the provided webhook url.")
public class InvalidTokenHashException extends RuntimeException {
}
