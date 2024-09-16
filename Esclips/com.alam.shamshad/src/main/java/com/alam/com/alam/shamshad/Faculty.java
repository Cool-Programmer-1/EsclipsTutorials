package com.alam.com.alam.shamshad;

import org.springframework.stereotype.Component;

@Component
public class Faculty implements college{
	
	
	@Override
	public void dispaly() {
		
		System.out.println("faculty class");
	}
	
}
