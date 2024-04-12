package com.NXTJavaBackendTask.NXTJavaBackendTask.data.dtos;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Builder
public class ApplyCouponResponse {
   private BigDecimal totalDiscountOff;
   private BigDecimal discountPercentOff;
   private BigDecimal discountAmountOff;
   private BigDecimal totalAdjustedPrice;
   private String message;
}
