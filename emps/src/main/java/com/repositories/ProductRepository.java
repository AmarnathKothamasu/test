package com.repositories;

import java.util.List;

import com.entities.Product;

public interface ProductRepository {
	
    void save(Product theProduct);

    Product findById(Integer id);

    List<Product> findAll();

    void update(Product theProduct);

    void delete(Integer id);

    int deleteAll();

    Float getTotalValue();


}
