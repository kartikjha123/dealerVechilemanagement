package com.dealerVechileMnagement.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dealerVechileMnagement.dto.UserRequestDto;
import com.dealerVechileMnagement.entity.User;
import com.dealerVechileMnagement.repository.UserRepository;
import com.dealerVechileMnagement.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Override
	public String  saveUser(UserRequestDto userRequestDto) {

		// check existing username
		if (userRepository.findByUserName(userRequestDto.getUserName()).isPresent()) {
			throw new IllegalArgumentException("Username already exists: " + userRequestDto.getUserName());
		}

		User user = new User();
		user.setUserName(userRequestDto.getUserName());
		user.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
		userRepository.save(user);
		return "User Saved Sucessfully";

	}

}
