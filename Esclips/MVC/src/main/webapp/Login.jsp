<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Form</title>
</head>
<body bgcolor="cyan">
    <center>
        <font color="blue"><h1>Login Form</h1></font><br/><br/><br/><br/>
        
        <!-- Error message display -->
        <font color="red">${requestScope.ERROR}</font>
        
        <form action="LoginController" method="post">
            <font color="blue">User ID</font><input type="text" name="username"><br/>
            <font color="blue">Password</font><input type="password" name="password"><br/><br/>
            
            <input type="submit" value="Log In" name="submit">
            <input type="reset" value="Clear"><br/><br/>
            <input type="button" value="New User" onclick="window.location.href='register.jsp'">
            <input type="button" value="Forgot Password" onclick="window.location.href='forgotpassword.jsp'">
        </form>
    </center>
</body>
</html>
