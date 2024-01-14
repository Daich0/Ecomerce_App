package com.ecomerce.fis.repository;

import com.ecomerce.fis.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {

}
