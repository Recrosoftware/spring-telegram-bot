package com.recrosoftware.api.telegram.bot;

import com.recrosoftware.api.telegram.bot.model.api.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
class TelegramBotListener {
    private static final Logger log = LoggerFactory.getLogger(TelegramBotListener.class);

    private final LongPollingUpdater lpUpdater;
    private final List<TelegramBotDescriptor> botDescriptors;

    public TelegramBotListener(@Autowired(required = false) List<TelegramBotDescriptor> botDescriptors,
                               @Autowired LongPollingUpdater lpUpdater) {
        this.botDescriptors = botDescriptors;
        this.lpUpdater = lpUpdater;
    }

    @PostConstruct
    public void onApplicationEvent() {
        if (botDescriptors == null) {
            log.warn("TelegramBot API - No TelegramBotDescriptor bean found.");
            return;
        }

        Set<String> loadedBots = new HashSet<>();

        for (TelegramBotDescriptor descriptor : botDescriptors) {
            if (loadedBots.contains(descriptor.getBotId())) {
                throw new IllegalStateException(String.format("Bot %s already loaded", descriptor.getBotId()));
            }
            loadedBots.add(descriptor.getBotId());

            log.info("TelegramBot API - PreLoading Bot: " + descriptor.getBotId());
            TelegramBotApi client = TelegramBotApi.buildFor(descriptor);

            switch (descriptor.getBotType()) {
                case LONG_POLLING_BOT:
                    ApiResponse<Boolean> deleteWebhookResponse = client.invoke(new MethodDeleteWebhook());
                    if (deleteWebhookResponse == null || !deleteWebhookResponse.getOk()) {
                        throw new IllegalStateException("Error when trying to remove webhook configuration for bot " + descriptor.getBotId());
                    }

                    lpUpdater.startFor(descriptor);
                    break;
                case WEBHOOK_BOT:
                    String webhookUrl = String.format("%s/rs-telegram-api/bot/webhook/%s", descriptor.getWebhookUrl(), descriptor.getTokenHash());
                    MethodSetWebhook setWebhook = new MethodSetWebhook()
                            .setUrl(webhookUrl)
                            .setCertificate(descriptor.getCertificate())
                            .setMaxConnections(descriptor.getMaxConnections());

                    ApiResponse<Boolean> setWebhookResponse = client.invoke(setWebhook);
                    if (setWebhookResponse == null || !setWebhookResponse.getOk()) {
                        throw new IllegalStateException("Error while trying to set webhook configuration for bot " + descriptor.getBotId());
                    }
                    break;
            }
        }
        log.info("TelegramBot API - PreLoad completed");
    }

    @PreDestroy
    void test() {
        log.info("TelegramBot API - Closing listeners");
        lpUpdater.stopAll();
    }
}
