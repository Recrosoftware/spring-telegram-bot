package com.recrosoftware.api.telegram.bot.model.inline;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

import java.io.Serializable;

/**
 * Represents a link to a sticker stored on the Telegram servers.
 * By default, this sticker will be sent by the user.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the sticker.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class InlineQueryResultCachedSticker extends InlineQueryResult<InlineQueryResultCachedSticker> implements Serializable {
    public static final long serialVersionUID = 3005000L;

    private final static String FIELD_STICKER_FILE_ID = "sticker_file_id";

    /**
     * A valid file identifier of the sticker.
     */
    @Required
    @Validate(as = FIELD_STICKER_FILE_ID)
    @JsonProperty(FIELD_STICKER_FILE_ID)
    private String stickerFileId;

    public InlineQueryResultCachedSticker() {
        super(InlineQueryResult.TYPE_STICKER);
    }

    public String getStickerFileId() {
        return stickerFileId;
    }

    public InlineQueryResultCachedSticker setStickerFileId(String stickerFileId) {
        this.stickerFileId = stickerFileId;
        return this;
    }
}
