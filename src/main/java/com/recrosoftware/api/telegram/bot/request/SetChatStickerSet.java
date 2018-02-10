package com.recrosoftware.api.telegram.bot.request;

import com.fasterxml.jackson.core.type.TypeReference;
import com.recrosoftware.api.telegram.bot.annotation.Serialize;
import com.recrosoftware.api.telegram.bot.model.api.ApiResponse;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public class SetChatStickerSet extends AbstractRequestItem<Boolean> {
    private static final String FIELD_CHAT_ID = "chat_id";
    private static final String FIELD_STICKER_SET_NAME = "sticker_set_name";

    @Required
    @Validate(as = FIELD_CHAT_ID)
    @Serialize(as = FIELD_CHAT_ID)
    private String chatId;

    @Required
    @Validate(as = FIELD_STICKER_SET_NAME)
    @Serialize(as = FIELD_STICKER_SET_NAME)
    private String stickerSetName;

    public SetChatStickerSet() {
        super("setChatStickerSet", new TypeReference<ApiResponse<Boolean>>() {
        });
    }

    public String getChatId() {
        return chatId;
    }

    public SetChatStickerSet setChatId(String chatId) {
        this.chatId = chatId;
        return this;
    }

    public SetChatStickerSet setChatId(Long chatId) {
        if (chatId == null) {
            this.chatId = null;
        } else {
            this.chatId = chatId.toString();
        }
        return this;
    }

    public String getStickerSetName() {
        return stickerSetName;
    }

    public SetChatStickerSet setStickerSetName(String stickerSetName) {
        this.stickerSetName = stickerSetName;
        return this;
    }
}
