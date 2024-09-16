package com.mvc.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.mvc.bean.RegisterBean;
import com.mvc.dao.RegisterDao;

public class RegisterServlet extends HttpServlet {
    public RegisterServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Copying all the input parameters into local variables
        String fullName = request.getParameter("fullname");
        String email = request.getParameter("email");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        // Setting the input parameters into a RegisterBean object
        RegisterBean registerBean = new RegisterBean();
        registerBean.setFullName(fullName);
        registerBean.setEmail(email);
        registerBean.setUserName(userName);
        registerBean.setPassword(password);

        // Creating a RegisterDao object
        RegisterDao registerDao = new RegisterDao();

        // Calling registerUser method of RegisterDao to insert data
        String userRegistered = registerDao.registerUser(registerBean);

        // Forwarding the request based on registration success or failure
        if (userRegistered.equals("SUCCESS")) {
            // On success, forward to Home.jsp
            request.getRequestDispatcher("/Home.jsp").forward(request, response);
        } else {
            // On failure, forward back to Register.jsp with error message
            request.setAttribute("errMessage", userRegistered);
            request.getRequestDispatcher("/Register.jsp").forward(request, response);
        }
    }
}
