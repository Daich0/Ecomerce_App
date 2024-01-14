package com.ecomerce.fis.controllers;

import com.ecomerce.fis.models.ProductModel;
import com.ecomerce.fis.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/products3")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ArrayList<ProductModel> getProducts(@RequestParam(defaultValue = "30") int pagesize){
        return this.productService.getProducts(pagesize);
    }

    @PostMapping
    public ProductModel saveProduct(@RequestBody ProductModel product){
        return this.productService.saveProduct(product);
    }

    @GetMapping(path = "/{id}")
    public Optional<ProductModel> getProductById(@PathVariable Long id){
        return productService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public ProductModel updateUserById(@RequestBody ProductModel request, @PathVariable("id") Long id){
        return this.updateUserById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.productService.deleteUser(id);
        if(ok){
            return "User with id is " + id + "deleted";
        }else{
            return "User not finded with " + id;
        }
    }
}
