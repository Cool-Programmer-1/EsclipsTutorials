package com.sajjuproject.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DELL implements Laptop1 {

	@Autowired
	private Price price;

	public Price getprice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public void disp() {
		System.out.println("Laptop is DELL and  Price is = " + price);
	}
}