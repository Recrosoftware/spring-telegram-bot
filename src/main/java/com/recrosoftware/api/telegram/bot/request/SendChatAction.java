package com.recrosoftware.api.telegram.bot.request;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.type.TypeReference;
import com.recrosoftware.api.telegram.bot.annotation.Serialize;
import com.recrosoftware.api.telegram.bot.model.api.ApiResponse;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public class SendChatAction extends AbstractRequestItem<Boolean> {
    public enum ChatAction {
        TYPING("typing"),
        UPLOAD_PHOTO("upload_photo"),
        RECORD_VIDEO("record_video"),
        UPLOAD_VIDEO("upload_video"),
        RECORD_AUDIO("record_audio"),
        UPLOAD_AUDIO("upload_audio"),
        UPLOAD_DOCUMENT("upload_document"),
        FIND_LOCATION("find_location"),
        RECORD_VIDEO_NOTE("record_video_note"),
        UPLOAD_VIDEO_NOTE("upload_video_note");

        private final String action;

        ChatAction(String action) {
            this.action = action;
        }

        @JsonValue
        public String getAction() {
            return action;
        }
    }

    private static final String FIELD_CHAT_ID = "chat_id";
    private static final String FIELD_ACTION = "action";

    @Required
    @Validate(as = FIELD_CHAT_ID)
    @Serialize(as = FIELD_CHAT_ID)
    private String chatId;

    @Required
    @Validate(as = FIELD_ACTION)
    @Serialize(as = FIELD_ACTION)
    private ChatAction action;

    public SendChatAction() {
        super("sendChatAction", new TypeReference<ApiResponse<Boolean>>() {
        });
    }

    public String getChatId() {
        return chatId;
    }

    public SendChatAction setChatId(String chatId) {
        this.chatId = chatId;
        return this;
    }

    public SendChatAction setChatId(Long chatId) {
        if (chatId == null) {
            this.chatId = null;
        } else {
            this.chatId = chatId.toString();
        }
        return this;
    }

    public ChatAction getAction() {
        return action;
    }

    public SendChatAction setAction(ChatAction action) {
        this.action = action;
        return this;
    }
}
