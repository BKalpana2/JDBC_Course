package com.jdbc;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
public class ExecuteDemo {
	public static void main(String[] args) {
		try {
		//create connection
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/class","root","root");
		//create statement
		Statement stmt=con.createStatement();
		//get resultSet
		boolean result=stmt.execute("select * from student");
		while(result) {
			ResultSet rs=stmt.getResultSet();
			while(rs.next()) {
				System.out.println(rs.getInt("id")+" "
								  +rs.getString("name")+" "
								  +rs.getInt("age")
						
						);
			}
			boolean result2=stmt.execute(
					"insert into student(name,age) values('amit',25)"
					);
					if(!result2) {
						System.out.println("Rows effected :"+stmt.getUpdateCount());
					}
		}
		
		
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
