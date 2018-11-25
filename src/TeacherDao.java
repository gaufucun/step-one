

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import teacher.Teacher;



public class TeacherDao {

	public static void main(String[] args) {

		System.out.println(new TeacherDao().ListTeacher().size());

	}

	public List<Teacher> ListTeacher() {
		List<Teacher> products = new ArrayList<Teacher>();

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/teacher?characterEncoding=UTF-8",
					"root", "root");

			String sql = "select * from teacher_work";

			PreparedStatement ps = c.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Teacher teacher = new Teacher();
				int id = rs.getInt(1);// 可以使用字段名
                String name = rs.getString(2);// 也可以使用字段的顺序
                String sex = rs.getString(3);
                String birthday = rs.getString(4);
                float salary = rs.getFloat(5);
                String college = rs.getString(6);
                String major = rs.getString(7);

                teacher.setId(id);
                teacher.setName(name);
                teacher.setSex(sex);
                teacher.setBirthday(birthday);
                teacher.setSalary(salary);
                teacher.setCollege(college);
                teacher.setMajor(major);
                
				products.add(teacher);

			}

			ps.close();

			c.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}
	//删除教职工信息
	public void DeleteTeacher(int id1) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/teacher?characterEncoding=UTF-8",
					"root", "root");

			String sql = "delete from teacher_work where id= "+id1+" ";

			
			
			Statement  statement =  c.createStatement();
			statement.execute(sql);
			
			
			statement.close();

			c.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	//新增教职工信息
	public void AddTeacher(Teacher teacher) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/teacher?characterEncoding=UTF-8",
					"root", "root");

			String sql = "insert into teacher_work  values("+teacher.getId()+",'"+teacher.getName()+"','"+teacher.getSex()+"','"+teacher.getBirthday()+"',"+teacher.getSalary()+",'"+teacher.getCollege()+"','"+teacher.getMajor()+"')";

			
			
			Statement  statement =  c.createStatement();
			statement.execute(sql);
			
			
			statement.close();

			c.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	//修改教职工信息
	public List<Teacher> ListTeacher(int id1) {
		List<Teacher> products = new ArrayList<Teacher>();

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/teacher?characterEncoding=UTF-8",
					"root", "root");

			String sql = "select * from teacher_work where id = "+id1+" ";

			PreparedStatement ps = c.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Teacher teacher = new Teacher();
				int id = rs.getInt(1);// 可以使用字段名
                String name = rs.getString(2);// 也可以使用字段的顺序
                String sex = rs.getString(3);
                String birthday = rs.getString(4);
                float salary = rs.getFloat(5);
                String college = rs.getString(6);
                String major = rs.getString(7);

                teacher.setId(id);
                teacher.setName(name);
                teacher.setSex(sex);
                teacher.setBirthday(birthday);
                teacher.setSalary(salary);
                teacher.setCollege(college);
                teacher.setMajor(major);
                
				products.add(teacher);

			}

			ps.close();

			c.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}
	//修改数据中的值
	
	public void UpdateTeacher(Teacher teacher) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/teacher?characterEncoding=UTF-8",
					"root", "root");

			String sql = "update teacher_work  set name='"+teacher.getName()+"',salary="+teacher.getSalary()+" ,sex='"+teacher.getSex()+"' ,college='"+teacher.getCollege()+"',major='"+teacher.getMajor()+"',birthday='"+teacher.getBirthday()+"' where id= "+teacher.getId()+" ";

			
			
			Statement  statement =  c.createStatement();
			statement.execute(sql);
			
			
			statement.close();

			c.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}

