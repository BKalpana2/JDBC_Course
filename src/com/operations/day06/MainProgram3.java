package com.operations.day06;

import java.util.Scanner;

public class MainProgram3 {

	public static void main(String[] args) {
		var scanner = new Scanner(System.in);


       System.out.print("Enter Product ID: ");
		var productId = scanner.nextInt();
		
		var productOperations = new ProductOperations();

		var product = productOperations.findProductById(productId);
		if (product != null) {
			 System.out.println("Product found.");
			var productName = product.getName();
			var productPrice = product.getPrice();

			 System.out.println("Product ID: " + productId);
			 System.out.println("Name: " + productName);
			 System.out.println("Price : INR " + productPrice);
			 System.out.println();
		} else {
			 System.out.println("Product does not exist with the given id.");
		}
		
		scanner.close();
	}

}