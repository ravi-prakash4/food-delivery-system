package com.project.RestaurantFrontend.dao;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.RestaurantFrontend.entity.Food_Dish;
import com.project.RestaurantFrontend.entity.Orders;
import com.project.RestaurantFrontend.entity.User;
import com.project.RestaurantFrontend.entity.UserInfo;

@Repository
public class AppDao {
	private static final String URL = "http://localhost:8083/restaurantFrontend/";
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public AppDao() {
		super();
	}

	public User getUser(Integer mobileNumber) {
		if(mobileNumber==null)return null;
		System.out.println(URL+"getUser/"+mobileNumber);
		User user=restTemplate.getForObject(URL+"getUser/"+mobileNumber, User.class);
		return user;
	}
	
	public Food_Dish getOneFood(String id) {
		System.out.println(URL+"getFood/"+id);
		return restTemplate.getForObject(URL+"getFood/"+id, Food_Dish.class);
	}
	
	public List<Food_Dish> getAllFood() {
		System.out.println(URL+"getFood/");
		return restTemplate.getForObject(URL+"getFood", List.class);
	}
	
	public String addFood(Food_Dish foodDish) {
		System.out.println(URL+"addFood/");
		return restTemplate.postForObject(URL+"addFood/", foodDish, String.class);
	}
	
	public void deleteFood(String id) {
		System.out.println(URL+"deleteFood/"+id);
		 restTemplate.delete(URL+"deleteFood/"+id);
		 return;
	}

	public List<Food_Dish> getAllFoodOfRestaurant(Integer mobile_number) {
		System.out.println(URL+"getFoodOfRestaurant/"+mobile_number);
		return restTemplate.getForObject(URL+"getFoodOfRestaurant/"+mobile_number, List.class);
	}

	public List<Orders> getOrders() {
		UserInfo info=(UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return Arrays.asList(restTemplate.getForObject(URL+"getOrders/"+info.getUid(), Orders[].class));
	}

	public void markOrderAsPickedUp(String orderId) {
		restTemplate.postForObject(URL+"markOrderAsPickedUp/"+orderId, orderId, String.class);
	}
	
	public void updateFood(Food_Dish foodDish) {
		System.out.println(URL+"updateFood/");
		 restTemplate.postForObject(URL+"updateFood/", foodDish, String.class);
	}
	
	
}
