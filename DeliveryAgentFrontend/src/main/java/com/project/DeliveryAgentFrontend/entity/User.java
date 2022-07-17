package com.project.DeliveryAgentFrontend.entity;

public class User {
	private Integer mobileNumber;
	private String password;
	private String role;
	private String name;
	public User() {
		super();
	}
	public User(Integer mobileNumber, String password, String role, String name) {
		super();
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.role = role;
		this.name = name;
	}
	public Integer getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Integer mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
