


import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class filter
 */
@WebFilter("/listTeacher.jsp")
public class filter implements Filter {

    /**
     * Default constructor. 
     */
    public filter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
	}
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
        HttpServletRequest httpRequest=(HttpServletRequest)request;
        String uri = httpRequest.getRequestURI();
		if(uri.endsWith("/login.jsp") || uri.endsWith("/login"))
		{
			chain.doFilter(request, response);
			return;			
		}       
		HttpSession httpSession = httpRequest.getSession();
		if(httpSession.getAttribute("user") == null)
		{
			HttpServletResponse httpServletResponse = (HttpServletResponse)response;
			httpServletResponse.sendRedirect("login.jsp");
		}
		else
		{
			chain.doFilter(request, response);
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
