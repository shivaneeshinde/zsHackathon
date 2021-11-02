package com.zs.hackathon.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.zs.hackathon.entity.Products;
import com.zs.hackathon.repository.ProductRepository;

@Service
@Transactional
public class ProductService {
	
	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	
	public List<Products> getProductList() {
	    System.out.println("Inside getActivityList method");	    
		return this.productRepository.findAll();
	}
	

	public void addProduct(Products products) {
		System.out.println("Inside addProduct");
		productRepository.save(products);
		System.out.println("SAVED!!!");
	}
	
	public void deleteProduct(String productName) {
		System.out.println("Inside deleteProduct");
		productRepository.deleteByproductName(productName);
		System.out.println("deleted Product!!!");
	}
	
	
	public Products getProduct(String productName){
		System.out.println("Inside getProduct");
		Products products = productRepository.findByproductName(productName);
				//.orElseThrow( () -> new ResourceNotFoundException("Employee not found for this id: " + email) );
		
		System.out.println("Product is: "+products.toString());				
		return products;
	}

}
