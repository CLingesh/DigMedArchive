package com.p_015.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.p_015.controller.DAOController;
import com.p_015.model.ListOfAilments;
import com.p_015.model.LoginBean;
import com.p_015.model.MedicalConsultationDetails;
import com.p_015.model.PatientDetails;
import com.p_015.model.TreatmentDetails;
import com.p_015.model.TreatmentHistory;

@Service
public class ServiceControlImp implements ServiceControl {
	@Autowired
	DAOController daoController;

	@Autowired
	List<PatientDetails> patientList = new ArrayList<>();

	@Autowired
	PatientDetails patientDetails;

	@Autowired
	List<TreatmentDetails> treatmentList = new ArrayList<>();

	@Autowired
	TreatmentDetails treatmentDetails;

	@Autowired
	List<ListOfAilments> ailmentList = new ArrayList<>();

	@Autowired
	ListOfAilments listOfAilments;

	@Autowired
	List<MedicalConsultationDetails> doctorList = new ArrayList<>();

	@Autowired
	MedicalConsultationDetails medicalConsultationDetails;

	@Override
	public int checkRegisteredPhoneNo(PatientDetails patientDetails2) {
		patientList = daoController.getPatientList();
		for (PatientDetails p : patientList) {
			if (p.getPatientPhNo().equals(patientDetails2.getPatientPhNo())) {
				if (p.getPatientName().equalsIgnoreCase(patientDetails2.getPatientName())
						&& p.getPatientDob().equals(patientDetails2.getPatientDob())
						&& p.getPatientGender().equalsIgnoreCase(patientDetails2.getPatientGender())
						&& p.getPatientBlGroup().equalsIgnoreCase(patientDetails2.getPatientBlGroup()))
					return 2;
				else
					return 0;
			}
		}
		return 1;
	}

	@Override
	public PatientDetails retrivePatientDetailUsingLogin(LoginBean loginBean) {
		patientList = daoController.getPatientList();
		for (PatientDetails p : patientList) {
			if (loginBean.getUserName().equalsIgnoreCase(p.getPatientName())
					&& loginBean.getPassword().equals(p.getPatientPhNo()))
				return p;
		}
		return null;
	}

	@Override
	public PatientDetails retrivePatientDetailUsingId(int id) {
		patientList = daoController.getPatientList();
		for (PatientDetails p : patientList) {
			if (p.getPatientRegId() == id)
				return p;
		}
		return null;
	}

	@Override
	public int retriveMedicalConsultationDetails(MedicalConsultationDetails medicalConsultationDetails2) {
		doctorList = daoController.getDoctorList();
		for (MedicalConsultationDetails d : doctorList) {
			if (d.getDoctorName().equalsIgnoreCase(medicalConsultationDetails2.getDoctorName())
					&& d.getDoctorDegree().equalsIgnoreCase(medicalConsultationDetails2.getDoctorDegree())
					&& d.getConsultationName().equalsIgnoreCase(medicalConsultationDetails2.getConsultationName())
					&& d.getConsultantPhNo().equals(medicalConsultationDetails2.getConsultantPhNo()))
				return d.getDoctorRegId();
		}
		daoController.addMedicalConsultationDetails(medicalConsultationDetails2);
		return doctorList.size() + 1;
	}

	@Override
	public int retriveListOfAilments(ListOfAilments listOfAilments2) {
		ailmentList = daoController.getAilmentList();
		for (ListOfAilments a : ailmentList) {
			if (a.getAilmentReason().equalsIgnoreCase(listOfAilments2.getAilmentReason())
					&& a.getAilmentName().equalsIgnoreCase(listOfAilments2.getAilmentName())
					&& a.getDescription().equalsIgnoreCase(listOfAilments2.getDescription())) {
				return a.getAilmentId();
			}
		}
		daoController.addListOfAilments(listOfAilments2);
		return ailmentList.size() + 1;

	}

	@Override
	public Boolean addNewTreatmentHistory(TreatmentHistory treatment, PatientDetails patientDetails2) {

		listOfAilments.setAilmentReason(treatment.getAilmentReason());
		listOfAilments.setAilmentName(treatment.getAilmentName());
		listOfAilments.setDescription(treatment.getAilmentDescription());
		int ailmentId = retriveListOfAilments(listOfAilments);
		listOfAilments.setAilmentId(ailmentId);
		medicalConsultationDetails.setDoctorName(treatment.getDoctorName());
		medicalConsultationDetails.setDoctorDegree(treatment.getDoctorDegree());
		medicalConsultationDetails.setConsultationName(treatment.getConsultationName());
		medicalConsultationDetails.setConsultantPhNo(treatment.getConsultantPhNo());
		int doctorRegId = retriveMedicalConsultationDetails(medicalConsultationDetails);
		medicalConsultationDetails.setDoctorRegId(doctorRegId);
		treatmentDetails.setDateOfTreatment(treatment.getTreatmentDate());
		treatmentDetails.setTreatmentDuration(treatment.getTreatmentDuration());
		treatmentDetails.setTreatmentResult(treatment.getTreatmentResult());
		int patientRegId = patientDetails2.getPatientRegId();
		treatmentDetails.setPatientRegId(patientRegId);
		treatmentDetails.setDoctorRegId(doctorRegId);
		treatmentDetails.setAilmentId(ailmentId);
		treatmentList.removeAll(treatmentList);
		treatmentList = daoController.getTreatmentList();
		int temp = 0;
		for (TreatmentDetails t : treatmentList) {
			if ((t.getDateOfTreatment().equals(treatmentDetails.getDateOfTreatment()))
					&& (t.getPatientRegId() == patientRegId) && (t.getDoctorRegId() == doctorRegId)
					&& (t.getAilmentId() == ailmentId)
					&& (t.getTreatmentDuration().equalsIgnoreCase(treatmentDetails.getTreatmentDuration()))
					&& (t.getTreatmentResult().equalsIgnoreCase(treatmentDetails.getTreatmentResult()))) {

				temp = 1;
//				System.out.println("getting from treatmentDetails object if  equal " + temp);
			}
		}
//		System.out.println(temp);
		if (temp == 1) {
			return false;
		} else {
//				 System.out.println("getting from treatmentDetails2 object"
//					+ treatmentDetails.getMedicalConsultationDetails().getDoctorName());
			daoController.addTreatmentDetails(treatmentDetails);
//			System.out.println("treatment added successfully");
			return true;
		}
	}

}
