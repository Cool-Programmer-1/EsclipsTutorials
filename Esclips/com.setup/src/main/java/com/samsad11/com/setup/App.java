package com.samsad11.com.setup;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
//        System.out.println( "Hello World!" );
//        Laptop1 object=new HP();
//        obj.disp();
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//        Laptop1 obj=(Laptop1)context.getBean("dell");
//        obj.disp();

//        Student obj=(Student)context.getBean("student");
//        obj.disp();

		Subject obj = (Subject) context.getBean("subject");
		System.out.println(obj);
		DELL d = (DELL) context.getBean("DELL");
		d.disp();
	}
}