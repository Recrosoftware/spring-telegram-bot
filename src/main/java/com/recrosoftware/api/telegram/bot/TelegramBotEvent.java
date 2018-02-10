package com.recrosoftware.api.telegram.bot;

import com.recrosoftware.api.telegram.bot.model.Update;
import org.springframework.context.ApplicationEvent;

public class TelegramBotEvent extends ApplicationEvent {
    private final Update update;

    TelegramBotEvent(Object source, Update update) {
        super(source);
        this.update = update;
    }

    public Update getUpdate() {
        return this.update;
    }
}
