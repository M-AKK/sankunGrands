<%--
  Created by IntelliJ IDEA.
  User: KHM
  Date: 2017/10/19
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE"/>
    <title></title>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/all.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/pop.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/main.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/jquery.validate.css"/>
    <script type="text/javascript" src="${basePath}/js/common/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="${basePath}/js/common/validation/jquery.validate.js"></script>
    <script type="text/javascript" src="${basePath}/js/common/validation/messages_zh.js"></script>
    <script type="text/javascript" src="${basePath}/js/common/common.js"></script>
    <script type="text/javascript" src="${basePath}/js/content/ConnectModify.js"></script>
</head>
<body style="background: #e1e9eb;">
<form id="mainForm" name="mainForm3" method="post" action="${basePath}/connect/${modifyObj.id}" enctype="multipart/form-data">
    <input type="hidden" id="message" value="${pageCode.msg}"/>
    <input type="hidden" id="basePath" value="${basePath}"/>
    <div class="right">
        <div class="current">当前位置：<a href="###">内容管理</a> &gt; 联系方式管理</div>
        <div class="rightCont">
            <p class="g_title fix">修改联系方式</p>
            <table class="tab1" width="100%">
                <tbody>
                <tr>
                    <td align="right" width="15%">标题<font color="red">*</font>：</td>
                    <td width="30%">
                        <input name="title" value="${modifyObj.title}" class="allInput" style="width:100%;" type="text"/>
                    </td>
                    <td align="right" width="15%">作者<font color="red">*</font>：</td>
                    <td width="30%">
                        <input name="author" value="${modifyObj.author}" class="allInput" style="width:100%;" type="text"/>
                    </td>
                </tr>

                <tr>
                    <td align="right" width="10%">所属父菜单<font color="red">*</font>：</td>
                    <td width="30%">
                        <select id="flanmu3" name="fid" onChange="initSubMenu3()">
                            <option value="fu">${modifyObj.fname}</option>
                        </select>
                    </td>
                    <td align="right" width="10%">所属子菜单<font color="red">*</font>：</td>
                    <td width="30%">
                        <select id="zlanmu3" name="zid">
                            <option value="zi">${modifyObj.zname}</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td align="right" width="10%">权重<font color="red">*</font>：</td>
                    <td width="30%">
                        <input name="weight" value="${modifyObj.weight}" class="allInput" style="width:100%;" type="text"/>
                    </td>

                    <td align="right" width="10%">新闻展示图链接<font color="red">*</font>：</td>
                    <td width="30%">
                        <input name="imgurl" value="${modifyObj.imgurl}" class="allInput" style="width:100%;" type="text"/>
                    </td>
                </tr>

                <tr>
                    <td align="right" width="10%">内容<font color="red">*</font>：</td>
                    <td width="30%" colspan="3">
                        <textarea name="content" id="content"  cols="30" rows="10">${modifyObj.content}</textarea>
                        <script type="text/javascript" src="${basePath}/ckeditor/ckeditor.js"></script>
                        <script type="text/javascript">
                            CKEDITOR.replace('content');
                        </script>
                    </td>

                </tr>
                </tbody>
            </table>
            <div style="text-align: center; margin-top: 30px;">
                <input class="tabSub" value="保     存" type="button" onclick="modify();"/>&nbsp;&nbsp;&nbsp;&nbsp;
                <input class="tabSub" value="返     回" type="button" onclick="goback();"/>
            </div>
        </div>
    </div>
</form>
</body>
</html>