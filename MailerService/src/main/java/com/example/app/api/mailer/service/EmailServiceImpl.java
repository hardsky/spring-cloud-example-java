package com.example.app.api.mailer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

	@Override
	public void sendEmail(String to, String subject, String text) {
		// TODO Auto-generated method stub
		
	}

//	@Autowired
//	private JavaMailSender emailSender;
//	
//	@Override
//	public void sendEmail(String to, String subject, String text) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom("noreply@test.test");
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(text);
//
//        emailSender.send(message);
//	}

}
