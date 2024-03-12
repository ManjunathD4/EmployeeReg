package com.ja;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.java.first;

public class data {

	static String SQL="Insert into `employee`(`ID`,`Name`,`Email`,`Department`,`Salary`) values(?,?,?,?,? )";
	private static Connection con;
	private static PreparedStatement st;
	static Scanner c = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner c=new Scanner(System.in);
		String url="jdbc:mysql://localhost:3306/jdbc";
		String user="root";
		String password="ROOT";
		
		
		
		try {
			con=DriverManager.getConnection(url, user, password);
			first.display(con, st, null);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public static void ins(Connection connection,Statement statement,ResultSet res) throws SQLException
	{
		st=con.prepareStatement(SQL);
		
		do {
			System.out.println("Enter ID");
			int id=c.nextInt();
			System.out.println("Enter Name");
			String name=c.next();
			System.out.println("Enter Email");
			String Email=c.next();
			System.out.println("Enter Department");
			String Depart=c.next();
			System.out.println("Enter Salary");
			int salary=c.nextInt();	
			
			st.setInt(1, id);
			st.setString(2, name);
			st.setString(3, Email);
			st.setString(4, Depart);
			st.setInt(5, salary);
			
			st.executeUpdate();
			
			System.out.println("Do You Want to Add any values(Yes/No)");
		}while(c.next().equalsIgnoreCase("Yes"));
		
	}
}
