package com.kexun.entity;

public class Product {
	private Integer pid;
	private String pname;
	private String detail;
	private Double price;

	public Product(){}
	
	public Product(Integer pid, String pname, String detail, Double price) {
		this.pid = pid;
		this.pname = pname;
		this.detail = detail;
		this.price = price;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
