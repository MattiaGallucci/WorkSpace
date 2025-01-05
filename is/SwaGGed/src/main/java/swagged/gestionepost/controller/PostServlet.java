package swagged.gestionepost.controller;

import swagged.gestionepost.services.GestionePostServiceImpl;
import swagged.model.bean.CommunityBean;
import swagged.model.bean.PostBean;
import swagged.model.bean.UtenteBean;
import swagged.model.dao.PostDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet("/post")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)
public class PostServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final GestionePostServiceImpl gestionePost = new GestionePostServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mode = request.getParameter("mode");
        String path = null;

        try {
            if (mode.equals("visualizza")) {
                int id = Integer.parseInt(request.getParameter("id"));
                PostBean post = gestionePost.visualizza(id);
                request.getSession().setAttribute("post", post);
                response.sendRedirect(request.getContextPath() + "/post.jsp");
            }  else if (mode.equals("like")) {
                UtenteBean utente = (UtenteBean) request.getSession().getAttribute("utente");
                int id = Integer.parseInt(request.getParameter("id"));
                PostBean post = gestionePost.like(utente, id);
                request.getSession().setAttribute("utente", utente);
                response.sendRedirect(request.getContextPath() + "/homepage.jsp");
            } else if (mode.equals("remove")) {
                int id = Integer.parseInt(request.getParameter("id"));
                UtenteBean utente = (UtenteBean) request.getSession().getAttribute("utente");
                gestionePost.remove(id, utente);
                request.getSession().setAttribute("utente", utente);
                response.sendRedirect(request.getContextPath() + "/homepage.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mode = request.getParameter("mode");
        String path = null;

        try {
            if (mode.equals("create")) {
                String titolo = request.getParameter("titolo");
                String corpo = request.getParameter("corpo");
                Part filePart = null;
                try {
                    filePart = request.getPart("immagine"); // Può essere null se l'immagine non è caricata
                } catch (IllegalStateException | IOException | ServletException e) {
                    e.printStackTrace(); // Logga l'errore ma non interrompere l'esecuzione
                }
                UtenteBean utente = (UtenteBean) request.getSession().getAttribute("utente");
                String communityNome = request.getParameter("communityNome");
                PostBean post = gestionePost.create(titolo, corpo, filePart, utente, communityNome, this);
                request.getSession().setAttribute("utente", utente);
                if (post != null) {
                    response.sendRedirect(request.getContextPath() + "/community?mode=visualizza&nome=" + post.getCommunityNome());
                } else {
                    response.sendRedirect(request.getContextPath() + "/error.jsp"); // Gestione degli errori
                }
            } else if (mode.equals("cerca")) {
                String substring = request.getParameter("substring");
                gestionePost.cerca(substring);
            } else if (mode.equals("home")) {
                gestionePost.home();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
