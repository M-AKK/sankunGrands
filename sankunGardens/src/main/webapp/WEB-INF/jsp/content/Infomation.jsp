<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="X-UA-Compatible"content="IE=9; IE=8; IE=7; IE=EDGE" />
        <title>个人信息</title>
        <script src="${basePath}/js/common/jquery-1.8.3.js" type="text/javascript"></script>
        <script src="${basePath }/js/common/jquery.ztree.all.js" type="text/javascript"></script>
        <script src="${basePath}/js/common/validation/jquery.validate.js" type="text/javascript"></script>
		<script src="${basePath}/js/common/validation/messages_zh.js" type="text/javascript"></script>
        <script src="${basePath}/js/common/common.js" type="text/javascript"></script>
        <script src="${basePath}/js/system/auth.js" type="text/javascript"></script>
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
    <body style="background: #FFFFFF; margin: 50px 100px;">
	<form action="">
		<table>
			<tr>
				<td>用户名</td>
				<td>${user.name}</td>
			</tr>
			<tr>
				<td>最后登录时间</td>
				<td>2017-10-09 18:59:45</td>
			</tr>
			<tr>
				<td>最后登录IP</td>
				<td>192.160.40.100</td>
			</tr>
			<tr>
				<td>管理员名称</td>
				<td>
					${user.chName}
				</td>
			</tr>

		</table>
	</form>
	<button>提交</button>

	</body>
</html>