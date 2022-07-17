package com.project.BuyerFrontend.entity;

import java.util.ArrayList;
import java.util.List;

public class OrderItems {
	private List<OrderItem> orderItemsList;


	public OrderItems() {
		super();
	}
	public OrderItems(List<OrderItem> orderItemsList) {
		super();
		this.orderItemsList = orderItemsList;
	}
	public OrderItems(List<Dish> dishes,Boolean placeholder) {
		super();
		this.orderItemsList = new ArrayList<OrderItem>();
		for(Dish dish: dishes)orderItemsList.add(new OrderItem(dish.getDishId(),dish.getName(),0,dish.getPrice()));
	}
	public List<OrderItem> getOrderItemsList() {
		return orderItemsList;
	}
	public void setOrderItemsList(List<OrderItem> orderItemsList) {
		this.orderItemsList = orderItemsList;
	}
	
	
	
	
}
