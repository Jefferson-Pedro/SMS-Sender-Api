package dev.jeff.sms_sender.service;

import dev.jeff.sms_sender.dto.SmsRequest;

public interface ISmsSender {

    public void sendSms(SmsRequest smsRequest);
}
