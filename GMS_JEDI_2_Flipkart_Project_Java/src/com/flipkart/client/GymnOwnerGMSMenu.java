package com.flipkart.client;
import com.flipkart.bean.*;
import java.util.*;
import java.util.Scanner;
import com.flipkart.service.*;
import com.flipkart.bean.*;

public class GymnOwnerGMSMenu {
	GymOwnerService ownerService = new GymOwnerService();
	
	public void registerGymOwner(Scanner in) {
		System.out.println("Welcome to FlipFit Gymnasium Application");
		System.out.println("Please Enter your Details:-");
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
		
		GymOwner owner = new GymOwner();
		owner.setName(name);
		owner.setMobile(mobile);
		owner.setEmail(email);
		owner.setAddress(address);
		owner.setAadhaarNumber(aadhaarNumber);
		owner.setPanNumber(panNumber);
		owner.setGstNumber(gstNumber);
		ownerService.registerGymOwner(user, owner);
		
		
		gymOwnerActionPage(in,user);
	}
	
	public void fetchOwnerDetails(String ownerId) {
		ownerService.fetchOwnerDetails(ownerId);
	}
	
	public void fetchMyGyms(String ownerId) {
		ownerService.fetchMyGyms(ownerId);
	}
	
	public void registerGym(Scanner in, String ownerId) {
		Gymnasium gym = new Gymnasium();
		
		System.out.print("  Gym Name: ");
		String name = in.next();
		
		System.out.print("  Address: ");
		in.nextLine();
		String address = in.nextLine();
		
		System.out.print("  Area: ");
		double area = in.nextInt();
		
		System.out.print("  Number of Machines: ");
		int numItem = in.nextInt();
		
		System.out.print("Enter capacity of slot: ");
		int capacity = in.nextInt();
		
		
		System.out.println("Registerd. \n Your slots are 6-8 am and 6-8 pm with capacity of "+String.valueOf(capacity)+ ".\n");
		
		List<Boolean> slotAvailable = new ArrayList<Boolean>();
		
		slotAvailable.add(new Boolean(true));
		
		
		
		slotAvailable.add(new Boolean(false));
		
		slotAvailable.add(new Boolean(false));
		
		slotAvailable.add(new Boolean(true));
		
		
		gym.setOwnerId(ownerId);
		gym.setName(name);
		gym.setAddress(address);
		gym.setTotalArea(area);
		gym.setNumItem(numItem);
		gym.setApproved(false);
		ownerService.addGymDetails(gym, slotAvailable, capacity);
	}

	public void gymOwnerActionPage(Scanner in, User user) {
		System.out.println("Welcome to FlipFit Gymnasium Application");
		int choice = 0;
		
		if(!ownerService.isOwnerApproved(user.getUserName())) {
			System.out.println("Not Approved!!");
			choice = 4;
		}
		
		while(choice != 4) {
			System.out.println("Menu:-");
			System.out.println("1.Get Details \n2.Add Gym \n3.View My Gyms \n4.Return");
			
			System.out.print("Enter your choice: ");
			choice = in.nextInt();
			
			switch (choice) {
				// Case statements	
				case 1:
					fetchOwnerDetails(user.getUserName());
					break;
				case 2:
					registerGym(in, user.getUserName());
					break;
				case 3:
					fetchMyGyms(user.getUserName());
					break;
				// Default case statement
				case 4:
					break;
				default:
					System.out.println("Wrong Choice");
			}
		}
	}
}
