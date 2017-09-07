package com.attikovacs.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.attikovacs.domain.Product;

@Service
public class ProductServiceImpl implements ProductService {

	private HashMap<Integer,Product> products;
	
	public ProductServiceImpl() {
		loadProducts();
	}
	
    @Override
    public List<Product> listAllProducts() {
        return new ArrayList<>(products.values());
    }

    private void loadProducts() {
    	products = new HashMap<>();
    	
    	Product p1 = new Product();
    	p1.setId(1);
    	p1.setDescription("first product");
    	p1.setPrice(new BigDecimal("10.0"));
    	p1.setImageUrl("/product1");
    	products.put(1, p1);
    	
    	Product p2 = new Product();
    	p2.setId(2);
    	p2.setDescription("second product");
    	p2.setPrice(new BigDecimal("11.1"));
    	p2.setImageUrl("/product2");
    	products.put(2, p2);
    	
    	Product p3 = new Product();
    	p3.setId(3);
    	p3.setDescription("third product");
    	p3.setPrice(new BigDecimal("12.2"));
    	p3.setImageUrl("/product3");
    	products.put(3, p3);
    }

	@Override
	public Product getProductById(Integer id) {
		return products.get(id);
	}

	@Override
	public Product saveOrUpdateProduct(Product product) {
		if (product == null) throw new RuntimeException("Product cannot be null");
		
		if (product.getId() == null) {
			product.setId(products.keySet().isEmpty() ? 1 : Collections.max(products.keySet()) + 1);
		}
		
		products.put(product.getId(), product);
		return product;
	}

	@Override
	public void deleteProduct(Integer id) {
		products.remove(id);
	}
}
