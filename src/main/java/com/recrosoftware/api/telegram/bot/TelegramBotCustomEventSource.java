package com.recrosoftware.api.telegram.bot;

import com.recrosoftware.api.telegram.bot.model.Update;

public class TelegramBotCustomEventSource {
    private final TelegramBotDescriptor botDescriptor;
    private final Update update;

    TelegramBotCustomEventSource(TelegramBotDescriptor botDescriptor, Update update) {
        this.botDescriptor = botDescriptor;
        this.update = update;
    }

    public TelegramBotDescriptor getBotDescriptor() {
        return botDescriptor;
    }

    public Update getUpdate() {
        return update;
    }
}
