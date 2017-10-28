<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
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
	<script src="${basePath}/js/system/auth.js" type="text/javascript"></script>
	<style type="text/css">

		table {
			width: 550px;
			border-collapse: collapse;
            float: left;
            margin-bottom: 50px;
		}
		th{
			border:1px solid #000;
			background-color: #F9FAFC;
            height: 30px;
            text-align: center;
            width: 10%
		}
        td {
            text-align: center;
            border: 1px solid #000;
            height: 40px;
            font-size: 15px;
            width: 10%
        }
        input::-webkit-outer-spin-button,
        input::-webkit-inner-spin-button {
            -webkit-appearance: none;
        }
        input[type="number"]{
            -moz-appearance: textfield;
        }
        select,input {
            margin: 0 5px;
        }
	</style>
</head>
<body style="background: #e1e9eb;">
<input type="hidden" id="basePath" value="${basePath}"/>
<form>
	<div class="right">
		<div class="current">当前位置：<a href="###">栏目管理</a> &gt; 栏目调整</div>
		<div class="rightCont">
			<p class="g_title fix">新增栏目</p>
            <div style="width: 100%;height: 50px;float: left;">
                <input id="addfu" class="tabSub" value="添加父栏目" type="button">
                <input id="addzi" class="tabSub" value="添加子栏目" type="button" style="display: none;">
            </div>
            <table border="0" style="margin-right: 30px;">
                <thead>
                <tr>
                    <th>id</th>
                    <th>主栏目名称</th>
                    <th>排序</th>
                    <th>功能</th>
                </tr>
                </thead>
                <tbody id="fuid">
                </tbody>
            </table>
            <table border="0">
                <thead>
                <tr>
                    <th>副栏目名称</th>
                    <th>排序</th>
                    <th>跳转页面</th>
                    <th>功能</th>
                </tr>
                </thead>
                <tbody id="ziid">
                </tbody>
            </table>

            <div class="boxfu" style="display:none; width: 100%;height: 100%;z-index: 100;position: absolute;top:0;left:0;">
                <div style="width: 300px;height: 300px;background: #CBCBCB;position: absolute;top: 100px;left: 300px;">
                    <div style="margin: 50px 0 20px 0;width: 100%;height: 50px;">
                        <span style="width: 30%;line-height: 30px;text-align: right;display: block;float: left;">主栏目名称:</span><input class="zhuname" type="text" style="width: 60%;height: 30px;float: left;">
                    </div>
                    <div style="width: 100%;height: 50px;">
                        <span style="width: 30%;line-height: 30px;text-align: right;display: block;float: left;">排序:</span><input class="zhunum" type="number" style="width: 60%;height: 30px;float: left;">
                    </div>
                    <div style="margin: 0 auto;text-align: center;">
                        <input id="demofu" class="tabSub" value="提交" type="button">
                        <input class="tabSub close" value="取消" type="button">
                    </div>
                </div>
            </div>

            <div class="changefu" style="display:none; width: 100%;height: 100%;z-index: 100;position: absolute;top:0;left:0;">
                <div style="width: 300px;height: 300px;background: #CBCBCB;position: absolute;top: 100px;left: 300px;">
                    <div style="margin: 50px 0 20px 0;width: 100%;height: 50px;">
                        <span style="width: 30%;line-height: 30px;text-align: right;display: block;float: left;">主栏目名称:</span><input class="zhuname" type="text" style="width: 60%;height: 30px;float: left;">
                    </div>
                    <div style="width: 100%;height: 50px;">
                        <span style="width: 30%;line-height: 30px;text-align: right;display: block;float: left;">排序:</span><input class="zhunum" type="number" style="width: 60%;height: 30px;float: left;">
                    </div>
                    <div style="margin: 0 auto;text-align: center;">
                        <input id="changefu" class="tabSub" value="提交" type="button">
                        <input class="tabSub close" value="取消" type="button">
                    </div>
                </div>
            </div>

            <div class="boxzi" style="display:none;width: 100%;height: 100%;z-index: 100;position: absolute;top:0;left:0;">
                <div style="width: 300px;height: 300px;background: #CBCBCB;position: absolute;top: 100px;left: 300px;">
                    <div style="margin: 50px 0 20px 0;width: 100%;height: 50px;">
                        <span style="width: 30%;line-height: 30px;text-align: right;display: block;float: left;">副栏目名称:</span><input class="funame" type="text" style="width: 60%;height: 30px;float: left;">
                    </div>
                    <div style="width: 100%;height: 50px;">
                        <span style="width: 30%;line-height: 30px;text-align: right;display: block;float: left;">排序:</span><input class="funum" type="number" style="width: 60%;height: 30px;float: left;">
                    </div>
                    <div style="width: 100%;height: 50px;">
                        <span style="width: 30%;line-height: 30px;text-align: right;display: block;float: left;">跳转页面:</span>
                        <select class="futiao" style="width: 60%;height: 30px;float: left;">
                            <option value="erji.html">列表页面</option>
                            <option value="sanji.html">文章页面</option>
                        </select>
                    </div>
                    <div style="margin: 0 auto;text-align: center;">
                        <input id="demozi" class="tabSub" value="提交" type="button">
                        <input class="tabSub close" value="取消" type="button">
                    </div>
                </div>
            </div>

            <div class="changezi" style="display:none;width: 100%;height: 100%;z-index: 100;position: absolute;top:0;left:0;">
                <div style="width: 300px;height: 300px;background: #CBCBCB;position: absolute;top: 100px;left: 300px;">
                    <div style="margin: 50px 0 20px 0;width: 100%;height: 50px;">
                        <span style="width: 30%;line-height: 30px;text-align: right;display: block;float: left;">副栏目名称:</span><input class="funame" type="text" style="width: 60%;height: 30px;float: left;">
                    </div>
                    <div style="width: 100%;height: 50px;">
                        <span style="width: 30%;line-height: 30px;text-align: right;display: block;float: left;">排序:</span><input class="funum" type="number" style="width: 60%;height: 30px;float: left;">
                    </div>
                    <div style="width: 100%;height: 50px;">
                        <span style="width: 30%;line-height: 30px;text-align: right;display: block;float: left;">跳转页面:</span>
                        <select class="futiao" style="width: 60%;height: 30px;float: left;">
                            <option value="erji.html">列表页面</option>
                            <option value="sanji.html">文章页面</option>
                        </select>
                    </div>
                    <div style="margin: 0 auto;text-align: center;">
                        <input id="changezi" class="tabSub" value="提交" type="button">
                        <input class="tabSub close" value="取消" type="button">
                    </div>
                </div>
            </div>
		</div>
	</div>
</form>

</body>
</html>