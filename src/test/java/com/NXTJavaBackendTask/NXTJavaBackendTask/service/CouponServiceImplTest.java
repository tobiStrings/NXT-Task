package com.NXTJavaBackendTask.NXTJavaBackendTask.service;

import com.NXTJavaBackendTask.NXTJavaBackendTask.data.model.Coupon;
import com.NXTJavaBackendTask.NXTJavaBackendTask.exception.CouponServiceException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import org.junit.jupiter.api.BeforeEach;

import jakarta.validation.Validator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CouponServiceImplTest {


    @Autowired
    private CouponService couponService;

    @BeforeEach
    void setUp(){
//        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    void testThatCouponCannotBeAppliedIfTheCouponNameISNull(){
        CouponServiceException exception = assertThrows(CouponServiceException.class, () -> couponService.findCouponByName(null));
        assertEquals("coupon name cannot be empty blank or null", exception.getMessage());
    }

    @Test
    void testThatCouponCannotBeAppliedIfTheCouponNameIsBlank(){
        CouponServiceException exception = assertThrows(CouponServiceException.class,() ->couponService.applyCoupon(" ",1));
        assertEquals("coupon name cannot be empty blank or null", exception.getMessage());

    }

    @Test
    void testThatCouponCannotBeAppliedIfTheCouponNameIsEmpty(){
        CouponServiceException exception = assertThrows(CouponServiceException.class,() ->couponService.applyCoupon("",1));
        assertEquals("coupon name cannot be empty blank or null", exception.getMessage());

    }

    @Test
    void testThatCouponCannotBeValidatedWhenTheCouponNameDoesNotExistInTheDb(){
        CouponServiceException exception = assertThrows(CouponServiceException.class,() ->couponService.applyCoupon("COupon Mi",1));
        assertEquals("Coupon does not exist", exception.getMessage());

    }

//   @Test
//    void testThat
}