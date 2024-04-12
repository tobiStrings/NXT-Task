package com.NXTJavaBackendTask.NXTJavaBackendTask.service;

import com.NXTJavaBackendTask.NXTJavaBackendTask.data.dtos.AddCouponRequest;
import com.NXTJavaBackendTask.NXTJavaBackendTask.data.dtos.AddCouponResponse;
import com.NXTJavaBackendTask.NXTJavaBackendTask.data.dtos.ApplyCouponResponse;
import com.NXTJavaBackendTask.NXTJavaBackendTask.data.model.Coupon;
import com.NXTJavaBackendTask.NXTJavaBackendTask.exception.CartServiceException;
import com.NXTJavaBackendTask.NXTJavaBackendTask.exception.CouponServiceException;

import java.util.List;

public interface CouponService {

    ApplyCouponResponse applyCoupon(String name, long cartId) throws CouponServiceException, CartServiceException;

    Coupon findCouponByName(String name) throws CouponServiceException;

    AddCouponResponse addCoupon(AddCouponRequest addCouponRequest);

}
