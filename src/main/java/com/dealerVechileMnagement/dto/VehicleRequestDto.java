package com.dealerVechileMnagement.dto;

import org.antlr.v4.runtime.misc.NotNull;

import com.dealerVechileMnagement.utility.VehicleStatus;

public class VehicleRequestDto {
	private Long id; // optional for updates

	private String model;

	private Double price;

	private VehicleStatus status;

	// getters & setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public VehicleStatus getStatus() {
		return status;
	}

	public void setStatus(VehicleStatus status) {
		this.status = status;
	}
}