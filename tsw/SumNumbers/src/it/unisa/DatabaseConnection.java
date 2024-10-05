package it.unisa;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(name="DatabaseConnectionServlet", urlPatterns={"/connection"})
public class DatabaseConnection extends HttpServlet
{

    public DatabaseConnection()
    {
    	super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
		doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        String forward = "/index.jsp";
        String value = null;
        String number1 = request.getParameter("first");
        String number2 = request.getParameter("second");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        request.removeAttribute("result");
        
        try
        {
            value = DatabaseOperation.operation(login, password,number1, number2);
            request.setAttribute("result", value);
        }
        catch(Exception e)
        {
            request.setAttribute("error", e.getLocalizedMessage());
        }
        request.setAttribute("first", number1);
        request.setAttribute("second", number2);
        request.setAttribute("login", login);
        request.setAttribute("password", password);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(forward);
        dispatcher.forward(request, response);    	
    }

    private static final long serialVersionUID = 1L;
}
