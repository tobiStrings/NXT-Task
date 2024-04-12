package com.NXTJavaBackendTask.NXTJavaBackendTask.data.model;

import com.NXTJavaBackendTask.NXTJavaBackendTask.data.model.Cart;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Setter
@Getter
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long couponId;
    @OneToOne(mappedBy = "coupon")
    private Cart cart;
    private String couponName;
    private BigDecimal applicableAmount;
    private long applicableNumberOfItems;
    private BigDecimal discountAmount;
    private double discountPercent;
    private boolean applyEither;
    @CreationTimestamp
    private Date createdDate;
    @UpdateTimestamp
    private Date updatedDate;
}
