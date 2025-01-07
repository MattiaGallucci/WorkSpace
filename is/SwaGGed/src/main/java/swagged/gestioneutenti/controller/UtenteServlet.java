package swagged.gestioneutenti.controller;

import swagged.gestioneutenti.services.GestioneUtentiServiceImpl;
import swagged.model.bean.UtenteBean;
import swagged.model.dao.UtenteDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/utente")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)
public class UtenteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final GestioneUtentiServiceImpl gestioneUtenti = new GestioneUtentiServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mode = request.getParameter("mode");
        String path = null;
        UtenteDAO utenteDAO = new UtenteDAO();

        try {
            if (mode.equals("visualizza")) {
                String username = request.getParameter("username");
                UtenteBean profilo = gestioneUtenti.visualizza(username);
                request.getSession().setAttribute("profilo", profilo);
                UtenteBean utente = (UtenteBean) request.getSession().getAttribute("utente");
                if(utente == null)
                    response.sendRedirect(request.getContextPath() + "/utente.jsp");
                else if(profilo.getUsername().equals(utente.getUsername())) {
                    response.sendRedirect(request.getContextPath() + "/common/profilo.jsp");
                }else
                    response.sendRedirect(request.getContextPath() + "/utente.jsp");
            } else if (mode.equals("ban")) {
                String emailToBan = request.getParameter("utenteEmail"); // The email of the user to be banned
                UtenteBean bannato = utenteDAO.getByEmail(emailToBan);
                gestioneUtenti.ban(emailToBan);
                response.sendRedirect(request.getContextPath() + "/utente?mode=visualizza&username=" + bannato.getUsername());
            } else if (mode.equals("cerca")) {
                String substring = request.getParameter("substring");
                List<UtenteBean> risultati = gestioneUtenti.cerca(substring);
                request.getSession().setAttribute("risultati", risultati);
                response.sendRedirect(request.getContextPath() + "/ricerca.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mode = request.getParameter("mode");
        String path = null;
        UtenteDAO utenteDAO = new UtenteDAO();

        try {
            if (mode.equals("modificaImmagine")) {
                UtenteBean utente = (UtenteBean) request.getSession().getAttribute("utente");
                Part filePart = request.getPart("immagine");
                gestioneUtenti.modificaImmagine(utente, filePart, this);
                request.setAttribute("utente", utente);
                System.out.println("Servelt: "+utente);
                response.sendRedirect(request.getContextPath() + "/homepage.jsp");
            }else if(mode.equals("checkEmail")) {
                response.setContentType("text/plain");
                String email = request.getParameter("email");

                try {
                    if(gestioneUtenti.checkEmail(email)) {
                        response.getWriter().print("non disponibile");
                    } else {
                        response.getWriter().print("disponibile");
                    }
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else if(mode.equals("checkUsername")) {
                response.setContentType("text/plain");
                String username = request.getParameter("username");

                try {
                    if(gestioneUtenti.checkUsername(username)) {
                        response.getWriter().print("non disponibile");
                    } else {
                        response.getWriter().print("disponibile");
                    }
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
