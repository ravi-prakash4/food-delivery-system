package com.project.BuyerFrontend.entity;

import org.springframework.stereotype.Component;

@Component
public class OrderItem {
	private String dishId;
	private String name;
	private Integer quantity;
	private Integer price;
	public OrderItem() {
		super();
	}
	public OrderItem(String dishId, String name, Integer quantity, Integer price) {
		super();
		this.dishId = dishId;
		this.name = name;
		this.quantity = quantity;
		this.price=price;
	}
	public String getDishId() {
		return dishId;
	}
	public void setDishId(String dishId) {
		this.dishId = dishId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "OrderItem [dishId=" + dishId + ", name=" + name + ", quantity=" + quantity + ", price=" + price + "]";
	}
	
}
