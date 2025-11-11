package com.dealerVechileMnagement.dto;

public class PaymentRequestDto {

	private Long dealerId;
	private Double amount;
	private String method;

	public PaymentRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaymentRequestDto(Long dealerId, Double amount, String method) {
		super();
		this.dealerId = dealerId;
		this.amount = amount;
		this.method = method;
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

}
