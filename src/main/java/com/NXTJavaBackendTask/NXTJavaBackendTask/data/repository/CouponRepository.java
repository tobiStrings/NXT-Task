package com.NXTJavaBackendTask.NXTJavaBackendTask.data.repository;

import com.NXTJavaBackendTask.NXTJavaBackendTask.data.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {
    Optional<Coupon> findCouponByCouponName(String couponName);
}
