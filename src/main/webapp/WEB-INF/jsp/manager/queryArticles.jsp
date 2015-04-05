<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<div id="content">

<table class="easyui-datagrid"   id="managerArticles" >
</table>

<script>
	var tab=$("#managerArticles").datagrid({
		url:"${pageContext.request.contextPath}/manager/queryArticles",//加载的URL
		pagination:true,//显示分页
		pageSize:5,//分页大小
		pageList:[5,10,15,20],//每页的个数
		fit:true,//自动补全
		fitColumns:true,
		rownumbers:true,
		toolbar:'#toolbar',
		columns:[[      //每个列具体内容
	              {field:'title',title:'文章标题',width:100},   
	              {field:'content',title:'文章内容',width:100},
	              {field:'author',title:'作者',width:100},
	              {field:'createTime',title:'创建时间',width:100,formatter:function(value){
	            	  var date = new Date(value);
	                  return date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate();
	              }}
	          ]],
	     toolbar:[{
	    	 text:'新增',  
             iconCls:'icon-add',  
             handler : function() {
                 openWin("新增", "${pageContext.request.contextPath}/manager/addArticlePre", 960, 500);
             }
	     },'-',{ 
            	 text:'修改',  
	                iconCls:'icon-edit',  
	                handler : function() {
	                    var row = $('#dataTable').datagrid('getSelections');
	                    if (row.length == 0) {
	                        alert("请选择要修改的数据");
	                        return false;
	                    }
	                    if (row.length > 1) {
	                        alert("只能选择一条数据进行修改");
	                        return false;
	                    }
	                    openWin("修改", "${ctx}/admin/user/portalUser/getPortalUser.do?userId=" + row[0].userId, 900, 600);
	                }
             }
	     ],onLoadSuccess:function(){  
             tab.datagrid('clearSelections');  
         },
         onLoadError:function(data){
         	if(data.responseText) {
         		parent.show(data.responseText);
         	}
         }
	});    
</script>
</div>

