package com.p_015.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.p_015.model.LoginBean;
import com.p_015.model.PatientDetails;
import com.p_015.model.TreatmentHistory;
import com.p_015.service.ServiceControl;
import com.p_015.service.validationService;

@Controller
@SessionAttributes("session")
public class HomeController {

	@Autowired
	HttpSession session;

	@Autowired
	private DAOController daoController;

	@Autowired
	List<PatientDetails> patientList = new ArrayList<>();

	@Autowired
	PatientDetails patientDetails;

	@Autowired
	private validationService validation;

	@Autowired
	private ServiceControl service;

//----------------------------Start of Home Page------------------------------------
	@RequestMapping("/")
	public String showWelcomePage() {
		return "home";
	}
//----------------------------End of Home Page------------------------------------

//----------------------------Start of Login Page------------------------------------	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model, @ModelAttribute("login") LoginBean loginBean) {
// Getting Login Request with Login bean
		return "login";
	}

// Getting Main Page with validation
	@RequestMapping(value = "/submitlogin", method = RequestMethod.POST)
	public String checkLoginDetailsCustomer(ModelMap model, @ModelAttribute("login") LoginBean loginBean,
			BindingResult result) throws SQLException {
//		validating Login user
		boolean validate = validation.validateLoginCredential(loginBean);
		if (validate) {
			patientDetails = service.retrivePatientDetailUsingLogin(loginBean);
			session.setAttribute("session", patientDetails.getPatientName());
			model.addAttribute("patient", patientDetails);

			if (patientDetails.getPatientRegId() <= 4) {
				model.addAttribute("list", daoController.retrivetreatmentHistory(patientDetails));
				return "main";
			} else {
				return "support";
			}
		} else {
			model.addAttribute("error", 1);
			return "login";
		}

	}
//----------------------------End of Login Page------------------------------------

//----------------------------Start of Signup Page------------------------------------
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String showResitrationPage(ModelMap model, @ModelAttribute("signup") PatientDetails patientDetails) {

		model.addAttribute("signup", patientDetails);
		return "signup";

	}

	@RequestMapping(value = "/submitsignup", method = RequestMethod.POST)
	public String registerPatientDetails(@ModelAttribute("signup") @Validated PatientDetails patientDetails,
			BindingResult result, ModelMap model) throws SQLException {

		if (result.hasErrors()) {
//			model.addAttribute("error", 1);
			return "/signup";
		} else {
//			System.out.println(patientDetails.getPatientName());
			int temp = service.checkRegisteredPhoneNo(patientDetails);
			String warning, success;
			if (temp == 0) {
				warning = patientDetails.getPatientPhNo()
						+ " Already Registered in Database, SignUp Using Different Number";
				model.put("warning", warning);
			} else if (temp == 2) {
				warning = "Patient Details Already Registered in Database";
				model.put("warning", warning);
			} else {
				daoController.addPatientDetails(patientDetails);
				success = "Patient Details added Successfully...";
				model.put("success", success);
			}

			return "/home";
		}

	}

//----------------------------End of Signup Page------------------------------------

//----------------------------Treatment Details Manipulation------------------------------------

	@RequestMapping(value = "/addTreatment", method = RequestMethod.GET)
	public String enterTreatmentDetails(@RequestParam("id") int id,
			@ModelAttribute("treatment") TreatmentHistory treatment, ModelMap model) {
		session.setAttribute("session", patientDetails.getPatientName());
		model.addAttribute("patient", service.retrivePatientDetailUsingId(id));
		model.addAttribute("treatment", treatment);
		return "treatment";
	}

	@RequestMapping(value = "/back", method = RequestMethod.GET)
	public String getBackToMainPage(@RequestParam("id") int id, ModelMap model) {
		patientDetails = service.retrivePatientDetailUsingId(id);
		session.setAttribute("session", patientDetails.getPatientName());
		model.addAttribute("patient", patientDetails);
		model.addAttribute("list", daoController.retrivetreatmentHistory(patientDetails));
		return "main";
	}

	@RequestMapping(value = "/submittreatment", method = RequestMethod.POST)
	public String addTreatmentDetails(@RequestParam("id") int id,
			@ModelAttribute("treatment") @Validated TreatmentHistory treatment, BindingResult result, ModelMap model) {
		session.setAttribute("session", patientDetails.getPatientName());
		model.addAttribute("patient", service.retrivePatientDetailUsingId(id));
		if (result.hasErrors()) {
			model.addAttribute("error", 1);
			return "treatment";
		} else {
			patientDetails = service.retrivePatientDetailUsingId(id);
//			System.out.println(patientDetails.getPatientName());
//			System.out.println(treatment.getConsultantPhNo());
			Boolean success = service.addNewTreatmentHistory(treatment, patientDetails);
			if (success == true) {
				model.addAttribute("message", "Latest Treatment Details Updated Successfully...");
			}
			if (success == false) {
				model.addAttribute("warnmessage", "Treatment Details Already Updated !");
			}
			model.addAttribute("list", daoController.retrivetreatmentHistory(patientDetails));
			return "main";
		}
	}

//----------------------------End Treatment Details Manipulation------------------------------------

//----------------------------Logout------------------------------------

	@RequestMapping("/logout")
	public String LogOut() {
		session.invalidate();
		return "home";
	}
}