import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class AccessControlFilter
 */
@WebFilter(filterName = "/AccessControlFilter", urlPatterns = "/*")
public class AccessControlFilter extends HttpFilter implements Filter {
       
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		
		Boolean isAdmin = (Boolean) httpServletRequest.getSession().getAttribute("isAdmin");
		String path = httpServletRequest.getServletPath();
		System.out.println(path);
		if (path.contains("/common/") && isAdmin==null) {
			httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login.jsp");
			return;
		} else if (path.contains("/admin/") && (isAdmin==null || !isAdmin)) {
			httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login.jsp");
			return;
		}
		
		chain.doFilter(request, response);
	}

	private static final long serialVersionUID = 1L;

}
