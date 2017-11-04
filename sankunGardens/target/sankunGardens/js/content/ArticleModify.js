$(function() {
    common.showMessage($("#message").val());
    $("#mainForm").validate({
        rules : {
            "title" : "required",
            "content" : "required",
            "weight" : {
                required : true,
                digits : true,
                maxlength : 5
            }

        },
        messages : {
            "title" : "请输入标题！",
            "content" : "内容不能为空",
            "weight" : "权重不能为空",
        }
    });
});

function modify() {
	$("#mainForm").submit();
}

function goback() {
    location.href = $('#basePath').val() + '/articles';
}

var menuMap = [];
$(document).ready(function(){
    $(window).on("load",function(){

        $.ajax({
            type : "get" ,
            url : $('#basePath').val() + "/articles/menu",
            success : function(data){
                var dataTitle = data.data;
                $.each(dataTitle,function(index,value) {
                    if(!menuMap[value.parentId]) {
                        menuMap[value.parentId] = new Array();
                    }
                    menuMap[value.parentId].push(value);
                });

                initMenu();
            }
        });

        function initMenu() {
            var menuList = menuMap[0];
            $.each(menuList,function(index,value) {
                $("#flanmu1").append("<OPTION VALUE='"+value.id+"'>"+value.name+"</OPTION>");
            });
        }

    });
});

function initSubMenu1() {
    //alert("akk");
    var sltProvince=document.mainForm1.fid;
    var index=sltProvince.selectedIndex;
    var sltCity=document.mainForm1.zid;
    var menuList = menuMap[sltProvince.options[index].value];

    sltCity.length=1;

    $.each(menuList,function(index,value) {
        $("#zlanmu1").append("<OPTION VALUE='"+value.orderNum+"'>"+value.name+"</OPTION>");
    });
}
