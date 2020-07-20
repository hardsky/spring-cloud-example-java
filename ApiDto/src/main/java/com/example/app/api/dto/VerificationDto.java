package com.example.app.api.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class VerificationDto implements Serializable {

	private static final long serialVersionUID = -9017362197838415436L;

	private String firstName;
	private String lastName;
	private String email;
	private LocalDate birthDay;
	private String cityLiving;
	private String cityRegistration;
	private String verificationId;
	private VerificationStatus status;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}
	public String getCityLiving() {
		return cityLiving;
	}
	public void setCityLiving(String cityLiving) {
		this.cityLiving = cityLiving;
	}
	public String getCityRegistration() {
		return cityRegistration;
	}
	public void setCityRegistration(String cityRegistration) {
		this.cityRegistration = cityRegistration;
	}
	public String getVerificationId() {
		return verificationId;
	}
	public void setVerificationId(String verificationId) {
		this.verificationId = verificationId;
	}
	public VerificationStatus getStatus() {
		return status;
	}
	public void setStatus(VerificationStatus status) {
		this.status = status;
	}
}
