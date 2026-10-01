package com.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
	public static void main(String[] args) throws SQLException  {
		//step 1 : Register the Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//step 2 : Establish the connection
			//get cooncetion() Paramters : 
			//parameter 1  : 
			//url : protocal://servername:port/databasename
			//jdbc:mysql://localhost:3306/company
			//parameter 2 :
			//username
			//parameter 3:
			//password
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company_db","root","root");
			System.out.println("Connected to database");
			//step 3 : 
			String sql="select * from employee";
			Statement statement= con.createStatement();

			//step 4 : execute the query
			ResultSet resultSet= statement.executeQuery(sql);
			while(resultSet.next()) {
				int id=resultSet.getInt("employee_id");
				String name=resultSet.getString("employee_name");
				System.out.println("ID : "+id);
				System.out.println("Name : "+name);
			}
			resultSet.close();
			statement.close();
			con.close();
		}
		catch(ClassNotFoundException e) {

		}
		catch(SQLException a) {

		}
	}

}
