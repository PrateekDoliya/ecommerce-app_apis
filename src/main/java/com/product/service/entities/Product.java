package com.product.service.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document("products")
public class Product {

	private String id;
	private String name;
	private String price;
	private String cat;
	private String cmp;
	
}
