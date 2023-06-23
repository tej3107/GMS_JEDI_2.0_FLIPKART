/**
 * 
 */
package com.flipkart.client;
import java.util.*;

import com.flipkart.bean.*;
import com.flipkart.exception.UserNotApprovedException;
import com.flipkart.service.*;

/**
 * 
 */
public class GMSApplicationClient {
	/**
	 * @param args
	 */
	public static void main(String args[]) {
		System.out.println("\nWelcome to FlipFit Gymnasium Application");
		System.out.println("\nMenu:-");
		System.out.println("1.Login \n2.GymOwner Registration \n3.Customer Registration \n4.Exit\n");
		
		System.out.print("Enter your choice: ");
		Scanner in = new Scanner(System.in);
		int choice = in.nextInt();
		
		switch (choice) {
		case 1:
			openLoginMenu(in);
			break;
			
		case 2:
			GymnOwnerGMSMenu owner = new GymnOwnerGMSMenu();
			owner.registerGymOwner(in);
			break;
			
		case 3:
			CustomerGMSMenu customer = new CustomerGMSMenu();
			customer.registerCustomer(in);
			break;
			
//		case 4:
//			System.out.println("Sorry! This feature is not supported currently.\nInconveneience caused is deeply regretted.");
//			break;
			
		case 4:
			System.exit(0);
			break;
			
		default:
			System.out.println("Invalid Credentials");
		}
		in.close();
	}

	
	public static void openLoginMenu(Scanner in) {
		System.out.println("\nWelcome to FlipFit Gymnasium Application");
		
		System.out.println("\nMenu:-");
		System.out.println("E\nnter your login credentials:-");
		
		System.out.print("UserId: ");
		String userName = in.next();
		
		System.out.print("Password: ");
		String password = in.next();
		
		int role = 0; // Zero is a dummy value here
		User user = new User(userName, password, role);
		UserServiceInterface authentication = new UserService();
		
		try{ 
			role = authentication.authenticateUser(user);
			throw new UserNotApprovedException(user);
		}catch (UserNotApprovedException e){
			System.out.println("Exception error");
			System.out.println(e.getMessage());
//			System.out.println(e.getMessage());
		}
		if(role != 4) System.out.println("\nlogged in Successfully!!!");
			
		switch(role) {
			case 1: 
				AdminGMSMenu admin = new AdminGMSMenu();
				admin.adminActionPage(in);
				break;
				
			case 2: 
				GymnOwnerGMSMenu owner = new GymnOwnerGMSMenu();
				owner.gymOwnerActionPage(in, user);
				break;
				
			case 3: 
				CustomerGMSMenu customer = new CustomerGMSMenu();
				customer.customerActionPage(in, user);
				break;
				
			default:
				System.out.println("\nIncorrect choice!!! Please try again!!!");
				break;
		}
	}
}
