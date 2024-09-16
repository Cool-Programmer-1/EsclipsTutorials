<!DOCTYPE html>
<html>
<head>
    <title>Number Check</title>
</head>
<body>
    <h1>Enter a Number</h1>

    <!-- Display error message if available -->
    <c:if test="${not empty errorMessage}">
        <p style="color: red;">${errorMessage}</p>
    </c:if>

    <form action="NumberCheckServlet" method="post">
        <label for="number">Number:</label>
        <input type="text" id="number" name="number" required>
        <br><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>