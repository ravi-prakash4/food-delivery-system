package com.project.DeliveryAgentFrontend.dao;

import java.io.IOException;
import java.util.ArrayList;
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
import com.project.DeliveryAgentFrontend.entity.Orders;
import com.project.DeliveryAgentFrontend.entity.User;
import com.project.DeliveryAgentFrontend.entity.UserInfo;
//import com.project.DeliveryAgentFrontend.prevalent.CurrentUser;

@Repository
public class AppDao {
	private static final String URL = "http://localhost:8085/deliveryAgentFrontend/";
	
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

	public List<Orders> getOrders() {
		UserInfo info=(UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return Arrays.asList(restTemplate.getForObject(URL+"getOrders/"+info.getUid(), Orders[].class));
	}
}
