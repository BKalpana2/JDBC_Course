
package com.customer1;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerOperations {

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

}
