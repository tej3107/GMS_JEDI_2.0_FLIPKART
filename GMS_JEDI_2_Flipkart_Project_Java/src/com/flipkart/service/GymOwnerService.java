/**
 * 
 */
package com.flipkart.service;
import com.flipkart.bean.*;
import java.util.*;
import com.flipkart.dao.GymOwnerGMSDao;

/**
 * 
 */
public class GymOwnerService {
	GymOwnerGMSDao ownerDBService = new GymOwnerGMSDao();
	
	public void registerGymOwner(User user, GymOwner owner) {
		ownerDBService.registerGymOwner(user, owner);
	}
	
	public void fetchOwnerDetails(String ownerId) {
		ownerDBService.fetchOwnerDetails(ownerId);
	}
	
	public void fetchMyGyms(String ownerId) {
		ownerDBService.fetchMyGyms(ownerId);
	}
	
	public void addGymDetails(Gymnasium gym, ArrayList<Integer> slotAvailable, int capacity) {
		ownerDBService.addGymDetails(gym, slotAvailable, capacity);
	}
	
	public boolean isOwnerApproved(String ownerId) {
		return ownerDBService.isOwnerApproved(ownerId);
	}
}
