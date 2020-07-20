package com.example.app.api.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.app.api.data.VerificationEntity;
import com.example.app.api.data.VerificationRepository;
import com.example.app.api.dto.VerificationDto;

@Component
public class VerificationReceiver {
	
	private VerificationRepository verificationsRepository;
	
	@Autowired
	public VerificationReceiver(VerificationRepository verificationsRepository) {
		this.verificationsRepository = verificationsRepository;
	}
	
	public void receiveVerification(VerificationDto msg) {
		VerificationEntity entity = verificationsRepository.findByVerificationId(msg.getVerificationId());
		entity.setStatus(msg.getStatus());
		verificationsRepository.save(entity);
	}
}
