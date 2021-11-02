package com.zs.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zs.hackathon.entity.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {
	

	Products findByproductName(String productName);
	
	void deleteByproductName(String productName);

}
