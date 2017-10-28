$(function() {
    common.showMessage($("#message").val());
    $("#mainForm").validate({
        rules : {
            "title" : "required",
            "content" : "required",

        },
        messages : {
            "title" : "请输入标题！",
            "content" : "内容不能为空",
        }
    });
});

function add() {
    if(CKEDITOR.instances.content.getData()==""){
        alert("内容不能为空！");
        return false;
    }else {
        document.getElementById("content").innerText=CKEDITOR.instances.content.getData();
        $("#mainForm").submit();
    }
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
                $("#flanmu").append("<OPTION VALUE='"+value.id+"'>"+value.name+"</OPTION>");
            });
        }

    });
});

function initSubMenu() {
    //alert("akk");
    var sltProvince=document.mainForm.fid;
    var index=sltProvince.selectedIndex;
    var sltCity=document.mainForm.zid;

    var menuList = menuMap[sltProvince.options[index].value];

    sltCity.length=1;

    $.each(menuList,function(index,value) {
        $("#zlanmu").append("<OPTION VALUE='"+value.orderNum+"'>"+value.name+"</OPTION>");
    });
}
