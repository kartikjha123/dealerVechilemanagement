package com.dealerVechileMnagement.entity;



import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "payments")
public class PaymentTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long dealerId;
    private Double amount;
    private String method; // UPI/Card/NetBanking
    private String status; // PENDING / SUCCESS / FAILED
    private Instant createdAt = Instant.now();
    private Instant updatedAt;
	public PaymentTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PaymentTransaction(Long id, Long dealerId, Double amount, String method, String status, Instant createdAt,
			Instant updatedAt) {
		super();
		this.id = id;
		this.dealerId = dealerId;
		this.amount = amount;
		this.method = method;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getDealerId() {
		return dealerId;
	}
	public void setDealerId(Long dealerId) {
		this.dealerId = dealerId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Instant getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}
	public Instant getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
	}

    
    
    
}
