package com.Task1_NumberGame;

import java.util.Random;
import java.util.Scanner;

public class Number_game {
	
		static int max_attempts = 10;
		static int min_number = 1;
		static int max_number = 100;
	
		public static int generate_random_Number(int min, int max) {
			Random r = new Random();
			int random = r.nextInt(max - min + 1) + min;
			return random;
	
		}
	
		public static void Startgame() {
	
			Scanner scan = new Scanner(System.in);
	
			System.out.println("*** WELCOME TO THE NUMBER GUESSING GAME ***");
	
			boolean play_Again = true;
	
			while (play_Again) {
	
				int generatednumber = generate_random_Number(min_number, max_number);
	
				boolean guessing = false;
	
				System.out
						.println(" I Generated Number Between " + min_number + " and " + max_number + " Can you guess it?");
	
				try {
					for (int attempt = 1; attempt <= max_attempts && !guessing; attempt++) {
	
						System.out.println("Enter you guessing Number ::");
	
						int user_gueesingnumber = scan.nextInt();
	
						if (user_gueesingnumber == generatednumber) {
	
							guessing = true;
							String cel = "\uD83C\uDF89";
							System.out.println("Congratulations!" + cel + " You guessed the correct number in your "
									+ attempt + " attempt awesome!! ");
	
							break;
						}
	
						else if (user_gueesingnumber > generatednumber) {
							System.out.println("Your guess is too high. Try again");
						}
	
						else {
	
							System.out.println("Your guess is too low. Try again.");
						}
	
						int result = max_attempts - attempt;
	
						System.out.println("remaing Attempts :" + result);
					}
	
					if (!guessing) {
	
						System.out.println("Sorry! You've used all " + max_attempts + " attempts. The correct number was "
								+ generatednumber);
						System.out.print("Do you want to play again? (yes/no): ");
	
						String response1 = scan.next();
	
						System.out.println("user responcse is :" + response1);
	
						if (response1.equalsIgnoreCase("yes")) {
							play_Again = response1.equalsIgnoreCase("yes");
	
						}
	
						else if (isNumeric(response1)) {
							String sorry = "\uD83E\uDD7A";
							System.out.println(
									"Sorry!" + sorry + " its does not Numeric Values, Its Supports only yes/No ? Options");
	
							break;
						}
	
						else if (response1.equalsIgnoreCase("No")) {
							System.out.println("Thank you for playing Number Games ");
							break;
						}
	
						else {
							System.out.println(" please Enter valid Input!, Thank you");
						}
					}
				} catch (Exception e) {
					System.out.println("Sorry, its Support Only For 1 to 100 Number, So Please Enter valid Numbers");
					break;
	
				}
	
			}
		}
	
		public static boolean isNumeric(String str) {
			try {
				Double.parseDouble(str);
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
		}
}
