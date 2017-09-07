package com.attikovacs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.attikovacs.domain.Product;
import com.attikovacs.services.ProductService;

@Controller
public class ProductController {

	private ProductService productService;

	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping(value = "/products")
	public String listProducts(Model model) {
		model.addAttribute("products", productService.listAllProducts());
		System.out.println("Returning products");
		return "products";
	}

	@RequestMapping(value = "/product/{id}")
	public String showProduct(@PathVariable Integer id, Model model) {
		model.addAttribute("product", productService.getProductById(id));
		System.out.println("Showing product " + id);

		return "product";
	}

	@RequestMapping(value = "/product/new")
	public String newProduct(Model model) {
		model.addAttribute("product", new Product());
		System.out.println("Adding product");
		
		return "productform";
	}
	
	@RequestMapping(value = "/product/edit/{id}")
	public String editProduct(@PathVariable Integer id, Model model) {
		model.addAttribute("product", productService.getProductById(id));
		System.out.println("Editing product " + id);

		return "productform";
	}

	@RequestMapping(value = "/product/delete/{id}")
	public String deleteProduct(@PathVariable Integer id) {
		productService.deleteProduct(id);
		System.out.println("Deleting product " + id);

		return "redirect:/products";
	}
	
	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public String save(Product product) {
		Product newProduct = productService.saveOrUpdateProduct(product);
		System.out.println("Saving product");
		return "redirect:/product/edit/" + newProduct.getId();
	}

}
