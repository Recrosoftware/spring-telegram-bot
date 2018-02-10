package com.recrosoftware.api.telegram.bot.annotation;

import com.recrosoftware.api.telegram.bot.request.common.CustomSerializer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UseSerializer {
    Class<? extends CustomSerializer> value();
}
