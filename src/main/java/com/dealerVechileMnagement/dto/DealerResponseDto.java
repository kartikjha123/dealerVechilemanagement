package com.dealerVechileMnagement.dto;

import java.util.List;

import com.dealerVechileMnagement.utility.SubscriptionType;

public class DealerResponseDto {

	private Long id;
	private String name;
	private String email;
	private SubscriptionType subscriptionType;
	private List<VehicleResponseDto> vehicles;

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

	public List<VehicleResponseDto> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<VehicleResponseDto> vehicles) {
		this.vehicles = vehicles;
	}

}
