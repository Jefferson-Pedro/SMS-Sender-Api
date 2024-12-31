package dev.jeff.sms_sender.service;

import dev.jeff.sms_sender.dto.SmsRequest;
import dev.jeff.sms_sender.model.Sms;

import java.util.List;

public interface ISmsSenderService {

    public void sendSms(SmsRequest smsRequest);
    public Sms save(SmsRequest smsRequest);
    public List<Sms> findAll();
    public boolean delete (Integer id);
}
