package com.dealerVechileMnagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dealerVechileMnagement.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByUserName(String username);

}
