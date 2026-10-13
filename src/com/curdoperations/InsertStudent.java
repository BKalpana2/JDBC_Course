package com.curdoperations;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertStudent {

    public static void main(String[] args) {

        try {
            // Step 1: Register the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the connection
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/college",
                    "root",
                    "your_password"
            );

            // Step 3: Create the SQL query
            String query = "INSERT INTO student VALUES (?, ?, ?)";

            // Step 4: Create PreparedStatement
            PreparedStatement ps = con.prepareStatement(query);

            // Step 5: Set the values
            ps.setInt(1, 101);
            ps.setString(2, "Kalpana");
            ps.setInt(3, 90);

            // Step 6: Execute the query
            int rows = ps.executeUpdate();

            // Step 7: Display the result
            if (rows > 0) {
                System.out.println("Student inserted successfully!");
            }

            // Step 8: Close the resources
            ps.close();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
