package com.dealerVechileMnagement.dto;



public class VehicleResponseDtoPremium {

    private Long id;
    private String model;
    private Double price;

    private Long dealerId;
    private String dealerName;
    private String dealerEmail;
    private String dealerSubscriptionType;

    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Long getDealerId() {
        return dealerId;
    }
    public void setDealerId(Long dealerId) {
        this.dealerId = dealerId;
    }
    public String getDealerName() {
        return dealerName;
    }
    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }
    public String getDealerEmail() {
        return dealerEmail;
    }
    public void setDealerEmail(String dealerEmail) {
        this.dealerEmail = dealerEmail;
    }
    public String getDealerSubscriptionType() {
        return dealerSubscriptionType;
    }
    public void setDealerSubscriptionType(String dealerSubscriptionType) {
        this.dealerSubscriptionType = dealerSubscriptionType;
    }
}
