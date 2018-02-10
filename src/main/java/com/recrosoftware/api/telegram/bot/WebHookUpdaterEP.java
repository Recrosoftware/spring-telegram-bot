package com.recrosoftware.api.telegram.bot;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.recrosoftware.api.telegram.bot.model.Update;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;

@Path("/webhook")
@Singleton
@Component
class WebHookUpdaterEP {
    private final static Logger log = LoggerFactory.getLogger(WebHookUpdaterEP.class);

    private final List<TelegramBotDescriptor> botDescriptors;
    private final ApplicationEventPublisher eventPublisher;


    public WebHookUpdaterEP(@Autowired(required = false) List<TelegramBotDescriptor> botDescriptors,
                            @Autowired ApplicationEventPublisher eventPublisher) {
        this.botDescriptors = botDescriptors;
        this.eventPublisher = eventPublisher;
    }

    @Path("{tokenHash}")
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public Response handleUpdate(@PathParam("tokenHash") final String tokenHash,
                                 String rawRequest) {
        TelegramBotDescriptor descriptor = getDescriptorByHash(tokenHash);
        if (descriptor == null) {
            return Response.status(Response.Status.SERVICE_UNAVAILABLE).build();
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
        } catch (Exception ex) {
            log.error("Error while handling webhook update", ex);
        }

        return Response.ok().build();
    }

    private TelegramBotDescriptor getDescriptorByHash(final String tokenHash) {
        if (botDescriptors != null) {
            for (TelegramBotDescriptor descriptor : botDescriptors) {
                if (Objects.equals(descriptor.getTokenHash(), tokenHash)) {
                    return descriptor;
                }
            }
        }
        return null;
    }
}
