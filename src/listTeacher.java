


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import teacher.Teacher;



/**
 * Servlet implementation class listTeacher
 */
@WebServlet("/listTeacher")
public class listTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listTeacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// È·¶¨Ò³Êý
		List<Teacher> teachers = new TeacherDao().ListTeacher();
		int pageMegNum = 1;		
		if(request.getParameter("pageMegNum")!=null) {
			pageMegNum = Integer.parseInt(request.getParameter("pageMegNum"));
		}else {
			pageMegNum = 10;
		}
		
		
		int pageIndex = 1;
		int totalPage = 1;
		if(teachers.size()%pageMegNum==0) {
			totalPage = teachers.size()/pageMegNum;
		}else {
			totalPage = teachers.size()/pageMegNum+1;
		}				
		if(request.getParameter("pageIndex") == null){
			request.setAttribute("pageIndex", 1);
		}else{
			if(request.getParameter("pageTurn")!=null) {
				if(request.getParameter("pageTurn").equals("up")) {
					 pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
					if(Integer.parseInt(request.getParameter("pageIndex"))!=1) {
						pageIndex = pageIndex-1;
						request.setAttribute("pageIndex", pageIndex);
					}else {
						request.setAttribute("pageIndex", pageIndex);
					}
				}else {
					pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
					if(Integer.parseInt(request.getParameter("pageIndex"))!=totalPage) {
						pageIndex = pageIndex+1;				
						request.setAttribute("pageIndex", pageIndex);
					}else {
						request.setAttribute("pageIndex", pageIndex);
					}
				}				
			}else {
				request.setAttribute("pageIndex",1);
			}
		}	
		request.setAttribute("pageMegNum", pageMegNum);
		request.setAttribute("totalPage", totalPage);
		
		
		
		
		
		//
		
		
		 
        request.setAttribute("teachers", teachers);
		
		request.getRequestDispatcher("listTeacher.jsp").forward(request, response);
	}

}
