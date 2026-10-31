package com.customer2;

import static java.lang.System.out;
import java.util.Scanner;

public class MainProgram8 {
	public static void main(String[] args) {
		
		var scanner = new Scanner(System.in);
		
		out.println("Enter the Credential ID : ");
		var cCardentialId=scanner.nextInt();
		
		var customerOperations = new CustomerOperations();
		var isCustomerDeleted = customerOperations.deleteCustomer(cCardentialId);
		if(isCustomerDeleted) {
			out.println("Customer Deleted SuccessFUlly");
		}
		else {
			out.println("Error Deleting Customer ! Please try again");
		}
		scanner.close();
	}
}
