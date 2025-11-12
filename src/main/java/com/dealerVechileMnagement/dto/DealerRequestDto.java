package com.dealerVechileMnagement.dto;

import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;

import com.dealerVechileMnagement.utility.SubscriptionType;

public class DealerRequestDto {
	private Long id; // optional for update cases

	
	private String name;

	
	
	private String email;


	private SubscriptionType subscriptionType;

	
	private List<VehicleRequestDto> vehicles;

	// getters & setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public SubscriptionType getSubscriptionType() {
		return subscriptionType;
	}

	public void setSubscriptionType(SubscriptionType subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

	public List<VehicleRequestDto> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<VehicleRequestDto> vehicles) {
		this.vehicles = vehicles;
	}
}