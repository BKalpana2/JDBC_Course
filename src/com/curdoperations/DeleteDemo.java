package com.curdoperations;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
public class DeleteDemo {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/class","root","root");
			System.out.println("Connected to database");
			Statement stmt=con.createStatement();
			String delete="Delete from product where productId=105";
			String delete2="Delete from product where productId=104";
			int rows=stmt.executeUpdate(delete);
			int row=stmt.executeUpdate(delete2);
			System.out.println(rows+ " deleted successfully");
			System.out.println(row+" deleted successfully");
			
			
			con.close();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
