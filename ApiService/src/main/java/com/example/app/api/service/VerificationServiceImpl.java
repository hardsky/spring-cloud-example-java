package com.example.app.api.service;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.api.data.ApproverServiceClient;
import com.example.app.api.data.VerificationEntity;
import com.example.app.api.data.VerificationRepository;
import com.example.app.api.dto.VerificationDto;
import com.example.app.api.dto.VerificationStatus;

@Service
public class VerificationServiceImpl implements VerificationService {

	private VerificationRepository verificationsRepository;
	private ApproverServiceClient approverServiceClient;
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public VerificationServiceImpl(VerificationRepository verificationsRepository,
			ApproverServiceClient approverServiceClient) {
		this.verificationsRepository = verificationsRepository;
		this.approverServiceClient = approverServiceClient;
	}

	@Override
	public VerificationDto createVerification(VerificationDto verification) {
		String verificationId = UUID.randomUUID().toString();
		verification.setVerificationId(verificationId);
		verification.setStatus(VerificationStatus.CREATED);

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		VerificationEntity verificationEntity = modelMapper.map(verification, VerificationEntity.class);
		verificationsRepository.save(verificationEntity);
		
		logger.info("Before calling Approver microservice");
		approverServiceClient.createVerification(verification);
		logger.info("After calling Approver microservice");

		VerificationDto res = modelMapper.map(verificationEntity, VerificationDto.class);

		return res;
	}

}
