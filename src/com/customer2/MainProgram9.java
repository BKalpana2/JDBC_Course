package com.customer2;
import static java.lang.System.out;
public class MainProgram9 {
	public static void main(String[] args) {
		var customerOperations = new CustomerOperations();
		
		var customersList = customerOperations.getCustomers();
		
		for(Customers customer : customersList) {
			int customerId=customer.id();
			String firstName=customer.firstName();
			String lastName=customer.lastName();
			
			out.println("Customer ID : "+customerId);
			out.println("FirstName : "+firstName);
			out.println("LastName : "+lastName);
			out.println();
		}
		
	}
}
