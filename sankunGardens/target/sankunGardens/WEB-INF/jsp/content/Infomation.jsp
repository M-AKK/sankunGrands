<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="X-UA-Compatible"content="IE=9; IE=8; IE=7; IE=EDGE" />
        <title>个人信息</title>
		<link rel="stylesheet" type="text/css" href="${basePath}/css/all.css"/>
		<link rel="stylesheet" type="text/css" href="${basePath}/css/pop.css"/>
		<link rel="stylesheet" type="text/css" href="${basePath}/css/main.css"/>
		<link rel="stylesheet" type="text/css" href="${basePath}/css/jquery.validate.css"/>
        <script src="${basePath}/js/common/jquery-1.8.3.js" type="text/javascript"></script>
        <script src="${basePath }/js/common/jquery.ztree.all.js" type="text/javascript"></script>
        <script src="${basePath}/js/common/validation/jquery.validate.js" type="text/javascript"></script>
		<script src="${basePath}/js/common/validation/messages_zh.js" type="text/javascript"></script>
        <script src="${basePath}/js/common/common.js" type="text/javascript"></script>
        <script src="http://pv.sohu.com/cityjson?ie=utf-8"></script>
        <style type="text/css">

			table {
				width: 50%;
				border-collapse: collapse;
				border-top: 1px solid #F0F0F0;
			}
			tr {
				border-bottom: 1px solid #F0F0F0;
			}
			tr td {
				padding: 8px 0;
			}
			tr td:first-child {
				width: 20%;
			}
			td input {
				height: 20px;
			}
			button{
				box-shadow: 0px 3px 0px rgba(0, 0, 0, .9), 0px 3px 2px rgba(0, 0, 0, .9);
				margin-top: 30px;
			}

        </style>
    </head>
    <body style="background: #e1e9eb;">
	<form id="mainform" name="mainform" action="${basePath}/user/updateinfo" method="post" >
		<input type="hidden" id="message" value="${pageCode.msg}"/>
		<div class="right">
			<div class="current">当前位置：<a href="###">系统设置</a> &gt; 修改个人信息</div>
			<div class="rightCont">
				<p class="g_title fix">修改信息</p>
				<table>
					<tr>
						<td>用户名</td>
                        <td width="40%">
                            <input name="title" value="${user.name}" class="allInput" style="width:100%;" type="text"/>
                        </td>
					</tr>
					<tr>
						<td>最后修改时间</td>
                        <td width="40%">
                            <span name="updateTime1" class="allInput" style="width:100%;" type="text">${updateTime}</span>
                        </td>
					</tr>
					<tr>
						<td>登录IP</td>
                        <td width="40%">
                            <span name="ip" id="ipname" class="allInput" style="width:100%;" type="text"></span>
                        </td>
					</tr>
					<tr>
						<td>管理员名称</td>
						<td>
                            <input name="title" value="${user.chName}" class="allInput" style="width:100%;" type="text"/>
						</td>
					</tr>
                    <tr>
                        <td class="left"></td>
                        <td class="submit">
                            <input id="submitVal" class="tabSub" value="提交" onclick="modify()" type="button"/>
                        </td>
                    </tr>

				</table>
			</div>
		</div>
	</form>
    <script>
        $("#ipname").text(returnCitySN.cip);
    </script>
	</body>
</html>