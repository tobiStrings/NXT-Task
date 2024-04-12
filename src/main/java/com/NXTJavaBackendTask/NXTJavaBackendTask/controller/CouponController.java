package com.NXTJavaBackendTask.NXTJavaBackendTask.controller;

import com.NXTJavaBackendTask.NXTJavaBackendTask.data.dtos.AddCouponRequest;
import com.NXTJavaBackendTask.NXTJavaBackendTask.data.dtos.AddCouponResponse;
import com.NXTJavaBackendTask.NXTJavaBackendTask.data.dtos.ApplyCouponResponse;
import com.NXTJavaBackendTask.NXTJavaBackendTask.exception.CartServiceException;
import com.NXTJavaBackendTask.NXTJavaBackendTask.exception.CouponServiceException;
import com.NXTJavaBackendTask.NXTJavaBackendTask.service.CouponService;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/coupon")
public class CouponController {
    private final CouponService couponService;

    @GetMapping("/")
    public ApplyCouponResponse applyCoupon(@RequestParam String couponCode, @RequestParam long cartId) throws CouponServiceException, CartServiceException {
        return couponService.applyCoupon(couponCode,cartId);
    }

    //If there was security, this endpoint would have been for just the admin
    @PostMapping("/add")
    public AddCouponResponse addCoupon(@RequestBody AddCouponRequest request){
        return couponService.addCoupon(request);
    }
}
