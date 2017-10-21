<%--
  Created by IntelliJ IDEA.
  User: KHM
  Date: 2017/10/19
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
    <script type="text/javascript" src="${basePath}/js/content/ConnectAdd.js"></script>

</head>
<body style="background: #e1e9eb;">
<form id="mainForm" name="mainForm2" method="post" action="${basePath}/connect/add" enctype="multipart/form-data">
    <input type="hidden" id="message" value="${pageCode.msg}"/>
    <div class="right">
        <div class="current">当前位置：<a href="###">内容管理</a> &gt; 联系方式管理</div>
        <div class="rightCont">
            <p class="g_title fix">新增联系方式</p>
            <table class="tab1" width="100%">
                <tbody>
                <tr>
                    <td align="right" width="15%">标题<font color="red">*</font>：</td>
                    <td width="30%">
                        <input name="title" class="allInput" style="width:100%;" type="text"/>
                    </td>
                    <td align="right" width="15%">作者<font color="red">*</font>：</td>
                    <td width="30%">
                        <input name="author"  class="allInput" style="width:100%;" type="text"/>
                    </td>
                </tr>
                <tr>
                    <td align="right" width="10%">所属父菜单<font color="red">*</font>：</td>
                    <td width="30%">
                        <select id="flanmu2" name="fid" onChange="initSubMenu2()">
                            <OPTION VALUE="fu">父菜单</OPTION>
                        </select>
                    </td>

                    <td align="right" width="10%">所属子菜单<font color="red">*</font>：</td>
                    <td width="30%">
                        <select id="zlanmu2" name="zid">
                            <OPTION VALUE="zi">子菜单</OPTION>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td align="right" width="10%">权重<font color="red">*</font>：</td>
                    <td width="30%">
                        <input name="weight" class="allInput" style="width:100%;" type="text"/>
                    </td>

                    <td align="right" width="10%">新闻展示图链接<font color="red">*</font>：</td>
                    <td width="30%">
                        <input name="imgurl" class="allInput" style="width:100%;" type="text"/>
                    </td>
                </tr>
                <tr>
                    <td align="right" width="15%">内容<font color="red">*</font>：</td>
                    <td width="75%" colspan="3">
                        <textarea name="content" id="content"  cols="30" rows="10">默认内容...</textarea>
                        <script type="text/javascript" src="${basePath}/ckeditor/ckeditor.js"></script>
                        <script type="text/javascript">
                            CKEDITOR.replace('content');
                        </script>
                    </td>
                </tr>
                </tbody>
            </table>
            <div style="text-align: center; margin-top: 30px; float: right;">
                <input class="tabSub" value="保     存" type="button" onclick="add();"/>&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="http://127.0.0.1:8080/sankunGardens/connect"><input class="tabSub" value="返     回" type="button" /></a>
            </div>
        </div>
    </div>
</form>
</body>
</html>
