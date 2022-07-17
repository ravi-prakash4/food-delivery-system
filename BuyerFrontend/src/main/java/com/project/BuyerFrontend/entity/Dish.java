package com.project.BuyerFrontend.entity;

public class Dish {
	private String dishId;
	private String name;
	private Integer price;
	public Dish() {
		super();
	}
	public Dish(String dishId, String name, Integer price) {
		super();
		this.dishId = dishId;
		this.name = name;
		this.price = price;
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
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
}
