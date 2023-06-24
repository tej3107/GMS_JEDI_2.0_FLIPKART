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
		while(choice != 10) {
			System.out.println("\nMenu:-");
			System.out.println(
					"\t1.View All Gym Owner\n"
					+ "\t2.View All Gymnasius\n"
					+ "\t3.View Gym Owner pending requests \n"
					+ "\t4.View Gymnasiums pending requests \n"
					+ "\t5.Approve Gym Owner request \n"
					+ "\t6.Approve Gymnasium request \n"
					+ "\t7.Approve all Gym Owner requests \n"
					+ "\t8.Approve all Gymnasium requests \n"
					+ "\t9.Block a Gym Owner\n"
					+ "\t10.RETURN \n");
			
			System.out.print("$ Enter your choice: ");
			choice = in.nextInt();
			
			switch (choice) {
			// Case statements
			case 1:
				System.out.println("\n\tID\tGymOwner Name");
				adminService.seeAllGymOwner();
				break;
			case 2:
				System.out.println("\n\tID\tGymnasium Name");
				adminService.seeAllGyms();
				break;
			case 3:
				System.out.println("\n\tID\tGymOwner Name");
				adminService.seePendingGymOwnerRequest();
				break;
			case 4:
				System.out.println("\n\tID\tGymnasium Name");
				adminService.seePendingGymRequest();
				break;
			case 5:
				System.out.println("\n\tID\tGymOwner Name");
				adminService.seePendingGymOwnerRequest();
				approveGymOwner(in, adminService);
				break;
			case 6:
				System.out.println("\n\tID\tGymnasium Name");
				adminService.seePendingGymRequest();
				approveGym(in, adminService);
				break;
			case 7:
				adminService.approveAllOwnerRequest();
				break;	
			case 8:
				adminService.approveAllGymRequest();
				break;
			case 9:
				adminService.seeAllGymOwner();
				System.out.println("$ Enter Gym Owner Id to Block:   ");
				String gynOwnerId = in.next();
				adminService.blockGymOwner(gynOwnerId);
				break;
			case 10:
				System.out.println("Exit!!");
				break;
			// Default case statement
			default:
				System.out.println("Incorrect choice!!! Please try again!!!");
			}
		}

	}
}