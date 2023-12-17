package com.repositories;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;

import com.entities.Product;
import com.utilities.Constants;

import ExceptionHandlers.ExceptionHandlerController;

import com.entities.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	private EntityManager entityManager;

	private Constants constants;

	@Autowired
	ExceptionHandlerController exceptionalHandlerController;

	@Autowired
	public ProductRepositoryImpl(EntityManager entityManager, Constants constants) {
		this.entityManager = entityManager;
		this.constants = constants;
	}

	// implement save method
	@Override
	@Transactional
	public void save(Product theProduct) {
		entityManager.persist(theProduct);
	}

	@Override
	public Product findById(Integer id) {
		return entityManager.find(Product.class, id);
	}

	@Override
	public List<Product> findAll() {
		TypedQuery<Product> theQuery = entityManager.createQuery("FROM Product", Product.class);
		return theQuery.getResultList();
	}

	@Override
	@Transactional
	public void update(Product theProduct) {
		Integer id = theProduct.getProduct_id();
		Product existingProduct = entityManager.find(Product.class,id);
		if(existingProduct!=null) {
		entityManager.merge(theProduct);
		}
		else {
			exceptionalHandlerController.handleNotFoundException(new NotFoundException());
			
			}
	}

	@Override
	@Transactional
	public void delete(Integer id) {

		// retrieve the Product
		Product theProduct = entityManager.find(Product.class, id);

		// delete the Product
		entityManager.remove(theProduct);
	}

	@Override
	@Transactional
	public int deleteAll() {

		int numRowsDeleted = entityManager.createQuery("DELETE FROM Product").executeUpdate();

		return numRowsDeleted;
	}

	@Override
	public Float getTotalValue() {

		TypedQuery<Float> query = entityManager
				.createQuery("SELECT SUM(p.product_count * p.product_price) FROM product p", Float.class);
		Float totalValuation = query.getSingleResult();

		return totalValuation;
	}

}
