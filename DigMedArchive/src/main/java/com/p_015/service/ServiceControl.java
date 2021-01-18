package com.p_015.service;

import com.p_015.model.ListOfAilments;
import com.p_015.model.LoginBean;
import com.p_015.model.MedicalConsultationDetails;
import com.p_015.model.PatientDetails;
import com.p_015.model.TreatmentHistory;

public interface ServiceControl {

	int checkRegisteredPhoneNo(PatientDetails patientDetails);

	PatientDetails retrivePatientDetailUsingLogin(LoginBean loginBean);

	PatientDetails retrivePatientDetailUsingId(int id);

	int retriveMedicalConsultationDetails(MedicalConsultationDetails medicalConsultationDetails);

	int retriveListOfAilments(ListOfAilments listOfAilments);

	Boolean addNewTreatmentHistory(TreatmentHistory treatment, PatientDetails patientDetails);

}
