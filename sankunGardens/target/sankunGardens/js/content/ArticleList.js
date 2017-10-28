$(function() {
    common.showMessage($("#message").val());
});

function remove(id) {
    if(confirm("确定要删除这条篇文章吗？")) {
        $("#id").val(id);
        $("#mainForm").attr("action",$("#basePath").val() + "/articles/remove");
        $("#mainForm").submit();
    }
}

function search(currentPage) {
    $("#currentPage").val(currentPage);
    $("#mainForm").submit();
}

function modifyInit(id) {
    $("#id").val(id);
    $("#mainForm").attr("action",$("#basePath").val() + "/articles/modifyInit");
    $("#mainForm").submit();
	//location.href = $("#basePath").val() + "/articles/modifyInit" + id;
}

function add(id) {
    $("#id").val(id);
    $("#mainForm").attr("action",$("#basePath").val() + "/articles/addInit");
    $("#mainForm").submit();
}

$(document).ready(function(){
    $(window).on("load",function(){
        var menuMap = [];

        $.ajax({
            type: "get",
            url: $("#basePath").val() + "/articles/menu",
            success: function(data) {
                if(data.code == 1) {
                    alert(data.msg);
                } else
                if(data.code == 0) {

                    $.each(data.data,function(index,value) {
                        if(!menuMap[value.parentId]) {
                            menuMap[value.parentId] = new Array();
                        }
                        menuMap[value.parentId].push(value);
                    });

                    initMenu();
                }
            }
        });

        function initMenu() {
            var menuList = menuMap[0];
            $.each(menuList,function(index,value) {
                $("#treedemo").append("<li class='tree-node'><label><input class='node-check' type='checkbox'><div class='node-content'><i class='node-icon icon-expand'></i><i class='node-icon icon-folder'></i><span class='node-text'>" + value.name + "</span><ul class='tree' id='tree"+value.id+"'></ul></div></label></li>");
                initSubMenu(value.id);
            });
        }

        function initSubMenu(parentId) {
            var menuList = menuMap[parentId];
            $.each(menuList,function(index,value) {
                if(value.link == "image.html")
                    return true;
                $("#tree" + parentId).append("<li class='tree-node'><label><input class='node-check' type='checkbox'><div class='node-content'><i class='node-icon icon-l'></i><i class='node-icon icon-t'></i><i class='node-icon icon-file'></i><a class='node-text' href='"+$('#basePath').val()+"/"+value.url+"'>" + value.name + "</a></div></label></li>");
            });
        }

    });
});