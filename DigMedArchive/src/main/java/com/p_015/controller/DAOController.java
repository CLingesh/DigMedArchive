package com.p_015.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.p_015.model.ListOfAilments;
import com.p_015.model.MedicalConsultationDetails;
import com.p_015.model.PatientDetails;
import com.p_015.model.TreatmentDetails;
import com.p_015.model.TreatmentHistory;
import com.p_015.service.ConnectionHandler;

@Component
public class DAOController {

	@Autowired
	ConnectionHandler connectionHandler = new ConnectionHandler();

	@Autowired
	List<PatientDetails> patientList = new ArrayList<>();

	@Autowired
	List<TreatmentHistory> treatmentHistoryList = new ArrayList<>();

	@Autowired
	List<ListOfAilments> ailmentList = new ArrayList<>();

	@Autowired
	List<MedicalConsultationDetails> medicalList = new ArrayList<>();

	@Autowired
	List<TreatmentDetails> treatmentlist = new ArrayList<>();

	public List<PatientDetails> getPatientList() {
		Connection connection;
		PreparedStatement statement;
		patientList.removeAll(patientList);
		try {
			connection = connectionHandler.getConnection();
			statement = connection.prepareStatement("select * from patientDetails");
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				patientList.add(new PatientDetails(result.getInt("p_RegId"), result.getString("p_Name"),
						result.getString("p_PhNo"), result.getString("p_Gender"), result.getString("p_BlGroup"),
						result.getString("p_Dob")));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return patientList;
	}

	public List<ListOfAilments> getAilmentList() {
		Connection connection;
		PreparedStatement statement;
		ailmentList.removeAll(ailmentList);
		try {
			connection = connectionHandler.getConnection();
			statement = connection.prepareStatement("select * from ListOfAilments");
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				ailmentList.add(new ListOfAilments(result.getInt("a_Id"), result.getString("a_Reason"),
						result.getString("a_Name"), result.getString("a_Description")));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ailmentList;
	}

	public List<MedicalConsultationDetails> getDoctorList() {
		Connection connection;
		PreparedStatement statement;
		medicalList.removeAll(medicalList);
		try {
			connection = connectionHandler.getConnection();
			statement = connection.prepareStatement("select * from MedicalConsultationDetails");
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				medicalList.add(new MedicalConsultationDetails(result.getString("d_Name"), result.getInt("d_RegId"),
						result.getString("d_Degree"), result.getString("d_consultationName"),
						result.getString("d_consultantPhNo")));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return medicalList;
	}

	public List<TreatmentDetails> getTreatmentList() {
		Connection connection;
		PreparedStatement statement;
		treatmentlist.removeAll(treatmentlist);
		try {
			connection = connectionHandler.getConnection();
			statement = connection.prepareStatement("select * from TreatmentDetails");
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				treatmentlist.add(new TreatmentDetails(result.getInt("t_Id"), result.getString("t_Date"),
						result.getInt("p_Id"), result.getInt("d_Id"), result.getInt("a_Id"),
						result.getString("t_Duration"), result.getString("t_Result")));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return treatmentlist;
	}

	public List<TreatmentHistory> retrivetreatmentHistory(PatientDetails retrivePatientDetail) {
		Connection connection;
		PreparedStatement statement;
		treatmentHistoryList.removeAll(treatmentHistoryList);
		try {
			connection = connectionHandler.getConnection();
			statement = connection.prepareStatement(
					"select t.t_Id,t.t_Date,d.d_Name,d.d_Degree,d.d_consultationName,d.d_consultantPhNo,a.a_Reason,a.a_Name,a.a_Description,t.t_Duration,t.t_Result from TreatmentDetails t\r\n"
							+ "join MedicalConsultationDetails d on t.d_Id = d.d_RegId\r\n"
							+ "join ListOfAilments a on t.a_Id = a.a_Id\r\n"
							+ "join PatientDetails p on t.p_Id = p.p_RegId\r\n"
							+ "where p.p_RegId=? order by t.t_Date");
			statement.setInt(1, retrivePatientDetail.getPatientRegId());
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				treatmentHistoryList.add(new TreatmentHistory(result.getInt("t.t_Id"), result.getString("t.t_Date"),
						result.getString("d.d_Name"), result.getString("d.d_Degree"),
						result.getString("d.d_consultationName"), result.getString("d.d_consultantPhNo"),
						result.getString("a.a_Reason"), result.getString("a.a_Name"),
						result.getString("a.a_Description"), result.getString("t.t_Duration"),
						result.getString("t.t_Result")));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return treatmentHistoryList;
	}

	public boolean addPatientDetails(PatientDetails patientDetails) {
		Connection connection;
		try {
			connection = connectionHandler.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"insert into PatientDetails (p_Name,p_PhNo,p_Gender,p_BlGroup,p_Dob) values(?,?,?,?,?)");
			statement.setString(1, patientDetails.getPatientName());
			statement.setString(2, patientDetails.getPatientPhNo());
			statement.setString(3, patientDetails.getPatientGender());
			statement.setString(4, patientDetails.getPatientBlGroup());
			statement.setString(5, patientDetails.getPatientDob());
			statement.execute();
			connection.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void addListOfAilments(ListOfAilments listOfAilments2) {
		Connection connection;
		try {
			connection = connectionHandler.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("insert into ListOfAilments (a_Reason,a_Name,a_Description) values(?,?,?)");
			statement.setString(1, listOfAilments2.getAilmentReason());
			statement.setString(2, listOfAilments2.getAilmentName());
			statement.setString(3, listOfAilments2.getDescription());
			statement.execute();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void addMedicalConsultationDetails(MedicalConsultationDetails medicalConsultationDetails2) {
		Connection connection;
		try {
			connection = connectionHandler.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"insert into MedicalConsultationDetails(d_Name,d_Degree,d_consultationName,d_consultantPhNo) values(?,?,?,?)");
			statement.setString(1, medicalConsultationDetails2.getDoctorName());
			statement.setString(2, medicalConsultationDetails2.getDoctorDegree());
			statement.setString(3, medicalConsultationDetails2.getConsultationName());
			statement.setString(4, medicalConsultationDetails2.getConsultantPhNo());
			statement.execute();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addTreatmentDetails(TreatmentDetails treatmentDetails) {
		Connection connection;
		try {
			connection = connectionHandler.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"insert into TreatmentDetails(t_Date,p_Id,d_Id,a_Id,t_Duration,t_Result) values(?,?,?,?,?,?)");
			statement.setString(1, treatmentDetails.getDateOfTreatment());
			statement.setInt(2, treatmentDetails.getPatientRegId());
			statement.setInt(3, treatmentDetails.getDoctorRegId());
			statement.setLong(4, treatmentDetails.getAilmentId());
			statement.setString(5, treatmentDetails.getTreatmentDuration());
			statement.setString(6, treatmentDetails.getTreatmentResult());
			statement.execute();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}