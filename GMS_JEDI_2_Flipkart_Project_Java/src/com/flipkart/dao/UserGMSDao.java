/**
 * 
 */
package com.flipkart.dao;
import java.sql.Connection;
import com.flipkart.bean.*;
import com.flipkart.constants.SQLConstants;
import com.flipkart.utils.DBUtils;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 */
public class UserGMSDao {
	/**
	 * @param args
	 */
		   
   public int authenticateUser(String userName, String password) {
	   int exitCode = 4;
	   System.out.println("Connecting to database...");
	   
	   Connection conn = null;
	   PreparedStatement stmt = null;
	   
	   try {
		   
//		   Class.forName("com.mysql.cj.jdbc.Driver");
//		   conn = DriverManager.getConnection(DB_URL, USER, PASS);
		   conn = DBUtils.getConnection();
//		   String sql = "Select * From User Where UserId = (?)";
		   
		   stmt = conn.prepareStatement(SQLConstants.SQL_AUTH_QUERY);
		   stmt.setString(1, userName); 
	
		   ResultSet output = stmt.executeQuery();
		   output.next();
		   String desiredPassword = output.getString(2);
		   
		   if(password.equals(desiredPassword)) return output.getInt(3);
		   else return exitCode;
		   
	   } catch(SQLException sqlExcep) {
		      System.out.println(sqlExcep);
	   } catch(Exception excep) {
	      excep.printStackTrace();
	   }
	   
	   return exitCode;
   }
}
