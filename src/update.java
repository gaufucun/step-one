


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import teacher.Teacher;

/**
 * Servlet implementation class update
 */
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        int id = Integer.parseInt(request.getParameter("name"));
		
		List<Teacher> teachers = new TeacherDao().ListTeacher(id);
		 
        request.setAttribute("teachers", teachers);
		request.getRequestDispatcher("update.jsp").forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		
	else 
	{
		
		Teacher teacher_update = new Teacher();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("username");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		String college = request.getParameter("college");
		float salary = Float.parseFloat(request.getParameter("salary"));
		String major = request.getParameter("major");
		
		
		teacher_update.setId(id);
		teacher_update.setName(name);
		teacher_update.setSex(sex);
		teacher_update.setBirthday(birthday);
		teacher_update.setCollege(college);
		teacher_update.setSalary(salary);
		teacher_update.setMajor(major);
		
		new TeacherDao().UpdateTeacher(teacher_update);
		request.getRequestDispatcher("listTeacher").forward(request, response);
	}
		
	}

}
