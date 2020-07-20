package com.example.app.api.ui.models;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SendVerificationRequestModel {

	@NotNull(message="First name cannot be null")
	@Size(min=2, message= "First name must not be less than two characters")
	private String firstName;
	
	@NotNull(message="Last name cannot be null")
	@Size(min=2, message= "Last name must not be less than two characters")
	private String lastName;

	@NotNull(message="Email cannot be null")
	@Email
	private String email;
	
	@NotNull(message="Birth day cannot be null")
	private LocalDate birthDay;
	
	@NotNull(message="Living city cannot be null")
	@Size(min=2, message= "Living city must not be less than two characters")
	private String cityLiving;
	
	@NotNull(message="Registration city cannot be null")
	@Size(min=2, message= "Registration city must not be less than two characters")
	private String cityRegistration;
	
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
}
