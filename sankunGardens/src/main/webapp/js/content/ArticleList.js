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

$(document).ready(function(){
    $(window).on("load",function(){
        var menuMap = [];

        var dataTitle = {
            "data":
                [{"id":"1","name":"关于三鲲","url":"#","parentid":"0","order_num":"1"},{"id":"2","name":"公司简介","url":"/jsjj","parentid":"1","order_num":"1"},{"id":"3","name":"发展历程","url":"/fzlc","parentid":"1","order_num":"2"},{"id":"4","name":"企业文化","url":"/qywh","parentid":"1","order_num":"3"},{"id":"5","name":"荣誉资质","url":"/ryzz","parentid":"1","order_num":"4"},
                    {"id":"6","name":"新闻动态","url":"#","parentid":"0","order_num":"2"},{"id":"7","name":"公司动态","url":"/gsdt","parentid":"6","order_num":"1"},{"id":"8","name":"行业动态","url":"/hydt","parentid":"6","order_num":"2"},{"id":"9","name":"社会新闻","url":"/shxw","parentid":"6","order_num":"3"},{"id":"10","name":"重大公告","url":"/zdgg","parentid":"6","order_num":"4"}]
        };

        $.each(dataTitle.data,function(index,value) {
            if(!menuMap[value.parentid]) {
                menuMap[value.parentid] = new Array();
            }
            menuMap[value.parentid].push(value);
        });

        initMenu();

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
                $("#tree" + parentId).append("<li class='tree-node'><label><input class='node-check' type='checkbox'><div class='node-content'><i class='node-icon icon-l'></i><i class='node-icon icon-t'></i><i class='node-icon icon-file'></i><span class='node-text'>" + value.name + "</span></div></label></li>");
            });
        }

    });
});