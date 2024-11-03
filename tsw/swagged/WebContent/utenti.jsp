<%@page import="java.util.List"%>
<%@page import="model.UtenteBean"%>
<%@page import="model.UtenteDAO"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
Boolean isAdmin = (Boolean) session.getAttribute("admin");

    // Controlla se l'utente è loggato
    Boolean isLogged = (Boolean) session.getAttribute("logged");
    if (isLogged == null || !isLogged) {
        response.sendRedirect("login.jsp");
        return;
    }

    // Recupera la lista degli utenti
    UtenteDAO utenteDAO = new UtenteDAO();
    List<UtenteBean> utenti = utenteDAO.doRetrieveAll(""); // Assicurati di avere il metodo doRetrieveAll nella classe UtenteDAO
%>

<!DOCTYPE html>
<html>
<head>
    <title>Lista Utenti</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .user-container {
            border: 1px solid #ddd;
            padding: 20px;
            margin: 20px;
            max-width: 400px;
            box-shadow: 2px 2px 10px rgba(0, 0, 0, 0.1);
        }
        .user-name {
            font-size: 20px;
            font-weight: bold;
        }
        .user-email {
            font-size: 16px;
            color: #555;
        }
        .delete-button {
            background-color: red;
            color: white;
            border: none;
            padding: 5px 10px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <h1>Lista degli Utenti</h1>
    <a href="home.jsp">Torna alla Home</a>

    <% if (utenti != null && !utenti.isEmpty()) { %>
        <% for (UtenteBean utente : utenti) { %>
            <div class="user-container">
                <div class="user-name"><%= utente.getUsername()%></div>
                <div class="user-email"><%= utente.getEmail() %></div>
                <p>Follower: <%= utente.getFollower() %></p>
                <p>Seguiti: <%= utente.getSeguiti() %></p>
                <form action="utenti" method="get">
    				<input type="hidden" name="seguitoEmail" value="<%= utente.getEmail()%>" />
    				<input type="hidden" name="mode" value="segui" />
    				<button type="submit">Segui</button>
				</form>
				<% if (isAdmin) { %>
                        <form action="utenti" method="get" style="display:inline;">
                        	<input type="hidden" name="mode" value="ban" />
                            <input type="hidden" name="utenteEmail" value="<%= utente.getEmail() %>" />
                            <button type="submit" class="delete-button">Ban</button>
                        </form>
                    <% } %>
            </div>
        <% } %>
    <% } else { %>
        <p>Nessun utente disponibile.</p>
    <% } %>
</body>
</html>
