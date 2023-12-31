package com.MessagingSerive.service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class TwilioService {

    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    public void sendSms(String toPhoneNumber, String message) {
        Twilio.init(accountSid, authToken);

        Message.creator(new PhoneNumber(toPhoneNumber), new PhoneNumber("+15419452447"), message)
                .create();
    }
}
