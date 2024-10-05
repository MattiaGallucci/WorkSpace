package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.model.AddressBean;
import model.IndirizzoBean;
import model.IndirizzoDAO;
import model.MetodoDiPagamentoBean;
import model.MetodoDiPagamentoDAO;
import model.UtenteBean;
import model.UtenteDAO;

@WebServlet("/ModificaInfoServlet")
public class ModificaInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public ModificaInfoServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String action = request.getParameter("action");
        ArrayList<IndirizzoBean> indirizzi = new ArrayList<>();
        IndirizzoDAO indirizzo = new IndirizzoDAO();
        ArrayList<MetodoDiPagamentoBean> metodiDiPagamento = new ArrayList<>();
        try {
			indirizzi = (ArrayList<>) indirizzo.doRetrieveByClient(client.getUsername());
		} catch (SQLException e) {
            LOGGER.log( Level.SEVERE, e.toString(), e );
            response.sendRedirect("generalError.jsp");
            return;
        }
        request.setAttribute("addresses", indirizzi);
        request.setAttribute("payments", metodiDiPagamento);
        s
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
