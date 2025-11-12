package com.dealerVechileMnagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dealerVechileMnagement.entity.Vehicle;
import com.dealerVechileMnagement.service.VehicleService;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
	
    @Autowired 
    private VehicleService vehicleService;

    @GetMapping("/premium")
    public ResponseEntity<?> getPremiumVehicles() {
        return ResponseEntity.ok(vehicleService.getVehiclesOfPremiumDealers());
    }
}
