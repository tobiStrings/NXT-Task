package com.NXTJavaBackendTask.NXTJavaBackendTask.service;

import com.NXTJavaBackendTask.NXTJavaBackendTask.data.dtos.AddToCartResponse;
import com.NXTJavaBackendTask.NXTJavaBackendTask.data.dtos.FetchCartResponse;
import com.NXTJavaBackendTask.NXTJavaBackendTask.data.model.Cart;
import com.NXTJavaBackendTask.NXTJavaBackendTask.data.model.Coupon;
import com.NXTJavaBackendTask.NXTJavaBackendTask.exception.CartServiceException;
import com.NXTJavaBackendTask.NXTJavaBackendTask.exception.ProductServiceException;

import java.util.List;

public interface CartService {

    Cart findCartByCartId(long id) throws CartServiceException;
    Cart addCouponToCart(Coupon coupon,Cart cart) throws CartServiceException;
    FetchCartResponse fetchCart(long cartId) throws CartServiceException;

    AddToCartResponse addToCart(long cartId, long productId) throws CartServiceException, ProductServiceException;

}
