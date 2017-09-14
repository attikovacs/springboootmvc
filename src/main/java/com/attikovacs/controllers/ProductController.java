package com.attikovacs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.attikovacs.domain.Product;
import com.attikovacs.services.ProductService;

@RequestMapping(value = "/products")
@Controller
public class ProductController {

	private ProductService productService;

	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping(value = "")
	public String list(Model model) {
		model.addAttribute("products", productService.listAll());
		System.out.println("Returning products");
		return "product/list";
	}

	@RequestMapping(value = "/{id}")
	public String show(@PathVariable Integer id, Model model) {
		model.addAttribute("product", productService.getById(id));
		System.out.println("Showing product " + id);

		return "product/show";
	}

	@RequestMapping(value = "/new")
	public String add(Model model) {
		model.addAttribute("product", new Product());
		System.out.println("Adding product");
		
		return "product/form";
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String save(Product product) {
		Product newProduct = productService.saveOrUpdate(product);
		System.out.println("Saving product");
		return "redirect:/products/edit/" + newProduct.getId();
	}
	
	@RequestMapping(value = "/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		model.addAttribute("product", productService.getById(id));
		System.out.println("Editing product " + id);

		return "product/form";
	}

	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable Integer id) {
		productService.delete(id);
		System.out.println("Deleting product " + id);

		return "redirect:/products";
	}

}
