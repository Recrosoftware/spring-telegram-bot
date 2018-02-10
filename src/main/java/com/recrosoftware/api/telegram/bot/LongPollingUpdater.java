package com.recrosoftware.api.telegram.bot;

import com.recrosoftware.api.telegram.bot.model.Update;
import com.recrosoftware.api.telegram.bot.model.api.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class LongPollingUpdater {
    private static final Logger log = LoggerFactory.getLogger(LongPollingUpdater.class);

    private boolean running;
    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    LongPollingUpdater(ApplicationEventPublisher eventPublisher) {
        this.running = true;
        this.eventPublisher = eventPublisher;
    }

    @Async("telegramAsyncExecutor")
    void startFor(TelegramBotDescriptor descriptor) {
        try {
            MethodGetUpdates updateMethod = new MethodGetUpdates();
            TelegramBotApi apiClient = TelegramBotApi.buildFor(descriptor);

            Thread.sleep(TelegramBotApi.REQUEST_TIMEOUT / 5 * 1000);

            log.info(String.format("TelegramBot API - Bot '%s' loaded and listening for updates.", descriptor.getBotId()));

            while (this.running) {
                boolean allOk = false;
                Update processedUpdate = null;

                try {
                    ApiResponse<List<Update>> updates = updateMethod.invoke(apiClient);

                    if (updates != null && updates.getOk()) {
                        for (Update update : updates.getResult()) {
                            processedUpdate = update;

                            eventPublisher.publishEvent(new TelegramBotEvent(descriptor, update));
                            if (descriptor.getEventBuilder() != null) {
                                TelegramBotCustomEvent customEvent = descriptor.getEventBuilder()
                                        .apply(new TelegramBotCustomEventSource(descriptor, update));

                                eventPublisher.publishEvent(customEvent);
                            }

                            if (updateMethod.getLastUpdate() <= update.getUpdateId()) {
                                updateMethod.setLastUpdate(update.getUpdateId() + 1);
                            }
                        }

                        allOk = true;
                    }
                } catch (Exception ex) {
                    log.error(String.format("Unexpected error occurred while parsing update%s for bot: %s",
                            processedUpdate != null ? String.format(" (%s)", processedUpdate.getUpdateId()) : "",
                            descriptor.getBotId()), ex);
                }

                if (!allOk) {
                    Thread.sleep(TelegramBotApi.REQUEST_TIMEOUT * 1000);
                }
            }
        } catch (InterruptedException ex) {
            log.error("Error during execution", ex);
        }
    }

    void stopAll() {
        this.running = false;
    }
}
