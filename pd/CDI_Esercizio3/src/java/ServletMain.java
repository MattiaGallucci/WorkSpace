import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(urlPatterns = {"/"})
public class ServletMain extends HttpServlet {

    @Inject
    private Library library;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Libreria Musicale</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Libreria Musicale</h1>");

            // Ottenere tutte le canzoni dalla libreria
            List<Song> songs = library.getAllSongs();
            
            if (!songs.isEmpty()) {
                out.println("<ul>");
                for (Song song : songs) {
                    out.println("<li>" + song.toString() + "</li>");
                }
                out.println("</ul>");
            } else {
                out.println("<p>La libreria musicale è vuota.</p>");
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet per visualizzare la libreria musicale";
    }
}
