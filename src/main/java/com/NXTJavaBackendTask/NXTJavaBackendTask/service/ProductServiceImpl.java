package com.NXTJavaBackendTask.NXTJavaBackendTask.service;

import com.NXTJavaBackendTask.NXTJavaBackendTask.data.model.Product;
import com.NXTJavaBackendTask.NXTJavaBackendTask.data.repository.ProductRepository;
import com.NXTJavaBackendTask.NXTJavaBackendTask.exception.ProductServiceException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    @Override
    public Product getProductById(long id) throws ProductServiceException {
        if (id<=0){
            throw new ProductServiceException("This id is invalid");
        }
        return productRepository.findById(id).orElseThrow(()-> new ProductServiceException("Product with id "+id + " not found"));
    }

}
