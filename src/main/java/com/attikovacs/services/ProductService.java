package com.attikovacs.services;

import java.util.List;

import com.attikovacs.domain.Product;

public interface ProductService {
    List<Product> listAllProducts();
    
    Product getProductById(Integer id);
}
