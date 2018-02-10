package com.recrosoftware.api.telegram.bot;

import com.recrosoftware.api.telegram.bot.exception.TelegramBotValidationException;
import com.recrosoftware.api.telegram.bot.model.api.ApiResponse;
import com.recrosoftware.api.telegram.bot.request.AbstractRequestItem;
import com.recrosoftware.utils.validation.BeanValidator;
import com.recrosoftware.utils.validation.exception.ValidationProcessingException;
import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TelegramBotApi {
    static final Integer REQUEST_TIMEOUT = 45;
    private static final String TELEGRAM_BOT_API_URI = "https://api.telegram.org/bot{TOKEN}";

    private static Client tgClient;
    private static Map<String, TelegramBotApi> clientsMap;

    static {
        tgClient = ClientBuilder.newBuilder()
                .register(MultiPartFeature.class)
                .property(ClientProperties.CONNECT_TIMEOUT, 10000)
                .property(ClientProperties.READ_TIMEOUT, REQUEST_TIMEOUT * 1000)
                .build();

//        Logger logger = Logger.getLogger(TelegramBot.class.getName());
//        Feature feature = new LoggingFeature(logger, Level.INFO, LoggingFeature.Verbosity.PAYLOAD_ANY, null);
//        tgClient.register(feature);

        clientsMap = new ConcurrentHashMap<>();
    }

    public static TelegramBotApi buildFor(TelegramBotDescriptor descriptor) {
        return clientsMap.computeIfAbsent(descriptor.getTokenHash(), tokenHash -> {
            String apiUrl = descriptor.getApiUrlOverride();
            if (apiUrl == null) {
                apiUrl = TELEGRAM_BOT_API_URI;
            }
            return new TelegramBotApi(tgClient.target(apiUrl.replace("{TOKEN}", descriptor.getToken())));
        });
    }

    private final WebTarget botTarget;

    private TelegramBotApi(WebTarget botTarget) {
        this.botTarget = botTarget;
    }

    public <T> ApiResponse<T> invoke(AbstractRequestItem<T> request) {
        return request.parseResponse(this.makeRequest(request));
    }

    private Response makeRequest(AbstractRequestItem<?> request) throws TelegramBotValidationException {
        if (request == null) {
            throw new IllegalArgumentException("Request argument cannot be null.");
        }

        try {
            BeanValidator.validate(request);
        } catch (IllegalAccessException ex) {
            throw new RuntimeException(ex);
        } catch (ValidationProcessingException ex) {
            throw new TelegramBotValidationException(ex.getValidationErrors());
        }

        Invocation.Builder requestBuilder = botTarget
                .path(request.getRequestMethod())
                .request(MediaType.APPLICATION_JSON_TYPE);

        Entity requestEntity = request.requestEntity();
        if (requestEntity != null) {
            return requestBuilder.post(requestEntity);
        } else {
            return requestBuilder.get();
        }
    }
}
