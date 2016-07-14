package com.mobileiron;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
public class connectionHelper {
	private static String URL;
	private static connectionHelper instance=null;
	
	private connectionHelper(){
		String driver=null;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("after registration");
			URL= "jdbc:mysql://localhost:3306/asset_management"; 
			  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static Connection getconnection() throws SQLException{
		//Connection con=null; //local variables must always be initialized
		try{
			
			if(instance==null)
				instance=new connectionHelper();
			System.out.println("before connection getting");
		 return DriverManager.getConnection(URL,"InternPC","nikhil");
		// System.out.println("after connection getting");//here user-name and password should not be mentioned as it is a webservice and 
		              //gets requests from many requests so dont give...is it right?
		 
		 
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw e;
		}
		
		//return con;
		
				
	}
	
public static void close(Connection connection)
	{
		try
		{
			if(connection!=null)
			{
				connection.close();
			}
				
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}
