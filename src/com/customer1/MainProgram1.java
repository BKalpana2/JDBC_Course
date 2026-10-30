
package com.customer1;

import static java.lang.System.out;

import java.util.Scanner;

public class MainProgram1 {

	public static void main(String[] args) {

		var scanner = new Scanner(System.in);

		out.print("Enter the First Name : ");
		var cFirstName = scanner.nextLine();

		out.print("Enter the Last Name : ");
		var cLastName = scanner.nextLine();

		out.print("Enter UserName : ");
		var cUserName = scanner.nextLine();

		out.print("Enter PassWord : ");
		var cPassWord = scanner.nextLine();

		var newCustomer = new Customers(0, cFirstName, cLastName);

		var newCredential = new Credentials(0, cUserName, cPassWord);

		var customerOperations = new CustomerOperations();

		boolean isCustomerAdded = customerOperations.addCustomer(newCustomer, newCredential);

		if (isCustomerAdded) {

			out.println("\nCongratulations! You are now a registered member.");

		} else {

			out.println("\nApologies! Please try after some time.");

		}

		scanner.close();
	}

}
