package com.p_015.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class TreatmentDetails {
	@Id
	@GeneratedValue
	private int treatmentId;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private String dateOfTreatment;

	@NotNull
	private int patientRegId;

	@NotNull
	private int doctorRegId;

	@NotNull
	private int ailmentId;

	@NotNull
	private String treatmentDuration;

	@NotNull
	@Size(min = 5, max = 80)
	private String treatmentResult;

	public int getTreatmentId() {
		return treatmentId;
	}

	public void setTreatmentId(int treatmentId) {
		this.treatmentId = treatmentId;
	}

	public String getDateOfTreatment() {
		return dateOfTreatment;
	}

	public void setDateOfTreatment(String dateOfTreatment) {
		this.dateOfTreatment = dateOfTreatment;
	}

	public int getPatientRegId() {
		return patientRegId;
	}

	public void setPatientRegId(int patientRegId) {
		this.patientRegId = patientRegId;
	}

	public int getDoctorRegId() {
		return doctorRegId;
	}

	public void setDoctorRegId(int doctorRegId) {
		this.doctorRegId = doctorRegId;
	}

	public int getAilmentId() {
		return ailmentId;
	}

	public void setAilmentId(int ailmentId) {
		this.ailmentId = ailmentId;
	}

	public String getTreatmentDuration() {
		return treatmentDuration;
	}

	public void setTreatmentDuration(String treatmentDuration) {
		this.treatmentDuration = treatmentDuration;
	}

	public String getTreatmentResult() {
		return treatmentResult;
	}

	public void setTreatmentResult(String treatmentResult) {
		this.treatmentResult = treatmentResult;
	}

	public TreatmentDetails(@NotNull String dateOfTreatment, @NotNull int patientRegId, @NotNull int doctorRegId,
			@NotNull int ailmentId, @NotNull String treatmentDuration,
			@NotNull @Size(min = 5, max = 80) String treatmentResult) {
		super();
		this.dateOfTreatment = dateOfTreatment;
		this.patientRegId = patientRegId;
		this.doctorRegId = doctorRegId;
		this.ailmentId = ailmentId;
		this.treatmentDuration = treatmentDuration;
		this.treatmentResult = treatmentResult;
	}

	public TreatmentDetails(int treatmentId, @NotNull String dateOfTreatment, @NotNull int patientRegId,
			@NotNull int doctorRegId, @NotNull int ailmentId, @NotNull String treatmentDuration,
			@NotNull @Size(min = 5, max = 80) String treatmentResult) {
		super();
		this.treatmentId = treatmentId;
		this.dateOfTreatment = dateOfTreatment;
		this.patientRegId = patientRegId;
		this.doctorRegId = doctorRegId;
		this.ailmentId = ailmentId;
		this.treatmentDuration = treatmentDuration;
		this.treatmentResult = treatmentResult;
	}

	public TreatmentDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

}
