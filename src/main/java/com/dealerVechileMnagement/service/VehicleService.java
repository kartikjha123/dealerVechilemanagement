package com.dealerVechileMnagement.service;

import java.util.List;

import com.dealerVechileMnagement.dto.VehicleResponseDtoPremium;

public interface VehicleService {
	
	 List<VehicleResponseDtoPremium> getVehiclesOfPremiumDealers();

}
