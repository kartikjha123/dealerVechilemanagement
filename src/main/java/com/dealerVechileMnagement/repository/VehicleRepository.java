package com.dealerVechileMnagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dealerVechileMnagement.entity.Vehicle;
import com.dealerVechileMnagement.utility.SubscriptionType;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    @Query("select v from Vehicle v join v.dealer d where d.subscriptionType = :sub")
    List<Vehicle> findByDealerSubscription(@Param("sub") SubscriptionType sub);
}
