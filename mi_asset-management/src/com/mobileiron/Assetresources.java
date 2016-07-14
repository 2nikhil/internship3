package com.mobileiron;

import com.mobileiron.AssetsDAO;
import com.mobileiron.Assets_info;

import java.io.BufferedReader;
import java.io.FileReader;

import java.util.Date;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


@Path(value="/assets")
public class Assetresources {
    AssetsDAO dao = new AssetsDAO();
   


    @GET 
    @Produces(value={"application/json", "application/xml"})
    public List<Assets_info> findall() {
       
        return this.dao.find();
    }
    
    @GET @Path("{id}")
    @Produces(value={"application/json", "application/xml"})
    public List<Assets_info> find_update(@PathParam("id") String id){
    	 return this.dao.find_for_update(id);
    }
    
    @GET @Path("/{category}/{value}")
    @Produces(value={"application/json", "application/xml"})
    public List<Assets_info> findbasingonfilters(@PathParam("category") String category,
    		                                     @PathParam("value") String value){
    	System.out.println("assetresource:-"+category+value);
    	 return this.dao.findbasingoncategory(category,value);
    	
    }
    
    @GET @Path("/manufacturers")
    @Produces(value={"application/json", "application/xml"})
    public List<Assets_info> findmanufacturermodelno(){
    	return this.dao.find_manufacturer_modelno();
    }
    
    @GET @Path("/register/manufacturers/{manufacturer}")
    @Produces(value={"application/json", "application/xml"})
    public List<Assets_info> finding_list_manufacturer(@PathParam("manufacturer") String manufacturer){
    	return this.dao.list_of_values(manufacturer);
    }
    
    @GET @Path("/user_account/{user_id}")
    @Produces(value={"application/json", "application/xml"})
    public List<Assets_info> finding_accountdetails(@PathParam("user_id") int user_id){
    	return this.dao.account_details(user_id);
    }
    

    @POST @Path("/register_user_device/{userid}/{asset_number}/{start_date}/{end_date}")
   
    public Response assets_create(@PathParam("userid") int userid,
    							  @PathParam("asset_number") String asset_number,
    							  @PathParam("start_date") String start_date,
    							  @PathParam("end_date") String end_date) {
    	reservation_details rd = new reservation_details();
    	rd.set_asset_number(asset_number);
    	rd.set_user_ID(userid);
        rd.set_start_date(start_date);
        rd.set_end_date(end_date);
        dao.register_user(rd);
        return Response.status(200).entity("<a href=\"C:/Users/intern/workspace/mi_asset-management/WebContent/mi_front_end.html\">go home</a>").build();
    } 

    

	@POST
    public Response adduser(
    		@FormParam("allowedupgradeornot") boolean allowedupgradeornot,
    		@FormParam("assetnumber") String assetnumber,
    		@FormParam("color") String color,
    		@FormParam("comments") String comments,
    		@FormParam("department") String department,
    		// @FormParam("device_purchasedate") ,
    		@FormParam("devicetype") String devicetype,
    		@FormParam("IMEI") String IMEI,
    		@FormParam("isheadquarters") boolean isheadquarters,
    		@FormParam("isrootedorjailbroken") boolean isrootedorjailbroken,
    		@FormParam("manufacturer") String manufacturer,
    		@FormParam("MDT_no") String MDT_no,
    		@FormParam("modelnumber")String modelnumber) {
    	
    	Assets_info ai = new Assets_info();
    	ai.set_allowed_upgrade(allowedupgradeornot);
    	ai.set_asset_number(assetnumber);
    	ai.set_color(color);
    	ai.set_comments(comments);
    	ai.set_department(department);
    	ai.set_department(department);
    	ai.set_device_type(devicetype);
    	ai.set_IMEI(IMEI);
    	ai.set_is_head_quarters_device(isheadquarters);
    	ai.set_is_rooted_or_jail_broken(isrootedorjailbroken);
    	ai.set_manufacturer(manufacturer);
    	ai.set_MDT_no(MDT_no);
    	ai.set_model_number(modelnumber);
    	
    	
    	
    	
    	dao.assets_create(ai);
    	return Response.status(200).entity("<a href=\"C:/Users/intern/workspace/mi_asset-management/WebContent/mi_front_end.html\">go home</a>").build();
    	
    	//return Response.seeOther("file:///C:/Users/intern/workspace/mi_asset-management/WebContent/mi_front_end.html");
    	//return Response.seeOther("file:///C:/Users/intern/workspace/mi_asset-management/WebContent/mi_front_end.html");
    }
    
/*    @POST @Path(value="/register")
    public Assets_info register(
    		)
    
   */ 
    
    @POST @Path(value="/update")
    public Assets_info updateassets(
    		@FormParam("allowedupgradeornot") boolean allowedupgradeornot,
    		@FormParam("assetnumber") String assetnumber,
    		@FormParam("color") String color,
    		@FormParam("comments") String comments,
    		@FormParam("department") String department,
    		// @FormParam("device_purchasedate") ,
    		@FormParam("devicetype") String devicetype,
    		@FormParam("IMEI") String IMEI,
    		@FormParam("isheadquarters") boolean isheadquarters,
    		@FormParam("isrootedorjailbroken") boolean isrootedorjailbroken,
    		@FormParam("manufacturer") String manufacturer,
    		@FormParam("MDT_no") String MDT_no,
    		@FormParam("modelnumber")String modelnumber) {
    	Assets_info ai = new Assets_info();
    	ai.set_allowed_upgrade(allowedupgradeornot);
    	ai.set_asset_number(assetnumber);
    	ai.set_color(color);
    	ai.set_comments(comments);
    	ai.set_department(department);
    	ai.set_department(department);
    	ai.set_device_type(devicetype);
    	ai.set_IMEI(IMEI);
    	ai.set_is_head_quarters_device(isheadquarters);
    	ai.set_is_rooted_or_jail_broken(isrootedorjailbroken);
    	ai.set_manufacturer(manufacturer);
    	ai.set_MDT_no(MDT_no);
    	ai.set_model_number(modelnumber);
    	
    	
    	return this.dao.assets_update(ai);
    }
    
    
    /*@PUT
    @Path(value="/assets/{id}")
    @Consumes(value={"application/json", "application/xml"})
    @Produces(value={"application/json", "application/xml"})
    public Assets_info assets_update(Assets_info ai) {
        System.out.println("updating asset ");
        return this.dao.assets_update(ai);
    } */
/*
    @DELETE
    @Path(value="{id}")
    @Produces(value={"application/json", "application/xml"})
    public void remove_assets(@PathParam(value="id") int mobile_ID) {
        System.out.println("deleting the specified");
        this.dao.assets_delete(mobile_ID);
    }  */
    

    @DELETE
    @Path(value="{id}")
    @Produces(value={"application/json", "application/xml"})
    public void remove_assets(@PathParam(value="id") String assetnumber) {
        System.out.println("deleting the specified");
        this.dao.assets_delete(assetnumber);
    }
    
    @DELETE
    @Path("/cancel/{asset_number}")
    @Produces(value={"application/json", "application/xml"})
    public void remove_reserved_device(@PathParam("asset_number") String asset_number){
    	this.dao.reserved_delete(asset_number);
    }
    
    
}