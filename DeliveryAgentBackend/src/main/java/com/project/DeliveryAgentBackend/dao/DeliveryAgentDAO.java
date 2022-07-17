package com.project.DeliveryAgentBackend.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.DeliveryAgentBackend.entity.DeliveryAgent;

@Repository
public interface DeliveryAgentDAO extends JpaRepository<DeliveryAgent, Integer> {

	@Query(value = "SELECT * FROM delivery_agent u WHERE u.city =?1 AND u.status = 'available'", nativeQuery = true)
	List<DeliveryAgent> getAllAvailableDeliveryAgent(String city);
}
