<%@page import="java.util.List"%>
<%@page import="model.PostBean"%>
<%@page import="model.CommentoBean"%>
<%@page import="model.PostDAO"%>
<%@page import="model.CommentoDAO"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	Boolean isAdmin = (Boolean) session.getAttribute("admin");
	String userEmail = (String) session.getAttribute("email");

    // Recupera l'ID del post dal parametro della richiesta
    String postIdParam = request.getParameter("postId");
    int postId = (postIdParam != null) ? Integer.parseInt(postIdParam) : -1;

    // Controlla che l'utente sia loggato
    Boolean isLogged = (Boolean) session.getAttribute("logged");
    if (isLogged == null || !isLogged) {
        response.sendRedirect("login.jsp");
        return;
    }

    // Inizializza i DAO per recuperare il post e i commenti
    PostDAO postDAO = new PostDAO();
    CommentoDAO commentoDAO = new CommentoDAO();

    // Recupera il post e i commenti dal database
    PostBean post = postDAO.doRetrieveById(postId);
    List<CommentoBean> commenti = (List<CommentoBean>) request.getAttribute("commenti");

    if (post == null) {
        response.sendRedirect("posts?mode=home");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title><%= post.getTitolo() %></title>
    <style>
        /* Stile base */
        body {
            font-family: Arial, sans-serif;
        }
        .post-container, .comment-container {
            border: 1px solid #ddd;
            padding: 20px;
            margin: 20px;
            max-width: 600px;
            box-shadow: 2px 2px 10px rgba(0, 0, 0, 0.1);
        }
        .post-image, .comment-image {
            width: 100%;
            height: auto;
        }
        .post-title {
            font-size: 24px;
            font-weight: bold;
        }
        .post-body, .comment-body {
            margin-top: 10px;
            font-size: 16px;
        }
        .comment-info {
            font-size: 14px;
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
    <a href="home.jsp">Torna alla Home</a>

    <!-- Visualizza i dettagli del post -->
    <div class="post-container">
        <img src="<%= post.getImmagine() %>" alt="Post Image" class="post-image" />
        <h3 class="post-title"><%= post.getTitolo() %></h3>
        <p class="post-body"><%= post.getCorpo() %></p>
        <div class="post-info">
            <p>Likes: <%= post.getLikes() %></p>
            <p>Segnalazioni: <%= post.getSegnalazioni() %></p>
            <p>Creato da: <%= post.getUtenteEmail() %></p>
        </div>
    </div>

    <!-- Visualizza i commenti relativi al post -->
    <h3>Commenti</h3>
    <% if (commenti != null && !commenti.isEmpty()) { %>
        <% for (CommentoBean commento : commenti) { %>
            <div class="comment-container">
                <p class="comment-body"><%= commento.getCorpo() %></p>
                <div class="comment-info">
                    <p>Likes: <%= commento.getLikes() %></p>
                    <p>Segnalazioni: <%= commento.getSegnalazioni() %></p>
                    <p>Utente: <%= commento.getUtenteEmail() %></p>
                    <form action=commenti method="get">
                    	<input type="hidden" name="mode" value="like"/>
                    	<!-- <input type="hidden" name="postId" value="<%= postId %>" /> -->
                    	<input type="hidden" name="commentoId" value="<%= commento.getId()%>" />
                    	<button type="submit">Like</button>
                    </form>
                    <form action=commenti method="get">
                    	<input type="hidden" name="mode" value="segnala"/>
                    	<input type="hidden" name="commentoId" value="<%= commento.getId() %>" />
                    	<button type="submit">Segnala</button>
                    </form>
                    <% if (isAdmin || userEmail.equals(commento.getUtenteEmail())) { %>
                        <form action="commenti" method="get" style="display:inline;">
                        	<input type="hidden" name="mode" value="elimina" />
                            <input type="hidden" name="commentoId" value="<%= commento.getId() %>" />
                            <button type="submit" class="delete-button">Elimina</button>
                        </form>
                    <% } %>
                </div>
            </div>
        <% } %>
    <% } else { %>
        <p>Nessun commento disponibile.</p>
    <% } %>

    <!-- Form per aggiungere un nuovo commento -->
    <h3>Aggiungi un commento</h3>
    <form action="commenti" method="get">
        <input type="hidden" name="postId" value="<%= post.getId() %>" />
        <input type="hidden" name="mode" value="crea" />
        <textarea name="corpo" rows="4" cols="50" placeholder="Scrivi il tuo commento..." required></textarea><br>
        <button type="submit">Pubblica Commento</button>
    </form>
</body>
</html>
