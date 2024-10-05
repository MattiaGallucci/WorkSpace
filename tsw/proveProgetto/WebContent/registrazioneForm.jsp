<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Registrazione</title>
</head>
<body>
    <h1>Registrazione</h1>
    <form action="registrazione" method="post">
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" required><br>
        <label for="cognome">Cognome:</label>
        <input type="text" id="cognome" name="cognome" required><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>
        <label for="ripPassword">Ripeti Password:</label>
        <input type="password" id="passwordCheck" name="passwordCheck" required><br>
        <input type="submit" value="Registrati">
    </form>
    <%
        String result = (String) session.getAttribute("result");
        String error = (String) session.getAttribute("error");
        if (result != null) {
            out.println("<p>" + result + "</p>");
            session.removeAttribute("result");
        }
        if (error != null) {
            out.println("<p>" + error + "</p>");
            session.removeAttribute("error");
        }
    %>
</body>
</html>
