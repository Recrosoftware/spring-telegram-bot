package com.recrosoftware.api.telegram.bot;

import org.springframework.util.DigestUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.function.Function;

import static org.springframework.util.StringUtils.isEmpty;

class TelegramBotDescriptorImpl implements TelegramBotDescriptor {
    private final String botId;
    private final String token;
    private final String tokenHash;
    private final TelegramBotType botType;
    private final String webhookUrl;
    private final String apiUrlOverride;
    private final Object certificate;
    private final Integer maxConnections;
    private final Function<TelegramBotCustomEventSource, TelegramBotCustomEvent> eventBuilder;


    TelegramBotDescriptorImpl(String token,
                              TelegramBotType botType,
                              String webhookUrl,
                              String apiUrlOverride,
                              Object certificate,
                              Integer maxConnections,
                              Function<TelegramBotCustomEventSource, TelegramBotCustomEvent> eventBuilder) {
        if (isEmpty(token)) {
            throw new IllegalArgumentException("Argument required: 'token'.");
        }
        if (botType == null) {
            throw new IllegalArgumentException("Argument required: 'botType.");
        }
        if (TelegramBotType.WEBHOOK_BOT.equals(botType) && isEmpty(webhookUrl)) {
            throw new IllegalArgumentException("Argument required: 'webhookUrl.");
        }
        if (isEmpty(apiUrlOverride)) {
            apiUrlOverride = null;
        }
        if (certificate != null && certificate instanceof File) {
            File certificateFile = (File) certificate;
            if (!certificateFile.exists() || !certificateFile.canRead()) {
                throw new IllegalArgumentException("The provided certificate file does not exist or has invalid read permissions");
            }
        }
        if (maxConnections != null && (maxConnections < 1 || maxConnections > 100)) {
            throw new IllegalArgumentException("The 'maxConnections' argument must range between 1 and 100");
        }

        if (!token.contains(":")) {
            throw new IllegalArgumentException("Invalid token provided.");
        }

        this.token = token;
        this.botType = botType;
        this.webhookUrl = webhookUrl;
        this.apiUrlOverride = apiUrlOverride;
        this.certificate = certificate;
        this.maxConnections = maxConnections;
        this.eventBuilder = eventBuilder;

        this.botId = this.token.substring(0, token.indexOf(":"));
        this.tokenHash = DigestUtils.md5DigestAsHex(this.token.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public String getBotId() {
        return botId;
    }

    @Override
    public String getToken() {
        return token;
    }

    @Override
    public String getTokenHash() {
        return tokenHash;
    }

    @Override
    public TelegramBotType getBotType() {
        return botType;
    }

    @Override
    public String getWebhookUrl() {
        return webhookUrl;
    }

    @Override
    public String getApiUrlOverride() {
        return apiUrlOverride;
    }

    @Override
    public Object getCertificate() {
        return certificate;
    }

    @Override
    public Integer getMaxConnections() {
        return maxConnections;
    }

    @Override
    public Function<TelegramBotCustomEventSource, TelegramBotCustomEvent> getEventBuilder() {
        return eventBuilder;
    }
}

