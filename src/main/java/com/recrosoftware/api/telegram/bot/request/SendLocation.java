package com.recrosoftware.api.telegram.bot.request;

import com.recrosoftware.api.telegram.bot.annotation.Serialize;
import com.recrosoftware.api.telegram.bot.model.KeyboardMarkup;
import com.recrosoftware.utils.validation.annotation.Range;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public class SendLocation extends AbstractSendMethod<SendLocation, KeyboardMarkup> {
    private static final String FIELD_LATITUDE = "latitude";
    private static final String FIELD_LONGITUDE = "longitude";
    private static final String FIELD_LIVE_PERIOD = "live_period";

    @Range(from = -90, to = 90)
    @Required
    @Validate(as = FIELD_LATITUDE)
    @Serialize(as = FIELD_LATITUDE)
    private Float latitude;

    @Range(from = -180, to = 180)
    @Required
    @Validate(as = FIELD_LONGITUDE)
    @Serialize(as = FIELD_LONGITUDE)
    private Float longitude;

    @Range(from = 60, to = 86400)
    @Validate(as = FIELD_LIVE_PERIOD)
    @Serialize(as = FIELD_LIVE_PERIOD)
    private Integer livePeriod;

    public SendLocation() {
        super("sendLocation");
    }

    public Float getLatitude() {
        return latitude;
    }

    public SendLocation setLatitude(Float latitude) {
        this.latitude = latitude;
        return this;
    }

    public Float getLongitude() {
        return longitude;
    }

    public SendLocation setLongitude(Float longitude) {
        this.longitude = longitude;
        return this;
    }

    public Integer getLivePeriod() {
        return livePeriod;
    }

    public SendLocation setLivePeriod(Integer livePeriod) {
        this.livePeriod = livePeriod;
        return this;
    }
}
