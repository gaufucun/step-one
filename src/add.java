


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import teacher.Teacher;

/**
 * Servlet implementation class add
 */
@WebServlet("/add")
public class add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String cancel =request.getParameter("no");
		if("È¡Ïû".equals(cancel)) {
			request.getRequestDispatcher("listTeacher").forward(request, response);
		}
		else {
		
			Teacher teacher_add = new Teacher();
			
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("username");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		String college = request.getParameter("college");
		float salary = Float.parseFloat(request.getParameter("salary"));
		String major = request.getParameter("major");
		
		
		teacher_add.setId(id);
		teacher_add.setName(name);
		teacher_add.setSex(sex);
		teacher_add.setBirthday(birthday);
		teacher_add.setCollege(college);
		teacher_add.setSalary(salary);
		teacher_add.setMajor(major);
		
		new TeacherDao().AddTeacher(teacher_add);
		
		response.sendRedirect("listTeacher");
		}
		
		
			
	}

}
