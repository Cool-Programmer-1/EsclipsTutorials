<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="ISO-8859-1">
    <title>Login and Logout Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
   
<title>Insert title here</title>

    <style>
        body {
            background-color: #f8f9fa;
            padding-top: 50px;
        }
        .form-login {
            max-width: 330px;
            padding: 15px;
            margin: auto;
        }
        .form-login .form-control {
            position: relative;
            box-sizing: border-box;
            height: auto;
            padding: 10px;
            font-size: 16px;
        }
    </style>
</head>
<body>
    <div class="container">
        <%-- Check if user is logged in --%>
        <%
            String username = (String) session.getAttribute("username");
            if (username == null) {
        %>
        <!-- Login Form -->
        <form class="form-login" method="post" action="login.jsp">
            <h2 class="mb-3">Login</h2>
            <% if (request.getParameter("error") != null) { %>
                <div class="alert alert-danger" role="alert">
                    Invalid username or password!
                </div>
            <% } %>
            <div class="mb-3">
                <label for="username" class="form-label">Username</label>
                <input type="text" id="username" name="username" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" id="password" name="password" class="form-control" required>
            </div>
            <button class="btn btn-primary" type="submit">Sign in</button>
        </form>
        <% } else { %>
        <!-- Logout Form -->
        <form class="form-login" method="post" action="logout.jsp">
            <h2 class="mb-3">Welcome, <%= username %>!</h2>
            <button class="btn btn-primary" type="submit">Logout</button>
        </form>
        <% } %>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>