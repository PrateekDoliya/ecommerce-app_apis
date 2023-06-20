package com.product.service.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.service.entities.Product;
import com.product.service.exception.ResourceNotFoundException;
import com.product.service.repository.ProductRepository;
import com.product.service.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product createProduct(Product product) {
		Product savedProduct = this.productRepository.save(product);
		return savedProduct;
	}

	@Override
	public Product updateProduct(Product product, String productId) {
		Product product2 = this.productRepository.findById(productId).orElseThrow( () -> new ResourceNotFoundException("Product", "product_id", productId));
		product2.setCat(product.getCat());
		product2.setCmp(product.getCmp());
		product2.setPrice(product.getPrice());
		product2.setPrice(product.getPrice());
		return this.productRepository.save(product2);
	}

	@Override
	public Product deleteProduct(String productId) {
		Product product = this.productRepository.findById(productId).orElseThrow( () -> new ResourceNotFoundException("Product", "product_id", productId));
		this.productRepository.delete(product);
		return product;
	}

	@Override
	public Product getProductById(String productId) {
		Product product = this.productRepository.findById(productId).orElseThrow( () -> new ResourceNotFoundException("Product", "product_id", productId));
		return product;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> allProducts = this.productRepository.findAll();
		return allProducts;
	}

}
