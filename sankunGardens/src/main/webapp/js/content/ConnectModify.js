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
            url : "http://localhost:8080/sankunGardens/articles/menu",
            contentType:'application/json;charset=utf-8',
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

        /*var dataTitle =
         {
         "data":[{"id":"1","name":"关于三鲲","url":"#","parentid":"0","order_num":"1"},{"id":"2","name":"公司简介","url":"/jsjj","parentid":"1","order_num":"1"},{"id":"3","name":"发展历程","url":"/fzlc","parentid":"1","order_num":"2"},{"id":"4","name":"企业文化","url":"/qywh","parentid":"1","order_num":"3"},{"id":"5","name":"荣誉资质","url":"/ryzz","parentid":"1","order_num":"4"},
         {"id":"6","name":"新闻动态","url":"#","parentid":"0","order_num":"2"},{"id":"7","name":"公司动态","url":"/gsdt","parentid":"6","order_num":"1"},{"id":"8","name":"行业动态","url":"/hydt","parentid":"6","order_num":"2"},{"id":"9","name":"社会新闻","url":"/shxw","parentid":"6","order_num":"3"},{"id":"10","name":"重大公告","url":"/zdgg","parentid":"6","order_num":"4"}]
         };*/

        function initMenu() {
            var menuList = menuMap[0];
            $.each(menuList,function(index,value) {
                $("#flanmu3").append("<OPTION VALUE='"+value.id+"'>"+value.name+"</OPTION>");
            });
        }

    });
});

function initSubMenu3() {
    console.log("akkkkk3");
    //alert("akk");
    var sltProvince=document.mainForm3.fid;
    var index=sltProvince.selectedIndex;
    var sltCity=document.mainForm3.zid;

    //alert(sltProvince.options[index].value);

    var menuList = menuMap[sltProvince.options[index].value];

    sltCity.length=1;

    $.each(menuList,function(index,value) {
        $("#zlanmu3").append("<OPTION VALUE='"+value.orderNum+"'>"+value.name+"</OPTION>");
    });
}
