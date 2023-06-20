package com.product.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.product.service.entities.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
