package dev.jeff.sms_sender.service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import dev.jeff.sms_sender.config.TwilioConfg;
import dev.jeff.sms_sender.dto.SmsRequest;
import org.springframework.stereotype.Service;

@Service
public class SmsSenderImpl implements ISmsSender{

    public final TwilioConfg twilioConfg;

    public SmsSenderImpl(TwilioConfg twilioConfg) {
        this.twilioConfg = twilioConfg;
    }

    @Override
    public void sendSms(SmsRequest smsRequest) {

        String from = "De: " + smsRequest.sender() + "\n";

        Message message = Message
                .creator(
                        new PhoneNumber("+55" + smsRequest.ddd() + smsRequest.phoneNumber()),
                        new PhoneNumber(twilioConfg.getTrialNumber()),
                        from + smsRequest.message()
                )
                .create();
    }
}
