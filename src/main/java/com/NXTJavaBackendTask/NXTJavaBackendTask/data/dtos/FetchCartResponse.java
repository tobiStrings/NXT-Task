package com.NXTJavaBackendTask.NXTJavaBackendTask.data.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@Builder
public class FetchCartResponse {
    private BigDecimal totalAmount;
    private long totalItems;
    private List<ProductDto> products;
    private String message;
}
