<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!doctype HTML>
<html>
	<head>
		<title></title>
		
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/bootstrap/easyui.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/color.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/manager_main.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/simditor.css" />
	</head>
	
	<style>
	#articleForm{
		padding:5px;
	}
	.fitem{
		padding:5px 0;
	}
	</style>
	
	<body>
	<%--添加文章 begin --%>
		<form id="dataDicForm" method="post" novalidate>
	        <div class="fitem">
	       	 	<label>语料类型：</label>
	       	 	<select name="dataType">
	       	 		<option value="1">唐诗三百首</option>
	       	 		<option value="0">其他</option>
	       	 	</select>
	        </div>
			<div class="fitem">
	            <label>语料key：</label>
	            <input name="dataKey" class="easyui-textbox">
	        </div>
	        <div class="fitem">
	       	 	<label>语料key：</label>
	            <textarea id="txt-content" name="dataValue" ></textarea>
	        </div>
	        <div id="dlg-buttons" style="padding:20px; text-align:center;">
		       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveArticle()" style="width:90px">保存</a>
			</div>
		</form>
	
	<%--添加文章 end --%>
	<script src="${pageContext.request.contextPath}/js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/module.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/manager_main.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/hotkeys.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/uploader.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/simditor.min.js"></script>
	<script>
	(function() {
		  $(function() {
		    var editor, toolbar;
		    toolbar = ['title', 'bold', 'italic', 'underline', 'strikethrough', 'color', '|', 'ol', 'ul', 'blockquote', 'code', 'table', '|', 'link', 'image', 'hr', '|', 'indent', 'outdent', '|', 'source'];
		    return editor = new Simditor({
		      textarea: $('#txt-content'),
		      placeholder: '这里输入文字...',
		      toolbar: toolbar,
		      pasteImage: true,
		      defaultImage: 'assets/images/image.png',
		      upload: location.search === '?upload' ? {
		        url: '/upload'
		      } : false
		    });
		  });
		
		}).call(this);
	function saveArticle(){
	    $('#dataDicForm').form('submit',{
	        url: "${pageContext.request.contextPath}/manager/saveDataDic",
	        onSubmit: function(){
	            return $(this).form('validate');
	        },
	        success: function(result){
	            var result = eval('('+result+')');
	            if (result.errorMsg){
	                $.messager.show({
	                    title: 'Error',
	                    msg: result.errorMsg
	                });
	            } else {
	            	parent.closeWin();      // close the dialog
// 	                $('#managerDataDic').datagrid('reload');    // reload the user data
					
	            }
	        }
	    });
	}
	</script>
	</body>
</html>