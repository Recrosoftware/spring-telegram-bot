package com.recrosoftware.api.telegram.bot.request.common;

import org.glassfish.jersey.media.multipart.BodyPart;

import java.util.List;

public interface CustomSerializer<T> {
    List<BodyPart> serialize(String fieldName, T element);
}
