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
	private int productId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "image_url")
	private String imageUrl;

	@Column(name = "details")
	private String details;

	@Column(name = "price")
	private String price;
	
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Products(int productId, String productName, String imageUrl, String details, String price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.imageUrl = imageUrl;
		this.details = details;
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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
		return "Products [productId=" + productId + ", productName=" + productName + ", imageUrl=" + imageUrl
				+ ", details=" + details + ", price=" + price + "]";
	}
		
}
