<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>


<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="cyan">
<center>
  <!-- 
    if(request.getAttribute("ERROR")!=null) %>
      	 <div style="color:red">${ERROR}</div>  -->
  
<font color="Blue"><h1> Login Form</h1></font><br/><br/><br/><br/>
<font color=red>${requestScope.ERROR}</font>
<form action="LoginController" method="post">
<font color="blue">UserId</font><input type="text" name=uid><br/>
<font color="blue">Password</font><input type="password" name=pwd><br/>
<font color="blue">UserType</font><select name="utype">
  <option value="">--Please choose an option--</option>
  <option value="admin">Admin</option>
  <option value="faculty">Faculty</option>
  <option value="student">Student</option>
  
</select><br/><br/>
<input type="submit" value="LogIn" name="submit">
<input type="reset" value="Clear"><br/>
<input type="submit" value="NewUser" name="submit">
<input type="Submit" value="ForgotPassword" name="submit">
</form>
</center>
</body>
</html>