package com.project.BuyerBackend.entity;

public class DeliveryAgent {
	private String name;
	private Integer mobileNumber;

	public DeliveryAgent() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMobileNumber() {
		return mobileNumber;
	}

	public DeliveryAgent(String name, Integer mobileNumber) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
	}

	public void setMobileNumber(Integer mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
}
