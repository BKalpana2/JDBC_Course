package com.customer2;
import static java.lang.System.out;
public class MainProgram10 {
	public static void main(String[] args) {

		var customerOperations = new CustomerOperations();	
		
		var customersAndCredentialsMap=customerOperations.getCustomersAndCredentials();
		
		var mapEntrieSet = customersAndCredentialsMap.keySet();
		for(Customers customer : mapEntrieSet) {
			int customerId=customer.id();
			String firstname=customer.firstName();
			String lastName = customer.lastName();
			
			Credentials credential = customersAndCredentialsMap.get(customer);
			
			int credentialId=credential.id();
			String username=credential.username();
			String password=credential.password();
			
			out.println("Customer ID  :"+customerId);
			out.println("FirstName : "+firstname);
			out.println("Last Name : "+lastName);
			
			out.println("Credential ID : "+credentialId);
			out.println("UserName : "+username);
			out.println("PassWord : "+password);
			
			out.println();
		}
		
	}
}
