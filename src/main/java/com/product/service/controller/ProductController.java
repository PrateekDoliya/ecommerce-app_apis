package com.product.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.service.entities.Product;
import com.product.service.services.ProductService;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	// CREATE
	@PostMapping("/create")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		Product createProduct = this.productService.createProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(createProduct);
	}

	// UPDATE
	@PutMapping("/update/{productId}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable String productId) {
		Product updateProduct = this.productService.updateProduct(product, productId);
		return ResponseEntity.status(HttpStatus.OK).body(updateProduct);
	}

	// DELETE
	@DeleteMapping("/delete/{productId}")
	public ResponseEntity<Product> deleteProduct(@PathVariable String productId) {
		Product deleteProduct = this.productService.deleteProduct(productId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(deleteProduct);
	}

	// GET BY ID
	@GetMapping("/get/{productId}")
	public ResponseEntity<Product> getProduct(@PathVariable String productId) {
		Product productById = this.productService.getProductById(productId);
		return ResponseEntity.status(HttpStatus.OK).body(productById);
	}

	// GET ALL
	@GetMapping("/get-all")
	public ResponseEntity<List<Product>> getAllProduct() {
		List<Product> allProducts = this.productService.getAllProducts();
		return ResponseEntity.status(HttpStatus.OK).body(allProducts);
	}
}
