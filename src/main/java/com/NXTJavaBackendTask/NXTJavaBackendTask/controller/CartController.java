package com.NXTJavaBackendTask.NXTJavaBackendTask.controller;

import com.NXTJavaBackendTask.NXTJavaBackendTask.data.dtos.AddToCartResponse;
import com.NXTJavaBackendTask.NXTJavaBackendTask.data.dtos.FetchCartResponse;
import com.NXTJavaBackendTask.NXTJavaBackendTask.data.model.Cart;
import com.NXTJavaBackendTask.NXTJavaBackendTask.data.model.Coupon;
import com.NXTJavaBackendTask.NXTJavaBackendTask.data.model.Product;
import com.NXTJavaBackendTask.NXTJavaBackendTask.exception.CartServiceException;
import com.NXTJavaBackendTask.NXTJavaBackendTask.exception.ProductServiceException;
import com.NXTJavaBackendTask.NXTJavaBackendTask.service.CartService;
import com.NXTJavaBackendTask.NXTJavaBackendTask.service.CouponService;
import com.NXTJavaBackendTask.NXTJavaBackendTask.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/cart")
public class CartController {

    private final CartService cartService;
    private final CouponService couponService;
    private final ProductService productService;

    @GetMapping("/")
    public FetchCartResponse fetchCart(@RequestParam long cartId) throws CartServiceException {
        return cartService.fetchCart(cartId);
    }

    @PutMapping("/add/")
    public AddToCartResponse addToCart(@RequestParam long cartId, @RequestParam long productId) throws CartServiceException, ProductServiceException {
        return cartService.addToCart(cartId,productId);
    }

}
