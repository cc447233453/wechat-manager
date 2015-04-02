<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="panel-fit">
<head>
    <meta charset="UTF-8">
    <title>棒棒贝贝后台管理</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/bootstrap/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/manager_main.css">
</head>
<body class="easyui-layout layout panel-noscroll">
    <div class="easyui-layout" border="false" fit="true">
        <div data-options="region:'north'" class="nav_box" style="height:50px">
        	<div class="logo"></div>
        	<ul>
        		<li><a href="">活动管理</a></li>
        	</ul>
        </div>
        <div data-options="region:'south',split:true" style="height:50px;"></div>
        <div data-options="region:'west',split:true" title="二级导航" style="width:200px;">
        <ul class="easyui-tree tree">
        <li><div id="_easyui_tree_137" class="tree-node" onclick="open1('queryAppointment','活动预约查询')"><span class="tree-title">活动预约查询</span></div></li>
        <li><div id="_easyui_tree_137" class="tree-node" onclick="open1('managerArticles','文章管理')"><span class="tree-title">文章管理</span></div></li>
        </ul>
        </div>
        <div data-options="region:'center'" class="panel-body panel-body-noheader layout-body panel-noscroll">
        	<div id="tt" class="easyui-tabs tabs-container easyui-fluid" border="false" fit="true">
		        <div title="欢迎" style="padding:10px">
		            <p style="font-size:14px">jQuery EasyUI framework helps you build your web pages easily.</p>
		            <ul>
		                <li>easyui is a collection of user-interface plugin based on jQuery.</li>
		                <li>easyui provides essential functionality for building modem, interactive, javascript applications.</li>
		                <li>using easyui you don't need to write many javascript code, you usually defines user-interface by writing some HTML markup.</li>
		                <li>complete framework for HTML5 web page.</li>
		                <li>easyui save your time and scales while developing your products.</li>
		                <li>easyui is very easy but powerful.</li>
		            </ul>
		        </div>
		    </div>
        </div>
    </div>
    </div>

    <script src="${pageContext.request.contextPath}/js/jquery-1.11.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/manager_main.js"></script>
</body>
</html>