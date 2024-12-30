package dev.jeff.sms_sender.controller;

import dev.jeff.sms_sender.dto.SmsRequest;
import dev.jeff.sms_sender.service.ISmsSender;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmsSenderController {

    private final ISmsSender smsSender;

    public SmsSenderController(@Qualifier("twilio") ISmsSender smsSender) {
        this.smsSender = smsSender;
    }

    @PostMapping("/send-sms")
    public void sendSms(@RequestBody SmsRequest smsRequest){
        smsSender.sendSms(smsRequest);
    }
}
