package com.curdoperations;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class ConnectionDemo {
	public static void main(String[] args) {
		try {
			//step 1:register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//step 2:Estabilish connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/class","root","root");
			System.out.println("Database connected successfully .....");
			//step 3:create statement
			Statement stmt=con.createStatement();
			String result="select * from product";
			//step 4: execute the query
			ResultSet rs=stmt.executeQuery(result);
			
			System.out.println("===================================================");
			
			//1.Retrieve operation
			while(rs.next()) {
				int id=rs.getInt("productId");
				String name=rs.getString("productName");
				int price=rs.getInt("productPrice");
				System.out.println("ID : "+id+" Name : "+name+" Price : "+price);
			}
			
			System.out.println("===================================================");
			
			//2.Update Operation
			Statement stmt2=con.createStatement();
			String query2="Update product set productPrice=20000 where productId=101";
			int update=stmt2.executeUpdate(query2);
			System.out.println(update+"Row  Updated SuccessFully .....");
			
			System.out.println("===================================================");
			
			//3.Insert Operation
			Statement stmt3=con.createStatement();
			String query3="insert into product values (104,'AC',40000),(105,'Generator',750000) ";
			int insert=stmt3.executeUpdate(query3);
			System.out.println(insert +" Row Inserted successfully .....");
			
			System.out.println("===================================================");
			
			//4.Delete Operation
			Statement stmt4=con.createStatement();
			String query4="Delete from product where productId=106";
			int delete=stmt4.executeUpdate(query4);
			System.out.println(delete+ "Row  deleted successfully .......");
			
			System.out.println("===================================================");
			System.out.println("Table After CRUD Operations ");
			
			Statement st=con.createStatement();
			String r="select * from product";
			ResultSet r1=st.executeQuery(r);
			while(r1.next()) {
				int id=r1.getInt("productId");
				String name=r1.getString("productName");
				int price=r1.getInt("productPrice");
				System.out.println("ID : "+id+" Name : "+name+" Price : "+price);
			}
			
			//step 5 :close connection
			con.close();
			
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
