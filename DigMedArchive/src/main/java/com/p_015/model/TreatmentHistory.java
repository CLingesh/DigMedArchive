package com.p_015.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class TreatmentHistory {

	@Id
	@GeneratedValue
	private int treatmentId;

	@NotBlank(message = "*")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String treatmentDate;

	@NotBlank(message = "")
	@Size(min = 3, max = 20, message = "* Name must have min 3 characters")
	private String doctorName;

	@NotBlank(message = "")
	@Size(min = 3, max = 40, message = "* Eg: MBBS, Dentist, Dermatologist")
	private String doctorDegree;

	@NotBlank(message = "*")
	private String consultationName;

	@NotBlank(message = "")
	@Length(min = 10, max = 10, message = "* Please Enter Valid Mobile No, start between 7-9")
	private String consultantPhNo;

	@NotBlank(message = "")
	@Size(min = 10, max = 100, message = "* Ailment Reason must have characters within '10'-'100'")
	private String ailmentReason;

	@NotBlank(message = "")
	@Size(min = 8, max = 50, message = "* Ailment Name must have characters within '8'-'50'")
	private String ailmentName;

	@NotBlank(message = "")
	@Size(min = 10, max = 50, message = " * Ailment Description must have characters within '10'-'50'")
	private String ailmentDescription;

	@NotBlank(message = "")
	@Size(min = 2, max = 80, message = "* Eg: 15D for 15 days; 3W for 3 weeks; 1M for 1 month;")
	private String treatmentDuration;

	@NotBlank(message = "")
	@Size(min = 5, max = 80, message = "* Treatment Result must have characters within '5'-'80'")
	private String treatmentResult;

	public int getTreatmentId() {
		return treatmentId;
	}

	public void setTreatmentId(int treatmentId) {
		this.treatmentId = treatmentId;
	}

	public String getTreatmentDate() {
		return treatmentDate;
	}

	public void setTreatmentDate(String treatmentDate) {
		this.treatmentDate = treatmentDate;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorDegree() {
		return doctorDegree;
	}

	public void setDoctorDegree(String doctorDegree) {
		this.doctorDegree = doctorDegree;
	}

	public String getConsultationName() {
		return consultationName;
	}

	public void setConsultationName(String consultationName) {
		this.consultationName = consultationName;
	}

	public String getConsultantPhNo() {
		return consultantPhNo;
	}

	public void setConsultantPhNo(String consultantPhNo) {
		this.consultantPhNo = consultantPhNo;
	}

	public String getAilmentReason() {
		return ailmentReason;
	}

	public void setAilmentReason(String ailmentReason) {
		this.ailmentReason = ailmentReason;
	}

	public String getAilmentName() {
		return ailmentName;
	}

	public void setAilmentName(String ailmentName) {
		this.ailmentName = ailmentName;
	}

	public String getAilmentDescription() {
		return ailmentDescription;
	}

	public void setAilmentDescription(String ailmentDescription) {
		this.ailmentDescription = ailmentDescription;
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

	public TreatmentHistory(int treatmentId, String treatmentDate, String doctorName, String doctorDegree,
			String consultationName, String consultantPhNo, String ailmentReason, String ailmentName,
			String ailmentDescription, String treatmentDuration, String treatmentResult) {
		super();
		this.treatmentId = treatmentId;
		this.treatmentDate = treatmentDate;
		this.doctorName = doctorName;
		this.doctorDegree = doctorDegree;
		this.consultationName = consultationName;
		this.consultantPhNo = consultantPhNo;
		this.ailmentReason = ailmentReason;
		this.ailmentName = ailmentName;
		this.ailmentDescription = ailmentDescription;
		this.treatmentDuration = treatmentDuration;
		this.treatmentResult = treatmentResult;
	}

	public TreatmentHistory(@NotNull(message = "*") String treatmentDate,
			@Size(min = 3, max = 20, message = "Name must have min 3 characters") @NotBlank(message = "*") String doctorName,
			@Size(min = 3, max = 40, message = "Eg: MBBS, Dentist, Dermatologist") @NotBlank(message = "*") String doctorDegree,
			@NotBlank(message = "*") String consultationName,
			@Length(min = 10, max = 10, message = "Please Enter Valid Mobile No, start between 7-9") @NotBlank(message = "*") String consultantPhNo,
			@Size(min = 10, max = 100, message = "Ailment Reason must have characters within '10'-'100'") @NotBlank(message = "*") String ailmentReason,
			@NotBlank(message = "*") @Size(min = 8, max = 50, message = "Ailment Name must have characters within '8'-'50'") String ailmentName,
			@Size(min = 10, max = 50, message = "Ailment Description must have characters within '10'-'50'") @NotBlank(message = "*") String ailmentDescription,
			@NotBlank(message = "*") @Size(min = 2, max = 80, message = "Eg: 15D for 15 days; 3W for 3 weeks; 1M for 1 month;") String treatmentDuration,
			@NotBlank(message = "*") @Size(min = 5, max = 80, message = "Treatment Result must have characters within '5'-'80'") String treatmentResult) {
		super();
		this.treatmentDate = treatmentDate;
		this.doctorName = doctorName;
		this.doctorDegree = doctorDegree;
		this.consultationName = consultationName;
		this.consultantPhNo = consultantPhNo;
		this.ailmentReason = ailmentReason;
		this.ailmentName = ailmentName;
		this.ailmentDescription = ailmentDescription;
		this.treatmentDuration = treatmentDuration;
		this.treatmentResult = treatmentResult;
	}

	public TreatmentHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

}
