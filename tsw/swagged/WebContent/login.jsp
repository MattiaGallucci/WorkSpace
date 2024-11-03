<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h2>Login</h2>

    <% 
        String error = (String) session.getAttribute("error");
        if (error != null) {
    %>
        <p style="color:red;"><%= error %></p>
    <% 
        session.removeAttribute("error");
        } 
    %>

    <form action="login" method="post">
        <label for="usernameLogin">Username:</label>
        <input type="text" id="usernameLogin" name="usernameLogin" required><br><br>

        <label for="passwordLogin">Password:</label>
        <input type="password" id="passwordLogin" name="passwordLogin" required><br><br>

        <input type="submit" value="Login">
        
    </form>
</body>
</html>
