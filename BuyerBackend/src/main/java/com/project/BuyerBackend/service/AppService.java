package com.project.BuyerBackend.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.BuyerBackend.dao.AppDao;
import com.project.BuyerBackend.dao.BuyerDAO;
import com.project.BuyerBackend.dao.OrdersDAO;
import com.project.BuyerBackend.entity.Buyer;
import com.project.BuyerBackend.entity.Dish;
import com.project.BuyerBackend.entity.Orders;

@Service
public class AppService {
	@Autowired
	OrdersDAO ordersDAO;
	
	@Autowired
	BuyerDAO buyerDAO;
	
	@Autowired
	AppDao appDao;
	
	@Autowired
	ObjectMapper mapper;
	
	public Buyer getBuyer(Integer mobileNumber) {
		Optional<Buyer> opt= buyerDAO.findById(mobileNumber);
		if(!opt.isPresent())return null;
		return opt.get();
	}
	
	public String placeOrder(String buyerCity
			,Integer buyerMobileNumber
			,Integer restaurantMobileNumber
			,String items) {
		
		String oid=""+buyerMobileNumber+restaurantMobileNumber+(new Date()).toString();
		Orders order=new Orders(oid,restaurantMobileNumber,buyerMobileNumber,
				appDao.getAvailableDeliveryAgentInCity(buyerCity).getMobileNumber(),
				"with_restaurant",
				items);
		
		ordersDAO.save(order);
		return null;
	}

	public List<Orders> getOrders(Integer mobileNumber) {
		return processOrders(ordersDAO.buyerGetOrders(mobileNumber));
	}

	public String buyerGetDishes(Integer mobileNumber) {		
		return appDao.buyerGetDishes(mobileNumber);
	}

	public String buyerGetRestaurantsInCity(String city) {
		return appDao.buyerGetRestaurantsInCity(city);
	}

	public void updateBuyer(Integer buyerMobileNumber, Buyer buyer) {
		buyerDAO.deleteById(buyerMobileNumber);
		buyerDAO.save(buyer);
	}

	public void updateOrderStatus(String orderId, String status) {
		Optional<Orders> orderOpt=ordersDAO.findById(orderId);
		if(!orderOpt.isPresent())return;
		Orders order=orderOpt.get();
		ordersDAO.delete(order);
		order.setStatus(status);
		ordersDAO.save(order);
	}

	public void markDeliveryAgentAsAvailable(String orderId) {
		Optional<Orders> orderOpt=ordersDAO.findById(orderId);
		if(!orderOpt.isPresent())return;
		Orders order=orderOpt.get();
		appDao.markDeliveryAgentAsAvailable(order.getDeliveryAgentMobileNumber());
		
	}

	public void saveBuyer(Buyer buyer) {
		buyerDAO.save(buyer);	
	}

	public List<Orders> getOrdersForRestaurant(Integer mobileNumber) {
		return processOrders(ordersDAO.restaurantGetOrders(mobileNumber));
	}

	public List<Orders> getOrdersForDeliveryAgent(Integer mobileNumber) {
		return processOrders(ordersDAO.deliveryAgentGetOrders(mobileNumber));
	}
	
	public List<Orders> processOrders(List<Orders> orders){
		if(null!=orders) {
			for(int i=0;i<orders.size();i++) {
				Orders order=orders.get(i);
				order.setItems(processDishes(order.getItems()));
				orders.set(i, order);
			}
		}
		return orders;
	}
	
	public String processDishes(String dishJson) {
		List<Dish> dishes=new ArrayList<Dish>();
		try {
			dishes=Arrays.asList(mapper.readValue(dishJson, Dish[].class));
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringBuffer pString=new StringBuffer(" ");
		for(Dish dish: dishes) {
			pString.append(dish.getName()+" ("+dish.getQuantity()+"), ");
		}
		if(pString.length()>=1) {
			pString.deleteCharAt(pString.length()-1);
			pString.deleteCharAt(pString.length()-1);
		}
		return pString.toString();
	}

}
