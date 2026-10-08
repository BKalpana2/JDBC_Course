package com.curdoperations;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


public class UpdateDemo {
	public static void main(String[] args)  {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/class","root","root");
		System.out.println("Connected to database");
		Statement stmt=con.createStatement();
		String update="Update product  set productprice=100000 where productId=101";
		int rows=stmt.executeUpdate(update);
		System.out.println(rows+" Updated successfully");
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
