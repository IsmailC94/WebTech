package edu.thi.uebung5.bean;

import java.util.Date;

public class Product {
	private Long productId;
	private String productName;
	private Integer articleGroup;
	private Integer quantity;
	private Double price;
	private Date proddate;
	private Date prodtime;
	
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public Integer getArticleGroup() {
		return articleGroup;
	}
	public void setArticleGroup(Integer articleGroup) {
		this.articleGroup = articleGroup;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	
	public Date getProddate() {
		return proddate;
	}
	public void setProddate(Date proddate) {
		this.proddate = proddate;
	}
	public Date getProdtime() {
		return prodtime;
	}
	public void setProdtime(Date prodtime) {
		this.prodtime = prodtime;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
