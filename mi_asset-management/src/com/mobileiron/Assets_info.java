package com.mobileiron;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;


@XmlRootElement (name="Assets_info")
public class Assets_info {
	private boolean allowed_upgrade;
	
	private int mobile_ID;
	
	private String asset_number;
	
	private String color;
	
	private String comments;
	
	private String department;
	
	private Date date;
	
	private String device_type;
	
	private String IMEI;
	
	private boolean is_head_quarters_device;
	
	private boolean is_rooted_or_jail_broken;
	
	private String manufacturer;
	
	private String MDT_no;
	
	private String model_number;
	
	private int user_id;
	
	private String start_date;
	
	private String end_date;
	
	    
	

	@XmlElement
	public int get_mobile_ID()
	{
		return mobile_ID;
	}
	
	public void set_mobile_ID(int mobile_ID)
	{
		this.mobile_ID=mobile_ID;
	}
	
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
	public boolean get_allowed_upgrade()
	{
		return allowed_upgrade;
	}
	
	public void set_allowed_upgrade(boolean allowed_upgrade)
	{
		this.allowed_upgrade=allowed_upgrade;
	}
	
	
	@XmlElement
	
	public String get_color()
	{
		return color;
	}
	
	public void set_color(String color)
	{
		this.color=color;
	}
	
	@XmlElement
	public String get_comments()
	{
		return comments;
	}
	
	public void set_comments(String comments)
	{
		this.comments=comments;
	}
	
	@XmlElement
	public String get_department()
	{
		return department;
	}
	
	public void set_department(String department)
	{
		this.department=department;
	}
	
	@XmlElement
	
	public Date get_date()
	{
		return date;
	}
	
	public void set_date(Date date)
	{
		this.date=date;
	}
	
	@XmlElement
	
	public String get_device_type()
	{
		return device_type;
	}
	
	public void set_device_type(String device_type)
	{
		this.device_type=device_type;
	}
	
	@XmlElement
	
	public String get_IMEI()
	{
		return IMEI;
	}
	
	public void set_IMEI(String IMEI)
	{
		this.IMEI=IMEI;
	}
	
	@XmlElement
	public boolean get_is_head_quarters_device()
	{
		return is_head_quarters_device;
	}
	
	public void set_is_head_quarters_device(boolean is_head_quarters_device)
	{
		this.is_head_quarters_device=is_head_quarters_device;
	}
	
	@XmlElement
	public boolean get_is_rooted_or_jail_broken()
	{
		return is_rooted_or_jail_broken;
	}
	
	public void set_is_rooted_or_jail_broken(boolean is_rooted_or_jail_broken)
	{
		this.is_rooted_or_jail_broken=is_rooted_or_jail_broken;
	}
	
	
	
	@XmlElement  
	public String get_manufacturer()
	{
		return manufacturer;
	}
	
	public void set_manufacturer (String manufacturer)
	{
		this.manufacturer=manufacturer;
	}
	
	@XmlElement  
	public String get_MDT_no()
	{
		return MDT_no;
	}
	
	public void set_MDT_no (String MDT_no)
	{
		this.MDT_no=MDT_no;
	}
	
	@XmlElement
	public String get_model_number()
	{
		return model_number;
	}
	
	public void set_model_number (String model_number)
	{
		this.model_number=model_number;
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
