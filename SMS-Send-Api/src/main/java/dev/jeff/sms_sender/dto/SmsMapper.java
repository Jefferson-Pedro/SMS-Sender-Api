package dev.jeff.sms_sender.dto;

import dev.jeff.sms_sender.model.Sms;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SmsMapper {

    public Sms toEntity (SmsRequest request){
        return new Sms (
                null,
                request.sender(),
                request.ddd(),
                request.phoneNumber(),
                request.message(),
                LocalDateTime.now()
        );
    }
}
