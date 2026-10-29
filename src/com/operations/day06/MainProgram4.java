
package com.operations.day06;

import java.util.Scanner;

public class MainProgram4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ProductOperations operations = new ProductOperations();

        // Enter product ID
        System.out.print("Enter Product ID: ");
        int productId = scanner.nextInt();

        // Enter new price
        System.out.print("Enter New Product Price: ");
        double newPrice = scanner.nextDouble();

        // Update product price
        boolean isUpdated =
                operations.updateProductPrice(productId, newPrice);

        if (isUpdated) {
            System.out.println("Product price updated successfully.");
        } else {
            System.out.println(
                    "Product not found or price update failed.");
        }

        scanner.close();
    }
}

