package com.customer2;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.operations.Product;


public class ProductOperations {
	
	
	// Adding - Add Product --MainProgram1
	public boolean addProduct(com.customer1.Product newProduct) {

		boolean isAdded = false;

		var sqlQuery = "INSERT INTO product(productname, productprice) VALUES (?, ?)";

		try (
				var connection = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/class", "root", "root");
				var statement = connection.prepareStatement(sqlQuery)
				) {

			statement.setString(1, newProduct.name());
			statement.setDouble(2, newProduct.price());

			var numOfRowsAffected = statement.executeUpdate();

			if (numOfRowsAffected > 0) {
				isAdded = true;
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

		return isAdded;
	}
	
	
	//Get ALL products --MainProgram2
	public List<Product> getAllProducts() throws SQLException {

	    List<Product> products = new ArrayList<>();

	    var sqlQuery = "SELECT productid, productname, productprice FROM product";

	    try (
	        var connection = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/class", "root", "root");
	        var statement = connection.prepareStatement(sqlQuery);
	        var resultSet = statement.executeQuery()
	    ) {

	        while (resultSet.next()) {

	            int productId = resultSet.getInt(1);
	            String productName = resultSet.getString(2);
	            double productPrice = resultSet.getDouble(3);

	            Product product = new Product();

	            product.setId(productId);
	            product.setName(productName);
	            product.setPrice(productPrice);

	            // IMPORTANT: Add the product to the list
	            products.add(product);
	        }
	    }

	    return products;
	}

	
	//Find By Id  --MainProgram3
	public Product findProductById(int productId) {

		Product product = null;

		String sqlQuery =
		        "SELECT productid, productname, productprice FROM product WHERE productid = ?";

		try (
		        var connection = DriverManager.getConnection(
		                "jdbc:mysql://localhost:3306/class",
		                "root", "root"
		        );
		        var statement = connection.prepareStatement(sqlQuery)
		) {

		    statement.setInt(1, productId);

		    try (var resultSet = statement.executeQuery()) {

		        if (resultSet.next()) {

		            product = new Product();

		            product.setId(resultSet.getInt("productid"));
		            product.setName(resultSet.getString("productname"));
		            product.setPrice(resultSet.getDouble("productprice"));
		        }
		    }

		} catch (SQLException sqlException) {

		    System.out.println("Error finding product.");
		    sqlException.printStackTrace();
		}

		return product;
		}
	

	public boolean updateProductPrice(int productId, double newPrice) {

	    boolean isUpdated = false;

	    String sqlQuery =
	            "UPDATE product SET productprice = ? WHERE productid = ?";

	    try (
	            var connection = DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/class", "root", "root");

	            var statement = connection.prepareStatement(sqlQuery)
	    ) {
	        statement.setDouble(1, newPrice);
	        statement.setInt(2, productId);

	        int numOfRowsAffected = statement.executeUpdate();

	        if (numOfRowsAffected > 0) {
	            isUpdated = true;
	        }

	    } catch (SQLException sqlException) {
	        sqlException.printStackTrace();
	    }

	    return isUpdated;
	}


	
	
	//Delete  --MainProgram5
	public boolean deleteProduct(int productId) {

	    boolean isDeleted = false;

	    var sqlQuery = "DELETE FROM product WHERE productid = ?";

	    try (
	            var connection = DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/class", "root", "root");

	            var statement = connection.prepareStatement(sqlQuery)
	    ) {

	        statement.setInt(1, productId);

	        var numOfRowsAffected = statement.executeUpdate();

	        if (numOfRowsAffected > 0) {
	            isDeleted = true;
	        }

	    } catch (SQLException sqlException) {
	        sqlException.printStackTrace();
	    }

	    return isDeleted;
	}



}



