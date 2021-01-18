package com.p_015.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class MedicalConsultationDetails {

	@Size(min = 3, max = 20)
	private String doctorName;

	@Id
	@GeneratedValue
	private int doctorRegId;

	@Size(min = 3, max = 40)
	@NotNull
	private String doctorDegree;

	@NotNull
	private String consultationName;

	@NotNull
	private String consultantPhNo;

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public int getDoctorRegId() {
		return doctorRegId;
	}

	public void setDoctorRegId(int doctorRegId) {
		this.doctorRegId = doctorRegId;
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

	public MedicalConsultationDetails(@Size(min = 3, max = 20) String doctorName,
			@Size(min = 3, max = 40) @NotNull String doctorDegree, @NotNull String consultationName,
			@NotNull String consultantPhNo) {
		super();
		this.doctorName = doctorName;
		this.doctorDegree = doctorDegree;
		this.consultationName = consultationName;
		this.consultantPhNo = consultantPhNo;
	}

	public MedicalConsultationDetails(String doctorName, int doctorRegId, String doctorDegree, String consultationName,
			String consultantPhNo) {
		super();
		this.doctorName = doctorName;
		this.doctorRegId = doctorRegId;
		this.doctorDegree = doctorDegree;
		this.consultationName = consultationName;
		this.consultantPhNo = consultantPhNo;
	}

	public MedicalConsultationDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

}
