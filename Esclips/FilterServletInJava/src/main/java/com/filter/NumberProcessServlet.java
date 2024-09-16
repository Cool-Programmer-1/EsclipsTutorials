package com.filter;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/process")
public class NumberProcessServlet extends HttpServlet {

 @Override
 protected void doPost(HttpServletRequest request, HttpServletResponse res)
         throws ServletException, IOException {

    try {
    	 String inputNumber1 = request.getParameter("num1");
         String inputNumber2 = request.getParameter("num2");
         if(inputNumber1.equals(toString()) && inputNumber2.equals(toString()) )
         {
             res.getWriter().println("Invalid User Input....");
         }
         System.out.println();
         
         int num1 = Integer.parseInt(inputNumber1);
         int num2 = Integer.parseInt(inputNumber2);

         if ((num1 != 0 && num2 !=0)) {
        	 int sum = num1 + num2;
             res.getWriter().println("You entered a valid number and your sum is : " + sum);
           
         } else {
             res.getWriter().println("Invalid input! Please enter a valid number.");
         }
    } catch(NumberFormatException e) {
        res.getWriter().println("Invalid input type....");
    	e.printStackTrace();
    }

 }
}