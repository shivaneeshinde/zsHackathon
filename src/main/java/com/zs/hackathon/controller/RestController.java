package com.zs.hackathon.controller;

import java.util.Base64;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.zs.hackathon.entity.Login;
import com.zs.hackathon.entity.Products;
import com.zs.hackathon.entity.Users;
import com.zs.hackathon.exception.ResourceNotFoundException;
import com.zs.hackathon.service.ProductService;
import com.zs.hackathon.service.UserService;


@CrossOrigin(origins = "https://zshackathon.herokuapp.com/")
@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/healthCheck")
	public String check()
	{
		return "checked";
	}	
	
	@GetMapping("/productList")
	public List<Products> teamsList() {
	    System.out.println("Inside teamsList method");
		List<Products> teams = productService.getProductList();
		return teams;
	}
	

	@PostMapping("/addProduct")
	public String addProduct(@RequestBody Products products) {
	    System.out.println("Inside addProduct method");
	    //Products products = new Products("tea","dffsdfsdgsd","red lebel", "23");
	    System.out.println("Products Object is: "+products.toString());
		productService.addProduct(products);
		return "Propducts are added to the table!!";
	}
	
	@GetMapping("/searchProduct/{productName}")
	public Products searchProduct(@PathVariable("productName") String productName){
	    System.out.println("Inside showEmployee method");
		Products products = productService.getProduct(productName);
		return products;
	}
	
	  @DeleteMapping("/deletProduct/{productName}")
	  void deletProduct(@PathVariable("productName") String productName) {
		  System.out.println("Inside deletProduct method");
		  productService.deleteProduct(productName);
	  }

	
	
//
//	@GetMapping("/discussionList")
//	public List<Discussions> discussionList() {
//	    System.out.println("Inside discussionList method");
//		List<Discussions> discussions = discussionsService.getDiscList();
//		return discussions;
//	}
//
//	@GetMapping("/getEventList")
//	public List<Event_Type> getEventList() {
//	    System.out.println("Inside getEventList method");
//		List<Event_Type> event = eventService.getEventList();
//		return event;
//	}
//
//	@GetMapping("/getActivityList")
//	public List<Activities_Scheduled> getActivityList() {
//	    System.out.println("Inside getActivityList method");
//		List<Activities_Scheduled> activity = activityService.getActivityList();
//		return activity;
//	}
	
}
