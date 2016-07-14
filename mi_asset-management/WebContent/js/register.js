var value;

function get_details() {
    var manufacturer=$('#manufacturer option:selected').text();
    alert(manufacturer);
    var startdate=document.getElementById("startdate").value;
    var enddate=document.getElementById("enddate").value;
    if(startdate=="" || enddate=="")
        swal("enter dates");
    else{
    var name1,name2,name3,name4;
    $("#fill >tbody").empty();
    //alert(manufacturer);
    
    $.ajax({
        type: "GET",
        cache: "false",
        url: "http://localhost:8080/mi_asset-management/rest/assets/register/manufacturers/"+manufacturer,
        dataType: "xml",
        success: function(xml) {
            $(xml).find('assets_infoes').each(function() {
                $(this).find("Assets_info").each(function() {


                    $(this).find("_asset_number").each(function() {
                        name1 = $(this).text();

                    });



                    $(this).find("_user_ID").each(function() {
                        name2 = $(this).text();



                    });

                   

                    

                   
/*
                    $(this).find("_department").each(function() {
                        name7 = $(this).text();


                    });
                */

                
                    



                    $(this).find("_manufacturer").each(function() {
                        name3 = $(this).text();


                    });

                    $(this).find("_model_number").each(function() {
                        name4 = $(this).text();


                    });
                    var button='<input type="button" value="register" style="background-color:black" class="reg" onclick="local(\''+name1+'\')"/>'
                    var get_notified="<input type='button' value='get notified'/>"
                    
                        if(name2=="0"){
                            $("#fill").append('<tbody><tr col-md-3 name="table_rows" class="button" style="padding:60px;background-color:#40bf79;width:500px;color:white"><td>' + name1 + '</td>+<td>' + name2 + '</td>+<td>' + name3 + '</td>++<td>' + name4 + '</td>+<td>'+"available"+'</td>+<td>'+button+'</td></tr></tbody>');
                    
                        }
                        else
                        {
                            $("#fill").append('<tbody><tr  col-md-3 name="table_rows" style="padding:60px;width:500px;"><td>' + name1 + '</td>+<td>' + name2 + '</td>+<td>' + name3 + '</td>++<td>' + name4 + '</td>+<td>'+"notavailable"+'</td>+<td>'+get_notified+'</td></tr></tbody>');
                        }

                    
          name3 = name1 = name4 =name2= "";

                });

            });



        }

    });
}
  
}



function get_manufacturers() {
    var name;

    $.ajax({
        type: "GET",
        cache: "false",
        dataType: "xml",
        url: "http://localhost:8080/mi_asset-management/rest/assets/manufacturers",
        success: function(xml) {

            $(xml).find('assets_infoes').each(function() {

                $(this).find("_manufacturer").each(function() {
                    name = $(this).text();

                    $("#manufacturer").append("<option>" + name + "</option>");


                });

                  $(this).find("_model_number").each(function() {
                    name = $(this).text();

                    $("#modelno").append("<option>" + name + "</option>");


                });




            });
        }


    });



}

      
function local(asset_number){
    swal({
        title: "Are you sure?",
        text: "would you like to register",
        type: "warning",
        showCancelButton: true,
        confirmButtonColor: "#DD6B55",
        confirmButtonText: "Yes, go for it!",
        closeOnConfirm: false
    }, function() {
        swal("Registered!", "Selected device is registered", "success");

 
$("#modelno").value;
//var manufacturer=$('#manufacturer :selected').text();

/*
if($('#modelno :selected').text()!="")
   var modelno=$('#modelno :selected').text();
*/

if(document.getElementById("startdate").value!="")
  var start_date=document.getElementById("startdate").value;
else
    swal("please enter startdate");


if(document.getElementById("enddate").value!="")
  var end_date=document.getElementById("enddate").value;
else
    swal("please enter startdate");

var userid=Math.floor((Math.random()*10)+1); //remove afterwards
  

  $.ajax({
        type: "POST",
        cache: "false",
        url: "http://localhost:8080/mi_asset-management/rest/assets/register_user_device/"+userid+"/"+asset_number+"/"+start_date+"/"+end_date,
        dataType: "xml",
        success: function(xml) {
            

          
          location.reload();
            
           
        }
    });
});
}


