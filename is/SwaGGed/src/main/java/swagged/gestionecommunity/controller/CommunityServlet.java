package swagged.gestionecommunity.controller;

import swagged.gestionecommunity.services.GestioneCommunityServiceImpl;
import swagged.model.bean.CommentoBean;
import swagged.model.bean.CommunityBean;
import swagged.model.bean.UtenteBean;
import swagged.model.dao.CommentoDAO;
import swagged.model.dao.CommunityDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/community")
public class CommunityServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final GestioneCommunityServiceImpl gestioneCommunity = new GestioneCommunityServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mode = request.getParameter("mode");

        try {
            if (mode.equals("visualizza")) {
                String nome = request.getParameter("nome");
                CommunityBean community = gestioneCommunity.visualizza(nome);
                request.getSession().setAttribute("community", community);
                response.sendRedirect(request.getContextPath() + "/community.jsp");
            } else if (mode.equals("remove")) {
                String nome = request.getParameter("nome");
                CommunityDAO communityDAO = new CommunityDAO();
                CommunityBean community = communityDAO.getByNome(nome);
                UtenteBean utente = (UtenteBean) request.getSession().getAttribute("utente");
                gestioneCommunity.remove(community, utente);
                request.getSession().setAttribute("utente", utente);
                response.sendRedirect(request.getContextPath() + "/homepage.jsp");
            } else if (mode.equals("cerca")) {
                String substring = request.getParameter("substring");
                List<CommunityBean> risultati = gestioneCommunity.cerca(substring);
                request.getSession().setAttribute("risultati", risultati);
                response.sendRedirect(request.getContextPath() + "/ricerca.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mode = request.getParameter("mode");
        CommunityDAO communityDAO = new CommunityDAO();
        String path = null;

        try{
            if(mode.equals("create")){
                String nome = request.getParameter("communityNomeCreazione");
                String descrizione = request.getParameter("descrizione");
                UtenteBean utente = (UtenteBean) request.getSession().getAttribute("utente");
                CommunityBean community = gestioneCommunity.create(nome, descrizione, utente);
                request.getSession().setAttribute("utente", utente);
                response.sendRedirect(request.getContextPath() + "/community?mode=visualizza&nome=" + community.getNome());
            } else if (mode.equals("iscrizione")) {
                UtenteBean utente = (UtenteBean) request.getSession().getAttribute("utente");
                String nome = request.getParameter("nome");
                CommunityBean community = gestioneCommunity.iscrizione(utente, nome);
                request.getSession().setAttribute("utente", utente);
                response.sendRedirect(request.getContextPath() + "/community?mode=visualizza&nome=" + community.getNome());
            } else if (mode.equals("checkNome")) {
                response.setContentType("text/plain");
                String nome = request.getParameter("nome");

                try {
                    if(gestioneCommunity.checkNome(nome)) {
                        response.getWriter().print("non disponibile");
                    } else {
                        response.getWriter().print("disponibile");
                    }
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
