package com.foodapp.foodapp.sms;

public interface SmsSender {
	void sendSms(SmsRequest smsRequest);

    // or maybe void sendSms(String phoneNumber, String message);
}