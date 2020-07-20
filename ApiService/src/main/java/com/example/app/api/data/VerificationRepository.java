package com.example.app.api.data;

import org.springframework.data.repository.CrudRepository;

public interface VerificationRepository extends CrudRepository<VerificationEntity, Long> {
	VerificationEntity findByVerificationId(String verificationId);
}
