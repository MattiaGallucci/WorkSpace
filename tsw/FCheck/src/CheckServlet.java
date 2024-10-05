

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CheckServlet")
public class CheckServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String error = "";

		String name = request.getParameter("name");
		String surname = request.getParameter("surname");

		if (name == null || name.trim().equals("")) {
			error += "Insert name<br>";
		} else {
			request.setAttribute("name", name.trim());
		}

		if (surname == null || surname.trim().equals("")) {
			error += "Insert surname<br>";
		} else {
			request.setAttribute("surname", surname.trim());
		}

		if (!error.equals("")) {
			request.setAttribute("error", error);
		} else {
			String message = "Name:" + name + " Surname:" + surname;
			request.setAttribute("message", message);
		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/checkForm.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
