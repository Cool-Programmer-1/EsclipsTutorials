<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="in.sp.model.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome Page</title>
</head>
<body>
    
    <%
        User user = (User) session.getAttribute("session_user");
        if (user != null) {
    %>
    
    <h2>Welcome </h2>
    
    <h3>Name: <%= user.getName() %></h3>
    <h3>Email: <%= user.getEmail() %></h3>
    <h3>City: <%= user.getCity() %></h3>
    
    <a href="logout">LogOut</a>
    
    <%
        } else {
    %>
    
    <h2>You are not logged in.</h2>
    
    <a href="login.html">Login</a>
    
    <%
        }
    %>
    
</body>
</html>
