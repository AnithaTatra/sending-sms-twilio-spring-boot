package com.dev.twiliomessages.service;

import com.dev.twiliomessages.model.SMS;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

@Component
public class SMSService {

    private final String ACCOUNT_SID = "Enter Your Twilio Account SID";

    private final String AUTH_TOKEN = "Enter Your Twilio Account Auth Token";

    private final String FROM_NUMBER = "Enter the Generated number from Twilio";

    public void send(SMS sms) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber(sms.getTo()), new PhoneNumber(FROM_NUMBER), sms.getMessage()).create();
        System.out.println("here is my id:" + message.getSid());

    }

    public void receive(MultiValueMap<String, String> smscallback) {
    }
}




