package com.diesgut.market.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diesgut.market.entity.Customer;
import com.diesgut.market.service.ICustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	ICustomerService customerService;

	@GetMapping
	public String index(Model model) {
		List<Customer> clientes = customerService.getAll();
		model.addAttribute("nombre", "diego");
		model.addAttribute("clientes", "clientes");
		return "index";
	}

	@GetMapping("/list")
	public String listarCustomers(Model model) {
		List<Customer> clientes = customerService.getAll();
		model.addAttribute("clientes", clientes);
		return "index";
	}

	@GetMapping("/new")
	public String newCustomer(Model model) {
		model.addAttribute("customer", new Customer());
		return "new";
	}

	@PostMapping("/save")
	public String saveCustomer(Customer customer) {
		try {
			System.out.println("grabara");
			System.out.println(customer.toString());
			customerService.saveOrUpdate(customer);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/customers/list";
	}

}
