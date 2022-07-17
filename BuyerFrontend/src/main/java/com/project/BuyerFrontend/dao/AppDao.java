package com.project.BuyerFrontend.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.BuyerFrontend.entity.Dish;
import com.project.BuyerFrontend.entity.OrderItem;
import com.project.BuyerFrontend.entity.Orders;
import com.project.BuyerFrontend.entity.Restaurant;
import com.project.BuyerFrontend.entity.User;
import com.project.BuyerFrontend.entity.UserInfo;
//import com.project.BuyerFrontend.prevalent.CurrentUser;

@Repository
public class AppDao {
	private static final String URL = "http://localhost:8081/buyerFrontend/";
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Lazy
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
	
	public List<Restaurant> getRestaurantsInCity(){
		UserInfo info=(UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return Arrays.asList(restTemplate.getForObject(URL+"getRestaurants/"+getUser(info.getUid()).getCity(), Restaurant[].class));
		
	}

	public List<Dish> getDishesInRestaurant(Integer mobileNumber) {
		return Arrays.asList(restTemplate.getForObject(URL+"getDishes/"+mobileNumber, Dish[].class));
	}
	
	
	public void placeOrder(String orderItems,Integer restaurantMobileNumber) {
		UserInfo info=(UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		restTemplate.postForObject(
				URL+
				"placeOrder?mobileNumber="+info.getUid()
				+"&city="+getUser(info.getUid()).getCity()
				+"&restaurantMobileNumber="+restaurantMobileNumber, 
				orderItems, String.class);
	}

	public List<Orders> getOrders() {
		UserInfo info=(UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return Arrays.asList(restTemplate.getForObject(URL+"getOrders/"+info.getUid(), Orders[].class));
	}

	public void updateUser(User user) {
		UserInfo info=(UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		restTemplate.postForObject(URL+"updateProfile/"+info.getUid(),user, String.class);		
	}

	public void markOrderAsReceived(String orderId) {
		restTemplate.postForObject(URL+"markOrderAsReceived/"+orderId, orderId, String.class);
	}

	public void addUser(User user) {
		restTemplate.postForObject(URL+"saveUser/",user, String.class);		
	}
}
