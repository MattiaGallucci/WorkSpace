
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test.xls")
public class Test extends HttpServlet {

	//...
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/vnd.ms-excel");
		PrintWriter out = response.getWriter();
		out.println("\tQ1\tQ2\tQ3\tQ4\tTotal");
		out.println("Apples\t78\t87\t92\t29\t=SOMMA(B2:E2)");
		out.println("Oranges\t77\t86\t93\t30\t=SOMMA(B3:E3)");
		out.close();
	}

	
	private static final long serialVersionUID = 1L;

	public Test() {
		super();
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
