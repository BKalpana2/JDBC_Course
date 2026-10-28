package com.operations;

import static java.lang.System.out;

import java.util.Scanner;

public class MainProgram3 {
	public static void main(String[] args) {
		var scanner=new Scanner(System.in);
		out.println("Enter Product ID :");
		int productId=scanner.nextInt();
		
		ProductOperations productoperations=new ProductOperations();
		
		Product product=productoperations.findProductById(productId);
		if(product!=null) {
			out.println("Product Found");
			var productName=product.getName();
			var productPrice=product.getPrice();
			
			out.println("Product ID : "+productId);
			out.println("Product Name : "+productName);
			out.println("product Price : "+productPrice);
			out.println();
		}
		else {
			out.println("Product does not exist with the given ID .");
		}
		scanner.close();
	}
}
