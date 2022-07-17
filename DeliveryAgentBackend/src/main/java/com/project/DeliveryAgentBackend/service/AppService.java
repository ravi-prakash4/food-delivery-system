package com.project.DeliveryAgentBackend.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.project.DeliveryAgentBackend.dao.AppDao;
import com.project.DeliveryAgentBackend.dao.DeliveryAgentDAO;
import com.project.DeliveryAgentBackend.entity.DeliveryAgent;
import com.project.DeliveryAgentBackend.entity.Orders;

@Service
public class AppService {
	@Autowired
	DeliveryAgentDAO deliveryAgentDAO;
	
	@Autowired
	AppDao appDao;
	
	@Autowired
	ObjectMapper objectMapper;
	
	public DeliveryAgent getDeliveryAgent(Integer mobileNumber) {
		Optional<DeliveryAgent> opt= deliveryAgentDAO.findById(mobileNumber);
		if(!opt.isPresent())return null;
		return opt.get();
	}

	public DeliveryAgent getAvailableDeliveryAgent(String city) {
		List<DeliveryAgent>availableAgents=deliveryAgentDAO.getAllAvailableDeliveryAgent(city);
		if(availableAgents.size()==0)return new DeliveryAgent(007,"James Bond",city,"not found","not found","available","USER");
		double rand=Math.random()*availableAgents.size();
		DeliveryAgent chosenOne=availableAgents.get((int)(rand));
		return chosenOne;
	}

	public void updateDeliveryAgent(DeliveryAgent agent) {
		deliveryAgentDAO.save(agent);		
	}
	
	public String getOrders(Integer mobileNumber) {
		List<Orders> orders= appDao.getOrders(mobileNumber); 
		ArrayNode ordersObjectNode=objectMapper.createArrayNode();
		for(Orders order: orders) {
			ObjectNode childNode=objectMapper.createObjectNode();
			childNode.put("orderId",order.getOrderId());
			childNode.put("items",order.getItems());
			childNode.put("status",order.getStatus());
			childNode.put("restaurantAddress",appDao.getRestaurantAddress(order.getRestaurantMobileNumber()));
			childNode.put("buyerAddress",appDao.getBuyerAddress(order.getBuyerMobileNumber()));
			ordersObjectNode.add(childNode);
		}
		return ordersObjectNode.toPrettyString();
	}

}
