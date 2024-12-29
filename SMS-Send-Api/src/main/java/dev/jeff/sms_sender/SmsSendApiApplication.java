package dev.jeff.sms_sender;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmsSendApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmsSendApiApplication.class, args);
	}
}
