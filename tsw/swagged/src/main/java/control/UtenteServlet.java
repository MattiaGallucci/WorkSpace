package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SegueUtenteBean;
import model.SegueUtenteDAO;
import model.UtenteBean;
import model.UtenteDAO;

/**
 * Servlet implementation class UtenteServlet
 */
@WebServlet("/utenti")
public class UtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mode = request.getParameter("mode");
        UtenteDAO utenteDAO = new UtenteDAO();
        String path = null;
        
        try {
        	if("segui".equalsIgnoreCase(mode)) {
        		String seguaceEmail = (String) request.getSession().getAttribute("email"); // COLUI CHE SEGUE
        		String seguitoEmail = (String) request.getParameter("seguitoEmail");
        		
        		if(seguaceEmail != null) {
        			SegueUtenteDAO segueUtenteDAO = new SegueUtenteDAO();
        			SegueUtenteBean segueUtenteBean = new SegueUtenteBean();
        			
        			if((segueUtenteDAO.doRetrieveByKey(seguaceEmail, seguitoEmail)) == null) {
        				segueUtenteBean.setSeguaceEmail(seguaceEmail);
        				segueUtenteBean.setSeguitoEmail(seguitoEmail);
        				segueUtenteDAO.doSave(segueUtenteBean);
        				
        				UtenteBean seguaceBean = utenteDAO.doRetrieveByEmail(seguaceEmail);
        				seguaceBean.aumentaSeguiti();
        				
        				UtenteBean seguitoBean = utenteDAO.doRetrieveByEmail(seguitoEmail);
        				seguitoBean.aumentaFollower();
        				
        				utenteDAO.doUpdate(seguaceBean, seguaceEmail);
        				utenteDAO.doUpdate(seguitoBean, seguitoEmail);
        			} else {
        				segueUtenteDAO.doDelete(seguaceEmail, seguitoEmail);
        				
        				UtenteBean seguaceBean = utenteDAO.doRetrieveByEmail(seguaceEmail);
        				seguaceBean.diminuisciSeguiti();
        				
        				UtenteBean seguitoBean = utenteDAO.doRetrieveByEmail(seguitoEmail);
        				seguitoBean.diminuisciFollower();
        				
        				utenteDAO.doUpdate(seguaceBean, seguaceEmail);
        				utenteDAO.doUpdate(seguitoBean, seguitoEmail);
        			}
        		}
        		path = "posts?mode=home";
        	} else if("cerca".equalsIgnoreCase(mode)){
        		String searchString = request.getParameter("query");
                List<UtenteBean> utentiCercati = utenteDAO.doRetrieveByUsernameSubstring(searchString);
                request.setAttribute("utenti", utentiCercati);
                path = "searchResults.jsp";
        	}else if("ban".equalsIgnoreCase(mode)) {
        	    String emailToBan = request.getParameter("utenteEmail"); // The email of the user to be banned
        	    UtenteBean utente = utenteDAO.doRetrieveByEmail(emailToBan);

        	    if (utente != null) {
        	        utente.setBandito(true); // Set the bandito attribute to true

        	        // Update the user in the database
        	        utenteDAO.doUpdate(utente, emailToBan);
        	        request.setAttribute("successMessage", "Utente bandito con successo.");
        	    } else {
        	        request.setAttribute("errorMessage", "Utente non trovato.");
        	    }
        	    path = "posts?mode=home"; // Page to redirect after banning
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
