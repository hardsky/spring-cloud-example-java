package com.example.app.api.mailer.service;

public interface EmailService {
	void sendEmail(String to, String subject, String text);
}
