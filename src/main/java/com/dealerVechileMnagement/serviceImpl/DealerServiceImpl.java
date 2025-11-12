package com.dealerVechileMnagement.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dealerVechileMnagement.dto.DealerRequestDto;
import com.dealerVechileMnagement.dto.DealerResponseDto;
import com.dealerVechileMnagement.dto.VehicleRequestDto;
import com.dealerVechileMnagement.dto.VehicleResponseDto;
import com.dealerVechileMnagement.entity.Dealer;
import com.dealerVechileMnagement.entity.Vehicle;
import com.dealerVechileMnagement.repository.DealerRepository;
import com.dealerVechileMnagement.service.DealerService;

import jakarta.transaction.Transactional;

@Service
public class DealerServiceImpl implements DealerService {

	@Autowired
	private DealerRepository dealerRepository;

	@Override
	@Transactional
	public DealerResponseDto saveDealer(DealerRequestDto request) {
		// optional: check duplicate email
		if (request.getEmail() != null && dealerRepository.existsByEmail(request.getEmail())) {
			// You can throw a custom exception here. For simplicity, we'll throw
			// IllegalArgumentException
			throw new IllegalArgumentException("Dealer with email already exists: " + request.getEmail());
		}

		Dealer dealer = new Dealer();
		dealer.setName(request.getName());
		dealer.setEmail(request.getEmail());
		dealer.setSubscriptionType(request.getSubscriptionType());

		List<Vehicle> vehicles = new ArrayList<>();
		if (request.getVehicles() != null) {
			for (VehicleRequestDto vdto : request.getVehicles()) {
				Vehicle v = new Vehicle();
				v.setModel(vdto.getModel());
				v.setPrice(vdto.getPrice());
				v.setStatus(vdto.getStatus());
				// set relationship both sides
				v.setDealer(dealer);
				vehicles.add(v);
			}
		}
		dealer.setVehicles(vehicles);

		Dealer saved = dealerRepository.save(dealer); // cascade will save vehicles

		// map to response dto
		DealerResponseDto resp = new DealerResponseDto();
		resp.setId(saved.getId());
		resp.setName(saved.getName());
		resp.setEmail(saved.getEmail());
		resp.setSubscriptionType(saved.getSubscriptionType());

		List<VehicleResponseDto> vres = saved.getVehicles() == null ? new ArrayList<>()
				: saved.getVehicles().stream().map(v -> {
					VehicleResponseDto vr = new VehicleResponseDto();
					vr.setId(v.getId());
					vr.setModel(v.getModel());
					vr.setPrice(v.getPrice());
					vr.setStatus(v.getStatus());
					return vr;
				}).collect(Collectors.toList());

		resp.setVehicles(vres);
		return resp;
	}

}
