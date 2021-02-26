package com.test.customerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.test.customerservice.exception.ResourceNotFoundException;
import com.test.customerservice.model.Customer;
import com.test.customerservice.repository.CustomerRepository;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Agilan
 */
@RestController
@RequestMapping("/api/Customer")
public class CustomerController {

	@Autowired
	CustomerRepository custRepos;

	@GetMapping("/getAll")
	public List<Customer> getAllCustomers() {
		return custRepos.findAll();
	}

	@PostMapping("/create")
	public Customer createCustomer(@Valid @RequestBody Customer customer) {
		return custRepos.save(customer);
	}

	@GetMapping("/get/{id}")
	public Customer getCustomer(@PathVariable(value = "id") Long custId) {
		return custRepos.findById(custId).orElseThrow(() -> new ResourceNotFoundException("Customer", "id", custId));
	}

	@PutMapping("/update")
	public Customer updateCustomer(@Valid @RequestBody Customer custDetails) {
		Customer cust = custRepos.findById(custDetails.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "id", custDetails.getId()));
		cust.setCustomerFirstName(custDetails.getCustomerFirstName());
		cust.setCustomerLastName(custDetails.getCustomerLastName());
		return custRepos.save(cust);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable(value = "id") Long custId) {
		Customer cust = custRepos.findById(custId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "id", custId));
		custRepos.delete(cust);
		return ResponseEntity.ok().build();
	}
}
