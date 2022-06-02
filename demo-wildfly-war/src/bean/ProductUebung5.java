package edu.thi.uebung5.bean;

import java.io.Serializable;
import java.util.Date;

public class ProductUebung5 implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String productname;
	private Integer quantity;
	private Date proddate;
	private Date prodtime;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
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
}
