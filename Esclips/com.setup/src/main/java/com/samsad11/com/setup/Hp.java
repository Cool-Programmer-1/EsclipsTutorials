package com.samsad11.com.setup;

import org.springframework.stereotype.Component;

@Component
public class Hp implements Laptop1 {
	public void disp() {
		System.out.println("Laptop is Hp");
	}

}
