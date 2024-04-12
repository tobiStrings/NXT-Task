package com.NXTJavaBackendTask.NXTJavaBackendTask.service;

import com.NXTJavaBackendTask.NXTJavaBackendTask.data.dtos.FetchCartResponse;
import com.NXTJavaBackendTask.NXTJavaBackendTask.data.model.Cart;
import com.NXTJavaBackendTask.NXTJavaBackendTask.data.model.Coupon;
import com.NXTJavaBackendTask.NXTJavaBackendTask.data.model.Product;
import com.NXTJavaBackendTask.NXTJavaBackendTask.data.repository.CartRepository;
import com.NXTJavaBackendTask.NXTJavaBackendTask.exception.CartServiceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class CartServiceImplTest {

    @Autowired
    private CartServiceImpl cartService;

    @Autowired
    private CartRepository cartRepository;

    @Test
    void testFindCartByCartId_ValidId() throws CartServiceException {
        long validCartId = 1L;
        Cart mockCart = new Cart();
        mockCart.setCartId(validCartId);
        when(cartRepository.findCartByCartId(validCartId)).thenReturn(Optional.of(mockCart));

        Cart result = cartService.findCartByCartId(validCartId);

        assertEquals(mockCart, result);
    }

    @Test
    void testFindCartByCartId_InvalidId() {
        long invalidCartId = 0L;

        assertThrows(CartServiceException.class, () -> cartService.findCartByCartId(invalidCartId));
    }

    @Test
    void testAddCouponToCart() throws CartServiceException {
        Cart cart = new Cart();
        Coupon coupon = new Coupon();
        coupon.setCouponId(1L);

        when(cartRepository.save(cart)).thenReturn(cart);

        Cart result = cartService.addCouponToCart(coupon, cart);

        assertEquals(coupon, result.getCoupon());
    }

    @Test
    void testAddCouponToCart_NullCoupon() {
        Cart cart = new Cart();

        assertThrows(CartServiceException.class, () -> cartService.addCouponToCart(null, cart));
    }

    @Test
    void testFetchCart() throws CartServiceException {
        long cartId = 1L;
        Cart cart = new Cart();
        cart.setCartId(cartId);
        Product product1 = new Product();
        product1.setName("Product 1");
        product1.setPrice(100.0);
        Product product2 = new Product();
        product2.setName("Product 2");
        product2.setPrice(200.0);
        cart.getProducts().add(product1);
        cart.getProducts().add(product2);

        when(cartRepository.findCartByCartId(cartId)).thenReturn(Optional.of(cart));

        FetchCartResponse result = cartService.fetchCart(cartId);

        assertEquals(BigDecimal.valueOf(30), result.getTotalAmount());
        assertEquals(2, result.getTotalItems());
        assertEquals("Success", result.getMessage());
    }

}