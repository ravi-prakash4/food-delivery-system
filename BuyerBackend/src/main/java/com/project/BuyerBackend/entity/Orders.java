package com.project.BuyerBackend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {
	@Id
	@Column(name = "order_id")
	private String orderId;
	@Column(name = "restaurant_mobile_number")
	private Integer restaurantMobileNumber;
	@Column(name = "buyer_mobile_number")
	private Integer buyerMobileNumber;
	@Column(name = "delivery_agent_mobile_number")
	private Integer deliveryAgentMobileNumber;
	@Column
	private String status;
	@Column(columnDefinition = "JSON")
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
