<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
//Default username and password
String defaultUsername = "220101120029"; // Change this to your desired username
String defaultPassword = "Shamshad1"; // Change this to your desired password

// Get the entered username and password from the form
String username = request.getParameter("username");
String password = request.getParameter("password");

// Check if entered username and password match the default values
if (username != null && password != null && username.equals(defaultUsername) && password.equals(defaultPassword)) {
    // If authentication succeeds, set the username in session and redirect to dashboard.jsp
    session.setAttribute("username", username);
    response.sendRedirect("dashboard.jsp");
} else {
    // If authentication fails, redirect back to index.jsp with an error parameter
    response.sendRedirect("index.jsp?error=1");
}
%>