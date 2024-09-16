<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
    <center>
        <h1>Welcome, ${sessionScope.username}!</h1>
        <p>You have successfully logged in.</p>
        <!-- Add more content or functionality as needed -->
        
        <!-- Example link to logout -->
        <p><a href="LogoutController">Logout</a></p>
    </center>
</body>
</html>
