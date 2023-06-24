package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.flipkart.constants.SQLConstants;
import com.flipkart.utils.DBUtils;
import com.flipkart.bean.*;

public class CustomerGMSDao {
	
	
	public void registerCustomer(User user, Customer customer) {
		System.out.println("Connecting to database...");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// Getting customer Id
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(SQLConstants.SQL_SIZE_CUSTOMER_QUERY);
		    ResultSet output = stmt.executeQuery();
		    output.next();
		    int count = output.getInt(1);
		    count++;
		    
		    if(count <= 9) user.setUserName("C00" + Integer.toString(count));
		    else if(count <= 99) user.setUserName("C0" + Integer.toString(count));
		    else user.setUserName("C" + Integer.toString(count));
		    
		    
		    // Registering in Customer schema
		    stmt = conn.prepareStatement(SQLConstants.SQL_REGISTER_CUSTOMER_QUERY);
		    stmt.setString(1, user.getUserName());
		    stmt.setString(2, customer.getName());
		    stmt.setString(3, customer.getMobile());
		    stmt.setString(4, customer.getEmail());
		    stmt.setString(5, customer.getAddress());
		    
		    stmt.executeUpdate();
		    
		    
		    // Getting RegId
		    conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(SQLConstants.SQL_SIZE_CUSTOMER_REG_QUERY);
		    output = stmt.executeQuery();
		    output.next();
		    count = output.getInt(1);
		    count++;
		    
		    String regId = new String();
		    if(count <= 9) regId = ("R00" + Integer.toString(count));
		    else if(count <= 99) regId = ("R0" + Integer.toString(count));
		    else regId = ("R" + Integer.toString(count));
		    
		    // Registering in CustomerRegistration Schema
		    stmt = conn.prepareStatement(SQLConstants.SQL_REGISTER_CUSTOMER_REG_QUERY);
		    stmt.setString(1, regId);
		    stmt.setString(2, user.getUserName());
		    stmt.executeUpdate();
		    
		    
		    // Registering in User Schema
		    stmt = conn.prepareStatement(SQLConstants.SQL_REGISTER_CUSTOMER_USER_QUERY);
		    stmt.setString(1, user.getUserName());
		    stmt.setString(2, user.getPassword());
		    stmt.setInt(3, 3);
		    
		    stmt.executeUpdate();
	    } catch(SQLException sqlExcep) {
		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
	}
	
	public void fetchGymList() {
		System.out.println("Connecting to database...");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DBUtils.getConnection();
		    stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_ALL_GYM_QUERY);
	
		    ResultSet output = stmt.executeQuery();
		    while(output.next()) {
		    	System.out.println(output.getString(1) + " " + output.getString(2) + " " + output.getString(3));
		    }
	    } catch(SQLException sqlExcep) {
		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
	}
	
	public void fetchSlotList(String gymId) {
		System.out.println("Connecting to database...");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DBUtils.getConnection();
		    stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_GYM_SLOT_QUERY);
		    stmt.setString(1, gymId); 
		    ResultSet output = stmt.executeQuery();
//		    System.out.println(output);
		    while(output.next()) {
		    	System.out.println("SoltID - "+ output.getString(1) + " : Gymnasium Id - " 
		    			+ output.getString(2) + " : Capacity - " + output.getString(3) + " : Day - " 
		    			+ output.getString(4) +" : Slot Time - " + output.getString(5)+":00hrs");
		    }
	    } catch(SQLException sqlExcep) {
		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
	}
	
	public void bookSlots(String slotId,String customerId) {
		System.out.println("Connecting to database...");
		   
		Connection conn = null;
		PreparedStatement stmt = null;
		   
	    try {
	    	conn = DBUtils.getConnection();
		   
		    stmt = conn.prepareStatement(SQLConstants.SQL_SIZE_BOOK_QUERY);
		    ResultSet output = stmt.executeQuery();
		    output.next();
		    int count = output.getInt(1);
		    count++;
		    
		    stmt = conn.prepareStatement(SQLConstants.SQL_DATE_CHECK_FROM_SLOTID);
		    stmt.setString(1, slotId);
		    output = stmt.executeQuery();
		    output.next();
		    String date = output.getString(1);
		    
		    stmt = conn.prepareStatement(SQLConstants.SQL_INSERT_BOOK_QUERY);
		    stmt.setString(1, Integer.toString(count));
		    stmt.setString(2, slotId);
		    stmt.setString(3, customerId);
		    stmt.setString(4, date);
		    
		    stmt.executeUpdate();
		    
	    } catch(SQLException sqlExcep) {
		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
	    
	    return;
	}
	
	public boolean isFull(String slotId) {
		System.out.println("Connecting to database...");
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DBUtils.getConnection();
		    stmt = conn.prepareStatement(SQLConstants.SQL_COUNT_CURRENT_CAPACITY_QUERY);
		    stmt.setString(1, slotId); 
		    ResultSet output = stmt.executeQuery();
		    output.next();
		    int current_capacity = output.getInt(1);
		    
		    stmt = conn.prepareStatement(SQLConstants.SQL_CHECK_CAPACITY_QUERY);
		    stmt.setString(1, slotId); 
		    output = stmt.executeQuery();
		    output.next();
		    int total_capacity = output.getInt(3);
		    
		    return current_capacity>=total_capacity;
	    } catch(SQLException sqlExcep) {
		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
		return false;
	}
	
	public void bookedGymList(String custId) {
		System.out.println("Connecting to database...");
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DBUtils.getConnection(); 
		    stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_SLOTID_FOR_CUSTOMER);
		    stmt.setString(1, custId); 
		    ResultSet output = stmt.executeQuery();
		    
		    while(output.next()) {
		    	String slotId= output.getString(2);
		    	stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_SLOT_DETAILS_QUERY);
			    stmt.setString(1, slotId); 
			    ResultSet out = stmt.executeQuery();
			    out.next();
			    
			    System.out.println("SoltID - "+ out.getString(1) + " : Gymnasium Id - " 
		    			+ out.getString(2) + " : Capacity - " + out.getString(3) + " : Day - " 
		    			+ out.getString(4) +" : Slot Time - " + out.getString(5)+":00hrs");
		    }
		    
		    
	    } catch(SQLException sqlExcep) {
		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
		return;
	}
	
}
