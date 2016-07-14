package com.mobileiron;

public class user_details {

	int user_id;
	String username;
	String department;
	
	public int get_userid(){
		return user_id;
	}
	
	public void set_userid(int user_id){
		this.user_id=user_id;
	}
	
	public String get_username(){
		return username;
	}
	
	public void set_username(String username){
		this.username=username;
	}
	
	public String get_department(){
		return department;
	}
	
	public void set_department(String department){
		this.department=department;
	}
}
