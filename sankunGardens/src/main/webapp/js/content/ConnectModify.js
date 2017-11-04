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
    location.href = $('#basePath').val() + '/connect';
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
                $("#flanmu3").append("<OPTION VALUE='"+value.id+"'>"+value.name+"</OPTION>");
            });
        }

    });
});

function initSubMenu3() {
    //alert("akk");
    var sltProvince=document.mainForm3.fid;
    var index=sltProvince.selectedIndex;
    var sltCity=document.mainForm3.zid;
    var menuList = menuMap[sltProvince.options[index].value];

    sltCity.length=1;

    $.each(menuList,function(index,value) {
        $("#zlanmu3").append("<OPTION VALUE='"+value.orderNum+"'>"+value.name+"</OPTION>");
    });
}
