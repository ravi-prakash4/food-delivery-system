package com.project.BuyerFrontend.entity;

public class Orders {
	String orderId;
	String items;
	String status;
	Integer deliveryAgentMobileNumber;
	public Orders() {
		super();
	}
	public Orders(String orderId, String items, String status, Integer deliveryAgentMobileNumber) {
		super();
		this.orderId = orderId;
		this.items = items;
		this.status = status;
		this.deliveryAgentMobileNumber = deliveryAgentMobileNumber;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getDeliveryAgentMobileNumber() {
		return deliveryAgentMobileNumber;
	}
	public void setDeliveryAgentMobileNumber(Integer deliveryAgentMobileNumber) {
		this.deliveryAgentMobileNumber = deliveryAgentMobileNumber;
	}	
	
}
