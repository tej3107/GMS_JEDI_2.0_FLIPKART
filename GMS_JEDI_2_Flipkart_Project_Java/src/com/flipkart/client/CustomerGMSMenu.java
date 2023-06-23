package com.flipkart.client;
import java.util.*;
import java.util.Scanner;
import com.flipkart.service.*;
import com.flipkart.bean.*;

import java.util.Scanner;

public class CustomerGMSMenu {
	CustomerService customerService = new CustomerService();
	
	public void registerCustomer(Scanner in) {
		System.out.println("Welcome to FlipFit Gymnasium Application");
		
		System.out.println("Add Personal Details:-");
		System.out.print("Enter Username: ");
		String username = in.next();
		System.out.print("Enter your Name: ");
		String name = in.next();
		System.out.print("Enter your mobile: ");
		String mobile = in.next();
		System.out.print("Enter your email: ");
		String email = in.next();
		System.out.print("Enter your address: ");
		String address = in.next();
		System.out.print("Enter your aadhaarNumber: ");
		String aadhaarNumber = in.next();
		System.out.print("Enter your panNumber: ");
		String panNumber = in.next();
		System.out.print("Enter your DOB: ");
		String DOB = in.next();
		System.out.print("Enter your gstNumber: ");
		String gstNumber = in.next();
		System.out.print("Enter your Password: ");
		String password = in.next();
		User user =new User(username,password,3);
		customerActionPage(in,user);
	}
	
	
	public void viewCatalog(Scanner in, User user) {
		System.out.println("\nWelcome to FlipFit Gymnasium Application");
		System.out.println("Book a Slot:\nMenu:-");
		customerService.fetchGymList();
		
		System.out.print("Enter your Gym ID: ");
		String gymId = in.next();
		
		customerService.fetchAvilableSlots(gymId);
		System.out.print("Enter your Slot ID: ");
		String slotId = in.next();
		
		System.out.print("Enter your Date: ");
		int date = in.nextInt();
		
		int response = customerService.bookSlots(slotId, user.getUserName(), date);
		switch (response) {
			case 0:
				System.out.println("Changed your slot time with new gym loaction");
				break;
			case 1:
				System.out.println("No slots left");
				break;
			case 2:
				System.out.println("Slot is booked");
				break;
			// Default case statement
			default:
				System.out.println("Incorrect choice!!! Please try again!!!");
		}
	}

	
	public void customerActionPage(Scanner in, User user) {
		int choice = 0;
		
		while(choice != 3) {
			System.out.println("Welcome to FlipFit Gymnasium Application");
			
			System.out.println("\nMenu:-");
			System.out.println("1.View Gyms and Book Gym \n2.View Booked Slots\n3.Exit");
			System.out.print("Enter your choice: ");
			choice = in.nextInt();
			
			switch (choice) {
				case 1:
					viewCatalog(in, user);
					break;
				case 2:
					customerService.bookedSlots(user.getUserName()); //empty functions
					break;
				case 3:
					System.exit(0);
					break;
				default:
					System.out.println("Incorrect choice!!! Please try again!!!");
			}
		}
	}	
}