package com.operations;

import static java.lang.System.out;

import java.util.Scanner;


public class MainProgram1 {
	public static void main(String[] args) {
		var scanner =new Scanner(System.in);
		out.print("Enter the product Name : ");
		String productName=scanner.nextLine();
		out.print("Enter the product Price : ");
		double productPrice=scanner.nextDouble();
		
		Product newProduct=new Product();
		newProduct.setName(productName);
		newProduct.setPrice(productPrice);
		
		ProductOperations productoperations=new ProductOperations();
		boolean isProductAdded=productoperations.addProduct(newProduct);
		
		if(isProductAdded) {
			out.println("Product Added successFully");
		}
		else {
			out.println("Error Saving Product");
		}
	scanner.close();
	}
}
