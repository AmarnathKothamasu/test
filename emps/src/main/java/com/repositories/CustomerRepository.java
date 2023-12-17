package com.repositories;

import java.util.List;

import com.entities.Customer;

public interface CustomerRepository {
	
    void save(Customer theCustomer);

    Customer findById(Integer id);

    List<Customer> findAll();

    List<Customer> findByLastName(String theLastName);

    void update(Customer theCustomer);

    void delete(Integer id);

    int deleteAll();

}
