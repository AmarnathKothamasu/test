package com.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entities.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

	private EntityManager entityManager;
	
	@Autowired
	public CustomerRepositoryImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	 // implement save method
    @Override
    @Transactional
    public void save(Customer theCustomer) {
        entityManager.persist(theCustomer);
    }

    @Override
    public Customer findById(Integer id) {
        return entityManager.find(Customer.class, id);
    }

    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> theQuery = entityManager.createQuery("FROM Customer", Customer.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Customer> findByLastName(String theLastName) {
        // create query
        TypedQuery<Customer> theQuery = entityManager.createQuery(
                                        "FROM Customer WHERE lastName=:theData", Customer.class);

        // set query parameters
        theQuery.setParameter("theData", theLastName);

        // return query results
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Customer theCustomer) {
        entityManager.merge(theCustomer);
    }

    @Override
    @Transactional
    public void delete(Integer id) {

        // retrieve the Customer
        Customer theCustomer = entityManager.find(Customer.class, id);

        // delete the Customer
        entityManager.remove(theCustomer);
    }

    @Override
    @Transactional
    public int deleteAll() {

        int numRowsDeleted = entityManager.createQuery("DELETE FROM Customer").executeUpdate();

        return numRowsDeleted;
    }

}
