package com.project.RestaurantBackend.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.RestaurantBackend.entity.Restaurant;

@Repository
public interface RestaurantDAO extends JpaRepository<Restaurant, Integer> {

	@Query(value = "SELECT * FROM restaurant u WHERE u.city =?1", nativeQuery = true)
	List<Restaurant> getRestaurantsInCity(String city);
}
