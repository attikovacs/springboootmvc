package com.attikovacs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.attikovacs.domain.Customer;
import com.attikovacs.services.CustomerService;

@RequestMapping(value = "/customers")
@Controller
public class CustomerController {

	private CustomerService customerService;

	@Autowired
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping(value = "")
	public String list(Model model) {
		model.addAttribute("customers", customerService.listAll());
		System.out.println("Returning customers");
		return "customer/list";
	}

	@RequestMapping(value = "/{id}")
	public String show(@PathVariable Integer id, Model model) {
		model.addAttribute("customer", customerService.getById(id));
		System.out.println("Showing customer " + id);

		return "customer/show";
	}

	@RequestMapping(value = "/new")
	public String add(Model model) {
		model.addAttribute("customer", new Customer());
		System.out.println("Adding customer");
		
		return "customer/form";
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String save(Customer customer) {
		Customer newCustomer = customerService.saveOrUpdate(customer);
		System.out.println("Saving customer");
		return "redirect:/customers/edit/" + newCustomer.getId();
	}
	
	@RequestMapping(value = "/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		model.addAttribute("customer", customerService.getById(id));
		System.out.println("Editing customer " + id);

		return "customer/form";
	}

	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable Integer id) {
		customerService.delete(id);
		System.out.println("Deleting customer " + id);

		return "redirect:/customers";
	}

}