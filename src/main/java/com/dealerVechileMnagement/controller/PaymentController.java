package com.dealerVechileMnagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dealerVechileMnagement.dto.PaymentRequestDto;
import com.dealerVechileMnagement.entity.PaymentTransaction;
import com.dealerVechileMnagement.service.PaymentService;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
	
    @Autowired private PaymentService paymentService;

    @PostMapping("/initiate")
    public ResponseEntity<PaymentTransaction> initiate(@RequestBody PaymentRequestDto req) {
        PaymentTransaction p = paymentService.initiatePayment(req);
        return ResponseEntity.ok(p);
    }
}



