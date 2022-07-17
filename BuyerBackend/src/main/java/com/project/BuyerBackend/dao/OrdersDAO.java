package com.project.BuyerBackend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.BuyerBackend.entity.Orders;

@Repository
public interface OrdersDAO extends JpaRepository<Orders, String>  {

	@Query(value = "SELECT * FROM orders u WHERE u.buyer_mobile_number =?1", nativeQuery = true)
	List<Orders> buyerGetOrders(Integer mobileNumber);

	@Query(value = "SELECT * FROM orders u WHERE u.restaurant_mobile_number =?1", nativeQuery = true)
	List<Orders> restaurantGetOrders(Integer mobileNumber);
	
	@Query(value = "SELECT * FROM orders u WHERE u.delivery_agent_mobile_number =?1", nativeQuery = true)
	List<Orders> deliveryAgentGetOrders(Integer mobileNumber);

	
}
