package com.dealerVechileMnagement.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dealerVechileMnagement.dto.VehicleResponseDtoPremium;
import com.dealerVechileMnagement.entity.Vehicle;
import com.dealerVechileMnagement.repository.VehicleRepository;
import com.dealerVechileMnagement.service.VehicleService;
import com.dealerVechileMnagement.utility.SubscriptionType;

@Service
public class VehicleServiceImpl implements VehicleService {

	
	@Autowired 
	private VehicleRepository vehicleRepository;

	@Override
	public List<VehicleResponseDtoPremium> getVehiclesOfPremiumDealers() {
		List<Vehicle> vehicles = vehicleRepository.findByDealerSubscription(SubscriptionType.PREMIUM);

        // Convert Entity → DTO
        return vehicles.stream().map(v -> {
        	VehicleResponseDtoPremium dto = new VehicleResponseDtoPremium();
            dto.setId(v.getId());
            dto.setModel(v.getModel());
            dto.setPrice(v.getPrice());

            if (v.getDealer() != null) {
                dto.setDealerId(v.getDealer().getId());
                dto.setDealerName(v.getDealer().getName());
                dto.setDealerEmail(v.getDealer().getEmail());
                dto.setDealerSubscriptionType(v.getDealer().getSubscriptionType().name());
            }
            return dto;
        }).collect(Collectors.toList());
    }

	

}
