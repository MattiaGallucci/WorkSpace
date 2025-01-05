package swagged.gestioneutenti.controller;

import swagged.model.bean.UtenteBean;
import swagged.model.dao.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Base64;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        Base64.Encoder encoder = Base64.getEncoder();
        String password64 = encoder.encodeToString(request.getParameter("password").getBytes());
        UtenteBean utente = checkLogin(username, password64);

        if (utente != null) {
            PostDAO postDAO = new PostDAO();
            ApprezzaPostDAO apprezzaPostDAO = new ApprezzaPostDAO();
            CommentoDAO commentoDAO = new CommentoDAO();
            CommunityDAO communityDAO = new CommunityDAO();
            IscrivitiCommunityDAO iscrivitiCommunityDAO = new IscrivitiCommunityDAO();
            try {
                utente.set("postCreati", postDAO.getByEmail(utente.getEmail()));
                utente.set("postApprezzati", apprezzaPostDAO.getByEmail(utente.getEmail()));
                utente.set("commentiCreati", commentoDAO.getByUtenteEmail(utente.getEmail()));
                utente.set("communityCreate", communityDAO.getByEmail(utente.getEmail()));
                utente.set("communityIscritto", iscrivitiCommunityDAO.getByEmail(utente.getEmail()));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            request.getSession().setAttribute("logged", true);
            request.getSession().setAttribute("utente", utente);

            response.sendRedirect(request.getContextPath() + "/homepage.jsp");
        } else {
            request.getSession().setAttribute("logged", false);
            request.getSession().setAttribute("error", "Username e/o password invalidi.");
            response.sendRedirect(request.getContextPath() + "/login.jsp?action=error");
        }
    }

    private UtenteBean checkLogin(String username, String password64){
        UtenteDAO database = new UtenteDAO();
        UtenteBean user = new UtenteBean();

        try
        {
            user = database.getByUsername(username);

            if(user.getUsername().equals(username) && user.getPassword().equals(password64)) {
                return user;
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return null;
    }
}
