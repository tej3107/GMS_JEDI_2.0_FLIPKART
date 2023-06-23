/**
 * 
 */
package com.flipkart.dao;
import java.sql.Connection;
import com.flipkart.bean.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.flipkart.constants.SQLConstants;
import com.flipkart.utils.DBUtils;
/**
 * 
 */
public class GymOwnerGMSDao {
	
	
	
	public void registerGymOwner(User user, GymOwner owner) {
		System.out.println("Connecting to database...");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// Getting owner Id
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(SQLConstants.SQL_SIZE_GYMOWNER_QUERY);
		    ResultSet output = stmt.executeQuery();
		    output.next();
		    int count = output.getInt(1);
		    count++;
		    
		    if(count <= 9) user.setUserName("GO00" + Integer.toString(count));
		    else if(count <= 99) user.setUserName("GO0" + Integer.toString(count));
		    else user.setUserName("GO" + Integer.toString(count));
		    
		    
		    
		    // Registering in Owner schema
		    stmt = conn.prepareStatement(SQLConstants.SQL_REGISTER_GYMOWNER_QUERY);
		    stmt.setString(1, user.getUserName());
		    stmt.setString(2, owner.getName());
		    stmt.setString(3, owner.getMobile());
		    stmt.setString(4, owner.getEmail());
		    stmt.setString(5, owner.getAddress());
		    stmt.setString(6, owner.getAadhaarNumber());
		    stmt.setString(7, owner.getPanNumber());
		    stmt.setString(8, owner.getGstNumber());
		    
		    stmt.executeUpdate();
		    
		    
		    // Getting RegId
		    conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(SQLConstants.SQL_SIZE_GYMOWNER_REG_QUERY);
		    output = stmt.executeQuery();
		    output.next();
		    count = output.getInt(1);
		    count++;
		    
		    String regId = new String();
		    if(count <= 9) regId = ("R00" + Integer.toString(count));
		    else if(count <= 99) regId = ("R0" + Integer.toString(count));
		    else regId = ("R" + Integer.toString(count));
		    
		    
		    // Registering in CustomerRegistration Schema
		    stmt = conn.prepareStatement(SQLConstants.SQL_REGISTER_GYMOWNER_REG_QUERY);
		    stmt.setString(1, regId);
		    stmt.setString(2, user.getUserName());
		    stmt.executeUpdate();
		    
		    
		    // Registering in User Schema
		    stmt = conn.prepareStatement(SQLConstants.SQL_REGISTER_GYMOWNER_USER_QUERY);
		    stmt.setString(1, user.getUserName());
		    stmt.setString(2, user.getPassword());
		    stmt.setInt(3, 2);
		    
		    stmt.executeUpdate();
	    } catch(SQLException sqlExcep) {
		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
	}
	
	
	public void fetchOwnerDetails(String userName) {
		System.out.println("Connecting to database...");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DBUtils.getConnection();
		   
		    stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_SING_OWNER_DET_QUERY);
		    stmt.setString(1, userName); 
	
		    ResultSet output = stmt.executeQuery();
		    if(output.next()) {
		    	System.out.println("\tId - "+output.getString(1) + " ; User Name - " + output.getString(2));
		    }
	    } catch(SQLException sqlExcep) {
		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
	}
	
	public void fetchMyGyms(String userName) {
		System.out.println("Connecting to database...");
		   
		Connection conn = null;
		PreparedStatement stmt = null;
		   
	    try {
	    	conn = DBUtils.getConnection();
		   
		    stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_OWNER_GYM_DET_QUERY);
		    stmt.setString(1, userName); 
	
		    ResultSet output = stmt.executeQuery();
		    while(output.next()) {
		    	System.out.println("\tId - "+output.getString(1) + " ; User Name - " + output.getString(2));
		    }
	    } catch(SQLException sqlExcep) {
		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
	}
	
	public boolean isOwnerApproved(String userName) {
		System.out.println("Connecting to database...");
		   
		Connection conn = null;
		PreparedStatement stmt = null;
		   
	    try {
	    	conn = DBUtils.getConnection();
		   
		    stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_OWNER_APPROVAL_QUERY);
		    stmt.setString(1, userName); 
	
		    ResultSet output = stmt.executeQuery();
		    if(output.next()) return output.getBoolean(1);
	    } catch(SQLException sqlExcep) {
		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
	    
	    return false;
	}
	
	
	public void addGymDetails(Gymnasium gym, List<Boolean> slotAvailable, int capacity) {
		System.out.println("Connecting to database...");
		   
		Connection conn = null;
		PreparedStatement stmt = null;
		   
	    try {
	    	conn = DBUtils.getConnection();
		   
		    stmt = conn.prepareStatement(SQLConstants.SQL_SIZE_GYM_QUERY);
		    ResultSet output = stmt.executeQuery();
		    output.next();
		    int count = output.getInt(1);
		    count++;
		    
		    if(count <= 9) gym.setGymId("TEJ_GYM" + Integer.toString(count));
		    else if(count <= 99) gym.setGymId("TEJ_GYM" + Integer.toString(count));
		    else gym.setGymId("TEJ_GYM" + Integer.toString(count));
		    
		    stmt = conn.prepareStatement(SQLConstants.SQL_INSERT_GYM_QUERY);
		    stmt.setString(1, gym.getGymId());
		    stmt.setString(2, gym.getName());
		    stmt.setString(3, gym.getAddress());
		    stmt.setDouble(4, gym.getTotalArea());
		    stmt.setInt(5, gym.getNumItem());
		    stmt.setInt(6, 0);
		    stmt.setString(7, gym.getOwnerId());
		    
		    stmt.executeUpdate();
		    
	    } catch(SQLException sqlExcep) {
		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
	    
	    
	    for(int i = 0; i < slotAvailable.size(); i++) {
	    	if(slotAvailable.get(i)) {
		    	try {
			    	conn = DBUtils.getConnection();
				   
				    stmt = conn.prepareStatement(SQLConstants.SQL_SIZE_SLOTS_QUERY);
				    ResultSet output = stmt.executeQuery();
				    output.next();
				    int count = output.getInt(1);
				    count++;
				    
				    String slotId;
				    if(count <= 9) slotId = "S00" + Integer.toString(count);
				    else if(count <= 99) slotId = "S0" + Integer.toString(count);
				    else slotId = "S" + Integer.toString(count);
				    
				    stmt = conn.prepareStatement(SQLConstants.SQL_INSERT_SLOTS_QUERY);
				    stmt.setString(1, slotId);
				    stmt.setInt(2, capacity);
				    stmt.setInt(3, i);
				    stmt.setString(4, gym.getGymId());
				    
				    stmt.executeUpdate();
				    
			    } catch(SQLException sqlExcep) {
				       System.out.println(sqlExcep);
			    } catch(Exception excep) {
			           excep.printStackTrace();
			    }
	    	}
	    }
	    
	    return;
	}
	
}
