<%@page import="model.CommunityBean"%>
<%@page import="model.UtenteBean"%>
<%@page import="model.PostBean"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Risultati della Ricerca</title>
    <style>
        /* Stile di base */
        body {
            font-family: Arial, sans-serif;
        }
        .container {
            border: 1px solid #ddd;
            padding: 20px;
            margin: 20px;
            max-width: 600px;
            box-shadow: 2px 2px 10px rgba(0, 0, 0, 0.1);
        }
        .title {
            font-size: 24px;
            font-weight: bold;
        }
        .body-text {
            margin-top: 10px;
            font-size: 16px;
        }
        .info {
            font-size: 14px;
            color: #555;
        }

        /* Stile per gli utenti */
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
    </style>
</head>
<body>
    <h2>Risultati della Ricerca</h2>

    <form action="posts" method="get">
        <input type="hidden" name="mode" value="search" />
        <input type="text" name="query" placeholder="Cerca post per titolo" required />
        <button type="submit">Cerca</button>
    </form>

    <a href="posts?mode=home">Torna alla home</a>
<!-- 
    
     -->
     
     <% 
        List<UtenteBean> utentiCercati = (List<UtenteBean>) request.getAttribute("utenti");
        List<PostBean> searchedPosts = (List<PostBean>) request.getAttribute("posts");
        List<CommunityBean> communityCercate = (List<CommunityBean>) request.getAttribute("community");

        if (utentiCercati != null && !utentiCercati.isEmpty()) { 
    %>
        <h3>Utenti trovati</h3>
        <% 
            for (UtenteBean utente : utentiCercati) { 
        %>
            <div class="user-container">
                <div class="user-name"><%= utente.getUsername() %></div>
                <div class="user-email">Email: <%= utente.getEmail() %></div>
                <p>Follower: <%= utente.getFollower() %></p>
                <p>Seguiti: <%= utente.getSeguiti() %></p>
                <p><strong><%= utente.isBandito() ? "Utente bandito" : "Utente attivo" %></strong></p>
            </div>
        <% 
            } 
        %>
    <% 
        } else if (searchedPosts != null && !searchedPosts.isEmpty()) { 
    %>
        <h3>Post trovati</h3>
        <% 
            for (PostBean post : searchedPosts) { 
        %>
            <div class="container">
                <h3 class="title"><%= post.getTitolo() %></h3>
                <div class="body-text"><%= post.getCorpo() %></div>
                <div class="info">
                    <p>Likes: <%= post.getLikes() %></p>
                    <p>Creato da: <%= post.getUtenteEmail() %></p>
                </div>
            </div>
        <% 
            } 
        %>
    <% 
        } else if(communityCercate != null && !communityCercate.isEmpty()){ 
    %>
    	<h3>Community trovate</h3>
    	<% 
            for (CommunityBean community : communityCercate) { 
        %>
        	<div class="post-container">
	            <h3 class="post-title"><%= community.getNome() %></h3>
	            <p class="post-body"><%= community.getDescrizione() %></p>
	            <div class="post-info">
	                <p>Iscritti: <%= community.getIscritti() %></p>
	                <p>Segnalazioni: <%= community.getSegnalazioni() %></p>
	                <p>Creatore: <%= community.getUtenteEmail() %></p>
	            </div>
	        </div>
        <% 
            } 
        %>
    <% 
        } else { 
    %>
        <p>Nessun risultato trovato con il termine di ricerca fornito.</p>
    <% 
        } 
    %>
    
</body>
</html>
