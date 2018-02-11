package com.recrosoftware.api.telegram.bot;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.recrosoftware.api.telegram.bot.exception.InvalidTokenHashException;
import com.recrosoftware.api.telegram.bot.exception.WebhookProcessingException;
import com.recrosoftware.api.telegram.bot.model.Update;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Singleton;
import java.util.List;
import java.util.Objects;

@Singleton
@Controller
class WebHookUpdaterController {
    static final String WEBHOOK_PATH = "/rs/telegram/bot/webhook/{tokenHash}";

    private final static Logger log = LoggerFactory.getLogger(WebHookUpdaterController.class);

    private final List<TelegramBotDescriptor> botDescriptors;
    private final ApplicationEventPublisher eventPublisher;


    public WebHookUpdaterController(@Autowired(required = false) List<TelegramBotDescriptor> botDescriptors,
                                    @Autowired ApplicationEventPublisher eventPublisher) {
        this.botDescriptors = botDescriptors;
        this.eventPublisher = eventPublisher;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = WEBHOOK_PATH,
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void handleUpdate(@PathVariable("tokenHash") final String tokenHash,
                             @RequestBody String rawRequest) {
        TelegramBotDescriptor descriptor = getDescriptorByHash(tokenHash);
        if (descriptor == null) {
            throw new InvalidTokenHashException();
        }

        try {
            ObjectMapper mapper = new ObjectMapper();
            Update update = mapper.readValue(rawRequest, new TypeReference<Update>() {
            });

            eventPublisher.publishEvent(new TelegramBotEvent(this, update));
            if (descriptor.getEventBuilder() != null) {
                TelegramBotCustomEvent customEvent = descriptor.getEventBuilder()
                        .apply(new TelegramBotCustomEventSource(descriptor, update));

                eventPublisher.publishEvent(customEvent);
            }

        } catch (UnrecognizedPropertyException ex) {
            Class<?> referringClass = ex.getReferringClass();
            String field = ex.getPropertyName();

            log.error(String.format("Error while handling webhook update: Missing property '%s' from class '%s'", field, referringClass.getName()), ex);

            throw new WebhookProcessingException(ex);
        } catch (Exception ex) {
            log.error("Error while handling webhook update", ex);

            throw new WebhookProcessingException(ex);
        }
    }

    private TelegramBotDescriptor getDescriptorByHash(final String tokenHash) {
        if (botDescriptors != null) {
            for (TelegramBotDescriptor descriptor : botDescriptors) {
                if (descriptor != null && Objects.equals(descriptor.getTokenHash(), tokenHash)) {
                    return descriptor;
                }
            }
        }
        return null;
    }
}
