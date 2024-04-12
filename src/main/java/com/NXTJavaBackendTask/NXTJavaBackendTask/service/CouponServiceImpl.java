package com.NXTJavaBackendTask.NXTJavaBackendTask.service;

import com.NXTJavaBackendTask.NXTJavaBackendTask.data.dtos.AddCouponRequest;
import com.NXTJavaBackendTask.NXTJavaBackendTask.data.dtos.AddCouponResponse;
import com.NXTJavaBackendTask.NXTJavaBackendTask.data.dtos.ApplyCouponResponse;
import com.NXTJavaBackendTask.NXTJavaBackendTask.data.model.Cart;
import com.NXTJavaBackendTask.NXTJavaBackendTask.data.model.Coupon;
import com.NXTJavaBackendTask.NXTJavaBackendTask.data.model.Product;
import com.NXTJavaBackendTask.NXTJavaBackendTask.data.repository.CouponRepository;
import com.NXTJavaBackendTask.NXTJavaBackendTask.exception.CartServiceException;
import com.NXTJavaBackendTask.NXTJavaBackendTask.exception.CouponServiceException;
import com.NXTJavaBackendTask.NXTJavaBackendTask.service.CouponService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@AllArgsConstructor
public class CouponServiceImpl implements CouponService {
    private final CouponRepository couponRepository;
    private final CartService cartService;

    @Override
    public ApplyCouponResponse applyCoupon(String name, long cartId) throws CouponServiceException, CartServiceException {
        //TODO: Find coupon by coupon name,
        Coupon coupon = findCouponByName(name);

        //TODO: Find cart by cart id
        Cart cart = cartService.findCartByCartId(cartId);



        //TODO: Validate rules
        BigDecimal totalCartAmount = BigDecimal.ZERO;
        if (!cart.getProducts().isEmpty()){
            for (Product product: cart.getProducts()){
                totalCartAmount = totalCartAmount.add(BigDecimal.valueOf(product.getPrice()));
            }
        }

        BigDecimal totalDiscountOff = BigDecimal.ZERO;
         BigDecimal discountPercentOff = totalCartAmount.multiply(BigDecimal.valueOf(coupon.getDiscountPercent())).divide(BigDecimal.valueOf(100),2, RoundingMode.HALF_EVEN);
         BigDecimal discountAmountOff = coupon.getDiscountAmount();
        if (coupon.isApplyEither()){
            totalDiscountOff = discountPercentOff.compareTo(discountAmountOff) > 0 ? discountPercentOff : discountAmountOff;
        }else{
                    totalDiscountOff = discountPercentOff.add(discountAmountOff);
        }


        coupon.setCart(cartService.addCouponToCart(coupon,cart));
        couponRepository.save(coupon);

        return ApplyCouponResponse.builder()
                .discountAmountOff(discountAmountOff)
                .discountPercentOff(discountPercentOff)
                .totalDiscountOff(totalDiscountOff)
                .totalAdjustedPrice(totalCartAmount.subtract(totalDiscountOff))
                .message("success")
                .build();
    }

    @Override
    public Coupon findCouponByName(String name) throws CouponServiceException {
        if (null ==  name || name.isEmpty() || name.isBlank()){
            throw new CouponServiceException("coupon name cannot be empty blank or null");
        }


        return couponRepository.findCouponByCouponName(name).orElseThrow( ()-> new CouponServiceException("Coupon does not exist"));
    }

    @Override
    public AddCouponResponse addCoupon(AddCouponRequest addCouponRequest) {

        Coupon coupon = new Coupon();
        coupon.setCouponName(addCouponRequest.getCouponName());
        coupon.setApplicableAmount(addCouponRequest.getApplicableAmount());
        coupon.setApplicableNumberOfItems(addCouponRequest.getApplicableNumberOfItems());
        coupon.setDiscountAmount(addCouponRequest.getDiscountAmount());
        coupon.setDiscountPercent(addCouponRequest.getDiscountPercent());
        coupon.setApplyEither(addCouponRequest.isApplyEither());

        couponRepository.save(coupon);
        return AddCouponResponse.builder()
                .message("Coupon added successfully!")
                .build();
    }

}
