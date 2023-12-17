package com.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Product;
import com.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired	
	ProductRepository ProductRepository ;

	public void saveProduct(Product Product) {

		 ProductRepository.save(Product);
	}

	public Product getProductByID(int ProductId) {

		 return ProductRepository.findById(ProductId);
	}

	public Float getTotalValue() {

		return ProductRepository.getTotalValue();
	}


}
