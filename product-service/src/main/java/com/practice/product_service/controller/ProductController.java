package com.practice.product_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.product_service.entity.Product;
import com.practice.product_service.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	//create a Product
	@PostMapping
	public  Product addProduct(@RequestBody Product objProduct) {
	return productRepository.save(objProduct);
	}
	//get All products
	@GetMapping
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	//get product by ID
	@GetMapping("/{productId}")
	public ResponseEntity<Product> getProductByID(@PathVariable("productId") Long productId){
		Product objProduct=productRepository.findById(productId)
				.orElseThrow(()-> new RuntimeException("Product not Found with ID: "+ productId));
		return ResponseEntity.ok(objProduct);
	}

}
