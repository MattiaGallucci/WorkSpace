<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.UtenteBean" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modifica Informazioni Utente</title>
</head>
<body>
    <h1>Modifica le tue informazioni</h1>
    <%
        UtenteBean utente = (UtenteBean) session.getAttribute("utente");
        if (utente == null) {
            utente = new UtenteBean(); // Nel caso l'utente non sia presente nella sessione
        }
    %>
    <form action="ModificaInfoServlet" method="post">
        <label for="email">Email:</label><br>
        <input type="email" id="email" name="email" value="<%= utente.getEmail() %>" required><br><br>
        
        <label for="username">Username:</label><br>
        <input type="text" id="username" name="username" value="<%= utente.getUsername() %>" required><br><br>
        
        <label for="password">Password:</label><br>
        <input type="password" id="password" name="password" value="<%= utente.getPassword() %>" required><br><br>
        
        <label for="nome">Nome:</label><br>
        <input type="text" id="nome" name="nome" value="<%= utente.getNome() %>" required><br><br>
        
        <label for="cognome">Cognome:</label><br>
        <input type="text" id="cognome" name="cognome" value="<%= utente.getCognome() %>" required><br><br>
        
        <input type="submit" value="Salva modifiche">
    </form>
</body>
</html>
