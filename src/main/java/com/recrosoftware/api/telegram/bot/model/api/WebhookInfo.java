package com.recrosoftware.api.telegram.bot.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Contains information about the current status of a webhook.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class WebhookInfo implements Serializable {
    public static final long serialVersionUID = 3005000L;

    /**
     * Webhook URL, may be empty if webhook is not set up.
     */
    @JsonProperty("url")
    private String url;

    /**
     * True, if a custom certificate was provided for webhook certificate checks.
     */
    @JsonProperty("has_custom_certificate")
    private Boolean hasCustomCertificate;

    /**
     * Number of updates awaiting delivery.
     */
    @JsonProperty("pending_update_count")
    private Integer pendingUpdateCount;

    /**
     * Optional.
     * Unix time for the most recent error that happened when trying to deliver an update via webhook.
     */
    @JsonProperty("last_error_date")
    private Long lastErrorDate;

    /**
     * Optional.
     * Error message in human-readable format for the most recent error that happened when trying to deliver an update via webhook.
     */
    @JsonProperty("last_error_message")
    private String lastErrorMessage;

    /**
     * Optional.
     * Maximum allowed number of simultaneous HTTPS connections to the webhook for update delivery.
     */
    @JsonProperty("max_connections")
    private Integer maxConnections;

    /**
     * Optional.
     * A list of update types the bot is subscribed to.
     * Defaults to all update types.
     */
    @JsonProperty("allowed_updates")
    private List<String> allowedUpdates;

    public String getUrl() {
        return url;
    }


    public WebhookInfo setUrl(String url) {
        this.url = url;
        return this;
    }

    public Boolean getHasCustomCertificate() {
        return hasCustomCertificate;
    }

    public WebhookInfo setHasCustomCertificate(Boolean hasCustomCertificate) {
        this.hasCustomCertificate = hasCustomCertificate;
        return this;
    }

    public Integer getPendingUpdateCount() {
        return pendingUpdateCount;
    }

    public WebhookInfo setPendingUpdateCount(Integer pendingUpdateCount) {
        this.pendingUpdateCount = pendingUpdateCount;
        return this;
    }

    public Long getLastErrorDate() {
        return lastErrorDate;
    }

    public WebhookInfo setLastErrorDate(Long lastErrorDate) {
        this.lastErrorDate = lastErrorDate;
        return this;
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }

    public WebhookInfo setLastErrorMessage(String lastErrorMessage) {
        this.lastErrorMessage = lastErrorMessage;
        return this;
    }

    public Integer getMaxConnections() {
        return maxConnections;
    }

    public WebhookInfo setMaxConnections(Integer maxConnections) {
        this.maxConnections = maxConnections;
        return this;
    }

    public List<String> getAllowedUpdates() {
        return allowedUpdates;
    }

    public WebhookInfo setAllowedUpdates(List<String> allowedUpdates) {
        this.allowedUpdates = allowedUpdates;
        return this;
    }
}
