package com.operations.day06;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.List;
public class MainProgram2{
	public static void main(String[] args) throws SQLException {
		ProductOperations productoperations=new ProductOperations();
		List<com.operations.Product> products=productoperations.getAllProducts();
		for(com.operations.Product product:products) {
			var productId=product.getId();
			var productName=product.getName();
			var productPrice=product.getPrice();
			
			out.println("Product ID : "+productId);
			out.println("Name : "+productName);
			out.println("Price : "+productPrice);
			out.println();
		}
	}

}
