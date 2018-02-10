package com.recrosoftware.api.telegram.bot.request.sticker;

import com.recrosoftware.api.telegram.bot.request.AbstractSendFile;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public class SendSticker extends AbstractSendFile<SendSticker> {
    public SendSticker() {
        super("sendSticker", "sticker");
    }
}
