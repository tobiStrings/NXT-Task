package com.NXTJavaBackendTask.NXTJavaBackendTask.data.dtos;

import jakarta.validation.GroupSequence;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@GroupSequence({AddCouponRequest.FirstGroup.class, AddCouponRequest.SecondGroup.class})
public class AddCouponRequest {

    @NotNull(groups = FirstGroup.class,message = "coupon name cannot be null")
    @NotBlank(groups = FirstGroup.class,message = "coupon name cannot be blank")
    @NotEmpty(groups = SecondGroup.class,message = "coupon name cannot be empty")
    private String couponName;

    @Positive(groups = FirstGroup.class ,message = "applicable amount cannot be less than or equals to 0.0")
    private BigDecimal applicableAmount;

    @Min(value = 1, message = "Value must be greater than or equal to {value}")
    private long applicableNumberOfItems;

    @Positive(groups = FirstGroup.class ,message = "discount amount cannot be less than or equals to 0.0")
    private BigDecimal discountAmount;

    @DecimalMin(value = "1.0", groups = FirstGroup.class, message = "Value must be greater than or equals to {value} ")
    private double discountPercent;

    private boolean applyEither;

     static class FirstGroup{

    }

     static class SecondGroup{

    }
}
