package com.example.app.api.approver.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.example.app.api.dto.VerificationDto;

@Service
public class MessageServiceImpl implements MessageService {

	private RabbitTemplate rabbitTemplate;
	private Environment env;
	
	@Autowired
	public MessageServiceImpl(RabbitTemplate rabbitTemplate, Environment env) {
		this.rabbitTemplate = rabbitTemplate;
		this.env = env;
	}
	
	@Override
	public void broadcastMessage(VerificationDto msg) {
		rabbitTemplate.convertAndSend(env.getProperty("api.messaging.topic-exchange-name"),
				env.getProperty("api.messaging.routing.key"), msg);
	}

}
