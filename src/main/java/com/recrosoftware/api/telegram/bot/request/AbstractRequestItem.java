package com.recrosoftware.api.telegram.bot.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.recrosoftware.api.telegram.bot.TelegramBotApi;
import com.recrosoftware.api.telegram.bot.annotation.Serialize;
import com.recrosoftware.api.telegram.bot.annotation.UseMediaType;
import com.recrosoftware.api.telegram.bot.annotation.UseSerializer;
import com.recrosoftware.api.telegram.bot.model.api.ApiResponse;
import com.recrosoftware.api.telegram.bot.request.common.CustomSerializer;
import com.recrosoftware.utils.validation.Validable;
import org.glassfish.jersey.media.multipart.BodyPart;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.springframework.util.StringUtils.isEmpty;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public abstract class AbstractRequestItem<T> implements Validable {
    private static final Logger log = LoggerFactory.getLogger(AbstractRequestItem.class);

    private final String requestMethod;
    private TypeReference<? extends ApiResponse<T>> responseTypeReference;

    protected AbstractRequestItem(String method, TypeReference<? extends ApiResponse<T>> responseTypeReference) {
        this.requestMethod = method;
        this.responseTypeReference = responseTypeReference;
    }

    public String getRequestMethod() {
        return this.requestMethod;
    }

    @SuppressWarnings("unchecked")
    protected FormDataMultiPart prepareRequestEntity() {
        FormDataMultiPart request = new FormDataMultiPart();

        try {
            boolean hasFields = false;
            for (Field methodField : this.getMethodFields()) {
                hasFields = true;
                methodField.setAccessible(true);
                Object fieldValue = methodField.get(this);
                if (fieldValue == null) {
                    continue;
                }

                String fieldName = methodField.getName();
                Serialize propertyInfo = methodField.getAnnotation(Serialize.class);
                if (!isEmpty(propertyInfo.as())) {
                    fieldName = propertyInfo.as();
                }


                UseSerializer useSerializer = methodField.getAnnotation(UseSerializer.class);
                if (useSerializer != null) {
                    CustomSerializer serializer = useSerializer.value().newInstance();
                    List<BodyPart> parts = serializer.serialize(fieldName, fieldValue);
                    if (parts != null) {
                        for (BodyPart part : parts) {
                            request.bodyPart(part);
                        }
                    }
                } else {
                    MediaType mediaType = MediaType.TEXT_PLAIN_TYPE;

                    UseMediaType useMediaType = methodField.getAnnotation(UseMediaType.class);
                    if (useMediaType != null) {
                        String[] rawMediaType = useMediaType.value().split("/");
                        mediaType = new MediaType(rawMediaType[0], rawMediaType[1]);
                    }

                    if (fieldValue instanceof Enum) {
                        Method[] methods = fieldValue.getClass().getDeclaredMethods();
                        for (Method method : methods) {
                            if (method.getAnnotation(JsonValue.class) != null) {
                                method.setAccessible(true);
                                fieldValue = method.invoke(fieldValue);
                            }
                        }
                    }
                    request.field(fieldName, fieldValue, mediaType);
                }
            }
            if (!hasFields) {
                return null;
            }
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException ex) {
            throw new RuntimeException(ex);
        }

        return request;
    }

    public final Entity requestEntity() {
        FormDataMultiPart request = this.prepareRequestEntity();
        if (request == null) {
            return null;
        }
        return Entity.entity(request, request.getMediaType());
    }

    public ApiResponse<T> parseResponse(Response response) {
        return this.getApiResponse(response, responseTypeReference);
    }

    public ApiResponse<T> invoke(TelegramBotApi client) {
        return client.invoke(this);
    }

    protected <Q> ApiResponse<Q> getApiResponse(Response response, TypeReference<? extends ApiResponse<Q>> castType) {
        if (response != null) {
            if (response.getStatus() == Response.Status.OK.getStatusCode()) {
                String rawEntity = response.readEntity(String.class);

                try {
                    ObjectMapper mapper = new ObjectMapper();
                    return mapper.readValue(rawEntity, castType);
                } catch (UnrecognizedPropertyException ex) {
                    Class<?> referringClass = ex.getReferringClass();
                    String field = ex.getPropertyName();

                    log.error(String.format("Error: Missing property '%s' from class '%s'", field, referringClass.getName()), ex);
                } catch (Exception ex) {
                    log.error("Error while de-serializing response", ex);
                }
            }
        }
        return null;
    }

    private Set<Field> getMethodFields() {
        Set<Field> set = new HashSet<>();
        for (Class<?> c = this.getClass(); c != null; c = c.getSuperclass()) {
            for (Field field : c.getDeclaredFields()) {
                if (field.isAnnotationPresent(JsonProperty.class)) {
                    set.add(field);
                }
            }
        }
        return set;
    }
}
