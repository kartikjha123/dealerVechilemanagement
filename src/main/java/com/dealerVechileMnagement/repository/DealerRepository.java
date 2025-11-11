package com.dealerVechileMnagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dealerVechileMnagement.entity.Dealer;

public interface DealerRepository extends JpaRepository<Dealer, Long> {

}
