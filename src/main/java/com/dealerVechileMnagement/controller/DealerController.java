package com.dealerVechileMnagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dealerVechileMnagement.dto.DealerRequestDto;
import com.dealerVechileMnagement.dto.DealerResponseDto;
import com.dealerVechileMnagement.service.DealerService;

@RestController
@RequestMapping("/api/dealers")
@Validated
public class DealerController {

	@Autowired
    private DealerService dealerService;

    
    @PostMapping
    public ResponseEntity<DealerResponseDto> createDealer(@RequestBody DealerRequestDto request) {
        DealerResponseDto saved = dealerService.saveDealer(request);
        return new ResponseEntity<>(saved,HttpStatus.OK);
    }
}