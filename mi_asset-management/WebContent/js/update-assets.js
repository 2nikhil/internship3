

$(document).ready(function(){



    
  asset_number=localStorage.getItem("asset_no");

  //alert(asset_number);
   calling_ajax_request_get(asset_number);
   

});


function calling_ajax_request_get(asset_number){

 

   $.ajax({
        type: "GET",
        url: "http://localhost:8080/mi_asset-management/rest/assets/" + asset_number,
        cache: false,
        dataType: "xml",
        success: function(xml) {
          
        $(xml).find('assets_infoes').each(function() {
                $(this).find("Assets_info").each(function() {

                       $(this).find("_asset_number").each(function() {
                        name1 = $(this).text();

                    });

                    

                    $(this).find("_color").each(function() {
                        name3 = $(this).text();


                    });

                     $(this).find("_allowed_upgrade").each(function() {
                        name4 = $(this).text();


                    });

                      $(this).find("_MDT_no").each(function() {
                        name5 = $(this).text();


                    });

                       $(this).find("_IMEI").each(function() {
                        name6 = $(this).text();


                    });

                        $(this).find("_department").each(function() {
                        name7 = $(this).text();


                    });

                         $(this).find("_device_type").each(function() {
                        name8 = $(this).text();


                    });

                          $(this).find("_is_head_quarters_device").each(function() {
                        name9 = $(this).text();


                    });

                           $(this).find("_is_rooted_or_jail_broken").each(function() {
                        name10 = $(this).text();


                    });


                            $(this).find("_manufacturer").each(function() {
                        name11 = $(this).text();


                    });

                             $(this).find("_comments").each(function() {
                        name12 = $(this).text();


                    });

                   
                        document.getElementById("1").value=name1;
                        document.getElementById("2").value=name3;
                        document.getElementById("4").value=name4;
                        document.getElementById("9").value=name5;
                        document.getElementById("11").value=name6;
                        document.getElementById("7").value=name7;
                        document.getElementById("5").value=name8;
                        document.getElementById("3").value=name9;
                        document.getElementById("6").value=name10;
                        document.getElementById("8").value=name11;
                       document.getElementById("text-comments").value=name12;

                        


                   

         });
                });
        },


        error: function(jqXHR, exception){
            alert("bro not working check for error ");

        }
    




});
}

function redirect(){

    location.href = "file:///C:/Users/intern/workspace/mi_asset-management/WebContent/mi_front_end.html";
}






/*function update(){
    alert("uhh fucked");

    $("#submit").click(function(){

        var assetnumber=$("#1").val();
        var color=$("#2").val();
        var isheadquarters=$("#3").val();
        var allowedupgradeornot=$("#4").val();
        var devicetype=$("#5").val();
        var isrootedjailbroken=$("#6").val();
        var department=$("#7").val();
        var manufacturer=$("#8").val();
        var MDT_no=$("#9").val();
        var modelnumber=$("#10").val();
        var IMEI=$("#11").val();
        var comments=$("#12").val();


 var datastring='assetnumber='+assetnumber+'color='+color+'isheadquarters='+isheadquarters+'allowedupgradeornot='+'devicetype='+devicetype+'isrootedjailbroken='+'department='+department+' manufacturer='+ manufacturer+'MDT_no='+MDT_no+'modelnumber='+modelnumber+'IMEI='+IMEI+'comments='+comments;
        $.ajax({

       async : true,
       crossDomain: true,
        type: "PUT",
        url: "http://localhost:8080/mi_asset-management/rest/assets/update",
        contentType: "application/x-www-form-urlencoded",

        cache: false,
        data:datastring,
        //dataType: "xml",
        success: function(xml) {
           
            swal("successfully updated");
        },

        error: function(jqXHR, textStatus, errorThrown) {
               swal("unsuccessful updation...try again")
            }

        })
   

});
}
*/

