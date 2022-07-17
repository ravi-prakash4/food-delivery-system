package com.project.BuyerBackend.dao;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.project.BuyerBackend.entity.DeliveryAgent;

@Repository
public class AppDao {
	@Lazy
	@Autowired
	RestTemplate restTemplate;
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	private static final String DELIVERY_AGENT_URL = "http://localhost:8085/buyerBackend/";
	
	private static final String RESTAURANT_URL = "http://localhost:8083/buyerBackend/";
	
	public DeliveryAgent getAvailableDeliveryAgentInCity(String buyerCity) {
		return restTemplate.getForObject(DELIVERY_AGENT_URL+"getAvailableDeliveryAgent/"+buyerCity, DeliveryAgent.class);
	}

	public String buyerGetDishes(Integer mobileNumber) {
		return restTemplate.getForObject(RESTAURANT_URL+"getDishes/"+mobileNumber, String.class);
	}

	public String buyerGetRestaurantsInCity(String city) {
		return restTemplate.getForObject(RESTAURANT_URL+"getRestaurantsInCity/"+city,String.class);
	}

	public void markDeliveryAgentAsAvailable(Integer deliveryAgentMobileNumber) {
		restTemplate.postForObject(DELIVERY_AGENT_URL+"markDeliveryAgentAsAvailable/"+deliveryAgentMobileNumber, deliveryAgentMobileNumber, String.class);
	}
}
