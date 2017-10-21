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
			width: 500px;
			border-collapse: collapse;
		}
		th{
			border:1px solid #000;
			background-color: #F9FAFC;
		}
		td {
			border: 1px solid #000;
			height: 30px;
		}
		input::-webkit-outer-spin-button,
		input::-webkit-inner-spin-button {
			-webkit-appearance: none;
		}
		input[type="number"]{
			-moz-appearance: textfield;
		}
		input {
			border: 0;
		}

	</style>
</head>
<body style="background: #FFFFFF; margin: 50px 100px;">
<form action="">
	<table border="0">
		<tr>
			<th width="1" align="center">id</th>
			<th width="1" align="center">栏目名称</th>
			<th width="1" align="center">父id</th>
			<th width="1" align="center">子id</th>
			<th width="1" align="center">跳转页面</th>
		</tr>
		<tr>
			<td>
				<input type="number" value="1">
			</td>
			<td>
				<input type="text" value="关于三鲲">
			</td>
			<td>
				<input type="number" value="0">
			</td>
			<td>
				<input type="number" value="1">
			</td>
			<td>
				<input type="text" value="空">
			</td>
		</tr>
	</table>
</form>
<button>提交</button>

</body>
</html>