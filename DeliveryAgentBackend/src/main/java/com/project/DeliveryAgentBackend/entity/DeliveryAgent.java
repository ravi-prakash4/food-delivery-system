package com.project.DeliveryAgentBackend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "delivery_agent")
public class DeliveryAgent {
	@Id
	@Column(name = "mobile_number")
	private Integer mobileNumber;
	@Column
	private String name;
	@Column
	private String city;
	@Column
	private String address;
	@Column
	private String password;
	@Column
	private String status;
	@Column
	private String role;
	public DeliveryAgent() {
		super();
	}
	public DeliveryAgent(Integer mobileNumber, String name, String city, String address, String password, String status,
			String role) {
		super();
		this.mobileNumber = mobileNumber;
		this.name = name;
		this.city = city;
		this.address = address;
		this.password = password;
		this.status = status;
		this.role = role;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
