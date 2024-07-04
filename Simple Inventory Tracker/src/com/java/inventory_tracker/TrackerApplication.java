package com.java.inventory_tracker;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TrackerApplication {
	static {
		System.out.println("============================================\n");
		System.out.println("Inventory Management System\n");
		System.out.println("============================================\n");
	}

	public static void main(String[] args) {
		List<Product> products = new ArrayList<Product>();
		Scanner sc = new Scanner(System.in);
		int choice;

		do {
			System.out.println("1. Add Product");
			System.out.println("2. Display All Products");
			System.out.println("3. Search Products");
			System.out.println("4. Show Low Stock Products");
			System.out.println("5. Exit");
			System.out.println("Enter your choice: ");

			try {
				choice = sc.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("Invalid input. Please enter a number.(1-5)");
				sc.nextLine(); // Clear invalid input
				choice = -1; // Set a dummy value to avoid infinite loop
			}

			switch (choice) {
			case 1:
				addProduct(sc, products);
				break;
			case 2:
				displayProducts(products);
				break;
			case 3:
				searchProducts(sc, products);
				break;
			case 4:
				showLowStockProducts(products);
				break;
			case 5:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid choice!");
			}
		} while (choice != 5);

		sc.close(); // Close scanner resource
	}

	private static void addProduct(Scanner scanner, List<Product> products) {
		System.out.print("Enter product name: ");
		String name = scanner.next();scanner.nextLine();
		System.out.println("Enter quantity: ");
		int quantity = input(scanner);
		System.out.println("Enter minimum stock ");
		int thresold = input(scanner);
		products.add(new Product(name, quantity, thresold));
		System.out.println("Product Add Sucessfully");
	}

	private static void displayProducts(List<Product> products) {
		if (products.isEmpty()) {
			System.out.println("  No products found.");
		} else {
			for (Product product : products) {
				System.out.println(product);
			}

		}
	}

	private static void searchProducts(Scanner scanner, List<Product> products) {
		if (products.isEmpty()) {
			System.out.println("\nNo product found!");
		} else {
			System.out.println("Enter product name to search: ");
			String name = scanner.next(); scanner.nextLine();
			System.out.println("\nSearch results:");
			for (Product product : products) {
				if (product.getName().equalsIgnoreCase(name))
					System.out.println(product);
			}
		}
	}

	private static void showLowStockProducts(List<Product> products) {

		if (products.isEmpty()) {
			System.out.println("There is no avilable product.  add the product");
		} else {
			System.out.println("\nProducts needing restock:");
			int count = 1;
			for (Product product : products) {
				if (product.getStock() <= product.getRestockThreshold())
					System.err.println(product);
			}
			if (count == 1) {
				System.out.println("There is No Product in low stock");
			}
		}
	}

	private static int input(Scanner sc) {
		try {
			int choice = sc.nextInt();
			return choice;
		} catch (InputMismatchException e) {
			System.err.println("Invalid input. Please enter a number.");
			sc.nextLine(); // Clear invalid input
			return input(sc);
		}

	}

}
