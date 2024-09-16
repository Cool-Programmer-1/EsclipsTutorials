package com.mvc.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvc.util.DBConnection;

public class ForgotPasswordController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        
        // Validate username (check database)
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            con = DBConnection.createConnection();
            String query = "select * from login where userName=?";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, username);
            
            resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                // User found, reset password logic (update to a default password or generate a new one)
                String newPassword = "123456"; // Or generate a new one
                query = "update users set password=? where userName=?";
                preparedStatement = con.prepareStatement(query);
                preparedStatement.setString(1, newPassword);
                preparedStatement.setString(2, username);
                int updated = preparedStatement.executeUpdate();
                
                if (updated > 0) {
                    request.setAttribute("successMessage", "Password reset successfully. Your new password is '123456'.");
                } else {
                    request.setAttribute("errorMessage", "Password reset failed. Please try again.");
                }
            } else {
                // User not found, provide feedback
                request.setAttribute("errorMessage", "User not found. Please check your username.");
            }
            
            request.getRequestDispatcher("/forgotpassword.jsp").forward(request, response);
            
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred. Please try again.");
            request.getRequestDispatcher("/forgotpassword.jsp").forward(request, response);
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}