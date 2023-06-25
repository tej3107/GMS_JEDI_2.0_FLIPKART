package com.flipkart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.flipkart.constants.SQLConstants;
import com.flipkart.utils.DBUtils;

public class AdminGMSDao {
	/**
	 * @param args
	 */
   
   public void fetchGymOwnerDetails() {
//	   System.out.println("Connecting to database...");
	   
	   Connection conn = null;
	   PreparedStatement stmt = null;
	   
	   try {
		   conn = DBUtils.getConnection();
		   
		   stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_ALL_OWNER_QUERY);
		   ResultSet output = stmt.executeQuery();

		   if (output.next()) {
		       // At least one gym owner is present
		       System.out.println("\n\tID\tGymOwner Name");
		       do {
		           System.out.println("\t" + output.getString(1) + " \t " + output.getString(2));
		       } while (output.next());
		   } else {
		       // No gym owner present
		       System.out.println("No gym owner registered yet");
		   }

	   } catch(SQLException sqlExcep) {
//		      System.out.println(sqlExcep);
	   } catch(Exception excep) {
	      excep.printStackTrace();
	   }
   }
   
   

   public void fetchGymnasiumDetails() {
//	   System.out.println("Connecting to database...");
	   
	   Connection conn = null;
	   PreparedStatement stmt = null;
	   
	   try {
		   conn = DBUtils.getConnection();
		   
		   stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_ALL_GYM_QUERY);
		   ResultSet output = stmt.executeQuery();

		   if (output.next()) {
		       // At least one gym owner is present
			   System.out.println("\n\tID\tGymnasium Name");
		       do {
		           System.out.println("\t" + output.getString(1) + " \t " + output.getString(2));
		       } while (output.next());
		   } else {
		       // No gym owner present
		       System.out.println("No gymnasiums registered yet");
		   }
	   } catch(SQLException sqlExcep) {
//		      System.out.println(sqlExcep);
	   } catch(Exception excep) {
	      excep.printStackTrace();
	   } 
   }
   
   

   public boolean fetchPedningGymOwnerRequests() {
	    // System.out.println("Connecting to database...");

	    Connection conn = null;
	    PreparedStatement stmt = null;

	    try {
	        conn = DBUtils.getConnection();

	        stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_PENDING_OWNER_REQ_QUERY);
	        ResultSet output = stmt.executeQuery();

	        if (output.next()) {
	            // At least one gym owner is present
	            System.out.println("\n\tID\tGymOwner Name");
	            do {
	                System.out.println("\t" + output.getString(1) + " \t " + output.getString(2));
	            } while (output.next());
	        } else {
	            // No gym owner present
	            System.out.println("No pending gymowner requests");
	            return false;
	        }
	    } catch (SQLException sqlExcep) {
	        // System.out.println(sqlExcep);
	    } catch (Exception excep) {
	        excep.printStackTrace();
	    }
	    return true;
	}

   
   
   
   public boolean fetchPendingGymnasiumRequest() {
	    // System.out.println("Connecting to database...");

	    Connection conn = null;
	    PreparedStatement stmt = null;

	    try {
	        conn = DBUtils.getConnection();

	        stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_PENDING_GYM_REQ_QUERY);
	        ResultSet output = stmt.executeQuery();

	        if (output.next()) {
	            // At least one gymnasium request is present
	            System.out.println("\n\tID\tGymnasium Name");
	            do {
	                System.out.println("\t" + output.getString(1) + " \t " + output.getString(2));
	            } while (output.next());
	        } else {
	            // No gymnasium request present
	            System.out.println("No gymnasium request present");
	            return false;
	        }
	    } catch (SQLException sqlExcep) {
	        // System.out.println(sqlExcep);
	    } catch (Exception excep) {
	        excep.printStackTrace();
	    }
	    return true;
	}

   
   
   public void updateAllPendingGymOwnerRequests() {
//	   System.out.println("Connecting to database...");
	   
	   Connection conn = null;
	   PreparedStatement stmt = null;
	   
	   try {
		   conn = DBUtils.getConnection();
		   
		   stmt = conn.prepareStatement(SQLConstants.SQL_APPR_ALL_OWNER_QUERY);
		   stmt.executeUpdate();
	   } catch(SQLException sqlExcep) {
//		      System.out.println(sqlExcep);
	   } catch(Exception excep) {
	      excep.printStackTrace();
	   } 
   }

   
   
   public void updateAllPendingGymnasiumRequests() {
//	   System.out.println("Connecting to database...");
	   
	   Connection conn = null;
	   PreparedStatement stmt = null;
	   
	   try {
		   conn = DBUtils.getConnection();
		   
		   stmt = conn.prepareStatement(SQLConstants.SQL_APPR_ALL_GYM_QUERY);
		   stmt.executeUpdate();
	   } catch(SQLException sqlExcep) {
//		      System.out.println(sqlExcep);
	   } catch(Exception excep) {
	      excep.printStackTrace();
	   } 
   }
   
   
   
   public void updateSingleGymOwnerRequests(String id) {
//	   System.out.println("Connecting to database...");
	   
	   Connection conn = null;
	   PreparedStatement stmt = null;
	   
	   try {
		   conn = DBUtils.getConnection();
		   
		   stmt = conn.prepareStatement(SQLConstants.SQL_APPR_SING_OWNER_REQ_QUERY);
		   stmt.setString(1, id);
		   stmt.executeUpdate();
	   } catch(SQLException sqlExcep) {
//		      System.out.println(sqlExcep);
	   } catch(Exception excep) {
	      excep.printStackTrace();
	   } 
   }
   
   
   
   public void updateSingleGymnasiumRequests(String id) {
//	   System.out.println("Connecting to database...");
	   
	   Connection conn = null;
	   PreparedStatement stmt = null;
	   
	   try {
		   conn = DBUtils.getConnection();
		   
		   stmt = conn.prepareStatement(SQLConstants.SQL_APPR_SING_GYM_REQ_QUERY);
		   stmt.setString(1, id);
		   stmt.executeUpdate();
	   } catch(SQLException sqlExcep) {
//		      System.out.println(sqlExcep);
	   } catch(Exception excep) {
	      excep.printStackTrace();
	   } 
   }
   
   public void unApproveGymOwner(String gymOwnerId) {
//	   System.out.println("Connecting to database...");
	   
	   Connection conn = null;
	   PreparedStatement stmt = null;
	   
	   try {
		   conn = DBUtils.getConnection();
		   
		   stmt = conn.prepareStatement(SQLConstants.SQL_UNAPPR_SING_GYM_REQ_QUERY);
		   stmt.setString(1, gymOwnerId);
		   stmt.executeUpdate();
		   
		   stmt = conn.prepareStatement(SQLConstants.SQL_UNAPPR_SING_OWNER_REQ_QUERY);
		   stmt.setString(1, gymOwnerId);
		   stmt.executeUpdate();
		   
	   } catch(SQLException sqlExcep) {
//		      System.out.println(sqlExcep);
	   } catch(Exception excep) {
	      excep.printStackTrace();
	   }
   }
   
}
