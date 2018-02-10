package com.recrosoftware.api.telegram.bot.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * This object represents response from telegram APIs.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class ApiResponse<T> implements Serializable {
    public static final long serialVersionUID = 3005000L;

    /**
     * Returns whether the response request was successful or not.
     */
    @JsonProperty("ok")
    private Boolean ok;

    /**
     * Returns the a human-readable description of the result.
     */
    @JsonProperty("description")
    private String description;

    /**
     * Returns an Integer representing the error.
     * <p>
     * <b>NOTE:</b> this feature is subjected to change.
     */
    @JsonProperty("error_code")
    private Integer errorCode;

    /**
     * Returns information about why a request was unsuccessful.
     */
    @JsonProperty("parameters")
    private ResponseParameters parameters;

    /**
     * Returns the result of a method invocation.
     */
    @JsonProperty("result")
    private T result;

    public Boolean getOk() {
        return ok;
    }

    public ApiResponse<T> setOk(Boolean ok) {
        this.ok = ok;
        return this;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public ApiResponse<T> setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ApiResponse<T> setDescription(String description) {
        this.description = description;
        return this;
    }

    public ResponseParameters getParameters() {
        return parameters;
    }

    public ApiResponse<T> setParameters(ResponseParameters parameters) {
        this.parameters = parameters;
        return this;
    }

    public T getResult() {
        return result;
    }

    public ApiResponse<T> setResult(T result) {
        this.result = result;
        return this;
    }
}
