package com.green.vo;

public class CafeVO {
	private String coffee;
	private String size;
	private int number;
	private int price;
	private int total;
	
	public String getCoffee() {
		return coffee;
	}
	public void setCoffee(String coffee) {
		this.coffee = coffee;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		if(size.equals("tall")) {
			size = "톨";
		} else if (size.equals("grande")) {
			size = "그란데";
		} else if (size.equals("venti")) {
			size = "벤티";
		}
		this.size = size;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	

	
}
