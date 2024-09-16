package com.mvc.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.mvc.dao.LoginDao;
import com.mvc.bean.LoginBean;

public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        LoginBean loginBean = new LoginBean();
        loginBean.setUsername(username);
        loginBean.setPassword(password);

        LoginDao loginDao = new LoginDao();
        String authenticateResult = loginDao.authenticateUser(loginBean);

        if (authenticateResult.equals("SUCCESS")) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("welcome.jsp"); // Redirect to the welcome page upon successful login
        } else {
            request.setAttribute("errorMessage", authenticateResult);
            request.getRequestDispatcher("/login.jsp").forward(request, response); // Forward back to login page with error message
        }
    }
}
