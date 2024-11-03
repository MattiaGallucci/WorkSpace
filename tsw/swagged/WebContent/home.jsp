<%@page import="model.CommunityDAO"%>
<%@page import="model.CommunityBean"%>
<%@page import="model.ApprezzaPostDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.PostBean"%>
<%@page import="java.util.List"%>
<%@page import="model.SalvaPostBean"%>
<%@page import="model.SalvaPostDAO"%>
<%@page import="model.PostDAO"%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    Boolean isLogged = (Boolean) session.getAttribute("logged");
    Boolean isAdmin = (Boolean) session.getAttribute("admin");
    String userEmail = (String) session.getAttribute("email");

    if (isLogged == null || !isLogged) {
        response.sendRedirect("login.jsp");
        return;
    }

    // Recupera i post casuali dalla servlet
    List<PostBean> randomPosts = (List<PostBean>) request.getAttribute("posts");
    SalvaPostDAO salvaPostDAO = new SalvaPostDAO();
    
    List<SalvaPostBean> savedPosts = new ArrayList<>();

    // Recupera i post salvati dell'utente
    if (userEmail != null) {
        savedPosts = salvaPostDAO.doRetrieveByEmail(userEmail);
    }

    // Recupera i dettagli dei post salvati
    PostDAO postDAO = new PostDAO();
    List<PostBean> savedPostDetails = new ArrayList<>();
    for (SalvaPostBean savedPost : savedPosts) {
        PostBean post = postDAO.doRetrieveById(savedPost.getPostId());
        if (post != null) {
            savedPostDetails.add(post);
        }
    }
    
    CommunityDAO communityDAO = new CommunityDAO();
    List<CommunityBean> communities = (List<CommunityBean>) communityDAO.doRetrieveAll();

%>

<!DOCTYPE html>
<html>
<head>
    <title>Homepage</title>
    <style>
        /* Stile di base */
        body {
            font-family: Arial, sans-serif;
        }
        .post-container {
            border: 1px solid #ddd;
            padding: 20px;
            margin: 20px;
            max-width: 600px;
            box-shadow: 2px 2px 10px rgba(0, 0, 0, 0.1);
        }
        .post-image {
            width: 100%;
            height: auto;
        }
        .post-title {
            font-size: 24px;
            font-weight: bold;
        }
        .post-body {
            margin-top: 10px;
            font-size: 16px;
        }
        .post-info {
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
    <h2>Benvenuto, <%= session.getAttribute("username") %>!</h2>
    <p>Email: <%= session.getAttribute("email") %></p>

    <a href="LogoutServlet">Logout</a>

    <!-- Visualizza i post casuali -->
    <% if (randomPosts != null && !randomPosts.isEmpty()) { %>
        <% for (PostBean randomPost : randomPosts) { %>
            <div class="post-container">
                <img src="<%= randomPost.getImmagine() %>" alt="Post Image" class="post-image" />
                <h3 class="post-title"><%= randomPost.getTitolo() %></h3>
                <p class="post-body"><%= randomPost.getCorpo() %></p>
                <div class="post-info">
                    <p>Likes: <%= randomPost.getLikes() %></p>
                    <p>Segnalazioni: <%= randomPost.getSegnalazioni() %></p>
                    <p>Creato da: <%= randomPost.getUtenteEmail() %></p>
                    <form action=posts method="get">
                    	<input type="hidden" name="mode" value="like"/>
                    	<input type="hidden" name="postId" value="<%= randomPost.getId() %>" />
                    	<button type="submit">Like</button>
                    </form>
                    <form action=posts method="get">
                    	<input type="hidden" name="mode" value="salva"/>
                    	<input type="hidden" name="postId" value="<%= randomPost.getId() %>" />
                    	<button type="submit">Salva</button>
                    </form>
                    <form action=posts method="get">
                    	<input type="hidden" name="mode" value="segnala"/>
                    	<input type="hidden" name="postId" value="<%= randomPost.getId() %>" />
                    	<button type="submit">Segnala</button>
                    </form>
                    <form action="commenti" method="get">
    					<input type="hidden" name="postId" value="<%= randomPost.getId() %>" />
    					<input type="hidden" name="mode" value="visualizza" />
    					<button type="submit">Visualizza Commenti</button>
					</form>
                    <% if (isAdmin || userEmail.equals(randomPost.getUtenteEmail())) { %>
                        <form action="posts" method="get" style="display:inline;">
                        	<input type="hidden" name="mode" value="elimina" />
                            <input type="hidden" name="postId" value="<%= randomPost.getId() %>" />
                            <button type="submit" class="delete-button">Elimina</button>
                        </form>
                    <% } %>
                </div>
            </div>
        <% } %>
    <% } else { %>
        <p>Nessun post disponibile.</p>
    <% } %>
    
    <form action="posts" method="get">
    	<input type="hidden" name="mode" value="cerca" />
    	<input type="text" name="query" placeholder="Cerca post per titolo" required />
    	<button type="submit">Cerca</button>
	</form>
	<form action="utenti" method="get">
    	<input type="hidden" name="mode" value="cerca" />
    	<input type="text" name="query" placeholder="Cerca utenti per username" required />
    	<button type="submit">Cerca</button>
	</form>
	<form action="community" method="get">
    	<input type="hidden" name="mode" value="cerca" />
    	<input type="text" name="query" placeholder="Cerca community per nome" required />
    	<button type="submit">Cerca</button>
	</form>
	
	<h3>Crea un nuovo post</h3>
		<form action="posts" method="get" enctype="multipart/form-data">
    		<input type="hidden" name="mode" value="crea" />
		    <label for="titolo">Titolo:</label>
		    <input type="text" id="titolo" name="titolo" required maxlength="50" />
    
		    <label for="corpo">Corpo:</label>
		    <textarea id="corpo" name="corpo" required maxlength="512"></textarea>
		    
		    <label for="immagine">URL Immagine:</label>
		    <input type="text" id="immagine" name="immagine" maxlength="512" />
		    
		    <label for="communityId">Community ID:</label>
		    <input type="number" id="communityId" name="communityId" required />
		    
		    <button type="submit">Crea Post</button>
		</form>
	


    <h3>Post Salvati</h3>
    <% if (!savedPostDetails.isEmpty()) { %>
        <% for (PostBean savedPost : savedPostDetails) { %>
            <div class="post-container">
                <img src="<%= savedPost.getImmagine() %>" alt="Post Image" class="post-image" />
                <h3 class="post-title"><%= savedPost.getTitolo() %></h3>
                <p class="post-body"><%= savedPost.getCorpo() %></p>
                <div class="post-info">
                    <p>Likes: <%= savedPost.getLikes() %></p>
                    <p>Segnalazioni: <%= savedPost.getSegnalazioni() %></p>
                    <p>Creato da: <%= savedPost.getUtenteEmail() %></p>
                    <% if (isAdmin || userEmail.equals(savedPost.getUtenteEmail())) { %>
                        <form action="posts?mode=delete" method="get" style="display:inline;">
                            <input type="hidden" name="postId" value="<%= savedPost.getId() %>" />
                            <button type="submit" class="delete-button">Elimina</button>
                        </form>
                    <% } %>
                </div>
            </div>
        <% } %>
    <% } else { %>
        <p>Nessun post salvato.</p>
    <% } %>
    
    <%-- Sezione per visualizzare le community --%>
	<h3>Community</h3>
	<% 
	    if (communities != null && !communities.isEmpty()) { 
	%>
	    <% for (CommunityBean community : communities) { %>
	        <div class="post-container">
	            <h3 class="post-title"><%= community.getNome() %></h3>
	            <p class="post-body"><%= community.getDescrizione() %></p>
	            <div class="post-info">
	                <p>Iscritti: <%= community.getIscritti() %></p>
	                <p>Segnalazioni: <%= community.getSegnalazioni() %></p>
	                <p>Creatore: <%= community.getUtenteEmail() %></p>
	                <form action="community" method="get">
	                    <input type="hidden" name="mode" value="iscrizione"/>
	                    <input type="hidden" name="communityId" value="<%= community.getId() %>" />
	                    <button type="submit">Iscriviti</button>
	                </form>
	                <% if (isAdmin || userEmail.equals(community.getUtenteEmail())) { %>
	                    <form action="community" method="get" style="display:inline;">
	                        <input type="hidden" name="mode" value="elimina" />
	                        <input type="hidden" name="communityId" value="<%= community.getId() %>" />
	                        <button type="submit" class="delete-button">Elimina</button>
	                    </form>
	                <% } %>
	            </div>
	        </div>
	    <% } %>
	<% } else { %>
	    <p>Nessuna community disponibile.</p>
	<% } %>
    

<a href="utenti.jsp">Visualizza Utenti</a>
<br>
<a href="account?mode=profilo">Visualizza Profilo</a>
</body>
</html>
