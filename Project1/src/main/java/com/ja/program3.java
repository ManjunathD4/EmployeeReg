package com.ja;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class program3 extends HttpServlet{
	
	static private Connection connection;
	private String SQL;
	private PreparedStatement st;
	private ResultSet res;

	@Override
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "ROOT");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("department");
		resp.setContentType("text/html");

		PrintWriter writer = resp.getWriter();
		
		SQL="Select * from `employee` WHERE `ID`=?, `Name`=?";
		try {
			st=connection.prepareStatement(SQL);
			st.setInt(1, id);
			st.setString(2, name);
			
			res=st.executeQuery();
//			
			
			if(res.next()==true)
			{
				 req.getRequestDispatcher("p1").forward(req,resp);
				
			}
			else
			{
				req.getRequestDispatcher("calllogin").forward(req,resp);
				
			}
//			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
