package com.recrosoftware.api.telegram.bot.model.inline;

import com.recrosoftware.utils.validation.Validable;

/**
 * This object represents the content of a message to be sent as a result of an inline query.
 * Telegram clients currently support the following 4 types:
 * <ul>
 * <li>{@link InputTextMessageContent}
 * <li>{@link InputLocationMessageContent}
 * <li>{@link InputVenueMessageContent}
 * <li>{@link InputContactMessageContent}
 * </ul>
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public interface InputMessageContent extends Validable {
}
