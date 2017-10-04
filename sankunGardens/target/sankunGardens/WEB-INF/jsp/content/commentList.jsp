<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
		<title></title>
		<%--<link rel="stylesheet" type="text/css" href="${basePath}/css/all.css">
		<link rel="stylesheet" type="text/css" href="${basePath}/css/pop.css">
		<link rel="stylesheet" type="text/css" href="${basePath}/css/main.css">--%>
		<script type="text/javascript" src="${basePath}/js/common/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="${basePath}/js/content/adList.js"></script>
		<style>
			body{
				background:#F0F0F0;
			}
			.tree{
				list-style:none;
				/*列表的样式为空*/
				padding-left:0;
			}
			.tree>.tree-node .tree{
				display:block;
				/*控制层的显示*/
				overflow-y:hidden;
				/*当高度超过时，进行裁剪*/
				max-height:300px;
				height:auto;
				-webkit-transition:max-height .4s ease-in;
				-moz-transition:max-height .4s ease-in;
				-o-transition:max-height .4s ease-in;
				-ms-transition:max-height .4s ease-in;
				transition:max-height .4s ease-in;
			}
			.tree-node{
				margin-top:-3px;
			}
			.tree input.node-check{
				/*后代选择器*/
				display:none;
				/*display:block是将对象块状化display:none是不显示*/
			}

			.tree>.tree-node>label{
				cursor:pointer;
				/*当鼠标移到标签上时变成一个手*/
			}
			.tree .node-content{
				display:inline-block;
			}
			.tree .node-content>.node-text{
				font-size:12px;
				line-height:14px;
				font-family:arial,verdana,Microsoft YaHei,Tahoma,Simsun,sans-serif;
				margin-left:-4px;
			}
			.tree .node-content>.node-text:hover{
				color:#00A000;
			}
			.node-icon{
				background-repeat: no-repeat;
				/*是不重复背景图片的*/
				background-size:100% 100%;
				vertical-align:middle;
				display:inline-block;
				/*行内非替换元素,比如span、a等标签,正常情况下是不能设置宽高的,加上该属性之后,就可以*/
				width:16px;
				height:16px;
			}
			.node-check:checked+.node-content>.tree{
				max-height:0;
			}
			.node-check:checked+.node-content>.icon-folder{
				background-image:url(../../../images2/folder-closed.gif);
				/*当目录没打开时的图片*/
			}
			.node-check:checked+.node-content>.icon-expand{
				background-image:url(../../../images2/elbow-end-plus-nl.gif);
				/*树的加标签*/
			}
			.icon-expand{
				background-image:url(../../../images2/elbow-end-minus-nl.gif);
				/*树的减标签*/
			}
			.icon-t{
				background-image:url(../../../images2/elbow.gif);
				/*树的倒T形枝干*/
			}
			.icon-l{
				background-image:url(../../../images2/elbow-line.gif);
				/*树的主干图片*/
			}
			.icon-L{
				background-image:url(../../../images2/elbow-end.gif);
				/*树的L形枝干*/
			}
			.icon-file{
				background-image:url(../../../images2/file.gif);
				/*文件的图片*/
			}
			.icon-folder{
				background-image:url(../../../images2/folder.gif);
				/*当目录打开时的图片*/
			}
		</style>
	</head>
	<body style="background: #e1e9eb;">
	<ul class="tree">
		<li class="tree-node">
			<label>
				<input class="node-check" type="checkbox">
				<div class="node-content">
					<i class="node-icon icon-expand"></i>
					<i class="node-icon icon-folder"></i>
					<span class="node-text">关于三鲲</span>
					<ul class="tree">
						<li class="tree-node">
							<label>
								<input class="node-check" type="checkbox">
								<div class="node-content">
									<i class="node-icon icon-l"></i>
									<i class="node-icon icon-t"></i>
									<i class="node-icon icon-file"></i>
									<span class="node-text">公司简介</span>
								</div>
							</label>
						</li>
						<li class="tree-node">
							<label>
								<input class="node-check" type="checkbox">
								<div class="node-content">
									<i class="node-icon icon-l"></i>
									<i class="node-icon icon-t"></i>
									<i class="node-icon icon-file"></i>
									<span class="node-text">企业文化</span>
								</div>
							</label>
						</li>
						<li class="tree-node">
							<label>
								<input class="node-check" type="checkbox">
								<div class="node-content">
									<i class="node-icon icon-l"></i>
									<i class="node-icon icon-t"></i>
									<i class="node-icon icon-file"></i>
									<span class="node-text">团队介绍</span>
								</div>
							</label>
						</li>
						<li class="tree-node">
							<label>
								<input class="node-check" type="checkbox">
								<div class="node-content">
									<i class="node-icon icon-l"></i>
									<i class="node-icon icon-L"></i>
									<i class="node-icon icon-file"></i>
									<span class="node-text">荣誉资质</span>
								</div>
							</label>
						</li>
					</ul>
				</div>
			</label>
		</li>
		<li class="tree-node">
			<label>
				<input class="node-check" type="checkbox">
				<div class="node-content">
					<i class="node-icon icon-expand"></i>
					<i class="node-icon icon-folder"></i>
					<span class="node-text">新闻动态</span>
					<ul class="tree">
						<li class="tree-node">
							<label>
								<input class="node-check" type="checkbox">
								<div class="node-content">
									<i class="node-icon icon-l"></i>
									<i class="node-icon icon-t"></i>
									<i class="node-icon icon-file"></i>
									<span class="node-text">公司动态</span>
								</div>
							</label>
						</li>
						<li class="tree-node">
							<label>
								<input class="node-check" type="checkbox">
								<div class="node-content">
									<i class="node-icon icon-l"></i>
									<i class="node-icon icon-t"></i>
									<i class="node-icon icon-file"></i>
									<span class="node-text">行业动态</span>
								</div>
							</label>
						</li>
						<li class="tree-node">
							<label>
								<input class="node-check" type="checkbox">
								<div class="node-content">
									<i class="node-icon icon-l"></i>
									<i class="node-icon icon-t"></i>
									<i class="node-icon icon-file"></i>
									<span class="node-text">社会新闻</span>
								</div>
							</label>
						</li>
						<li class="tree-node">
							<label>
								<input class="node-check" type="checkbox">
								<div class="node-content">
									<i class="node-icon icon-l"></i>
									<i class="node-icon icon-L"></i>
									<i class="node-icon icon-file"></i>
									<span class="node-text">重大公告</span>
								</div>
							</label>
						</li>
					</ul>
				</div>
			</label>
		</li>
	</ul>
	
</body></html>