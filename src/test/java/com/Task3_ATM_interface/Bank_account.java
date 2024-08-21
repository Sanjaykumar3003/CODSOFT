package com.Task3_ATM_interface;

public class Bank_account {

	private double balance;

	public Bank_account(double initialBalance) {

		
		balance = initialBalance;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		balance += amount;
	}

	public void withdraw(double amount) {
		balance -= amount;
	}

}
