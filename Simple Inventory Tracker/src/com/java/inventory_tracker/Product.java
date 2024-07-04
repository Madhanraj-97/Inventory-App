package com.java.inventory_tracker;

public class Product {
	private String name;
	private int stock;
	private int restockThreshold;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getRestockThreshold() {
		return restockThreshold;
	}
	public void setRestockThreshold(int restockThreshold) {
		this.restockThreshold = restockThreshold;
	}
	public Product( String name, int stock, int restockThreshold) {
		super();
		this.name = name;
		this.stock = stock;
		this.restockThreshold = restockThreshold;
	}
	@Override
	public String toString() {
		return "Product Name=" + name + ", stock=" + stock +"]";
	}
	

}
