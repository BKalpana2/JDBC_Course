package com.curdoperations;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class RetrieveDemo {
	public static void main(String[] args) {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/class","root","root");
		System.out.println("Connected to database");
		
		Statement stmt=con.createStatement();
		String retrieve="Select * from product";
		ResultSet rs=stmt.executeQuery(retrieve);
		while(rs.next()) {
			int id=rs.getInt("productId");
			String name=rs.getString("productName");
			int price=rs.getInt("productPrice");
			System.out.println("Product ID : "+id);
			System.out.println("Product Name : "+name);
			System.out.println("Product Price : "+price);
		}
		con.close();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
