<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="format-detection" content="telephone=no"/>
    <meta name="viewport" content="width=device-width,user-scalable=no"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-mobile-web-app-status-bar-style" content="black"/>
    <title>文章列表</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/frozenui/css/frozen.css">
    <style>
    .content{
    	border-top:4px solid #56A000;
    }
</style>
</head>
<body>
    <div class="wrapper content">
        <!-- list1 start -->
      <ul class="ui-list ui-list-text ui-border-tb">
	    <c:forEach items="${list }"  var="item">
			<li class="ui-border-t ui-list-item-link"><a href="article?id=${item.id }">${item.title}</a></li>
		</c:forEach>
	</ul>
    </div>
    <div class="ui-center" style="height:100px;">
	    <p>©2015 棒棒贝贝双桥乐高科技中心</p>
	</div>
    
    <script src="${pageContext.request.contextPath}/frozenui/js/zepto.min.js"></script>
    <script src="${pageContext.request.contextPath}/frozenui/js/frozen.js"></script>
</body>
</html>