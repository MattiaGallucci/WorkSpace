package it.unisa.ajaxexample.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.ajaxexample.dao.DAOCapoluogoMock;
import it.unisa.ajaxexample.dao.IDAOCapoluogo;
import it.unisa.ajaxexample.model.Capoluogo;

@WebServlet("/cercaCapoluogo")
public class ServletCercaCapoluogo extends HttpServlet {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	private IDAOCapoluogo daoCapoluogo = new DAOCapoluogoMock();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	    	
        response.setContentType("text/xml");
        PrintWriter out = response.getWriter();
        String CAP = request.getParameter("CAP");
        Capoluogo capoluogo = null;
        if (CAP != null && !CAP.equals("")) {
            capoluogo = daoCapoluogo.findCapolougoByCAP(CAP);
        }
        String risultato = null;
        if (capoluogo != null) {
            risultato = capoluogo.getNome() + " (" + capoluogo.getRegione() + ")";
        } else {
            risultato = "non trovato";
        }
        out.println("<?xml version=\"1.0\" encoding=\"iso-8859-1\" ?>");
        out.println("<response>");
        out.println("<functionName>aggiornaDatiCapoluogo</functionName>");
        out.println("<result>" + risultato + "</result>");
        out.println("</response>");
    }
    
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
}
