import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			List<String> errors = new ArrayList<>();
        	RequestDispatcher dispatcherToLoginPage = request.getRequestDispatcher("login.jsp");

			if(username == null || username.trim().isEmpty()) {
				errors.add("Il campo username non può essere vuoto!");
			}
            if(password == null || password.trim().isEmpty()) {
            	errors.add("Il campo password non può essere vuoto!");
			}
            if (!errors.isEmpty()) {
            	request.setAttribute("errors", errors);
            	dispatcherToLoginPage.forward(request, response);
            	return; // note the return statement here!!!
            }
            
            username = username.trim();
            password = password.trim();
			
			if(username.equals("admin") && password.equals("mypass")){ //admin
				request.getSession().setAttribute("isAdmin", Boolean.TRUE); //inserisco il token nella sessione
				response.sendRedirect("admin/protected.jsp");
			} else if (username.equals("user") && password.equals("mypass")){ //user
				request.getSession().setAttribute("isAdmin", Boolean.FALSE); //inserisco il token nella sessione
				response.sendRedirect("common/protected.jsp");
			} else {
				errors.add("Username o password non validi!");
				request.setAttribute("errors", errors);
				dispatcherToLoginPage.forward(request, response);
			}
	}
	
	private static final long serialVersionUID = 1L;


}
