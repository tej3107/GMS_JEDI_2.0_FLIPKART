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
