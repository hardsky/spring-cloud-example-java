package com.example.app.api.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.app.api.dto.VerificationDto;

import feign.FeignException;
import feign.hystrix.FallbackFactory;

@FeignClient(name = "approver-ws", fallbackFactory = ApproverFallbackFactory.class)
public interface ApproverServiceClient {

	@PostMapping("/verifications")
	public void createVerification(@RequestBody VerificationDto verification);
}

@Component
class ApproverFallbackFactory implements FallbackFactory<ApproverServiceClient> {

	@Override
	public ApproverServiceClient create(Throwable cause) {
		return new ApproverServiceClientFallback(cause);
	}

}

class ApproverServiceClientFallback implements ApproverServiceClient {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	private final Throwable cause;

	public ApproverServiceClientFallback(Throwable cause) {
		this.cause = cause;
	}

	@Override
	public void createVerification(VerificationDto verification) {
		if (cause instanceof FeignException && ((FeignException) cause).status() == 404) {
			logger.error("404 error took place when createVerification was called with verificationId: "
					+ verification.getVerificationId() + ". Error message: " + cause.getLocalizedMessage());
		} else {
			logger.error("Other error took place: " + cause.getLocalizedMessage());
		}
	}

}
