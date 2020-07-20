package com.example.app.api.ui.controllers;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.api.service.VerificationService;
import com.example.app.api.dto.VerificationDto;
import com.example.app.api.ui.models.SendVerificationRequestModel;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	private Environment env;
	@Autowired
	private VerificationService verificationService;
	
	@GetMapping("/status/check")
	public String status()
	{
		return "Working on port " + env.getProperty("local.server.port");
	}
	
	@PostMapping("/send-verification")
	public ResponseEntity<String> sendVerification(@Valid @RequestBody SendVerificationRequestModel verificationDetails) {
		ModelMapper modelMapper = new ModelMapper(); 
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		VerificationDto verDto = modelMapper.map(verificationDetails, VerificationDto.class);
		VerificationDto createdVerification = verificationService.createVerification(verDto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(createdVerification.getVerificationId());
	}
	
	@GetMapping("/check-verification-status/{id}")
	public String checkVerificationStatus(@PathVariable("id") String id) {
		return "APPROVED";
	}
}
