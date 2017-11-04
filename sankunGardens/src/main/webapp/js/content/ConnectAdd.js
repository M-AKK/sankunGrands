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
    location.href = $('#basePath').val() + '/connect';
}

var menuMap = [];
$(document).ready(function(){
    $(window).on("load",function(){

        $.ajax({
            type : "get" ,
            url : $('#basePath').val() + "/articles/menu",
            //url : "http://115.159.35.121:8080/sankunGardens/articles/menu",
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
                $("#flanmu2").append("<OPTION VALUE='"+value.id+"'>"+value.name+"</OPTION>");
            });
        }

    });
});

function initSubMenu2() {
    //alert("akk");
    var sltProvince=document.mainForm2.fid;
    var index=sltProvince.selectedIndex;
    var sltCity=document.mainForm2.zid;
    var menuList = menuMap[sltProvince.options[index].value];

    sltCity.length=1;

    $.each(menuList,function(index,value) {
        $("#zlanmu2").append("<OPTION VALUE='"+value.orderNum+"'>"+value.name+"</OPTION>");
    });
}

