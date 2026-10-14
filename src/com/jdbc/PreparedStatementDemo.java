package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementDemo {
	public static void main(String[] args) {
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");
			PreparedStatement ps=con.prepareStatement("select * from student where id=?");
			ps.setInt(1, 1);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				int age=rs.getInt(3);
				System.out.println("ID : "+id);
				System.out.println("Name : "+name);
				System.out.println("Age : "+age);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
