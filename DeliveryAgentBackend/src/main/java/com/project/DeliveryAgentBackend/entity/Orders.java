package com.project.DeliveryAgentBackend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class Orders {
	private String orderId;
	private Integer restaurantMobileNumber;
	private Integer buyerMobileNumber;
	private Integer deliveryAgentMobileNumber;
	private String status;
	private String items;
	public Orders() {
		super();
	}
	public Orders(String orderId, Integer restaurantMobileNumber, Integer buyerMobileNumber,
			Integer deliveryAgentMobileNumber, String status, String items) {
		super();
		this.orderId = orderId;
		this.restaurantMobileNumber = restaurantMobileNumber;
		this.buyerMobileNumber = buyerMobileNumber;
		this.deliveryAgentMobileNumber = deliveryAgentMobileNumber;
		this.status = status;
		this.items = items;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Integer getRestaurantMobileNumber() {
		return restaurantMobileNumber;
	}
	public void setRestaurantMobileNumber(Integer restaurantMobileNumber) {
		this.restaurantMobileNumber = restaurantMobileNumber;
	}
	public Integer getBuyerMobileNumber() {
		return buyerMobileNumber;
	}
	public void setBuyerMobileNumber(Integer buyerMobileNumber) {
		this.buyerMobileNumber = buyerMobileNumber;
	}
	public Integer getDeliveryAgentMobileNumber() {
		return deliveryAgentMobileNumber;
	}
	public void setDeliveryAgentMobileNumber(Integer deliveryAgentMobileNumber) {
		this.deliveryAgentMobileNumber = deliveryAgentMobileNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	
}
