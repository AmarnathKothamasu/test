package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Customer;
import com.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerContoller {

	@Autowired
	CustomerService customerService;

	@PostMapping("/saveCustomer")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {

		// Saves the new customer
		Customer newCustomer = new Customer();
		customerService.save(newCustomer);
		return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);

	}
	
	@GetMapping("{customerId}")
    public ResponseEntity<Customer> getCustomerByID(@PathVariable("customerId") int customerId) {
        // Logic to retrieve customer by ID
        Customer customer = customerService.getCustomerByID(customerId);
        if (customer != null) {
            return ResponseEntity.ok(customer); // Return customer in the response body
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Return 404 Not Found if customer is not found
        }
    }
	
	 @PutMapping("/updateCustomer")
	    public ResponseEntity<String> updateCustomer(@RequestBody Customer customer) {
	        try {
	            // Logic to update the customer
	            boolean isUpdated = customerService.updateCustomer(customer);

	            if (isUpdated) {
	                return ResponseEntity.ok("Customer updated successfully");
	            } else {
	                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
	            }
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating customer");
	        }
	    }
	
}
