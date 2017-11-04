$(function() {
    common.showMessage($("#message").val());
    $("#mainForm").validate({
        rules : {
            "username" : "username",
            "chName" : "chName",

        },
        messages : {
            "username" : "请输入name！",
            "chName" : "内容不能为空",
        }
    });
});


function modify() {
    $("#mainform").submit();
}