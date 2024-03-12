package com.ja;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class query extends HttpServlet{
	
		Scanner sc=new Scanner(System.in);
		String name="root";
		String password="ROOT";
		String url="jdbc:mysql://localhost:3306/jdbc";
		private Connection con;
		private Statement st;
		String p="Select * from `employee`";
		private ResultSet res;
		
	@Override
	public void init() throws ServletException {
	// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	      	con=DriverManager.getConnection(url, name, password);
	      	
	      	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} 
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	try {
		resp.setContentType("text/html");
		st=con.createStatement();
		res=st.executeQuery(p);
		PrintWriter op=resp.getWriter();

		op.println("<table border=5>\r\n"
				+ " <tr>\r\n"
				+ "     <th>Id</th>\r\n"
				+ "     <th>Name</th>\r\n"
				+ "     <th>Email</th>\r\n"
				+ "     <th>Department</th>\r\n"
				+ "     <th>Salary</th>\r\n"
				+ " </tr>");
		
      	while(res.next())
		{
			int id=res.getInt("ID");
			String name=res.getString("Name");
			String email=res.getString("Email");
			String dept=res.getString("Department");
			int salary=res.getInt("Salary");
		//	System.out.println(id+" "+name+" "+email+" "+dept+" "+salary); 
			op.println("<tr>\r\n"
					+ "     <td>" + id + "</td>\r\n"
					+ "     <td>" + name + "</td>\r\n"
					+ "     <td>" + email + "</td>\r\n"
					+ "     <td>" + dept + "</td>\r\n"
					+ "     <td>" + salary + "</td>\r\n"
					+ " </tr>");
		
		}
      	op.println("</table>");

      	
//      	op.println("Do You Want to add more values(YES/NO)");
//      	if(sc.next().equalsIgnoreCase("Yes"))
//      	{
//      		RequestDispatcher rd= req.getRequestDispatcher("callprogram");
//      		rd.include(req, resp);
//      		
//      	}
//      	else {
//      		op.println("<center><h1>Thank You</h1></center>");
//      	}
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
