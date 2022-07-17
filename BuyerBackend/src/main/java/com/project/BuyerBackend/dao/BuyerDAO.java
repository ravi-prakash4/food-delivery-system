package com.project.BuyerBackend.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.BuyerBackend.entity.Buyer;

@Repository
public interface BuyerDAO extends JpaRepository<Buyer, Integer> {
}
