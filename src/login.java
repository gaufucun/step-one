


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException  {
		String username = request.getParameter("username");
        String password = request.getParameter("psw");
       
        if ("1095894554".equals(username) && "chen5544".equals(password)) {      
        	HttpSession httpSession = request.getSession();
			httpSession.setAttribute("username",username);
            response.sendRedirect("listTeacher");
        } else
            response.sendRedirect("login.jsp");
	
	}

}
