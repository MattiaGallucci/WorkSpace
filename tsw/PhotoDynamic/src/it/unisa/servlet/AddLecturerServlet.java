package it.unisa.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.LecturerControl;
import it.unisa.model.Lecture;

@WebServlet("/addLecturer")
public class AddLecturerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddLecturerServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		String name = (String) request.getParameter("name");
		String surname = (String) request.getParameter("surname");
		if (name != null && !name.equals("") && surname != null && !surname.equals("")) 
		{
			Lecture model = new Lecture();
			model.setName(name);
			model.setSurname(surname);
			
			LecturerControl.add(model);		
		}
		
		List<Lecture> model = LecturerControl.load();
		request.setAttribute("lecturers", model);
			
		RequestDispatcher dispatcher = this.getServletContext().
				getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
