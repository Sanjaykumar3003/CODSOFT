package com.Task2_MarkGrade;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class MarkGrade {

	public static void Student_grade_Calculater() throws IOException {

		System.out.println("***Welcome To Grade Codeing***");

		boolean execution = false;

		while (!execution) {

			try {

				Scanner scan = new Scanner(System.in);
				System.out.println("Enter Total Number of the Subject : ");

				int t_Sub = scan.nextInt();

				if (t_Sub <= 10) {

					String subject = null;

					double sub_mark = 0;

					Properties p = new Properties();
					for (int i = 0; i < t_Sub; i++) {

						System.out.println("Enter the Subject name : ");

						String line = scan.nextLine();
						subject = scan.nextLine();

						System.out.println("Subject Name is :" + subject);

						System.out.println("Enter mark in " + subject + ":");
						double mark = scan.nextDouble();
						System.out.println(subject + " mark is :" + mark);

						sub_mark += mark;

						String marks = Double.toString(mark);

						p.put("Subject", subject);
						p.put("Mark", marks);

//						FileOutputStream fos = new FileOutputStream("property\\userdata.properties", true);
//
//						p.store(fos, "Data was Stored");

					}

					System.out.println("total :" + sub_mark);

					double percentage = sub_mark / t_Sub;
					System.out.println("");

					String grade;

					if (percentage >= 90) {
						grade = "A+";
					} else if (percentage >= 80) {
						grade = "A";
					} else if (percentage >= 70) {
						grade = "B+";
					} else if (percentage >= 60) {
						grade = "B";
					} else if (percentage >= 50) {
						grade = "C+";
					} else if (percentage >= 40) {
						grade = "C";
					} else {
						grade = "F";
					}

					System.out.println("\nResults:");
					System.out.println("Total Marks: " + sub_mark);
					System.out.println("Average Percentage: " + percentage + "%");
					System.out.println("Grade: " + grade);

					p.put("Results",":");
					p.put("Total Mark :", sub_mark);
					p.put("Average Percentage : ", percentage);
					p.put("Grade :", grade);

					FileOutputStream fos = new FileOutputStream("property\\userdata1.properties", true);

					p.store(fos, "Data was Stored");

					System.out.println("Thank you For using this Application");

					break;

				}

				else {
					System.out.println(" its Support less then 10 Subject ,So Enter the valid Number");
				}

			} catch (Exception e) {
				System.out.println("Enter the valid Number!!");
				execution = false;
			}

		}
	}

}
