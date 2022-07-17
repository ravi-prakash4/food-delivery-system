package com.project.BuyerFrontend.controller;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.project.BuyerFrontend.dao.AppDao;
import com.project.BuyerFrontend.entity.Dish;
import com.project.BuyerFrontend.entity.OrderItem;
import com.project.BuyerFrontend.entity.OrderItems;
import com.project.BuyerFrontend.entity.Orders;
import com.project.BuyerFrontend.entity.Restaurant;
import com.project.BuyerFrontend.entity.User;
import com.project.BuyerFrontend.entity.UserInfo;
//import com.project.BuyerFrontend.prevalent.CurrentUser;

@Controller
public class AppController {
	@Autowired
	ObjectMapper objectMapper;
	
	@Autowired
	@Lazy
	AppDao appDao;
	
	@RequestMapping("/")
	public String home(Model model) {
		if( SecurityContextHolder.getContext().getAuthentication() != null &&
				SecurityContextHolder.getContext().getAuthentication().isAuthenticated() &&
				//when Anonymous Authentication is enabled
				!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken) )
		{
			UserInfo info=(UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			model.addAttribute("userName",appDao.getUser(info.getUid()).getName());
			if(info.getRole().equals("ADMIN"))return "admin";
			return "home";
		}
//		UserInfo info=(UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		System.out.println(info);
//		if(notLoggedIn())return "login";
		return "notLoggedInPage";
	}
	
	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}
	
//	@RequestMapping("/checkCredentials")
//	public String checkCredentials(@RequestParam("mobile_number")Integer mobileNumber, @RequestParam("password")String password) {
//		if(mobileNumber==null || password==null)return "redirect:/logInFailure";
//		User user=appDao.getUser(mobileNumber);
//		if(user==null)return "redirect:/logInFailure";
//		if(!user.getPassword().equals(password))return "redirect:/logInFailure";
//		CurrentUser.MOBILE_NUMBER=user.getMobileNumber();
//		CurrentUser.PASSWORD=user.getPassword();
//		CurrentUser.currentUser=user;
//		return "redirect:/";
//	}
	
//	@RequestMapping("/logInFailure")
//	public String loginFailure() {		
//		return "logInFailure";
//	}
//	
//	@RequestMapping("/logout")
//	public String logout() {
//		CurrentUser.MOBILE_NUMBER=null;
//		CurrentUser.PASSWORD=null;
//		CurrentUser.currentUser=null;
//		return "redirect:/";
//	}
//	
//	public boolean notLoggedIn() {
//		return CurrentUser.MOBILE_NUMBER==null;
//	}
//	
	@RequestMapping("/signUp")
	public String signUp(){
		if( SecurityContextHolder.getContext().getAuthentication() != null &&
				SecurityContextHolder.getContext().getAuthentication().isAuthenticated() &&
				//when Anonymous Authentication is enabled
				!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken) )
		{
			return "redirect:/";
		}
		return "signUp";
	}
	
	@RequestMapping("/admin")
	public String home() {
//		if(notLoggedIn())return "login";
		return "admin";
	}
	
	@RequestMapping(value = "/signUpSubmit", method = RequestMethod.POST )
	public String signUpSubmit(@ModelAttribute User user) {
		user.setRole("USER");
		appDao.addUser(user);
		return "signUpSuccessful";
	}
	
	@RequestMapping("/seeRestaurants")
	public String seeRestaurants(Model model) {
//		if(notLoggedIn())return "login";
		List<Restaurant>restaurants=appDao.getRestaurantsInCity();
		model.addAttribute("restaurants", restaurants);
		UserInfo info=(UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("userCity",appDao.getUser(info.getUid()).getCity());
		return "seeRestaurants";
	}
	
	@RequestMapping("/seeRestaurant")
	public String seeRestaurant(@RequestParam("mobileNumber")Integer mobileNumber,
			@RequestParam("name")String restaurantName,
			Model model) {
//		if(notLoggedIn())return "login";
		List<Dish> dishes=appDao.getDishesInRestaurant(mobileNumber);
		OrderItems orderItems=new OrderItems(dishes,true);
		model.addAttribute("restaurantName",restaurantName);
		model.addAttribute("mobileNumber", mobileNumber);
		model.addAttribute("orderItems",orderItems);
		return "seeRestaurant";		
	}
	
	@RequestMapping(value = "/placeOrder", method = RequestMethod.POST )
	public String placeOrder(@RequestParam("mobileNumber") Integer mobileNumber,@ModelAttribute("orderItems") OrderItems orderItems,Model model) {
//		if(notLoggedIn())return "login";
		List<OrderItem> orderItemsList=orderItems.getOrderItemsList();
		List<OrderItem> validOrders=new ArrayList<OrderItem>();
		Integer orderAmount=0;
		for(OrderItem item:orderItemsList) {
			if(item.getQuantity()<=0)continue;
			validOrders.add(item);
			orderAmount+=(item.getQuantity()*item.getPrice());
		}
		if(validOrders.size()==0)return "orderUnsuccessful";
		String validOrderItems=new String();
		try {validOrderItems = objectMapper.writeValueAsString(validOrders);
		} catch (JsonProcessingException e) {}
		appDao.placeOrder(validOrderItems,mobileNumber);
		model.addAttribute("orderAmount", orderAmount);
		return "orderSuccessful";
	}
	
	@RequestMapping(value ="/seeOrders")
	public String seeOrders(Model model) {
//		if(notLoggedIn())return "login";
		List<Orders> orders=appDao.getOrders();
		model.addAttribute("orders",orders);
		return "seeOrders";
	}
	
	@RequestMapping(value ="/editProfile")
	public String seeEditProfilePage(Model model) {
//		if(notLoggedIn())return "login";
		UserInfo info=(UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("command",appDao.getUser(info.getUid()));
		return "editProfile";
	}
	
	@RequestMapping(value = "/updateProfile", method = RequestMethod.POST )
	public String updateProfile(@ModelAttribute("command") User user) {
//		if(notLoggedIn())return "login";
//		CurrentUser.currentUser=user;
		appDao.updateUser(user);
		return "redirect:/";
	}
	
	@RequestMapping("/markAsReceived/{orderId}")
	public String markOrderAsReceived(@PathVariable String orderId) {
//		if(notLoggedIn())return "login";
		appDao.markOrderAsReceived(orderId);
		return "redirect:/seeOrders";
	}
	
	

}