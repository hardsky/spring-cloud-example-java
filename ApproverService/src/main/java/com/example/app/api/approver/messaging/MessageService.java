package com.example.app.api.approver.messaging;

import com.example.app.api.dto.VerificationDto;

public interface MessageService {
	
	public void broadcastMessage(VerificationDto msg);
}
