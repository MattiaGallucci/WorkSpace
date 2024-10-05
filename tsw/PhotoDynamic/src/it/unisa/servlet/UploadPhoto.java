package it.unisa.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import it.unisa.PhotoControl;

@WebServlet("/UploadPhoto")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class UploadPhoto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UploadPhoto() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");

		out.write("Error: GET method is used but POST method is required");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");

		for (Part part : request.getParts()) {
			String fileName = part.getSubmittedFileName();
			if (fileName != null && !fileName.equals("")) {
				try {
					PhotoControl.updatePhoto(id, part.getInputStream());
				} catch (SQLException sqlException) {
					System.out.println(sqlException);
				}
			}
		}

		RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
		view.forward(request, response);
	}

}
