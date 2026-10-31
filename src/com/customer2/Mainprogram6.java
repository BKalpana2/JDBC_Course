package com.customer2;

import static java.lang.System.out;

import java.util.Scanner;

public class Mainprogram6 {

    public static void main(String[] args) {

        var scanner = new Scanner(System.in);

        out.print("Enter UserName : ");
        var cUserName = scanner.nextLine();

        out.print("Enter PassWord : ");
        var cPassWord = scanner.nextLine();

        var credential = new Credentials(0, cUserName, cPassWord);

        var customerOperations = new CustomerOperations();

        var customer = customerOperations.findCustomerByUsernamePassword(credential);

        if (customer != null) {

            out.println("\nLogin Successful!");
//            out.println("Customer ID : " + customer.customerId());
            out.println("First Name : " + customer.firstName());
            out.println("Last Name : " + customer.lastName());

        } else {

            out.println("\nInvalid Username or Password!");

        }

        scanner.close();
    }
}