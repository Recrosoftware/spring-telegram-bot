package com.recrosoftware.api.telegram.bot.request.payment;

import com.recrosoftware.api.telegram.bot.annotation.Serialize;
import com.recrosoftware.api.telegram.bot.annotation.UseMediaType;
import com.recrosoftware.api.telegram.bot.model.InlineKeyboardMarkup;
import com.recrosoftware.api.telegram.bot.model.payment.LabeledPrice;
import com.recrosoftware.api.telegram.bot.request.AbstractSendMethod;
import com.recrosoftware.utils.validation.annotation.Range;
import com.recrosoftware.utils.validation.annotation.Required;
import com.recrosoftware.utils.validation.annotation.Validate;

import javax.ws.rs.core.MediaType;
import java.util.List;

@SuppressWarnings({"unused", "UnusedReturnValue", "WeakerAccess"})
public class SendInvoice extends AbstractSendMethod<SendInvoice, InlineKeyboardMarkup> {
    private static final String FIELD_TITLE = "title";
    private static final String FIELD_DESCRIPTION = "description";
    private static final String FIELD_PAYLOAD = "payload";
    private static final String FIELD_PROVIDER_TOKEN = "provider_token";
    private static final String FIELD_START_PARAMETER = "start_parameter";
    private static final String FIELD_CURRENCY = "currency";
    private static final String FIELD_PRICES = "prices";
    private static final String FIELD_PROVIDER_DATA = "provider_data";
    private static final String FIELD_PHOTO_URL = "photo_url";
    private static final String FIELD_PHOTO_SIZE = "photo_size";
    private static final String FIELD_PHOTO_WIDTH = "photo_width";
    private static final String FIELD_PHOTO_HEIGHT = "photo_height";
    private static final String FIELD_NEED_NAME = "need_name";
    private static final String FIELD_NEED_PHONE_NUMBER = "need_phone_number";
    private static final String FIELD_NEED_EMAIL = "need_email";
    private static final String FIELD_NEED_SHIPPING_ADDRESS = "need_shipping_address";
    private static final String FIELD_SEND_PHONE_NUMBER_TO_PROVIDER = "send_phone_number_to_provider";
    private static final String FIELD_SEND_EMAIL_TO_PROVIDER = "send_email_to_provider";
    private static final String FIELD_IS_FLEXIBLE = "is_flexible";

    @Range(from = 1, to = 32)
    @Required
    @Validate(as = FIELD_TITLE)
    @Serialize(as = FIELD_TITLE)
    private String title;

    @Range(from = 1, to = 255)
    @Required
    @Validate(as = FIELD_DESCRIPTION)
    @Serialize(as = FIELD_DESCRIPTION)
    private String description;

    @Range(from = 1, to = 128)
    @Required
    @Validate(as = FIELD_PAYLOAD)
    @Serialize(as = FIELD_PAYLOAD)
    private String payload;

    @Required
    @Validate(as = FIELD_PROVIDER_TOKEN)
    @Serialize(as = FIELD_PROVIDER_TOKEN)
    private String providerToken;

    @Required
    @Validate(as = FIELD_START_PARAMETER)
    @Serialize(as = FIELD_START_PARAMETER)
    private String startParameter;

    @Required
    @Validate(as = FIELD_CURRENCY)
    @Serialize(as = FIELD_CURRENCY)
    private String currency;

    @Required
    @Validate(as = FIELD_PRICES)
    @Serialize(as = FIELD_PRICES)
    @UseMediaType(MediaType.APPLICATION_JSON)
    private List<LabeledPrice> prices;

    @Serialize(as = FIELD_PROVIDER_DATA)
    private String providerData;

    @Serialize(as = FIELD_PHOTO_URL)
    private String photoUrl;

    @Serialize(as = FIELD_PHOTO_SIZE)
    private Integer photoSize;

    @Serialize(as = FIELD_PHOTO_WIDTH)
    private Integer photoWidth;

    @Serialize(as = FIELD_PHOTO_HEIGHT)
    private Integer photoHeight;

    @Serialize(as = FIELD_NEED_NAME)
    private Boolean needName;

    @Serialize(as = FIELD_NEED_PHONE_NUMBER)
    private Boolean needPhoneNumber;

    @Serialize(as = FIELD_NEED_EMAIL)
    private Boolean needEmail;

    @Serialize(as = FIELD_NEED_SHIPPING_ADDRESS)
    private Boolean needShippingAddress;

    @Serialize(as = FIELD_SEND_PHONE_NUMBER_TO_PROVIDER)
    private Boolean sendPhoneNumberToProvider;

    @Serialize(as = FIELD_SEND_EMAIL_TO_PROVIDER)
    private Boolean sendEmailToProvider;

    @Serialize(as = FIELD_IS_FLEXIBLE)
    private Boolean isFlexible;

    public SendInvoice() {
        super("sendInvoice");
    }

    public String getTitle() {
        return title;
    }

    public SendInvoice setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SendInvoice setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getPayload() {
        return payload;
    }

    public SendInvoice setPayload(String payload) {
        this.payload = payload;
        return this;
    }

    public String getProviderToken() {
        return providerToken;
    }

    public SendInvoice setProviderToken(String providerToken) {
        this.providerToken = providerToken;
        return this;
    }

    public String getStartParameter() {
        return startParameter;
    }

    public SendInvoice setStartParameter(String startParameter) {
        this.startParameter = startParameter;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public SendInvoice setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public List<LabeledPrice> getPrices() {
        return prices;
    }

    public SendInvoice setPrices(List<LabeledPrice> prices) {
        this.prices = prices;
        return this;
    }

    public String getProviderData() {
        return providerData;
    }

    public SendInvoice setProviderData(String providerData) {
        this.providerData = providerData;
        return this;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public SendInvoice setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
        return this;
    }

    public Integer getPhotoSize() {
        return photoSize;
    }

    public SendInvoice setPhotoSize(Integer photoSize) {
        this.photoSize = photoSize;
        return this;
    }

    public Integer getPhotoWidth() {
        return photoWidth;
    }

    public SendInvoice setPhotoWidth(Integer photoWidth) {
        this.photoWidth = photoWidth;
        return this;
    }

    public Integer getPhotoHeight() {
        return photoHeight;
    }

    public SendInvoice setPhotoHeight(Integer photoHeight) {
        this.photoHeight = photoHeight;
        return this;
    }

    public Boolean getNeedName() {
        return needName;
    }

    public SendInvoice setNeedName(Boolean needName) {
        this.needName = needName;
        return this;
    }

    public Boolean getNeedPhoneNumber() {
        return needPhoneNumber;
    }

    public SendInvoice setNeedPhoneNumber(Boolean needPhoneNumber) {
        this.needPhoneNumber = needPhoneNumber;
        return this;
    }

    public Boolean getNeedEmail() {
        return needEmail;
    }

    public SendInvoice setNeedEmail(Boolean needEmail) {
        this.needEmail = needEmail;
        return this;
    }

    public Boolean getNeedShippingAddress() {
        return needShippingAddress;
    }

    public SendInvoice setNeedShippingAddress(Boolean needShippingAddress) {
        this.needShippingAddress = needShippingAddress;
        return this;
    }

    public Boolean getSendPhoneNumberToProvider() {
        return sendPhoneNumberToProvider;
    }

    public SendInvoice setSendPhoneNumberToProvider(Boolean sendPhoneNumberToProvider) {
        this.sendPhoneNumberToProvider = sendPhoneNumberToProvider;
        return this;
    }

    public Boolean getSendEmailToProvider() {
        return sendEmailToProvider;
    }

    public SendInvoice setSendEmailToProvider(Boolean sendEmailToProvider) {
        this.sendEmailToProvider = sendEmailToProvider;
        return this;
    }

    public Boolean getIsFlexible() {
        return isFlexible;
    }

    public SendInvoice setIsFlexible(Boolean isFlexible) {
        this.isFlexible = isFlexible;
        return this;
    }
}
