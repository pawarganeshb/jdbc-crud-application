package com.student.management.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {

		System.out.println("***Welcome to student Management App***");

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.println("PRESS 1 to Add Student.");
			System.out.println("PRESS 2 to Delete Student.");
			System.out.println("PRESS 3 to Update Student.");
			System.out.println("PRESS 4 to Display Student.");
			System.out.println("PRESS 5 to Exit app.");
			int c = Integer.parseInt(reader.readLine());

			if (c == 1) {
				// add student
				System.out.println("Enter use name:");
				String name = reader.readLine();

				System.out.println("Enter use phone:");
				String phone = reader.readLine();

				System.out.println("Enter use city:");
				String city = reader.readLine();

				Student stu = new Student(name, phone, city);

				boolean responce1 = StudentDao.insertData(stu);

				if (responce1) {
					System.out.println("Successfully inserted your data.");
				} else {
					System.out.println("Something went wrong.");
				}

			} else if (c == 2) {
				// delete student

				System.out.println("Enter the Student ID to delete: ");
				int usrID = Integer.parseInt(reader.readLine());

				boolean response2 = StudentDao.deleteStudent(usrID);

				if (response2) {
					System.out.println("One record deleted.");
				} else {
					System.out.println("Something went wrong.");
				}

			} else if (c == 3) {
				// update student

				System.out.println("Enter the Student ID to update:");
				int sid = Integer.parseInt(reader.readLine());

				// Prompt user for updated information
				System.out.println("Enter the updated name:");
				String updatedName = reader.readLine();

				System.out.println("Enter the updated phone:");
				String updatedPhone = reader.readLine();

				System.out.println("Enter the updated city:");
				String updatedCity = reader.readLine();

				// Create a Student object with updated information
				Student updatedStudent = new Student(updatedName, updatedPhone, updatedCity);

				boolean response3 = StudentDao.updateStudent(sid, updatedStudent);

				if (response3) {
					System.out.println("Your record has been updated.");
				} else {
					System.out.println("Something went wrong.");
				}
			} else if (c == 4) {
				// display student

				StudentDao.showDetails();

			} else {
				break;
			}
		}
		System.out.println("Thank you for using my application.");
	}
}
