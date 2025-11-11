package com.dealerVechileMnagement.serviceImpl;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import com.dealerVechileMnagement.dto.PaymentRequestDto;
import com.dealerVechileMnagement.entity.PaymentTransaction;
import com.dealerVechileMnagement.repository.PaymentTransactionRepository;
import com.dealerVechileMnagement.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired private PaymentTransactionRepository paymentTransactionRepository;
    @Autowired private TaskExecutor taskExecutor; // configure a ThreadPoolTaskExecutor

    @Override
    
    public PaymentTransaction initiatePayment(PaymentRequestDto paymentRequestDto) {
        PaymentTransaction p = new PaymentTransaction();
        p.setDealerId(paymentRequestDto.getDealerId());
        p.setAmount(paymentRequestDto.getAmount());
        p.setMethod(paymentRequestDto.getMethod());
        p.setStatus("PENDING");

        // Save and capture the ID
        PaymentTransaction savedPayment = paymentTransactionRepository.save(p);
        Long paymentId = savedPayment.getId();  // effectively final

        // Simulate callback after 5 seconds
        taskExecutor.execute(() -> {
            try {
                Thread.sleep(5000);

                PaymentTransaction payment = paymentTransactionRepository.findById(paymentId).orElse(null);
                if (payment != null) {
                    payment.setStatus("SUCCESS");
                    payment.setUpdatedAt(Instant.now());
                    paymentTransactionRepository.save(payment);
                }

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                PaymentTransaction payment = paymentTransactionRepository.findById(paymentId).orElse(null);
                if (payment != null) {
                    payment.setStatus("FAILED");
                    paymentTransactionRepository.save(payment);
                }
            }
        });

        return savedPayment;
    }

}
