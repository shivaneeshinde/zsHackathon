package com.zs.hackathon.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="PRODUCT")
public class Products {

	@Id
	@Column(name = "product_id")
	private int product_id;

	@Column(name = "product_name")
	private String product_name;

	@Column(name = "image_url")
	private String image_url;

	@Column(name = "details")
	private String details;

	@Column(name = "price")
	private String price;
	
	

	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Products(int product_id, String product_name, String image_url, String details, String price) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.image_url = image_url;
		this.details = details;
		this.price = price;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Products [product_id=" + product_id + ", product_name=" + product_name + ", image_url=" + image_url
				+ ", details=" + details + ", price=" + price + "]";
	}
	
}
