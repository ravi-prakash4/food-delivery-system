package com.project.BuyerFrontend.entity;

public class Restaurant {
	
	private Integer mobileNumber;
	private String name;
	public Restaurant() {
		super();
	}
	public Restaurant(Integer mobileNumber, String name) {
		super();
		this.mobileNumber = mobileNumber;
		this.name = name;
	}
	public Integer getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Integer mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
