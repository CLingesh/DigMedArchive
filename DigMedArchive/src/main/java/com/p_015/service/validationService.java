package com.p_015.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.p_015.controller.DAOController;
import com.p_015.model.LoginBean;
import com.p_015.model.PatientDetails;

@Service
public class validationService {

	@Autowired
	DAOController daoController;

	@Autowired
	List<PatientDetails> patientList = new ArrayList<>();

	public boolean validateLoginCredential(LoginBean loginBean) {
		patientList = daoController.getPatientList();
		for (PatientDetails list : patientList) {

			if (loginBean.getUserName().equalsIgnoreCase(list.getPatientName())
					&& loginBean.getPassword().equals(list.getPatientPhNo()))
				return true;
		}
		return false;
	}

}
