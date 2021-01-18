package com.p_015.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

@Service
public class ConnectionHandler {
	public Connection getConnection() throws SQLException {
		Connection connection = null;
		connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/DigMedArchive?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
				"root", "root");
		return connection;
	}
}
