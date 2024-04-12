package com.NXTJavaBackendTask.NXTJavaBackendTask.data.repository;

import com.NXTJavaBackendTask.NXTJavaBackendTask.data.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
