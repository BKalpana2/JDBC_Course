package com.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
public class Product {
	public static  void main(String[] args) throws ClassNotFoundException {
		//Step1 : Register the Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//step 2: Establish the conncetion
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/class","root","root");
			System.out.println("Connected to DataBase");
			//step 3 : create the statement
			String sql="select * from product";
			Statement statement=con.createStatement();
			String insert="insert into product values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(insert);
			//step 4 : execute the query
			ps.setInt(1, 104);
			ps.setString(2, "AC");
			ps.setInt(3,90000);
			
			int result=ps.executeUpdate();
			System.out.println(result+" row inserted ");
			ResultSet resultSet=statement.executeQuery(sql);
			while(resultSet.next()) {
				int id=resultSet.getInt("productId");
				//TO get the particular paramter (column)
				//String id=resultSet.getString(2);
				String name=resultSet.getString("productName");
				int price=resultSet.getInt("productPrice");
				System.out.println("ProductId : "+id);
				System.out.println("ProductName : "+name);
				System.out.println("ProductPrice : "+price);
			}
			
			//step 5: close connection
			con.close();
			resultSet.close();
			statement.close();
			ps.close();
		}
		catch(SQLException e) {

		}
	}
}
