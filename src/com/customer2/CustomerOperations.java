
package com.customer2;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerOperations {
	
	//ADD CUSTOMER 
	public boolean addCustomer(Customers customer, Credentials credential) {

		boolean isAdded = false;

		String sqlQuery1 = "INSERT INTO credentials(username, password) VALUES(?, ?)";

		String sqlQuery2 = "INSERT INTO customer(first_name, last_name, credential_id) VALUES(?, ?, ?)";

		try (var connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tfi", "root", "root");

				var statement1 = connection.prepareStatement(sqlQuery1, Statement.RETURN_GENERATED_KEYS);

				var statement2 = connection.prepareStatement(sqlQuery2)) {

			// Insert credentials
			statement1.setString(1, credential.username());
			statement1.setString(2, credential.password());

			int rowsAffected = statement1.executeUpdate();

			if (rowsAffected > 0) {

				// Retrieve generated credential_id
				try (ResultSet resultSet = statement1.getGeneratedKeys()) {

					if (resultSet.next()) {

						int credentialId = resultSet.getInt(1);

						// Insert customer details
						statement2.setString(1, customer.firstName());
						statement2.setString(2, customer.lastName());
						statement2.setInt(3, credentialId);

						rowsAffected = statement2.executeUpdate();

						if (rowsAffected > 0) {
							isAdded = true;
						}
					}
				}
			}

		} catch (SQLException sqlException) {

			sqlException.printStackTrace();

		}

		return isAdded;
	}
	
	//FINDCUSTOMERBYUSERNAMEANDPASSWORD
	public Customers findCustomerByUsernamePassword(Credentials credential) {

		Customers customer = null;

		var sqlQuery = """
				SELECT cust.customer_id, cust.first_name, cust.last_name
				FROM credentials cre
				INNER JOIN customer cust USING(credential_id)
				WHERE cre.username = ? AND cre.password = ?
				""";

		try (var connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/tfi", "root", "root");
				var statement = connection.prepareStatement(sqlQuery)) {

			statement.setString(1, credential.username());
			statement.setString(2, credential.password());

			var resultSet = statement.executeQuery();

			if (resultSet.next()) {

				customer = new Customers(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3)
						);

			}

		} catch (SQLException sqlException) {

			sqlException.printStackTrace();

		}

		return customer;
	}
	
	//UPDATE PASSWORD
	public boolean updatePassword(String newPassword, int credential_Id) {

	    var isUpdated = false;

	    var sqlQuery = "UPDATE credentials SET password = ? WHERE credential_id = ?";

	    try (var connection = DriverManager.getConnection(
	            "jdbc:mysql://localhost:3306/tfi", "root", "root");
	         var statement = connection.prepareStatement(sqlQuery)) {

	        statement.setString(1, newPassword);
	        statement.setInt(2, credential_Id);

	        var rowsAffected = statement.executeUpdate();

	        if (rowsAffected > 0) {
	            isUpdated = true;
	        }

	    } catch (SQLException sqlException) {

	        sqlException.printStackTrace();

	    }

	    return isUpdated;
	}
	
	public boolean deleteCustomer( int credentialId) {

	    var isDeleted = false;

	    var sqlQuery1 = "Delete from customer where credential_id=?";
	    var sqlQuery2 = "Delete from credentials where credential_id=?";

	    try (var connection = DriverManager.getConnection(
	            "jdbc:mysql://localhost:3306/tfi", "root", "root");
	         var statement1 = connection.prepareStatement(sqlQuery1) ;
	    		var statement2 = connection.prepareStatement(sqlQuery2))
	    		{

	        statement1.setInt(1,credentialId );

	        var rowsAffected = statement1.executeUpdate();

	        if (rowsAffected > 0) {
	        	statement2.setInt(1, credentialId);
	        	
	        	rowsAffected=statement2.executeUpdate();
	            isDeleted = true;
	        }

	    } catch (SQLException sqlException) {

	        sqlException.printStackTrace();

	    }

	    return isDeleted;
	}
	
	
	//Get all customers 
	public List<Customers> getCustomers() {
		List<Customers> customersList=new ArrayList<>();
		Customers customer = null;

		var sqlQuery = """
			select customer_id,first_name,last_name from customer
				""";

		try (var connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/tfi", "root", "root");
				var statement = connection.prepareStatement(sqlQuery);
				var resultSet=statement.executeQuery())
		{
			while(resultSet.next()) {
				customer = new Customers(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3)
						);
				customersList.add(customer);
			}	

		} catch (SQLException sqlException) {

			sqlException.printStackTrace();

		}

		return customersList;
	}
	
	//Get all customers and credentials
	public Map<Customers, Credentials> getCustomersAndCredentials() {

	    Map<Customers, Credentials> customersList = new HashMap<>();

	    var sqlQuery = """
	            SELECT cre.credential_id, cre.username, cre.password,
	                   cust.customer_id, cust.first_name, cust.last_name
	            FROM credentials cre
	            INNER JOIN customer cust USING(credential_id)
	            """;

	    try (var connection = DriverManager.getConnection(
	            "jdbc:mysql://localhost:3306/tfi", "root", "root");

	         var statement = connection.prepareStatement(sqlQuery);

	         var resultSet = statement.executeQuery()) {

	        while (resultSet.next()) {

	            Customers customer1 = new Customers(
	                    resultSet.getInt(4),
	                    resultSet.getString(5),
	                    resultSet.getString(6)
	            );

	            Credentials credential = new Credentials(
	                    resultSet.getInt(1),
	                    resultSet.getString(2),
	                    resultSet.getString(3)
	            );

	            // Adding customer and credentials into HashMap
	            customersList.put(customer1, credential);
	        }

	    } catch (SQLException sqlException) {
	        sqlException.printStackTrace();
	    }

	    return customersList;
	}
}
