package com.sajjuproject.springdemo;

import org.springframework.stereotype.Component;

@Component
public class Hp implements Laptop1 {
	public void disp() {
		System.out.println("Laptop is Hp");
	}

}
