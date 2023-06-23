package com.flipkart.client;
import java.util.Scanner;
import com.flipkart.service.*;
import java.util.Formatter; 

/**
 * 
 */
public class AdminGMSMenu {
	public void approveGymOwner(Scanner in, AdminGMSInterface adminService) {
		System.out.print("Enter Owner ID: ");
		String choice = in.next();
		
		if(adminService.approveSingleOwnerRequest(choice)) {
			System.out.print("Owner " + choice + " request approved successfylly");
		}else {
			System.out.print("Error...please try after some time");
		}
	}
	
	public void approveGym(Scanner in, AdminGMSInterface adminService) {
		//add one Slot timing menu here
		System.out.print("Enter Gym ID: ");
		String choice = in.next();
		
		if(adminService.approveSingleGymRequest(choice)) {
			System.out.print("Gym " + choice + " request approved successfully");
		}else {
			System.out.print("Error...please try after some time");
		}
	}

	public void adminActionPage(Scanner in) {
		System.out.println("\nWelcome to FlipFit Gymnasium Application");
		AdminGMSInterface adminService = new AdminGMSService();
		
		int choice = 0;
		while(choice != 7) {
			System.out.println("\nMenu:-");
			System.out.println(
					"\t1.View Gym Owner pending requests \n"
					+ "\t2.View Gymnasiums pending requests \n"
					+ "\t3.Approve Gym Owner request \n"
					+ "\t4.Approve Gymnasium request \n"
					+ "\t5.Approve all Gym Owner requests \n"
					+ "\t6.Approve all Gymnasium requests \n"
					+ "\t7.RETURN \n");
			
			System.out.print("Enter your choice: ");
			choice = in.nextInt();
			
			switch (choice) {
			// Case statements
//			case 1:
//				adminService.seeAllGymOwner();
//				break;
//			case 2:
//				adminService.seeAllGyms();
//				break;
			case 1:
				adminService.seePendingGymOwnerRequest();
				break;
			case 2:
				adminService.seePendingGymRequest();
				break;
			case 3:
				approveGymOwner(in, adminService);
				break;
			case 4:
				approveGym(in, adminService);
				break;
			case 5:
				adminService.approveAllOwnerRequest();
				break;	
			case 6:
				adminService.approveAllGymRequest();
				break;
			case 7:
				System.out.println("Exit!!");
				break;
			// Default case statement
			default:
				System.out.println("Incorrect choice!!! Please try again!!!");
			}
		}

	}
}