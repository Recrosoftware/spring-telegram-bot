package com.recrosoftware.api.telegram.bot;

import java.util.function.Function;

public interface TelegramBotDescriptor {
    String getBotId();

    String getToken();

    String getTokenHash();

    TelegramBotType getBotType();

    String getWebhookUrl();

    String getApiUrlOverride();

    Object getCertificate();

    Integer getMaxConnections();

    Function<TelegramBotCustomEventSource, TelegramBotCustomEvent> getEventBuilder();
}

