package com.recrosoftware.api.telegram.bot.request;

import com.fasterxml.jackson.core.type.TypeReference;
import com.recrosoftware.api.telegram.bot.annotation.Serialize;
import com.recrosoftware.api.telegram.bot.annotation.UseSerializer;
import com.recrosoftware.api.telegram.bot.model.InputMedia;
import com.recrosoftware.api.telegram.bot.model.Message;
import com.recrosoftware.api.telegram.bot.model.api.ApiResponse;
import com.recrosoftware.api.telegram.bot.request.common.serializer.MediaGroupSerializer;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public class SendMediaGroup extends AbstractRequestItem<List<Message>> {
    private static final String FIELD_CHAT_ID = "chat_id";
    private static final String FIELD_MEDIA = "media";
    private static final String FIELD_DISABLE_NOTIFICATION = "disable_notification";
    private static final String FIELD_REPLY_TO_MESSAGE_ID = "reply_to_message_id";

    @Required
    @Validate(as = FIELD_CHAT_ID)
    @Serialize(as = FIELD_CHAT_ID)
    private String chatId;

    @Required
    @Validate(as = FIELD_MEDIA)
    @Serialize(as = FIELD_MEDIA)
    @UseSerializer(MediaGroupSerializer.class)
    private List<InputMedia<?>> media;

    @Serialize(as = FIELD_DISABLE_NOTIFICATION)
    private Boolean disableNotification;

    @Serialize(as = FIELD_REPLY_TO_MESSAGE_ID)
    private Integer replyToMessageId;

    public SendMediaGroup() {
        super("sendMediaGroup", new TypeReference<ApiResponse<List<Message>>>() {
        });
    }

    public String getChatId() {
        return chatId;
    }

    public SendMediaGroup setChatId(String chatId) {
        this.chatId = chatId;
        return this;
    }

    public SendMediaGroup setChatId(Long chatId) {
        if (chatId == null) {
            this.chatId = null;
        } else {
            this.chatId = chatId.toString();
        }
        return this;
    }

    public List<InputMedia<?>> getMedia() {
        if (media == null) {
            media = new ArrayList<>();
        }
        return media;
    }

    public SendMediaGroup setMedia(List<InputMedia<?>> media) {
        this.media = media;
        return this;
    }

    public Boolean getDisableNotification() {
        return disableNotification;
    }

    public SendMediaGroup setDisableNotification(Boolean disableNotification) {
        this.disableNotification = disableNotification;
        return this;
    }

    public Integer getReplyToMessageId() {
        return replyToMessageId;
    }

    public SendMediaGroup setReplyToMessageId(Integer replyToMessageId) {
        this.replyToMessageId = replyToMessageId;
        return this;
    }
}
