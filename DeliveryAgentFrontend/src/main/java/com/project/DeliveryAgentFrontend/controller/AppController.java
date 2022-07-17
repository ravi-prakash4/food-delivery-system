package com.project.DeliveryAgentFrontend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.DeliveryAgentFrontend.dao.AppDao;
import com.project.DeliveryAgentFrontend.entity.Orders;
import com.project.DeliveryAgentFrontend.entity.User;
//import com.project.DeliveryAgentFrontend.prevalent.CurrentUser;
import com.project.DeliveryAgentFrontend.entity.UserInfo;

@Controller
public class AppController {
	@Autowired
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
	
	@RequestMapping("/orders")
	public String seeOrders(Model model) {
		
		List<Orders> orders = appDao.getOrders();
		model.addAttribute("orders", orders);
		return "orders";
	}
	
	@RequestMapping("/admin")
	public String home() {
//		if(notLoggedIn())return "login";
		return "admin";
	}
	
//	@RequestMapping("/logout")
//	public String logout() {
//		CurrentUser.MOBILE_NUMBER=null;
//		CurrentUser.PASSWORD=null;
//		CurrentUser.currentUser=null;
//		return "redirect:/";
//	}
	
//	public boolean notLoggedIn() {
//		return CurrentUser.MOBILE_NUMBER==null;
//	}

}