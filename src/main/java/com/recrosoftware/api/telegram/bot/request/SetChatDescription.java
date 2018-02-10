package com.recrosoftware.api.telegram.bot.request;

import com.fasterxml.jackson.core.type.TypeReference;
import com.recrosoftware.api.telegram.bot.annotation.Serialize;
import com.recrosoftware.api.telegram.bot.model.api.ApiResponse;
import com.recrosoftware.utils.validation.annotation.Range;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public class SetChatDescription extends AbstractRequestItem<Boolean> {
    private static final String FIELD_CHAT_ID = "chat_id";
    private static final String FIELD_DESCRIPTION = "description";

    @Required
    @Validate(as = FIELD_CHAT_ID)
    @Serialize(as = FIELD_CHAT_ID)
    private String chatId;

    @Range(to = 255)
    @Validate(as = FIELD_DESCRIPTION)
    @Serialize(as = FIELD_DESCRIPTION)
    private String description;

    public SetChatDescription() {
        super("setChatDescription", new TypeReference<ApiResponse<Boolean>>() {
        });
    }

    public String getChatId() {
        return chatId;
    }

    public SetChatDescription setChatId(String chatId) {
        this.chatId = chatId;
        return this;
    }

    public SetChatDescription setChatId(Long chatId) {
        if (chatId == null) {
            this.chatId = null;
        } else {
            this.chatId = chatId.toString();
        }
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SetChatDescription setDescription(String description) {
        this.description = description;
        return this;
    }
}
