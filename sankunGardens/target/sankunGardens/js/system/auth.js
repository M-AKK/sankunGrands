var menuMap = [];
//$(document).ready(function(){
    //$(window).on("load",function(){
        $(function() {

        common.ajax({
            type: "get",
            url : $("#basePath").val() + "/articles/menu",
            //url : "http://localhost:8080/sankunGardens/articles/menu",
            //url : "http://115.159.35.121:8080/sankunGardens/articles/menu",
            success: function(data) {
                if(data.code == 0) {
                    $.each(data.data,function(index,value) {
                        if(!menuMap[value.parentId]) {
                            menuMap[value.parentId] = new Array();
                        }
                        menuMap[value.parentId].push(value);
                    });
                    initMenu();

                } else {
                    alert(data.msg);
                }
            }
        });

        $("#addfu").click(function(){ //新增父栏目，让添加框显示，让子栏目清空
            $("#ziid").empty();
            $(".boxfu").show();
        });

        $("#demofu").click(function(){ //提交新增加的父栏目
            var title = $(".boxfu .zhuname").val();
            var orderNum = $(".boxfu .zhunum").val();

            $.ajax({
                type: "post",
                // url: $("#basePath").val() + "/lanmu/addFlanmu",
                url: $('#basePath').val() + "/lanmu/addFlanmu",
                data: {
                    name:title,
                    orderNum:orderNum
                },
                success: function(data) {
                    if(data.code == 0) {
                        alert(data.msg);
                        window.location.reload();
                    } else {
                        alert(data.msg);
                    }
                }
            });
        });

        $(".close").click(function(){ //取消按钮
            $(".zhunum").val("");
            $(".zhuname").val("");
            $(".funum").val("");
            $(".funame").val("");
            $(".boxfu").hide();
            $(".boxzi").hide();
            $("#addzi").hide();
            $(".changezi").hide();
            $(".changefu").hide();
        });

    });
//});

function initMenu() {
    var menuList = menuMap[0];

    $.each(menuList,function(index,value) {
        $("#fuid").append("<tr class='"+value.id+"'><td class='parent'>"+value.id+"</td><td class='futitle'>"+value.name+"</td><td class='fupai'>"+value.orderNum+"</td><td><input class='tabSub fuchose' value='修改' name='"+value.id+"' type='button'><input class='tabSub fumove' value='删除' name='"+value.id+"' type='button'></td></tr>");
    });

    $(".fumove").click(function(){ //父菜单的删除
        var parentId = $(this).prop("name");
        $.ajax({
            type: "post",
            // url: $("#basePath").val() + "/lanmu/delete",
            url: $('#basePath').val() + "/lanmu/delete",
            data: "id="+parentId,
            success: function(data) {
                if(data.code == 0) {
                    alert(data.msg);
                    window.location.reload();
                } else {
                    alert(data.msg);
                }
            }
        });
    });

    $(".fuchose").click(function(){ //父菜单的修改,获取以前的值
        var parentId = $(this).prop("name");
        $(".changefu").show();
        $("#changefu").attr("name",parentId);
        $(".zhuname").val($(this).parent().parent().find(".futitle").text());
        $(".zhunum").val($(this).parent().parent().find(".fupai").text());
    });

    $("#changefu").click(function(){ //提交修改的值
        var id = $(this).prop("name");
        var title = $(".changefu .zhuname").val();
        var orderNum = $(".changefu .zhunum").val();
        console.log(title);
        $.ajax({
            type: "post",
            url: $('#basePath').val() + "/lanmu/update",
            data: {
                id:id,
                name:title,
                orderNum:orderNum
            },
            success: function(data) {
                if(data.code == 0) {
                    alert(data.msg);
                    window.location.reload();
                } else {
                    alert(data.msg);
                }
            }
        });
    });

    $("#fuid .parent,.futitle,.fupai").click(function(){ //子菜单的联动
        var parentId = $(this).parent().attr('class');
        initSubMenu(parentId);

        $("#addzi").show();

        $("#addzi").click(function(){
            $(".boxzi").show();
            $("#demozi").attr("name",parentId);
        });
    });


    $("#demozi").click(function(){ //提交子栏目
        var parentId = $(this).prop("name");
        var title = $(".boxzi .funame").val();
        var orderNum = $(".boxzi .funum").val();
        var link = $(".boxzi option:selected").val();

        $.ajax({
            type: "post",
            url: $("#basePath").val() + "/lanmu/addZlanmu",
            data:{
                parentId:parentId,
                name:title,
                orderNum:orderNum,
                link:link
            },
            success: function(data) {
                if(data.code == 0) {
                    alert(data.msg);
                    window.location.reload();
                } else {
                    alert(data.msg);
                }
            }
        });
    });
}

function initSubMenu(parentId) {  //添加子菜单
    var menuList = menuMap[parentId];
    $("#ziid").empty();
    $.each(menuList,function(index,value) {
        var title1;
        if(value.link == "erji.html"){
            title1 = "列表页面";
        } else {
            title1 = "文章页面";
        }

        $("#ziid").append("<tr><td class='zititle'>"+value.name+"</td><td class='zipai'>"+value.orderNum+"</td><td class='tiaozhuan'>"+title1+"</td><td><input class='tabSub zichose' value='修改' name='"+value.id+"' type='button'><input class='tabSub zimove' value='删除' name='"+value.id+"' type='button'></td></tr>");
    });

    $(".zimove").click(function(){ //子菜单的删除
        var parentId = $(this).prop("name");
        $.ajax({
            type: "post",
            url: $("#basePath").val() + "/lanmu/delete",
            data: "id="+parentId,
            success: function(data) {
                if(data.code == 0) {
                    alert(data.msg);
                    window.location.reload();
                } else {
                    alert(data.msg);
                }
            }
        });
    });
    $(".zichose").click(function(){ //子菜单的修改初始
        var parentId = $(this).prop("name");
        $(".changezi").show();
        $("#changezi").attr("name",parentId);
        var a = $(this).parent().parent().find(".tiaozhuan").text();
        if(a == "列表页面") {
            a = "erji.html";
        } else {
            a = "sanji.html";
        }
        $(".funame").val($(this).parent().parent().find(".zititle").text());
        $(".funum").val($(this).parent().parent().find('.zipai').text());
        $(".futiao").find('option[value="'+a+'"]').attr("selected",true);
    });

    $("#changezi").click(function(){ //提交子修改的数据

        var id = $(this).prop("name");
        var title = $(".changezi .funame").val();
        var orderNum = $(".changezi .funum").val();
        var link = $(".changezi option:selected").val();

        $.ajax({
            type: "post",
            url: $('#basePath').val() + "/lanmu/update",
            data:{
                id:id,
                name:title,
                orderNum:orderNum,
                link:link
            },
            success: function(data) {
                if(data.code == 0) {
                    alert(data.msg);
                    window.location.reload();
                } else {
                    alert(data.msg);
                }
            }
        });
    });
}
