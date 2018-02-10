package com.recrosoftware.api.telegram.bot.model;

/**
 * Represents a photo to be sent.
 *
 * @author Davide Menegatti - d.menegatti@recrosoftware.com
 */
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class InputMediaPhoto extends InputMedia<InputMediaPhoto> {
    public InputMediaPhoto() {
        super("photo");
    }
}
