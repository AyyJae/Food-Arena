package com.foodapp.foodapp.sms;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("origins = http://localhost:4200")
@RestController
@RequestMapping("api/v1/sms")
public class Controller {
	@Autowired
	 private  Service service;




	@RequestMapping("/s")
	    public SmsRequest sendSms() {
		SmsRequest smsrequest=new SmsRequest();
		smsrequest.setPhoneNumber("+918604056980");
		smsrequest.setMessage("Dear Customer, Your Order Placed Successfully");
		System.out.println("Welcome");
	       service.sendSms(smsrequest);
		return smsrequest;
	}
}