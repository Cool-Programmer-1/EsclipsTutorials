<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Forgot Password</title>
</head>
<body>
    <center>
        <h2>Forgot Password?</h2>
        <form action="ForgotPasswordController" method="post">
            <input type="text" name="username" placeholder="Enter your username" required>
            <input type="submit" value="Reset Password">
        </form>
        <br/>
        <font color="red">${requestScope.errorMessage}</font>
        <font color="green">${requestScope.successMessage}</font><br></br>
        <b>Please <a href="login.jsp">log-in</a> to continue.</b>
    </center>
</body>
</html>
