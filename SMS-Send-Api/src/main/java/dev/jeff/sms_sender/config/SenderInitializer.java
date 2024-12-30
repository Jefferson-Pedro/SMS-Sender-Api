package dev.jeff.sms_sender.config;

import com.twilio.Twilio;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@Configuration
public class SenderInitializer {

    public static Logger logger = Logger.getLogger(SenderInitializer.class.getName());

    public SenderInitializer(TwilioConfg senderConfg){
        Twilio.init(senderConfg.getAccountSid(), senderConfg.getAuthToken());

        logger.info("Twilio inicializado com sucesso! " +
                "Account Sid: " + senderConfg.getAccountSid() +
                "Auth Token: " + senderConfg.getAuthToken() +
                "Trial Number" + senderConfg.getTrialNumber()
        );
    }
}
