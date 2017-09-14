package com.attikovacs.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.attikovacs.domain.DomainObject;
import com.attikovacs.domain.Product;

@Service
public class ProductServiceImpl extends AbstractMapService implements ProductService {

    @Override
	protected void loadMap() {
    	Product p1 = new Product();
    	p1.setId(1);
    	p1.setDescription("first product");
    	p1.setPrice(new BigDecimal("10.0"));
    	p1.setImageUrl("/product1");
    	map.put(1, p1);
    	
    	Product p2 = new Product();
    	p2.setId(2);
    	p2.setDescription("second product");
    	p2.setPrice(new BigDecimal("11.1"));
    	p2.setImageUrl("/product2");
    	map.put(2, p2);
    	
    	Product p3 = new Product();
    	p3.setId(3);
    	p3.setDescription("third product");
    	p3.setPrice(new BigDecimal("12.2"));
    	p3.setImageUrl("/product3");
    	map.put(3, p3);
    }

	@Override
	public Product getById(Integer id) {
		return (Product) super.getById(id);
	}

	@Override
	public Product saveOrUpdate(Product product) {
		return (Product) super.saveOrUpdate(product);
	}

}
