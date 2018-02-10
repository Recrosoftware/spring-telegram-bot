package com.recrosoftware.api.telegram.bot;

import java.io.File;
import java.io.InputStream;
import java.util.function.Function;

public class TelegramBotBuilder {
    public static TelegramBotBuilder create(TelegramBotType botType) {
        return new TelegramBotBuilder(botType);
    }

    private String token;
    private TelegramBotType botType;
    private String webhookUrl;
    private String apiUrlOverride;
    private File certificateFile;
    private InputStream certificateStream;
    private Integer maxConnections;
    private Function<TelegramBotCustomEventSource, TelegramBotCustomEvent> eventBuilder;

    private TelegramBotBuilder(TelegramBotType botType) {
        this.botType = botType;
    }

    public TelegramBotBuilder withToken(String token) {
        this.token = token;
        return this;
    }

    public TelegramBotBuilder withWebhookUrl(String webhookUrl) {
        this.webhookUrl = webhookUrl;
        return this;
    }

    public TelegramBotBuilder withApiUrlOverride(String apiUrlOverride) {
        this.apiUrlOverride = apiUrlOverride;
        return this;
    }

    public TelegramBotBuilder withCertificate(File certificateFile) {
        this.certificateFile = certificateFile;
        this.certificateStream = null;
        return this;
    }

    public TelegramBotBuilder withCertificate(InputStream certificateStream) {
        this.certificateFile = null;
        this.certificateStream = certificateStream;
        return this;
    }

    public TelegramBotBuilder withMaxConnections(Integer maxConnections) {
        this.maxConnections = maxConnections;
        return this;
    }

    public TelegramBotBuilder withEventBuilder(Function<TelegramBotCustomEventSource, TelegramBotCustomEvent> eventBuilder) {
        this.eventBuilder = eventBuilder;
        return this;
    }


    public TelegramBotDescriptor build() {
        Object certificate = certificateFile != null ? certificateFile : certificateStream;
        return new TelegramBotDescriptorImpl(token, botType, webhookUrl, apiUrlOverride, certificate, maxConnections, eventBuilder);
    }
}
