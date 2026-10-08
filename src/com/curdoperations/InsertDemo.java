package com.curdoperations;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InsertDemo {
	public static void main(String[] args) throws ClassNotFoundException  {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/class","root","root");
		System.out.println("Connected to database");
		Statement stmt=con.createStatement();
		String sql="insert into product values(105,'Generator',50000),(106,'Fan',10000)";
		int rows=stmt.executeUpdate(sql);
		System.out.println(rows+" rows inserted successfully");
		con.close();
	}catch(SQLException e) {
		e.printStackTrace();
	}
	
		
	}
}
