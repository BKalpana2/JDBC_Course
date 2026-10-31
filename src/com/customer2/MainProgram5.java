package com.customer2;

import static java.lang.System.out;
import java.util.Scanner;

public class MainProgram5 {
public static void main(String[] args) {
	var scanner=new Scanner(System.in);
	
	out.println("Enter product ID : ");
	var productId=scanner.nextInt();
	
	var productOperations=new ProductOperations();
	
	var isproductDeleted=productOperations.deleteProduct(productId);
	if(isproductDeleted) {
		System.out.println("Product successfully deleted");
	}
	else {
		out.println("Error Deleting Product");
	}
	scanner.close();
}
}
