package com.samsad11.com.setup;

import org.springframework.stereotype.Component;

@Component
public class Price {
	private String price;

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "50000";
	}
}