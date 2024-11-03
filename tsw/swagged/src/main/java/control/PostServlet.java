package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ApprezzaPostBean;
import model.ApprezzaPostDAO;
import model.PostBean;
import model.PostDAO;
import model.SalvaPostBean;
import model.SalvaPostDAO;
import model.SegnalaPostBean;
import model.SegnalaPostDAO;
import model.UtenteBean;

@WebServlet("/posts")
public class PostServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mode = request.getParameter("mode");
        PostDAO postDAO = new PostDAO();
        SalvaPostDAO salvaPostDAO = new SalvaPostDAO();
        String path = null;

        try {
            if ("home".equalsIgnoreCase(mode)) {
                // Recupera più post casuali per la homepage
                List<PostBean> allPosts = postDAO.doRetrieveAll();
                List<PostBean> randomPosts = new ArrayList<>();
                int numberOfPostsToShow = 5; // Numero di post casuali da mostrare

                if (!allPosts.isEmpty()) {
                    Random random = new Random();
                    HashSet<Integer> selectedIndices = new HashSet<>();
                    while (selectedIndices.size() < Math.min(numberOfPostsToShow, allPosts.size())) {
                        int randomIndex = random.nextInt(allPosts.size());
                        selectedIndices.add(randomIndex);
                    }
                    
                    for (int index : selectedIndices) {
                        randomPosts.add(allPosts.get(index));
                    }
                }
                
                request.setAttribute("posts", randomPosts);
                path = "home.jsp"; // Pagina della home
            } else if ("cerca".equalsIgnoreCase(mode)) {
                // Esegui la ricerca per titolo
                String searchString = request.getParameter("query");
                List<PostBean> postCercati = postDAO.doRetrieveByTitleSubstring(searchString);
                request.setAttribute("posts", postCercati);
                path = "searchResults.jsp"; // Pagina dei risultati della ricerca
            } else if ("profile".equalsIgnoreCase(mode)) {
                // Visualizza i post creati dall'utente
                UtenteBean currentUser = (UtenteBean) request.getSession().getAttribute("username");
                if (currentUser != null) {
                    List<PostBean> userPosts = postDAO.doRetrieveByEmail(currentUser.getEmail());
                    request.setAttribute("userPosts", userPosts);
                    
                    // Visualizza i post salvati dall'utente
                    List<SalvaPostBean> savedPosts = salvaPostDAO.doRetrieveByEmail(currentUser.getEmail());
                    request.setAttribute("savedPosts", savedPosts);
                }
                path = "profile.jsp"; // Pagina del profilo utente
            } else if ("elimina".equalsIgnoreCase(mode)) {
                // Elimina il post
                String postIdParam = request.getParameter("postId");
                if (postIdParam != null) {
                    int postId = Integer.parseInt(postIdParam);
                    postDAO.doDelete(postId);
                }
                path="posts?mode=home";
            } else if ("like".equalsIgnoreCase(mode)) {
                // Handle like action
                String utenteEmail = (String) request.getSession().getAttribute("email"); // Get user email from session
                int postId = Integer.parseInt(request.getParameter("postId"));
                if (utenteEmail != null) {
	                ApprezzaPostDAO apprezzaPostDAO = new ApprezzaPostDAO();
	                ApprezzaPostBean apprezzaPostBean = new ApprezzaPostBean();
	                
	                if((apprezzaPostDAO.doRetrieveByKey(utenteEmail, postId) == null)){
	                    apprezzaPostBean.setUtenteEmail(utenteEmail);
	                    apprezzaPostBean.setPostId(postId);
	                    apprezzaPostBean.setApprezzamento(1);
						apprezzaPostDAO.doSave(apprezzaPostBean);
						
						PostBean postBean = postDAO.doRetrieveById(postId);
						postBean.aggiungiLike();
						postDAO.doUpdate(postBean);
                    } else {
                    	apprezzaPostDAO .doDelete(utenteEmail, postId);
    					
    					PostBean postBean = postDAO.doRetrieveById(postId);
    					postBean.rimuoviLike();
    					postDAO.doUpdate(postBean);
                    }
                }
                path = "posts?mode=home"; // Redirect back to home after liking
            } else if("salva".equalsIgnoreCase(mode)) {
            	String utenteEmail = (String) request.getSession().getAttribute("email"); // Get user email from session
                int postId = Integer.parseInt(request.getParameter("postId"));
                if (utenteEmail != null) {
                	salvaPostDAO = new SalvaPostDAO();
                	SalvaPostBean salvaPostBean = new SalvaPostBean();
                	
                	if((salvaPostDAO.doRetrieveByKey(utenteEmail, postId)) == null) {
                		salvaPostBean.setUtenteEmail(utenteEmail);
                		salvaPostBean.setPostId(postId);
                		salvaPostDAO.doSave(salvaPostBean);
                		
                	} else {
                		salvaPostDAO.doDelete(utenteEmail, postId);
                	}
                }
                path = "posts?mode=home";
            } else if("segnala".equalsIgnoreCase(mode)) {
            	String utenteEmail = (String) request.getSession().getAttribute("email"); // Get user email from session
                int postId = Integer.parseInt(request.getParameter("postId"));
                
                if (utenteEmail != null) {
                	SegnalaPostDAO segnalaPostDAO = new SegnalaPostDAO();
                	SegnalaPostBean segnalaPostBean = new SegnalaPostBean();
                	
                	if((segnalaPostDAO.doRetrieveByKey(utenteEmail, postId)) == null) {
                		segnalaPostBean.setUtenteEmail(utenteEmail);
                		segnalaPostBean.setPostId(postId);
                		segnalaPostDAO.doSave(segnalaPostBean);
                		
                		PostBean postBean = postDAO.doRetrieveById(postId);
                		postBean.aggiungiSegnalazione();
                		postDAO.doUpdate(postBean);
                	}
                }
                path = "posts?mode=home";
            } else if("crea".equalsIgnoreCase(mode)) {
            	// Recupera i parametri dal form
                String titolo = request.getParameter("titolo");
                String corpo = request.getParameter("corpo");
                String immagine = request.getParameter("immagine");
                int communityId = Integer.parseInt(request.getParameter("communityId"));
                String utenteEmail = (String) request.getSession().getAttribute("email");

                // Crea il bean del post e impostalo
                PostBean newPost = new PostBean();
                newPost.setTitolo(titolo);
                newPost.setCorpo(corpo);
                newPost.setImmagine(immagine);
                newPost.setSegnalazioni(0);
                newPost.setLikes(0);
                newPost.setUtenteEmail(utenteEmail);
                newPost.setCommunityId(communityId);

                // Salva il post nel database
                postDAO.doSave(newPost);

                // Redirigi alla home
                path = "posts?mode=home";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Errore nel recupero dei dati.");
            path = "error.jsp"; // Pagina di errore
        }

        // Inoltra la richiesta alla pagina appropriata
        RequestDispatcher view = request.getRequestDispatcher(path);
        view.forward(request, response);
    }
    
    
}
