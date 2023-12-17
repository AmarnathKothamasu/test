package com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Customer;
import com.repositories.CustomerRepository;

@Service
public class CustomerService {

	
	@Autowired
	CustomerRepository customerRespository;
	
	public void save(Customer newCustomer) {
		customerRespository.save(newCustomer);
	}

	public Customer getCustomerByID(int customerId) {
		return customerRespository.findById(customerId);
	}

	public boolean updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		try {
			customerRespository.update(customer);
			return true;
		}
		catch(Exception e) {
			return false;
		}
		
	}

}
