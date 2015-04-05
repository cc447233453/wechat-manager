<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/simditor.css" />

<style type="text/css">
    #articleForm{
        margin:0;
        padding:10px 30px;
    }
    .ftitle{
        font-size:14px;
        font-weight:bold;
        padding:5px 0;
        margin-bottom:10px;
        border-bottom:1px solid #ccc;
    }
    .fitem{
        margin-bottom:5px;
    }
    .fitem label{
        display:inline-block;
        width:80px;
    }
    .fitem input{
        width:160px;
    }
</style>
<%--添加文章 begin --%>
<div id="addArticle" class="easyui-dialog"   buttons="#dlg-buttons"  style="padding:10px">
	<div class="ftitle">增加文章</div>
	<form id="articleForm" method="post" novalidate>
		<div class="fitem">
            <label>标题：</label>
            <input name="title" class="easyui-textbox" required="true">
        </div>
        <div class="fitem">
       	 	<label>分类：</label>
        	<input name="title" class="easyui-textbox">
        </div>
        <div>
        	内容：<textarea id="editor" name="content" placeholder="这里输入内容" autofocus></textarea>
        </div>
	</form>
</div>
<div id="dlg-buttons">
       <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveArticle()" style="width:90px">保存</a>
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#addArticle').dialog('close')" style="width:90px">取消</a>
</div>
<%--添加文章 end --%>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/module.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/hotkeys.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/uploader.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/simditor.min.js"></script>
<script>
//文本编辑器
var editor = new Simditor({
	textarea: $('#editor')
});
function saveArticle(){
    $('#articleForm').form('submit',{
        url: "${pageContext.request.contextPath}/manager/saveArticle",
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
            	closeWin();      // close the dialog
                $('#managerArticles').datagrid('reload');    // reload the user data
            }
        }
    });
}
</script>