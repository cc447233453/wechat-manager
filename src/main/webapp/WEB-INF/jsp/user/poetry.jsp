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
    <title>${article.title }</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/frozenui/css/frozen.css">
    <style>
    .content{
    	border-top:4px solid #56A000;
    }
    .content_box{
    	padding:5px;
    }
    .content_box h2{
    	font-size:24px;
    }
    .content_box hr{
    	border:1px solid #ccc;
    	border-bottom:1px solid#fff;
    }
</style>
</head>
<body>
    <div class="wrapper content">
    <div class="content_box">
    	<h2>${poetry.pName }</h2>
    	<hr>
    	<h2>${poetry.pAuthor }<br><br></h2>
       
        <h2>${poetry.pContent }<br><br></h2>
        
        <h2>【注解】：<br>${poetry.note }<br><br></h2>
        
        <h2>【韵译】：<br> ${poetry.translation }<br><br></h2>
       
        <h2>【评析】：<br> ${poetry.analysis }<br><br></h2>
        
    </div>
    </div>
    <div class="ui-center" style="height:100px;">
<!-- 	    <p>©2015 棒棒贝贝双桥乐高科技中心</p> -->
	</div>
    
    <script src="${pageContext.request.contextPath}/frozenui/js/zepto.min.js"></script>
    <script src="${pageContext.request.contextPath}/frozenui/js/frozen.js"></script>
</body>
</html>