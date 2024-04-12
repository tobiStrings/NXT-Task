package com.NXTJavaBackendTask.NXTJavaBackendTask.service;

import com.NXTJavaBackendTask.NXTJavaBackendTask.data.model.Product;
import com.NXTJavaBackendTask.NXTJavaBackendTask.exception.ProductServiceException;

import java.util.List;

public interface ProductService {
    Product getProductById(long id) throws ProductServiceException;

}
