<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration</title>
</head>
<body>

<form action="regForm" method="post">

Name : <input type="text" name="name1"/><br><br/>
Email : <input type="text" name="email1"/><br/><br/>
Password : <input type="password" name="pass1"/> <br/><br/>
Gender : <input type="radio" name="gender1" value="Male" /> Male 
        <input type="radio" name="gender1" value="Female" /> Female <br/><br/>
City : <select name="City1">
        <option value="city name">Select City</option>
        <option value="Bettiah">Bettiah</option>
        <option value="Delhi">Delhi</option>
        <option value="Hydrabad">Hydrabad</option>
        <option value="Bhubneshwar">Bhubneshwar</option>
       </select> <br/><br/>
    
       
         
<input type="submit" name="Register"/>

</form>

</body>
</html>