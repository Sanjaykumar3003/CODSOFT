package com.Task3_ATM_interface;

public class Atm_Runner {

	
	
	
	public static void main(String[] args) {

		Bank_account account = new Bank_account(1000.00);
		Atm_interface atm = new Atm_interface(account);
		atm.showMenu();
	}
}
