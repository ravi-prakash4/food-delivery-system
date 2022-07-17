package com.project.BuyerBackend.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.project.BuyerBackend.entity.Buyer;
import com.project.BuyerBackend.entity.Orders;
import com.project.BuyerBackend.service.AppService;

@RestController
public class AppController {
	@Autowired
	AppService appService;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@GetMapping("/buyerFrontend/getUser/{mobileNumber}")
	public Buyer buyerGetUser(@PathVariable Integer mobileNumber) {
		Buyer buyer=appService.getBuyer(mobileNumber);
		if(buyer==null)return null;
		return buyer;
	}
	
	@PostMapping("/buyerFrontend/saveUser/")
	public String buyerSaveUser(@RequestBody Buyer buyer) {
		appService.saveBuyer(buyer);
		return null;
	}
	
	@PostMapping("/buyerFrontend/placeOrder")
	public String placeOrder(@RequestParam("mobileNumber") Integer buyerMobileNumber,
			@RequestParam("city") String buyerCity,
			@RequestParam("restaurantMobileNumber") Integer restaurantMobileNumber,
			@RequestBody String orderItems) {
		appService.placeOrder(buyerCity, buyerMobileNumber, restaurantMobileNumber, orderItems);
		return null;
	}
	
	@GetMapping("/buyerFrontend/getOrders/{mobileNumber}")
	public String buyerGetOrders(@PathVariable Integer mobileNumber) {
		List<Orders> orders= appService.getOrders(mobileNumber);		
		ArrayNode ordersObjectNode=objectMapper.createArrayNode();
		for(Orders order: orders) {
			ObjectNode childNode=objectMapper.createObjectNode();
			childNode.put("orderId",order.getOrderId());
			childNode.put("items",order.getItems());
			childNode.put("status",order.getStatus());
			childNode.put("deliveryAgentMobileNumber",order.getDeliveryAgentMobileNumber());
			ordersObjectNode.add(childNode);
		}
		return ordersObjectNode.toPrettyString();
	}
	
	@GetMapping("/buyerFrontend/getDishes/{mobileNumber}")
	public String buyerGetDishes(@PathVariable Integer mobileNumber) {
		return appService.buyerGetDishes(mobileNumber);
	}
	
	@GetMapping("/buyerFrontend/getRestaurants/{city}")
	public String buyerGetRestaurantsInCity(@PathVariable String city) {
		return appService.buyerGetRestaurantsInCity(city);
	}
	
	@PostMapping("/buyerFrontend/updateProfile/{mobileNumber}")
	public String placeOrder(@PathVariable("mobileNumber") Integer buyerMobileNumber,@RequestBody Buyer buyer) {
		appService.updateBuyer(buyerMobileNumber,buyer);
		return null;
	}
	
	@PostMapping("/buyerFrontend/markOrderAsReceived/{orderId}")
	public String buyerMarkAsReceived(@PathVariable("orderId") String orderId) {
		appService.updateOrderStatus(orderId,"delivered");
		appService.markDeliveryAgentAsAvailable(orderId);
		return null;
	}
	
	//Restaurant apis
	@PostMapping("/restaurantBackend/markOrderAsPickedUp/{orderId}")
	public String restaurantMarkAsPickedUp(@PathVariable("orderId") String orderId) {
		appService.updateOrderStatus(orderId,"with delivery agent");
		return null;
	}
	
	@GetMapping("/restaurantBackend/getOrders/{mobileNumber}")
	public String restaurantGetOrders(@PathVariable Integer mobileNumber) {
		List<Orders> orders= appService.getOrdersForRestaurant(mobileNumber);		
		ArrayNode ordersObjectNode=objectMapper.createArrayNode();
		for(Orders order: orders) {
			ObjectNode childNode=objectMapper.createObjectNode();
			childNode.put("orderId",order.getOrderId());
			childNode.put("items",order.getItems());
			childNode.put("status",order.getStatus());
			childNode.put("deliveryAgentMobileNumber",order.getDeliveryAgentMobileNumber());
			ordersObjectNode.add(childNode);
		}
		return ordersObjectNode.toPrettyString();
	}
	
	@GetMapping("/deliveryAgentBackend/getOrders/{mobileNumber}")
	public List<Orders> deliveryAgentGetOrders(@PathVariable Integer mobileNumber) {
		List<Orders> orders= appService.getOrdersForDeliveryAgent(mobileNumber);		
		return orders;
	}
	
	@GetMapping("/deliveryAgentBackend/getBuyerAddress/{mobileNumber}")
	public String deliveryAgentGetBuyerAddress(@PathVariable Integer mobileNumber) {
		Buyer buyer=appService.getBuyer(mobileNumber);
		if(buyer==null)return " ";
		return buyer.getAddress();
	}
	
	@RequestMapping("/health")
	public String healthCheck() {
		return "health is ok";
	}

}
