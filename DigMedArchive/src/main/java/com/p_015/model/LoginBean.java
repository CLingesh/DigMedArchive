package com.p_015.model;

import org.springframework.stereotype.Component;

@Component
public class LoginBean {
	private String userName;
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LoginBean(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public LoginBean() {
		// TODO Auto-generated constructor stub
	}

}
