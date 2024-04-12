package com.NXTJavaBackendTask.NXTJavaBackendTask.service;

import com.NXTJavaBackendTask.NXTJavaBackendTask.data.dtos.AddToCartResponse;
import com.NXTJavaBackendTask.NXTJavaBackendTask.data.dtos.FetchCartResponse;
import com.NXTJavaBackendTask.NXTJavaBackendTask.data.dtos.ProductDto;
import com.NXTJavaBackendTask.NXTJavaBackendTask.data.model.Cart;
import com.NXTJavaBackendTask.NXTJavaBackendTask.data.model.Coupon;
import com.NXTJavaBackendTask.NXTJavaBackendTask.data.model.Product;
import com.NXTJavaBackendTask.NXTJavaBackendTask.data.repository.CartRepository;
import com.NXTJavaBackendTask.NXTJavaBackendTask.exception.CartServiceException;
import com.NXTJavaBackendTask.NXTJavaBackendTask.exception.ProductServiceException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Service
@Slf4j
public class CartServiceImpl implements CartService{
    private final CartRepository cartRepository;
    private final ProductService productService;
    @Override
    public Cart findCartByCartId(long id) throws CartServiceException {
        if (id<=0){
            throw new CartServiceException("This id is invalid");
        }
       return cartRepository.findCartByCartId(id).orElseThrow(()-> new CartServiceException("Cart with this id does not exist"));
    }

    @Override
    public Cart addCouponToCart(Coupon coupon,Cart cart) throws CartServiceException {
        if (null == coupon){
            throw new CartServiceException("You have to pass a coupon to add");
        }
        cart.setCoupon(coupon);
        return cartRepository.save(cart);
    }

    @Override
    public FetchCartResponse fetchCart(long cartId) throws CartServiceException {
        Cart cart = findCartByCartId(cartId);

        BigDecimal totalAmount = BigDecimal.ZERO;
        if (!cart.getProducts().isEmpty()){
            for (Product product: cart.getProducts()){
                totalAmount = totalAmount.add(BigDecimal.valueOf(product.getPrice()));
            }
        }

        FetchCartResponse fetchCartResponse = FetchCartResponse.builder()
                .totalAmount(totalAmount)
                .totalItems(cart.getProducts().size())
                .message("Success")
                .build();
        if (!cart.getProducts().isEmpty()){
            fetchCartResponse.setProducts(new ArrayList<>());
            for (Product product : cart.getProducts()){
                ProductDto productDto = new ProductDto();
                productDto.setName(product.getName());
                productDto.setPrice(product.getPrice());
                fetchCartResponse.getProducts().add(productDto);
            }
        }
        return fetchCartResponse;
    }

    @Override
    public AddToCartResponse addToCart(long cartId, long productId) throws CartServiceException, ProductServiceException {
        Cart cart =  findCartByCartId(cartId);
        Product product = productService.getProductById(productId);
        cart.getProducts().add(product);
        cartRepository.save(cart);
        return AddToCartResponse.builder()
                .message("Product added to cart successfully")
                .build();
    }

}
