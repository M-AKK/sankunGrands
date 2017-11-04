<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
	<title></title>
	<link rel="stylesheet" type="text/css" href="${basePath}/css/all.css"/>
	<link rel="stylesheet" type="text/css" href="${basePath}/css/pop.css"/>
	<link rel="stylesheet" type="text/css" href="${basePath}/css/main.css"/>
	<script type="text/javascript" src="${basePath}/js/common/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${basePath}/js/common/common.js"></script>
	<script type="text/javascript" src="${basePath}/js/content/ConnectList.js"></script>
</head>
<body style="background: #e1e9eb;">
<div class="current">当前位置：<a href="#">内容管理</a> &gt; 联系方式管理</div>
<form action="${basePath}/connect" id="mainForm" method="post">
	<input type="hidden" id="id" name="id"/>
	<input type="hidden" id="basePath" value="${basePath}"/>
	<input type="hidden" id="message" value="${pageCode.msg}"/>
	<input type="hidden" name="page.currentPage" id="currentPage" value="1"/>
	<div class="right">
		<div class="rightCont">
			<p class="g_title fix">联系方式</p>
				<table class="tab1">
					<tbody>
					<tr>
						<td align="right" width="80">标题：</td>
						<td>
							<input name="title" id="title" value="${searchParam.title}" class="allInput" type="text"/>
						</td>
						<td style="text-align: right;" width="150">
							<input class="tabSub" value="查询" onclick="search('1');" type="button"/>&nbsp;&nbsp;&nbsp;&nbsp;
                            <c:choose>
                                <c:when test="${not empty list}">
                                    <input class="tabSub" value="添加" onclick="location.href='${basePath}/connect/addInit'+'?id=${list.get(0).id}'" type="button"/>
                                </c:when>

                                <c:otherwise>
                                    <input class="tabSub" value="添加" onclick="location.href='${basePath}/connect/addInit'" type="button"/>
                                </c:otherwise>
                            </c:choose>
                        </td>
					</tr>
					</tbody>
				</table>
				<div class="zixun fix">
					<table class="tab2" width="100%">
						<thead>
						<tr>
							<th>序号</th>
							<th>标题</th>
							<th>作者</th>
							<th>所属父菜单</th>
							<th>所属子菜单</th>
							<th>权重</th>
							<th>更新时间</th>
							<th>操作</th>
						</tr>
						</thead>
						<tbody>
						<c:forEach items="${list}" var="item" varStatus="s">
							<tr>
								<td>${s.index + 1}</td>
								<td>${item.title}</td>
								<td>${item.author}</td>
								<td>${item.fname}</td>
								<td>${item.zname}</td>
								<td>${item.weight}</td>
								<td>${item.updateTime}</td>
								<td>
									<a href="javascript:void(0);" onclick="modifyInit('${item.id}')">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;
									<a href="javascript:void(0);" onclick="remove('${item.id}')">删除</a>
								</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>

				<!-- 分页 -->
				<t:page jsMethodName="search" page="${searchParam.page}"></t:page>
			</div>
		</div>
	</div>
</form>

</body>
</html>