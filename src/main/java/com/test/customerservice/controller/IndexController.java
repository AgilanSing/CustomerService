package com.test.customerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

	@GetMapping
	public String sayHello() {
		return "Hello and Welcome to the Customer Service application. You can create a new Customer by making a POST request to /api/Customer/create endpoint.";
	}
}
