package com.Task3_ATM_interface;

import java.util.Scanner;

public class Atm_interface {

	private static Bank_account bankAccount;

	public Atm_interface(Bank_account account) {
		bankAccount = account;
	}

	public static Scanner scan;

	public static void showMenu() {

		scan = new Scanner(System.in);
		int choice = 0;

		do {
			System.out.println("ATM Menu:");
			System.out.println("1. Withdraw");
			System.out.println("2. Deposit");
			System.out.println("3. Check Balance");
			System.out.println("4. Exit");
			System.out.print("Choose an option: ");

			choice = scan.nextInt();

			System.out.println("You Choose an option is :" + choice);

			switch (choice) {
			case 1:
				System.out.print("Enter amount to withdraw: ");
				double withdrawAmount = scan.nextDouble();
				withdraw(withdrawAmount);
				break;
			case 2:
				System.out.print("Enter amount to deposit: ");
				double depositAmount = scan.nextInt();
				deposit(depositAmount);
				break;
			case 3:
				checkBalance();
				break;
			case 4:
				System.out.println("Thank you for using the ATM. Goodbye!");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 4);

		scan.close();

	}

	public static void checkBalance() {
		System.out.println("Current balance: " + bankAccount.getBalance());
	}

	public static void withdraw(double amount) {
		if (amount <= 0) {
			System.out.println("Invalid amount. Please enter a positive value.");
		} else if (amount > bankAccount.getBalance()) {
			System.out.println("Insufficient balance. Transaction failed.");
		} else {
			bankAccount.withdraw(amount);
			System.out.println("Successfully withdrew " + amount);

			System.out.println("Want to check balance :");

			System.out.println("press 1 yes :");
			System.out.println("press 0 No :");

			while (true) {
				int userresp = scan.nextInt();

				if (userresp == 1) {

					checkBalance();

				} else if (userresp == 0) {

					String emoji1 = "\uD83D\uDE4F";
					String emoji2 = "\uD83D\uDE0A";
					System.out.println("Take your Card");
					System.out.println("Thank you for Using!!" + emoji1 + emoji2);

				}
			}
		}
	}

	public static void deposit(double amount) {
		if (amount <= 0) {
			System.out.println("Invalid amount. Please enter a positive value.");
		} else {
			bankAccount.deposit(amount);
			System.out.println("Successfully deposited " + amount + ". New balance: " + bankAccount.getBalance());
		}
	}

	

}
