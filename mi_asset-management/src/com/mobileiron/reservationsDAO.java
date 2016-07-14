package com.mobileiron;

import java.util.Date;

import java.sql.PreparedStatement;

import java.sql.Connection;
import java.sql.SQLException;

public class reservationsDAO {

	
	public reservation_details register(int user_id,String asset_number){
		
		return null;
	}

	public Assets_info register(String user_id, String asset_number, Date start_time, Date end_time) {
		Connection c=null;
		PreparedStatement ps=null;
		
		
		String sql="INSERT into reservations (asset_number,user_id,start_time,end_time) values (?,?,?,?)";
		try{
			c=connectionHelper.getconnection();
			ps =c.prepareStatement(sql);
			ps.setString(1, asset_number);
			ps.setString(2, user_id);
			//ps.setTimestamp(3, start_time);
			
			
			
		}
		catch(SQLException e){
			
		}
		finally{
			
		}
		return null;
	}

	public void user_register() {
	Connection c= null;
	PreparedStatement ps= null;
	String sql="Insert into user (user_id,user_name,department) values (?,?,?)";
		
	}
}
