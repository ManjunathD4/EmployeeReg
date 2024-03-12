package com.ja;

import java.io.IOException;




import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.first;
import com.java.four;
public class program1 extends HttpServlet {
	private static PreparedStatement st;
	private Statement st1;
	
	

	
	String url="jdbc:mysql://localhost:3306/jdbc";
	String user="root";
	String password="ROOT";
	String SQL="insert  into `employee` (`ID`,`Name`,`Email`,`Department`,`Salary`)"
			+ "values(?,?,?,?,?)";
	
	private Connection con;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.setContentType("text/html");
		PrintWriter o=resp.getWriter();
		String id=req.getParameter("id");
		int id1=Integer.parseInt(id);
		String n=req.getParameter("name");
		String e=req.getParameter("Email");
		String d=req.getParameter("dept");
		String s=req.getParameter("Sal");
		int s1=Integer.parseInt(s); 
		 
		
		try {
			st=con.prepareStatement(SQL);
			
			st.setInt(1, id1);
			st.setString(2, n);
			st.setString(3, e);
			st.setString(4, d);
			st.setInt(5, s1);
			
			st.executeUpdate();
			
			
			RequestDispatcher rd=req.getRequestDispatcher("p1");
			rd.include(req, resp);
			 
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
	    
		
		
			
		     
		    
			
		
		
//		ok.println("<h1>Hello"+" "+fn+" "+ln+"</h1>");
//		ok.println("<h3>Your Record has been saved</h3>");
	//	System.out.println("hello"+fn+" "+ ln);
	}

	

}
