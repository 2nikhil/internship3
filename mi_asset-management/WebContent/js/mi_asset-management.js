var iter;
var checkboxes = document.getElementsByName("cb");


$(document).ready(function() {
    $('#select_all').change(function() {

        //--------------this is being called twice check out---------------------------------------------------
        //var check_ = $('#select_all').checked;
        var checkboxes_checked = [];
        var check_box_rows = document.getElementsByName('cb');
        var check_ = check_box_rows[0].checked


        if (check_ == false) {

            for (i = 0; i < checkboxes.length; i++) {
                if (!checkboxes[i].checked)
                    checkboxes[i].checked = true;
            }
        } else {
            for (i = 0; i < checkboxes.length; i++) {
                if (checkboxes[i].checked)
                    checkboxes[i].checked = false;
            }
        }
    });




    
});


function getrequest() {
    
    $("#styling").sticky({
          topSpacing:0
    });


    var name1, name2, name3,name4,name5,name6,name7,name8,name9,name10,name11,name12,name13;
//----------here if the first record is null for few columns then undefined(since no values are being given) is being placed, instead of that null value should be given 
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/mi_asset-management/rest/assets",
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


                    $("#fill").append('<tbody><tr name="table_rows"><td>' + name1 + '</td>+<td>' + name4 + '</td>+<td>' + name3 + '</td>++<td>' + name5 + '</td>++<td>' + name6 + '</td>++<td>' + name7 + '</td>++<td>' + name8 + '</td>++<td>' + name9 + '</td>++<td>' + name10 + '</td>++<td>' + name11 + '</td>++<td>' + name12 + '</td></tr></tbody>')
                    name3 = name1 = name4 = name5 = name6 = name7 = name8 = name9 = name10 = name11 = name12 = name2="";


                });

            });
        }
    });
}


/*

        success:function(xml){
            var columns=['_asset_number','_mobile_ID','_color'];
            var values = new values(columns.length); //creating a array of column length
            $(xml).find('assets_infoes').each(function(){
            $(this).find("Assets_info").each(function(){
                var length_value=columns.length;
                for(i=0;i<length_value;i++)
                {
                    $(this).find(columns[i]).each(function(){
                        values[i]=$(this).text();
                    });

                    $("#fill").append('<tr><td>'+values[i]+'</td></tr>');
                }
                values.fill(" ");
                



        }

    }
})*/




function delete_request() {
    $("#update").hide();
    $("#update_input_fields").hide();

    var table = $('#fill');
    iter = 0;
    table.find('tr').each(function() {
        var trow = $(this);


        trow.append('<td><input type="checkbox" name="cb"/></td>');
        iter += 1;
    });


    $('#delete-selected').show();
    $('#delete').hide();
    $('#add_button').hide();
    $('#back').show();


}




function get_assetnum(i) {
    var table_rows = document.getElementsByTagName('tr');
    var cells = table_rows[i].getElementsByTagName('td');

    var asset_number = cells[0].innerText;
    
    return asset_number;
}


function final_delete() {


    /*alert box code-------------------------------*/
    swal({
        title: "Are you sure?",
        text: "You will not be able to recover deleted fields",
        type: "warning",
        showCancelButton: true,
        confirmButtonColor: "#DD6B55",
        confirmButtonText: "Yes, delete it!",
        closeOnConfirm: false
    }, function() {
        swal("Deleted!", "Selected assets are deleted", "success");


        /*above is alert box code */




        var checkboxes_checked = [];
        var check_box_rows = document.getElementsByName('cb');
        var check = check_box_rows[0].checked

        if (check == false) { //select_all check box not checked

            for (var i = 1; i < checkboxes.length; i++) {
                if (checkboxes[i].checked) {


                    asset_number = get_assetnum(i);

                    calling_ajax_request_delete(asset_number);
                }
            }
        } else {

            all_checkboxes_to_be_deleted();
        }
    });
}


function calling_ajax_request_delete(asset_number) {
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/mi_asset-management/rest/assets/" + asset_number,
        cache: false,
        dataType: "xml",
        success: function(xml) {
            location.reload();
        }
    });
}

function calling_ajax_request_get(asset_number) {

    
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/mi_asset-management/rest/assets/" + asset_number,
        cache: false,
        dataType: "xml",
        success: function(xml) {
            if (xml != null) {



                if (typeof(Storage) !== "undefined") {
                    localStorage.setItem("asset_no", asset_number);

                    //localStorage.getItem("asset_no");



                } else {
                    swal("please update your browser..local storage feature is not working..so updating is not working");
                }

                $(xml).find('assets_infoes').each(function() {


                    $(this).find("Assets_info").each(function() {


                        location.href = "file:///C:/Users/intern/workspace/mi_asset-management/WebContent/update-assets.html";



                    });


                });


            } else {
                swal("not found");
            }


        }




    });




}


function all_checkboxes_to_be_deleted() {

    var len = checkboxes.length - 1;

    for (var i = 1; i <= len; i++) {


        asset_number = get_assetnum(i);

        
        setTimeout(calling_ajax_request_delete(asset_number),9000);

    }
}

function calling_update() {

    document.getElementById("update_input_fields").style.visibility = 'visible';
    // document.getElementById("update_asset_number").value=" ";
    //document.getElementById("update").visibility=false;
    $("#update").hide();
    $("#update_input_fields").animate({
        bottom: '250px'
    }); //not working properly
    $("#update_input_fields").insertBefore("#fill");


    $("#update_input_fields").sticky({
        topSpacing: 0
    });
    



}

function close_update_input_fields_div() {
    $("#update_input_fields").hide();
    location.reload(); //-----this should be changed -----------------------------------------------------

    /* $("#update_input_fields").style.float="right";
      $("#update_input_fields").style.margin-bottom="4px";
      $("#update_input_fields").style.margin-right="4px";
     */
    // document.getElementById("update").visibility=true;
}


function fetch_update_fields() {
    var text_field = document.getElementById("update_asset_number");

    if (text_field.value == "")
        swal("Enter asset_number");
    else {




        asset_number = document.getElementById("update_asset_number").value;

        //swal("Enter asset_number");

        
        text_field.value = "";
        calling_ajax_request_get(asset_number);
    }
}


function get_request_for_search(category_value,value){
var name1,name2,name3,name4,name5,name6,name7,name8,name9,name10,name11,name12,name13;
 
     $.ajax({
        type: "GET",
        url: "http://localhost:8080/mi_asset-management/rest/assets/" + category_value+"/"+value,
        cache: false,
        dataType: "xml",
        success: function(xml) {
            if(xml==undefined){
               swal("sorry...records on the given search values are not found");
              //    getrequest();

             // $("#fill").append('<tr name="table_rows"><td>"not found please type someother value"</td></tr>');
            }

            $("#fill >tbody").empty();  //to empty previous values and display current fetched values


   




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


                    $("#fill").append('<tr name="table_rows"><td>' + name1 + '</td>+<td>' + name3 + '</td>+<td>' + name4 + '</td>++<td>' + name5 + '</td>++<td>' + name6 + '</td>++<td>' + name7 + '</td>++<td>' + name8 + '</td>++<td>' + name9 + '</td>++<td>' + name10 + '</td>++<td>' + name11 + '</td>++<td>' + name12 + '</td></tr>');
                    name3 = name1 = name4 = name5 = name6 = name7 = name8 = name9 = name10 = name11 = name12 = "";


                });

            });




    }

      
  });
}
function handle(e) {

     var search = document.getElementById("search");

    if (e.keyCode === 13) {
        
        var category=document.getElementById("filter");
        var category_value=category.options[category.selectedIndex].value;
    

        value1= search.value;

        
        
        get_request_for_search(category_value,value1);
        //search.value="";
    }
    
    

    return false;
}