package com.dealerVechileMnagement.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dealerVechileMnagement.entity.Vehicle;
import com.dealerVechileMnagement.repository.VehicleRepository;
import com.dealerVechileMnagement.service.VehicleService;
import com.dealerVechileMnagement.utility.SubscriptionType;

@Service
public class VehicleServiceImpl implements VehicleService {

	
	@Autowired 
	private VehicleRepository vehicleRepository;

	@Override
    public List<Vehicle> getVehiclesOfPremiumDealers() {
        return vehicleRepository.findByDealerSubscription(SubscriptionType.PREMIUM);
    }

}
