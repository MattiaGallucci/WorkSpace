<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="model.ProdottoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.UtenteBean" %>
<!DOCTYPE html>
<html>
<head>
    <title>Gestione</title>
</head>
<body>
    <h1>Gestione</h1>
    
    <%
        Boolean isLoggedIn = (Boolean) session.getAttribute("logged");
        if (isLoggedIn != null && isLoggedIn) {
            String nome = (String) session.getAttribute("nome");
            String cognome = (String) session.getAttribute("cognome");
            out.println("<p>Welcome, " + nome + " " + cognome + "!</p>");
        } else {
            out.println("<p>Please <a href='loginForm.jsp'>login</a> to continue.</p>");
        }

        String error = (String) session.getAttribute("error");
        if (error != null) {
            out.println("<p style='color:red;'>" + error + "</p>");
            session.removeAttribute("error"); // Rimuovi l'attributo per evitare di visualizzarlo nuovamente
        }
    %>
    
    <ul>
        <li><a href="mostraIndirizzi.jsp">Mostra Indirizzi</a></li>
        <li><a href="mostraCategorie.jsp">Mostra Categorie</a></li>
        <li><a href="mostraInserimenti.jsp">Mostra Inserimenti</a></li>
        <li><a href="mostraMetodiDiPagamento.jsp">Mostra Metodi Di Pagamento</a></li>
        <li><a href="mostraOrdini.jsp">Mostra Ordini</a></li>
        <li><a href="mostraProdotti.jsp">Mostra Prodotti</a></li>
        <li><a href="mostraUtenti.jsp">Mostra Utenti</a></li>
        <li><a href="loginForm.jsp">Login</a></li>
        <li><a href="LogOutServlet">Logout</a></li>
        <li><a href="registrazioneForm.jsp">Registrati</a></li>
    </ul>
    
    <%
        List<ProdottoBean> prodotti = (List<ProdottoBean>) request.getAttribute("prodotti");
        if (prodotti != null) {
            for (ProdottoBean prodotto : prodotti) {
    %>
                <div class="main_card">
                    <p><%= prodotto.getNome() %></p>
                </div>
    <%
            }
        } else {
            out.println("<p>Nessun prodotto disponibile.</p>");
        }
    %>
</body>
</html>
