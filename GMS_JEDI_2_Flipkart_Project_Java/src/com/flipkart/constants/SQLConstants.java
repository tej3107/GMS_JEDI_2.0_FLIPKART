/**
 * 
 */
package com.flipkart.constants;

/**
 * 
 */
public class SQLConstants {

	public static final String SQL_AUTH_QUERY = "Select * From User Where UserId = (?)";
	
	
	public static final String SQL_FETCH_ALL_OWNER_QUERY = "Select * From GymOwner";
	public static final String SQL_FETCH_ALL_GYM_QUERY = "Select * From Gymnasium";
	public static final String SQL_FETCH_PENDING_OWNER_REQ_QUERY = "Select * From GymOwner Where Approved = 0";
	public static final String SQL_FETCH_PENDING_GYM_REQ_QUERY = "Select * From Gymnasium Where Approved = 0";
	public static final String SQL_APPR_SING_OWNER_REQ_QUERY = "Update GymOwner Set Approved = 1 Where GymOwnerId = (?)";
	public static final String SQL_APPR_SING_GYM_REQ_QUERY = "Update Gymnasium Set Approved = 1 Where GymnasiumId = (?)";
	public static final String SQL_APPR_ALL_OWNER_QUERY = "Update GymOwner Set Approved = 1";
	public static final String SQL_APPR_ALL_GYM_QUERY = "Update Gymnasium Set Approved = 1";
	
	
	public static final String SQL_FETCH_SING_OWNER_DET_QUERY = "Select * From GymOwner Where GymOwnerId = (?)";
	public static final String SQL_FETCH_OWNER_GYM_DET_QUERY = "Select * From Gymnasium Where GymOwnerId = (?)";
	public static final String SQL_FETCH_OWNER_APPROVAL_QUERY = "Select Approved From GymOwner Where GymOwnerId = (?)";
	public static final String SQL_SIZE_GYM_QUERY = "Select Count(*) From Gymnasium";
	public static final String SQL_INSERT_GYM_QUERY = "Insert Into Gymnasium Values (?,?,?,?,?,?,?)";
	public static final String SQL_SIZE_SLOTS_QUERY = "Select Count(*) From Slots";
	public static final String SQL_INSERT_SLOTS_QUERY = "Insert Into Slots Values (?,?,?,?)";
	
	public static final String SQL_FETCH_GYM_SLOT_QUERY = "Select * From Slots Where GymnasiumId = (?)";
	public static final String SQL_SIZE_BOOK_QUERY = "Select Count(*) From BookedSlot";
	public static final String SQL_INSERT_BOOK_QUERY = "Insert Into BookedSlot Values (?,?,?,?)";
	public static final String SQL_COUNT_CURRENT_CAPACITY_QUERY = "Select Count(*) From BookedSlot Where SlotId = (?) AND SlotDate = (?)";
	public static final String SQL_CHECK_CAPACITY_QUERY = "Select * From Slots Where SlotId = (?)";
}