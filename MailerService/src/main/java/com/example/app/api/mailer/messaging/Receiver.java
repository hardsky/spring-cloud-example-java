package com.example.app.api.mailer.messaging;

import org.springframework.stereotype.Component;

import com.example.app.api.dto.VerificationDto;

@Component
public class Receiver {
	public void receiveMessage(VerificationDto message) {
	    System.out.println("Received <" + message + ">");
	  }
}
