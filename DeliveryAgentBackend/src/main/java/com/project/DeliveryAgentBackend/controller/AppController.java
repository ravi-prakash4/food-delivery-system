package com.project.DeliveryAgentBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.project.DeliveryAgentBackend.entity.DeliveryAgent;
import com.project.DeliveryAgentBackend.service.AppService;

@RestController
public class AppController {
	@Autowired
	AppService appService;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@GetMapping("/deliveryAgentFrontend/getUser/{mobileNumber}")
	public String deliveryAgentGetUser(@PathVariable Integer mobileNumber) {
		DeliveryAgent deliveryAgent=appService.getDeliveryAgent(mobileNumber);
		if(deliveryAgent==null)return null;
		ObjectNode deliveryAgentObjectNode=objectMapper.createObjectNode();
		deliveryAgentObjectNode.put("mobileNumber",deliveryAgent.getMobileNumber());
		deliveryAgentObjectNode.put("password",deliveryAgent.getPassword());
		deliveryAgentObjectNode.put("role",deliveryAgent.getRole());
		deliveryAgentObjectNode.put("name",deliveryAgent.getName());
		return deliveryAgentObjectNode.toPrettyString();
	}
	
	@GetMapping("/buyerBackend/getAvailableDeliveryAgent/{city}")
	public String getAvailableDeliveryAgent(@PathVariable String city) {
		DeliveryAgent availableAgent=appService.getAvailableDeliveryAgent(city);
		availableAgent.setStatus("out for delivery");
		appService.updateDeliveryAgent(availableAgent);
		ObjectNode objectNode=objectMapper.createObjectNode();
		objectNode.put("name", availableAgent.getName());
		objectNode.put("mobileNumber", availableAgent.getMobileNumber());
		return objectNode.toPrettyString();
	}
	
	@PostMapping("/buyerBackend/markDeliveryAgentAsAvailable/{mobileNumber}")
	public String buyerMarkDeliveryAgentAsAvailable(@PathVariable("mobileNumber") Integer mobileNumber) {
		DeliveryAgent deliveryAgent=appService.getDeliveryAgent(mobileNumber);
		if(deliveryAgent==null)return null;
		deliveryAgent.setStatus("available");
		appService.updateDeliveryAgent(deliveryAgent);
		return null;
	}
	
	@GetMapping("/deliveryAgentFrontend/getOrders/{mobileNumber}")
	public String restaurantGetOrders(@PathVariable Integer mobileNumber) {
		return appService.getOrders(mobileNumber);
	}
}
