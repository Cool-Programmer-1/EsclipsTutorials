package com.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NumberFilter implements Filter {

 @Override
 public void init(FilterConfig filterConfig) throws ServletException {
	 System.out.println("init() method is called..");
 }

 @Override
 public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
         throws IOException, ServletException {

     HttpServletRequest req = (HttpServletRequest) request;
     HttpServletResponse res = (HttpServletResponse) response;
     

     String inputNumber1 = request.getParameter("num1");
     String inputNumber2 = request.getParameter("num2");
  
     int num1 = Integer.parseInt(inputNumber1);
     int num2 = Integer.parseInt(inputNumber2);
     


     if ((num1 != 0 && num2 !=0) ) {
         chain.doFilter(request, response);
     } else {
         res.getWriter().println("Invalid input! Please enter a valid number.");
     }
 }

 @Override
 public void destroy() {
     // Cleanup code, if necessary
	 System.out.println("Destory method is called..");
 }
}