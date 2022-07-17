package com.project.RestaurantBackend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.RestaurantBackend.entity.Food_Dish;

public interface FoodDAO extends JpaRepository<Food_Dish, String> {

	@Query(value = "SELECT * FROM food_dish u WHERE u.mobile_number =?1", nativeQuery = true)
	List<Food_Dish> getDishesForRestaurant(Integer mobileNumber);

}
