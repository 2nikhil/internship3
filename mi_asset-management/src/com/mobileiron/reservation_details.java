package com.mobileiron;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;

public class reservation_details {
	
	private String asset_number;
	private int user_id;
    private String start_date;
    private String end_date;
    
    
    
    @XmlElement
	public String get_asset_number()
	{
		return asset_number;
	}
	
	public void set_asset_number(String asset_number)
	{
		this.asset_number=asset_number;
	}
	
	@XmlElement
	public int get_user_ID()
	{
		return user_id;
	}
	
	public void set_user_ID(int user_id)
	{
		this.user_id=user_id;
	}
	
	@XmlElement
	public String get_startdate()
	{
		return start_date;
	}
	
	public void set_start_date(String startdate)
	{
		this.start_date=startdate;
	}
	
	@XmlElement
	public String get_end_date()
	{
		return end_date;
	}
	
	public void set_end_date(String enddate)
	{
		this.end_date=enddate;
	}
    
    

}
