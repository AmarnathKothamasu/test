package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Customer;
import com.entities.Product;
import com.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping("/saveProduct")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		Product newProduct = new Product();
		productService.saveProduct(newProduct);
		return new ResponseEntity<>(newProduct, HttpStatus.CREATED);

	}
	
	@GetMapping("/totalValue")
	public ResponseEntity<Float> totalvalue(){
		float totalValue = productService.getTotalValue();
		return new ResponseEntity<>(totalValue,HttpStatus.OK);
	}

}
