package com.attikovacs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.attikovacs.services.ProductService;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/products")
    public String list(Model model){
        model.addAttribute("products", productService.listAllProducts());
        System.out.println("Returning products");
        return "products";
    }
    
    @RequestMapping(value = "/product/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.getProductById(id));
        System.out.println("Editing product " + id);
        return "product";
    }

}
