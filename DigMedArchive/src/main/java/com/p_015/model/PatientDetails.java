package com.p_015.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class PatientDetails {

	@Id
	@GeneratedValue
	private int patientRegId;

	@NotEmpty(message = "Name is madatory")
	@Size(min = 3, max = 30, message = "Name must have min 3 characters")
	private String patientName;

	@NotBlank(message = "Phone number is madatory")
	@Length(min = 10, max = 10, message = "Please Enter Valid Mobile No, start within 7-9")
	private String patientPhNo;

	@NotBlank(message = "Gender is madatory")
	private String patientGender;

	@NotBlank(message = "Blood Group is madatory")
	@Size(min = 2, max = 10, message = "Eg: A+ve or AB positive")
	private String patientBlGroup;

	@NotBlank(message = "DOB is madatory")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String patientDob;

	public int getPatientRegId() {
		return patientRegId;
	}

	public void setPatientRegId(int patientRegId) {
		this.patientRegId = patientRegId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientPhNo() {
		return patientPhNo;
	}

	public void setPatientPhNo(String patientPhNo) {
		this.patientPhNo = patientPhNo;
	}

	public String getPatientGender() {
		return patientGender;
	}

	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}

	public String getPatientBlGroup() {
		return patientBlGroup;
	}

	public void setPatientBlGroup(String patientBlGroup) {
		this.patientBlGroup = patientBlGroup;
	}

	public String getPatientDob() {
		return patientDob;
	}

	public void setPatientDob(String patientDob) {
		this.patientDob = patientDob;
	}

	public PatientDetails(
			@NotBlank(message = "*") @Size(min = 3, max = 30, message = "Name must have min 3 characters") String patientName,
			@Length(min = 10, max = 10, message = "Please Enter Valid Mobile No, start between 7-9") @NotBlank(message = "*") String patientPhNo,
			@NotBlank(message = "*") String patientGender,
			@NotBlank(message = "*") @Size(min = 2, max = 10, message = "Eg: A+ve or AB positive") String patientBlGroup,
			@NotBlank(message = "*") String patientDob) {
		super();
		this.patientName = patientName;
		this.patientPhNo = patientPhNo;
		this.patientGender = patientGender;
		this.patientBlGroup = patientBlGroup;
		this.patientDob = patientDob;
	}

	public PatientDetails(int patientRegId, String patientName, String patientPhNo, String patientGender,
			String patientBlGroup, String patientDob) {
		super();
		this.patientRegId = patientRegId;
		this.patientName = patientName;
		this.patientPhNo = patientPhNo;
		this.patientGender = patientGender;
		this.patientBlGroup = patientBlGroup;
		this.patientDob = patientDob;
	}

	public PatientDetails() {
		super();
	}

}
