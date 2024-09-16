package com.alam.com.alam.shamshad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component
public class collegeService {
	
	@Autowired
	@Qualifier("Faculty")
	private  college clg ;// interface
	
	
	public college getClg() {
		return clg;
	}

	public void setClg(college clg) {
		this.clg = clg;
	}
	
	public void show_details() {
		clg.dispaly();
	}
	
}
