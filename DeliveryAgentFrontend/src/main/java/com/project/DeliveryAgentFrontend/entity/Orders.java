package com.project.DeliveryAgentFrontend.entity;

public class Orders {
	 
	 private String orderId;
	 private String items;
	 private String status;
	 private String restaurantAddress;
	 private String buyerAddress;
	public Orders(String orderId, String items, String status, String restaurantAddress, String buyerAddress) {
		super();
		this.orderId = orderId;
		this.items = items;
		this.status = status;
		this.restaurantAddress = restaurantAddress;
		this.buyerAddress = buyerAddress;
	}
	public Orders() {
		super();
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
	public String getRestaurantAddress() {
		return restaurantAddress;
	}
	public void setRestaurantAddress(String restaurantAddress) {
		this.restaurantAddress = restaurantAddress;
	}
	public String getBuyerAddress() {
		return buyerAddress;
	}
	public void setBuyerAddress(String buyerAddress) {
		this.buyerAddress = buyerAddress;
	}
	 
	 

}
