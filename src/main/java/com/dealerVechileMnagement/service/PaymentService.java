package com.dealerVechileMnagement.service;

import com.dealerVechileMnagement.dto.PaymentRequestDto;
import com.dealerVechileMnagement.entity.PaymentTransaction;

public interface PaymentService {
	
	public PaymentTransaction initiatePayment(PaymentRequestDto paymentRequestDto);

}
