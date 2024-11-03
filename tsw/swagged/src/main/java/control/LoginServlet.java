package control;

import model.UtenteBean;
import model.UtenteDAO;


import java.io.IOException;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Base64.Encoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("usernameLogin");
        Encoder encoder = Base64.getEncoder();
        String password64 = encoder.encodeToString(request.getParameter("passwordLogin").getBytes());
        //System.out.println("Password codificata durante il login: " + password64); // Aggiungi questa riga
        UtenteBean user = checkLogin(username, password64);

        if (user != null) {
            request.getSession().setAttribute("username", user.getUsername());
            request.getSession().setAttribute("email", user.getEmail());
            request.getSession().setAttribute("password", user.getPassword());
            request.getSession().setAttribute("logged", true);

            if (user.isAdmin()) {
                request.getSession().setAttribute("admin", true);
                response.sendRedirect("index.jsp");
            } else {
                request.getSession().setAttribute("admin", false);
                response.sendRedirect("index.jsp");
            }


        } else {
            request.getSession().setAttribute("logged", false);
            request.getSession().setAttribute("error", "Username e/o password invalidi.");
            response.sendRedirect("login.jsp?action=error");
        }
    }

    private UtenteBean checkLogin(String username, String password64)
    {
        UtenteDAO database = new UtenteDAO();
        UtenteBean user = new UtenteBean();

        try
        {
            user = database.doRetrieveByUsername(username);

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
