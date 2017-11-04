$(function() {
    common.showMessage($("#message").val());
});

function remove(id) {
    if(confirm("确定要删除这篇文章吗？")) {
        $("#id").val(id);
        $("#mainForm").attr("action",$("#basePath").val() + "/connect/remove");
        $("#mainForm").submit();
    }
}

function search(currentPage) {
    $("#currentPage").val(currentPage);
    $("#mainForm").submit();
}

function add1(id) {
    $("#id").val(id);
    $("#mainForm").attr("action",$("#basePath").val() + "/connect/addInit");
    $("#mainForm").submit();
}

function modifyInit(id) {
    $("#id").val(id);
    $("#mainForm").attr("action",$("#basePath").val() + "/connect/modifyInit");
    $("#mainForm").submit();
	//location.href = $("#basePath").val() + "/articles/modifyInit" + id;
}