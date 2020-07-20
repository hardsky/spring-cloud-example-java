package com.example.app.api.approver.ui.controllers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.api.approver.messaging.MessageService;
import com.example.app.api.approver.ui.models.ApproverRequestModel;
import com.example.app.api.dto.VerificationDto;
import com.example.app.api.dto.VerificationStatus;

@RestController
@RequestMapping("/verifications")
public class ApproverController {

	@Autowired
	private MessageService msgService;
	
	@PostMapping
	public ResponseEntity<Void> createVerification(@RequestBody ApproverRequestModel userDetails)
	{
		ModelMapper modelMapper = new ModelMapper(); 
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		VerificationDto msg = modelMapper.map(userDetails, VerificationDto.class);
		msg.setStatus(VerificationStatus.APPROVED);
		
		msgService.broadcastMessage(msg);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
}
