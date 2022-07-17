package com.project.DeliveryAgentBackend.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.project.DeliveryAgentBackend.entity.Orders;

@Repository
public class AppDao {
	@Lazy
	@Autowired
	RestTemplate restTemplate;
	
	private static final String BUYER_URL = "http://localhost:8081/deliveryAgentBackend/";
	
	private static final String RESTAURANT_URL = "http://localhost:8083/deliveryAgentBackend/";
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	public List<Orders> getOrders(Integer mobileNumber) {
		return Arrays.asList(restTemplate.getForObject(BUYER_URL+"getOrders/"+mobileNumber, Orders[].class)); 
	}

	public String getRestaurantAddress(Integer restaurantMobileNumber) {
		return restTemplate.getForObject(RESTAURANT_URL+"getRestaurantAddress/"+restaurantMobileNumber,String.class);
	}

	public String getBuyerAddress(Integer buyerMobileNumber) {
		return restTemplate.getForObject(BUYER_URL+"getBuyerAddress/"+buyerMobileNumber,String.class);
	}
}
