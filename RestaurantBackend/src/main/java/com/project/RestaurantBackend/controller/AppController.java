package com.project.RestaurantBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.project.RestaurantBackend.entity.Food_Dish;
import com.project.RestaurantBackend.entity.Restaurant;
import com.project.RestaurantBackend.service.AppService;

@RestController
public class AppController {
	@Autowired
	AppService appService;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@GetMapping("/restaurantFrontend/getUser/{mobileNumber}")
	public String restaurantGetUser(@PathVariable Integer mobileNumber) {
		Restaurant restaurant=appService.getRestaurant(mobileNumber);
		if(restaurant==null)return null;
		ObjectNode restaurantObjectNode=objectMapper.createObjectNode();
		restaurantObjectNode.put("mobileNumber",restaurant.getMobileNumber());
		restaurantObjectNode.put("password",restaurant.getPassword());
		restaurantObjectNode.put("role",restaurant.getRole());
		restaurantObjectNode.put("name",restaurant.getName());
		return restaurantObjectNode.toPrettyString();
	}
	
	@GetMapping("/restaurantFrontend/getFood/{id}")
	public Food_Dish onefoodGet(@PathVariable String id) {
		return appService.getOneFoodDish(id);
	}
	
	@GetMapping("/restaurantFrontend/getFood")
	public List<Food_Dish> foodGet() {
		return appService.getFoodDish();
	}
	
	@GetMapping("/restaurantFrontend/getFoodOfRestaurant/{mobileNumber}")
	public List<Food_Dish> foodGetOfRestaurant(@PathVariable Integer mobileNumber) {
		return appService.getFoodDishForRestaurant(mobileNumber);
	}
	
	@PostMapping("/restaurantFrontend/addFood")
	public String addfood(@RequestBody Food_Dish foodDish){
		return appService.addFoodDish(foodDish);
	}
	
	@DeleteMapping("/restaurantFrontend/deleteFood/{id}")
	public String deletefood(@PathVariable String id) {
		return appService.deleteFoodDish(id);
	}
	
	@PostMapping("/restaurantFrontend/updateFood")
	public String updatefood(@RequestBody Food_Dish foodDish) {
		return appService.updateFoodDish(foodDish);
	}
	
	//buyer backend apis
	@GetMapping("/buyerBackend/getDishes/{mobileNumber}")
	public String buyerGetDishes(@PathVariable Integer mobileNumber) {
		List<Food_Dish> dishes=appService.getFoodDishForRestaurant(mobileNumber);
		ArrayNode dishesObjectNode=objectMapper.createArrayNode();
		for(Food_Dish dish: dishes) {
			ObjectNode childNode=objectMapper.createObjectNode();
			childNode.put("dishId",dish.getId());
			childNode.put("name",dish.getName());
			childNode.put("price",dish.getPrice());
			dishesObjectNode.add(childNode);
		}
		return dishesObjectNode.toPrettyString();
	}

	@GetMapping("/buyerBackend/getRestaurantsInCity/{city}")
	public String buyerGetRestaurantsInCity(@PathVariable String city) {
		List<Restaurant> restaurants=appService.getRestaurantsInCity(city);
		ArrayNode restaurantsObjectNode=objectMapper.createArrayNode();
		for(Restaurant restaurant: restaurants) {
			ObjectNode childNode=objectMapper.createObjectNode();
			childNode.put("mobileNumber",restaurant.getMobileNumber());
			childNode.put("name",restaurant.getName());
			restaurantsObjectNode.add(childNode);
		}
		return restaurantsObjectNode.toPrettyString();
	}
	
	@GetMapping("/restaurantFrontend/getOrders/{mobileNumber}")
	public String restaurantGetOrders(@PathVariable Integer mobileNumber) {
		return appService.getOrders(mobileNumber);
	}
	
	@PostMapping("/restaurantFrontend/markOrderAsPickedUp/{orderId}")
	public String restaurantMarkAsPickedUp(@PathVariable("orderId") String orderId) {
		appService.restaurantMarkAsPickedUp(orderId);
		return null;
	}
	
	@GetMapping("/deliveryAgentBackend/getRestaurantAddress/{mobileNumber}")
	public String deliveryAgentGetBuyerAddress(@PathVariable Integer mobileNumber) {
		Restaurant restaurant=appService.getRestaurant(mobileNumber);
		if(restaurant==null)return " ";
		return restaurant.getAddress();
	}
}
