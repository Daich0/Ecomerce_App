package com.ecomerce.fis.services;

import com.ecomerce.fis.models.ProductModel;
import com.ecomerce.fis.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public ArrayList<ProductModel> getProducts(int pageSize){
//        Pageable pageable = (Pageable) PageRequest.of(0, pageSize);
//        Page<ProductModel> productPage = productRepository.findAll((org.springframework.data.domain.Pageable) pageable);
//        return (ArrayList<ProductModel>) productRepository.findAll();
        PageRequest pageable = PageRequest.of(0, pageSize);
        Page<ProductModel> productPage = productRepository.findAll(pageable);

        return new ArrayList<>(productPage.getContent());
    }

    public ProductModel saveProduct(ProductModel product){
        return productRepository.save(product);
    }

    public Optional<ProductModel> getById(Long id){
        return productRepository.findById(id);
    }

    public ProductModel updateById(ProductModel newProduct, Long id){
            ProductModel product = productRepository.findById(id).get();
            product.setNombre(newProduct.getNombre());
///? agregar para todos lo mismo
        return  product;
    }

    public Boolean deleteUser(Long id){
        try{
            productRepository.deleteById(id);
            return  true;
        }catch (Exception e){
            return false;
        }
    }
}
