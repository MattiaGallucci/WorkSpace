package swagged.gestionecommenti.controller;

import swagged.gestionecommenti.services.GestioneCommentiServiceImpl;
import swagged.model.bean.UtenteBean;
import swagged.model.dao.CommentoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/commento")
public class CommentoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final GestioneCommentiServiceImpl gestioneCommenti = new GestioneCommentiServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mode = request.getParameter("mode");
        CommentoDAO commentoDAO = new CommentoDAO();
        String path = null;

        try{
            if (mode.equals("remove")) {
                int id = Integer.parseInt(request.getParameter("id"));
                int postId = Integer.parseInt(request.getParameter("postId"));
                UtenteBean utente = (UtenteBean) request.getSession().getAttribute("utente");

                gestioneCommenti.remove(id,postId, utente);
                request.getSession().setAttribute("utente", utente);
                response.sendRedirect(request.getContextPath() + "/homepage.jsp");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mode = request.getParameter("mode");
        CommentoDAO commentoDAO = new CommentoDAO();
        String path = null;

        try{
            if(mode.equals("create")){
                UtenteBean utente = (UtenteBean) request.getSession().getAttribute("utente");
                String email = utente.getEmail();
                int postId = Integer.parseInt(request.getParameter("postId"));
                String corpo = request.getParameter("corpo");
                gestioneCommenti.create(postId, corpo, email);
                response.sendRedirect(request.getContextPath() + "/post?mode=visualizza&id="+postId);
            } else if (mode.equals("visualizza")) {
                int postId = Integer.parseInt(request.getParameter("id"));
                gestioneCommenti.visualizza(postId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
