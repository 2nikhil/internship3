package com.mobileiron;

//DAO-data access object

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;






public class AssetsDAO {
	Assets_info list;
	reservation_details rd;
	
public Assets_info assets_create(Assets_info ai){
	
	Connection c=null;
	
	System.out.println("success after connection=null");
	PreparedStatement ps= null;
	try  // , department, device_purchase_date, device_type, IMEI, is_head_quarters_device,is_rooted_or_jail_broken_device, manufacturer, MDT_No, model_number
	{
		c=connectionHelper.getconnection();
		System.out.println("success after gettingconnectionhahahaha");
		ps=c.prepareStatement("INSERT INTO mi_mobiledevices (allowed_upgrade_or_not,asset_number,color,comments,department,device_type,IMEI,is_head_quarters_device,is_rooted_or_jail_broken_device,manufacturer,MDT_no,model_number) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)" ,new String[] { "ID" }); //allowed_upgrade_or_not, 
		
	    ps.setBoolean(1, ai.get_allowed_upgrade());
		ps.setString(2,ai.get_asset_number());
		ps.setString(3, ai.get_color());
		ps.setString(4,ai.get_comments() );
		ps.setString(5, ai.get_department());
		ps.setString(6, ai.get_device_type());
		ps.setString(7, ai.get_IMEI());
		ps.setBoolean(8, ai.get_is_head_quarters_device());
		ps.setBoolean(9, ai.get_is_rooted_or_jail_broken());
		ps.setString(10, ai.get_manufacturer());
		ps.setString(11, ai.get_MDT_no());
		ps.setString(12,ai.get_model_number());
		
		
		/*ps.setString(2, "yellow");
		ps.setString(3, "okparty");
		/*---still fill these */
		System.out.println("success before line31 mobileID");
		/* ResultSet rs = ps.getGeneratedKeys();
         rs.next();
         // Update the id in the returned object. This is important as this value must be returned to the client.
         int id = rs.getInt(1);
        ai.set_mobile_ID(id);*/
        System.out.println("success after mobileID");
		
		ps.executeUpdate();
	}
	
	catch(SQLException e)
	{
		e.printStackTrace();
		throw new RuntimeException(e);
		
	}
	finally
	{
		connectionHelper.close(c);
		
	}
	return ai;
	
}

public void printfun(){
	System.out.println("yes entered here");
}

public Assets_info assets_update(Assets_info ai) {
	
	Connection c=null;
	PreparedStatement ps= null;
	
	try
	{
		
		 c = connectionHelper.getconnection();
	  
		
		ps=c.prepareStatement("UPDATE mi_mobiledevices SET allowed_upgrade_or_not=?,asset_number=?,color=?,comments=?,department=?,device_type=?,IMEI=?,is_head_quarters_device=?,is_rooted_or_jail_broken_device=?,manufacturer=?,MDT_no=?,model_number=? where asset_number=?");
		//, comments=?, department=?, device_purchase_date=?, device_type=?, IMEI=?, is_head_quarters_device=?,is_rooted_or_jail_broken_device=?, manufacturer=?, MDT_No=?, model_number=?
		//ps.setBoolean(1, ai.get_allowed_upgrade());
		ps.setBoolean(1, ai.get_allowed_upgrade());
		ps.setString(2,ai.get_asset_number());
		ps.setString(3, ai.get_color());
		ps.setString(4,ai.get_comments() );
		ps.setString(5, ai.get_department());
		ps.setString(6, ai.get_device_type());
		ps.setString(7, ai.get_IMEI());
		ps.setBoolean(8, ai.get_is_head_quarters_device());
		ps.setBoolean(9, ai.get_is_rooted_or_jail_broken());
		ps.setString(10, ai.get_manufacturer());
		ps.setString(11, ai.get_MDT_no());
		ps.setString(12,ai.get_model_number());
		ps.setString(13, ai.get_asset_number());
		
		
		/*---still fill these */
		
		
		ps.executeUpdate();
	}
	
	catch(SQLException e)
	{
		e.printStackTrace();
		throw new RuntimeException(e);
	}
	finally
	{
		connectionHelper.close(c);
	}
	

	
	return ai;
}

public boolean assets_delete(String assetsdelete) {
	 
	 Connection c=null;
	 try{
	 c=connectionHelper.getconnection();
	 PreparedStatement ps=c.prepareStatement("DELETE FROM mi_mobiledevices where asset_number= ?");
	 ps.setString(1, assetsdelete);
	 int count=ps.executeUpdate();
	 return count==1;
	 
	 }catch(SQLException e)
	 {
		 e.printStackTrace();
		 throw new RuntimeException(e);
	 }
	 
	 finally{
		 connectionHelper.close(c);
	 }
	
}

public List<Assets_info> find() {
	List<Assets_info> list= new ArrayList<Assets_info>();
	/*Assets_info objAsset = new Assets_info();
	objAsset.set_asset_number("1");
	list.add(objAsset);*/
	 Connection c = null;
	 //int records_per_page_values
 	String sql = "SELECT * FROM mi_mobiledevices";
     try {
         c = connectionHelper.getconnection();
         Statement s = c.createStatement();
         System.out.println("hello after satement creation");
         ResultSet rs = s.executeQuery(sql);
         System.out.println("hello after satement execution and into resultset");
         while(rs.next()){
             list.add(processRow(rs));
         }
         
         
     } catch (SQLException e) {
         e.printStackTrace(); 
        throw new RuntimeException(e);
		} finally {
			connectionHelper.close(c);
		}
     return list;
	
	
}

public Object findassetnumber() {
	
	List<Assets_info> list= new ArrayList<Assets_info>();
	
	 Connection c = null;
 	String sql = "SELECT asset_number FROM mi_mobiledevices order by ASC";
     try {
         c = connectionHelper.getconnection();
         Statement s = c.createStatement();
         
         ResultSet rs = s.executeQuery(sql);
         
         while(rs.next()){
             list.add(processRow(rs));
         }
         
         
     } catch (SQLException e) {
         e.printStackTrace(); 
        throw new RuntimeException(e);
		} finally {
			connectionHelper.close(c);
		}
     return list;
	
	
	
	
}

public List<Assets_info> find_for_update(String asset_number){
	List<Assets_info> list= new ArrayList<Assets_info>();
	/*Assets_info objAsset = new Assets_info();
	objAsset.set_asset_number("1");
	list.add(objAsset);*/
	 Connection c = null;
	 //int records_per_page_values
 	String sql = "SELECT * FROM mi_mobiledevices where asset_number=?";
     try {
         c = connectionHelper.getconnection();
         PreparedStatement ps = c.prepareStatement(sql);
         ps.setString(1, asset_number);
         ResultSet rs= ps.executeQuery();
         
         
        
         while(rs.next()){
             list.add(processRow(rs));
         }
         
         
     } catch (SQLException e) {
         e.printStackTrace(); 
        throw new RuntimeException(e);
		} finally {
			connectionHelper.close(c);
		}
     System.out.println(list.size());
     if(list.size()==0){
    	 return null;
     }
     return list;
	
}

public List<Assets_info> findbasingoncategory(String category, String value) {
	List<Assets_info> list= new ArrayList<Assets_info>();
	/*Assets_info objAsset = new Assets_info();
	objAsset.set_asset_number("1");
	list.add(objAsset);*/
	 Connection c = null;
	 //int records_per_page_values
 	String sql = "SELECT * FROM mi_mobiledevices where asset_number=? or color=? or department=? or device_type=?";
 	System.out.println("hell:"+value);
 
     try {
    	 String asset_number="";
    	 String color="";
    	 String department="";
    	 String device_type="";
    	 //boolean is_rooted_or_jail_broken_device=true;--this is boolean ...many changes have to be made to entertain this like @pathparam must also support boolean
    	 
    	
    	 
    	 if(category.compareTo("assetnumber")==0){
    		 asset_number=value;
    	 }
    	 else if(category.compareTo("color")==0){
    		  	 color=value;
    	 }
    	 else if(category.compareTo("department")==0){
    		 System.out.println(department);
    		 department=value;
    	 }
    	 else if(category.compareTo("device_type")==0){
    		 device_type=value;
    	 }
    	 
       
    	 
         c = connectionHelper.getconnection();
         PreparedStatement ps = c.prepareStatement(sql);
         ps.setString(1, asset_number);
         ps.setString(2, color);
         ps.setString(3, department);
         ps.setString(4, device_type);
        
         
         ResultSet rs= ps.executeQuery();
         
         
         
        
         while(rs.next()){
             list.add(processRow(rs));
         }
         
         
     } 
     catch (SQLException e) {
         e.printStackTrace(); 
        throw new RuntimeException(e);
		}
     finally {
			connectionHelper.close(c);
		}
     System.out.println(list.size());
     if(list.size()==0){
    	 return null;
     }
     return list;

}

public Assets_info processRow(ResultSet rs) throws SQLException{
	Assets_info ai= new Assets_info();
	//ai.set_mobile_ID(rs.getInt("mobile_ID"));
	ai.set_allowed_upgrade(rs.getBoolean("allowed_upgrade_or_not"));
	ai.set_asset_number(rs.getString("asset_number"));
	ai.set_color(rs.getString("color"));
	ai.set_comments(rs.getString("comments"));
	ai.set_department(rs.getString("department"));
	//ai.set_date(date);
	ai.set_device_type(rs.getString("device_type"));
	
	ai.set_IMEI(rs.getString("IMEI"));
	ai.set_is_head_quarters_device(rs.getBoolean("is_head_quarters_device"));
	ai.set_is_rooted_or_jail_broken(rs.getBoolean("is_rooted_or_jail_broken_device"));
	ai.set_manufacturer(rs.getString("manufacturer"));
	ai.set_MDT_no(rs.getString("MDT_No"));
	ai.set_MDT_no(rs.getString("model_number"));
	
		
	return ai;
}

public List<Assets_info> find_manufacturer_modelno() {
	List<Assets_info> list= new ArrayList<Assets_info>();

	 Connection c = null;
	
	 String sql = "SELECT DISTINCT manufacturer,model_number FROM mi_mobiledevices";
	 try{
		 c = connectionHelper.getconnection();
		 PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs= ps.executeQuery();
		while(rs.next()){
			list.add(processmanufactuer_modelno(rs));
		}
	 }
	  catch (SQLException e) {
	         e.printStackTrace(); 
	        throw new RuntimeException(e);
			}
	 finally{
		 connectionHelper.close(c);
	 }
 	
 	
 	return list;
	
}

private Assets_info processmanufactuer_modelno(ResultSet rs)throws SQLException {
	Assets_info ai= new Assets_info();
	ai.set_manufacturer(rs.getString("manufacturer"));
	ai.set_model_number(rs.getString("model_number"));
	return ai;
}

public List<Assets_info> list_of_values(String manufacturer) {
	
	List<Assets_info> list= new ArrayList<Assets_info>();

	 Connection c = null;
	
	 String sql = " select md.asset_number,model_number,manufacturer,user_id from reservations AS rs RIGHT JOIN mi_mobiledevices AS md on rs.asset_number=md.asset_number where manufacturer=?";
	 try{
		 c = connectionHelper.getconnection();
		 PreparedStatement ps = c.prepareStatement(sql);
		 ps.setString(1, manufacturer);
		ResultSet rs= ps.executeQuery();
		while(rs.next()){
			list.add(processlist(rs));
		}
	 }
	  catch (SQLException e) {
	         e.printStackTrace(); 
	        throw new RuntimeException(e);
			}
	 finally{
		 connectionHelper.close(c);
	 }
	
	
	return list;
	
}

private Assets_info processlist(ResultSet rs) throws SQLException {
	Assets_info ai= new Assets_info();
	ai.set_asset_number(rs.getString("asset_number"));
	ai.set_model_number(rs.getString("model_number"));
	ai.set_manufacturer(rs.getString("manufacturer"));
	ai.set_user_ID(rs.getInt("user_id"));
	
	return ai;
}
//int userid,String asset_number,String start_date,String end_date

public reservation_details register_user(reservation_details rd){
	
Connection c=null;
	
	System.out.println("success after connection=null");
	PreparedStatement ps= null;
	try  // , department, device_purchase_date, device_type, IMEI, is_head_quarters_device,is_rooted_or_jail_broken_device, manufacturer, MDT_No, model_number
	{
		c=connectionHelper.getconnection();
		System.out.println("success after gettingconnectionhahahaha");
		ps=c.prepareStatement("INSERT INTO reservations (asset_number,user_id,start_date,end_date) values (?,?,?,?)" ,new String[] { "ID" }); //allowed_upgrade_or_not, 
		
	   
		ps.setString(1,rd.get_asset_number());
		
		
		ps.setInt(2, rd.get_user_ID());
		
		java.sql.Date sql_startDate = java.sql.Date.valueOf(rd.get_startdate());
		
		ps.setDate(3,sql_startDate);
		java.sql.Date sql_endDate = java.sql.Date.valueOf(rd.get_end_date());
		
		ps.setDate(4, sql_endDate);
		
	
		
		
		

		System.out.println("success before line31 mobileID");
		/* ResultSet rs = ps.getGeneratedKeys();
         rs.next();
         // Update the id in the returned object. This is important as this value must be returned to the client.
         int id = rs.getInt(1);
        ai.set_mobile_ID(id);*/
        System.out.println("success after mobileID");
		
		ps.executeUpdate();
	}
	
	catch(SQLException e)
	{
		e.printStackTrace();
		throw new RuntimeException(e);
		
	}
	finally
	{
		connectionHelper.close(c);
		
	}
	return rd;
}

public List<Assets_info> account_details(int user_id)  {
	List<Assets_info> list= new ArrayList<Assets_info>();
	Connection con=null;
	PreparedStatement ps;
	try{
		String sql="select * from mi_mobiledevices as md LEFT JOIN  reservations as r on md.asset_number=r.asset_number where user_id=?";
		con=connectionHelper.getconnection();
		
		ps = con.prepareStatement(sql);
		ps.setInt(1, user_id);
		ResultSet rs =ps.executeQuery();
		
		while(rs.next()){
			list.add(processing_account_details(rs));
		}
	}
	catch(SQLException e)
	{
		e.printStackTrace();
		throw new RuntimeException(e);
	}
	finally{
		connectionHelper.close(con);
	}
	return list;
}

private Assets_info processing_account_details(ResultSet rs) throws SQLException {
	Assets_info ai = new Assets_info();
	
	
	ai.set_mobile_ID(rs.getInt("mobile_ID"));
	ai.set_allowed_upgrade(rs.getBoolean("allowed_upgrade_or_not"));
	ai.set_asset_number(rs.getString("asset_number"));
	ai.set_color(rs.getString("color"));
	ai.set_comments(rs.getString("comments"));
	ai.set_department(rs.getString("department"));
	//ai.set_date(date);
	ai.set_device_type(rs.getString("device_type"));
	
	ai.set_IMEI(rs.getString("IMEI"));
	ai.set_is_head_quarters_device(rs.getBoolean("is_head_quarters_device"));
	ai.set_is_rooted_or_jail_broken(rs.getBoolean("is_rooted_or_jail_broken_device"));
	ai.set_manufacturer(rs.getString("manufacturer"));
	ai.set_MDT_no(rs.getString("MDT_No"));
	ai.set_model_number(rs.getString("model_number"));
	
	 
	 DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
	 String strDate = dateFormat.format(rs.getDate("start_date"));
	 String endDate = dateFormat.format(rs.getDate("end_date"));
	 
	 
	ai.set_start_date(strDate);
	ai.set_end_date(endDate);
	
	return ai;
}

public boolean reserved_delete(String asset_number) {
	Connection con=null;
	System.out.println("yes bro u entered rey");
	try{
		
		String sql="DELETE from reservations where asset_number=?";
		con= connectionHelper.getconnection();
		System.out.println("yes bro u entered rey after connection");
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, asset_number);
		 int count=ps.executeUpdate();
		 System.out.println("yes bro u entered rey after execute update");
		 return count==1;
		 
		 }catch(SQLException e)
		 {
			 e.printStackTrace();
			 throw new RuntimeException(e);
		 }
		 
		 finally{
			 connectionHelper.close(con);
		 }
	
}




}
 