package com.product.service.services;

import java.util.List;

import com.product.service.entities.Product;

public interface ProductService {

	// CREATE
	Product createProduct(Product product);
	
	// UPDATE
	Product updateProduct(Product product, String productId);
	
	// DELETE
	Product deleteProduct(String productId);
	
	// GET BY ID
	Product getProductById(String productId);
	
	// GET ALL
	List<Product> getAllProducts();
	
}
