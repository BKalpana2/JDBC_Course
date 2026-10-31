package com.customer2;

import static java.lang.System.out;

import java.util.Scanner;

public class MainProgram7 {

    public static void main(String[] args) {

        var scanner = new Scanner(System.in);

        out.print("Enter Credential ID : ");
        var credentialId = scanner.nextInt();

        scanner.nextLine();

        out.print("Enter New Password : ");
        var newPassword = scanner.nextLine();

        var customerOperations = new CustomerOperations();

        boolean isPasswordUpdated = customerOperations.updatePassword(newPassword, credentialId);

        if (isPasswordUpdated) {

            out.println("\nPassword Updated Successfully!");

        } else {

            out.println("\nPassword Update Failed!");

        }

        scanner.close();
    }
}