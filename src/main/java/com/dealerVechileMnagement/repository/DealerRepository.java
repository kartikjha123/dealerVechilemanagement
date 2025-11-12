package com.dealerVechileMnagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dealerVechileMnagement.entity.Dealer;

@Repository
public interface DealerRepository extends JpaRepository<Dealer, Long> {
	
	boolean existsByEmail(String email);

}
