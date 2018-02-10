package com.recrosoftware.api.telegram.bot;

import com.recrosoftware.api.telegram.bot.model.Update;
import org.springframework.context.ApplicationEvent;

public abstract class TelegramBotCustomEvent extends ApplicationEvent {
    private final Update update;

    public TelegramBotCustomEvent(TelegramBotCustomEventSource source) {
        super(source.getBotDescriptor());

        this.update = source.getUpdate();
    }

    @Override
    public final Object getSource() {
        return super.getSource();
    }

    public final TelegramBotDescriptor getSourceBot() {
        return (TelegramBotDescriptor) this.getSource();
    }

    public final Update getUpdate() {
        return update;
    }
}
