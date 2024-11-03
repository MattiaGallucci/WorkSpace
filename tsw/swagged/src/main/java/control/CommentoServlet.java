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

import model.ApprezzaCommentoBean;
import model.ApprezzaCommentoDAO;
import model.CommentoBean;
import model.CommentoDAO;
import model.SegnalaCommentoBean;
import model.SegnalaCommentoDAO;
import model.SegnalaCommunityBean;

/**
 * Servlet implementation class CommentoServlet
 */
@WebServlet("/commenti")
public class CommentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mode = request.getParameter("mode");
		CommentoDAO commentoDAO = new CommentoDAO();
		String path = null;
		
		try {
			if("visualizza".equalsIgnoreCase(mode)) {
				String postIdParam = request.getParameter("postId");
				int postId = -1;
                if (postIdParam != null) {
                    postId = Integer.parseInt(postIdParam);
                }
                List<CommentoBean> commenti = commentoDAO.doRetrieveByPostId(postId);
                request.setAttribute("commenti", commenti);
                
                path="post.jsp";
			} else if("crea".equalsIgnoreCase(mode)) {
				String postIdParam = request.getParameter("postId");
				int postId = -1;
                if (postIdParam != null) {
                    postId = Integer.parseInt(postIdParam);
                }
                String corpo = request.getParameter("corpo");
                String utenteEmail = (String) request.getSession().getAttribute("email");
                
                CommentoBean newCommento = new CommentoBean();
                newCommento.setCorpo(corpo);
                newCommento.setSegnalazioni(0);
                newCommento.setLikes(0);
                newCommento.setPadre(0);
                newCommento.setUtenteEmail(utenteEmail);
                newCommento.setPostId(postId);
                
                commentoDAO.doSave(newCommento);
                
                path="posts?mode=home"; //modificare in modo che si rimane nella pagina del post
			} else if("like".equalsIgnoreCase(mode)) {
				String utenteEmail = (String) request.getSession().getAttribute("email"); // Get user email from session
				int commentoId = Integer.parseInt(request.getParameter("commentoId"));
				//String postIdParam = request.getParameter("postId");
				//int postId = -1;
                /*if (postIdParam != null) {
                    postId = Integer.parseInt(postIdParam);
                }*/
                if (utenteEmail != null) {
                	ApprezzaCommentoDAO apprezzaCommentoDAO = new ApprezzaCommentoDAO();
                	ApprezzaCommentoBean apprezzaCommentoBean = new ApprezzaCommentoBean();
                	
                	if((apprezzaCommentoDAO.doRetrieveByKey(utenteEmail, commentoId)) == null) {
                		apprezzaCommentoBean.setUtenteEmail(utenteEmail);
                		apprezzaCommentoBean.setCommentoId(commentoId);
                		apprezzaCommentoBean.setApprezzamento(1);
                		apprezzaCommentoDAO.doSave(apprezzaCommentoBean);
                		
                		CommentoBean commentoBean = commentoDAO.doRetrieveById(commentoId);
                		commentoBean.aggiungiLike();
                		commentoDAO.doUpdate(commentoBean);
                	} else {
                		apprezzaCommentoDAO.doDelete(utenteEmail, commentoId);
                		
                		CommentoBean commentoBean = commentoDAO.doRetrieveById(commentoId);
                		commentoBean.rimuoviLike();
                		commentoDAO.doUpdate(commentoBean);
                	}
                }
                path="posts?mode=home"; //modificare in modo che si rimane nella pagina del post
			} else if("segnala".equalsIgnoreCase(mode)) {
				String utenteEmail = (String) request.getSession().getAttribute("email"); // Get user email from session
				int commentoId = Integer.parseInt(request.getParameter("commentoId"));
                
				if (utenteEmail != null) {
					SegnalaCommentoDAO segnalaCommentoDAO = new SegnalaCommentoDAO();
					SegnalaCommentoBean segnalaCommentoBean = new SegnalaCommentoBean();
					
					if((segnalaCommentoDAO.doRetrieveByKey(utenteEmail, commentoId)) == null) {
						segnalaCommentoBean.setUtenteEmail(utenteEmail);
						segnalaCommentoBean.setCommentoId(commentoId);
						segnalaCommentoDAO.doSave(segnalaCommentoBean);
						
						CommentoBean commentoBean = commentoDAO.doRetrieveById(commentoId);
						commentoBean.aggiungiSegnalazione();
						commentoDAO.doUpdate(commentoBean);
						
					}
				}
				path="posts?mode=home"; //modificare in modo che si rimane nella pagina del post
			} else if("elimina".equalsIgnoreCase(mode)) {
				int commentoId = Integer.parseInt(request.getParameter("commentoId"));
                commentoDAO.doDelete(commentoId);
                
                path="posts?mode=home"; //modificare in modo che si rimane nella pagina del post
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
