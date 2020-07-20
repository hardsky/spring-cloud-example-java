package com.example.app.api.data;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.app.api.dto.VerificationStatus;

@Entity
@Table(name="verifications")
public class VerificationEntity implements Serializable {

	private static final long serialVersionUID = 7197111630123472067L;

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable=false, length=150)
	private String firstName;
	
	@Column(nullable=false, length=150)
	private String lastName;
	
	@Column(nullable=false, length=150, unique=true)
	private String email;
	
	@Column(nullable=false)
	private LocalDate birthDay;
	
	@Column(nullable=false, length=150)
	private String cityLiving;
	
	@Column(nullable=false, length=150)
	private String cityRegistration;
	
	@Column(nullable=false, unique=true)
	private String verificationId;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false, length=10)
	private VerificationStatus status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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
