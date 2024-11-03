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

import model.CommunityBean;
import model.CommunityDAO;
import model.SegnalaCommentoDAO;
import model.SegnalaCommunityBean;
import model.SegnalaCommunityDAO;
import model.SegueCommunityBean;
import model.SegueCommunityDAO;

/**
 * Servlet implementation class CommunityServlet
 */
@WebServlet("/community")
public class CommunityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mode = request.getParameter("mode");
        CommunityDAO communityDAO = new CommunityDAO();
        String path = null;
        
        try {
        	if("cerca".equalsIgnoreCase(mode)) {
        		String searchString = request.getParameter("query");
                List<CommunityBean> communityCercate = communityDAO.doRetrieveByNameSubstring(searchString);
                request.setAttribute("community", communityCercate);
                path = "searchResults.jsp";
        	} else if("iscrizione".equalsIgnoreCase(mode)) {
        		String utenteEmail = (String) request.getSession().getAttribute("email"); // Get user email from session
        		int communityId = Integer.parseInt(request.getParameter("communityId"));
        		if (utenteEmail != null) {
        			SegueCommunityDAO segueCommunityDAO = new SegueCommunityDAO();
        			SegueCommunityBean segueCommunityBean = new SegueCommunityBean();
        			
        			if((segueCommunityDAO.doRetrieveByKey(utenteEmail, communityId)) == null) {
        				segueCommunityBean.setUtenteEmail(utenteEmail);
        				segueCommunityBean.setCommunityId(communityId);
        				segueCommunityDAO.doSave(segueCommunityBean);
        				
        				CommunityBean communityBean = communityDAO.doRetrieveById(communityId);
        				communityBean.aggiungiIscritto();
        				communityDAO.doUpdate(communityBean);
        				
        			} else {
        				segueCommunityDAO.doDelete(utenteEmail, communityId);
        				
        				CommunityBean communityBean = communityDAO.doRetrieveById(communityId);
        				communityBean.rimuoviIscritto();
        				communityDAO.doUpdate(communityBean);
        			}
        		}
        		path = "posts?mode=home";
        	} else if("segnala".equalsIgnoreCase(mode)) {
        		String utenteEmail = (String) request.getSession().getAttribute("email"); // Get user email from session
        		int communityId = Integer.parseInt(request.getParameter("communityId"));
        		
        		if (utenteEmail != null) {
        			SegnalaCommunityDAO segnalaCommunityDAO = new SegnalaCommunityDAO();
        			SegnalaCommunityBean segnalaCommunityBean = new SegnalaCommunityBean();
        			
        			if((segnalaCommunityDAO.doRetrieveByKey(utenteEmail, communityId)) == null) {
        				segnalaCommunityBean.setUtenteEmail(utenteEmail);
        				segnalaCommunityBean.setCommunityId(communityId);
        				segnalaCommunityDAO.doSave(segnalaCommunityBean);
        				
        				CommunityBean communityBean = communityDAO.doRetrieveById(communityId);
        				communityBean.aggiungiSegnalazione();
        				communityDAO.doUpdate(communityBean);
        			}
        		}
        		path = "posts?mode=home";
        	} else if("crea".equalsIgnoreCase(mode)) {
        		String nome = request.getParameter("nome");
        		String descrizione = request.getParameter("descrizione");
        		String utenteEmail = (String) request.getSession().getAttribute("email");

        		CommunityBean newCommunity = new CommunityBean();
        		newCommunity.setNome(nome);
        		newCommunity.setDescrizione(descrizione);
        		newCommunity.setSegnalazioni(0);
        		newCommunity.setIscritti(0);
        		newCommunity.setUtenteEmail(utenteEmail);
        		
        		communityDAO.doSave(newCommunity);
        		
        		path = "posts?mode=home";
        	} else if("elimina".equalsIgnoreCase(mode)) {
        		int communityId = Integer.parseInt(request.getParameter("communityId"));
        		communityDAO.doDelete(communityId);
        		
        		path="posts?mode=home";
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
