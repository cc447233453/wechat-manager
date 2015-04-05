<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<div id="content">

<table class="easyui-datagrid"   id="managerDataDic" >
</table>

<script>
var tab;
$(function(){
	 tab=$("#managerDataDic").datagrid({
		url:"${pageContext.request.contextPath}/manager/queryDataDic",//加载的URL
		pagination:true,//显示分页
		pageSize:5,//分页大小
		pageList:[5,10,15,20],//每页的个数
		fit:true,//自动补全
		fitColumns:true,
		rownumbers:true,
		toolbar:'#toolbar',
		columns:[[      //每个列具体内容
	              {field:'dataKey',title:'语料key',width:100},   
	              {field:'dataValue',title:'语料value',width:100},
	              {field:'dataType',title:'语料类型',width:100}
	             
	          ]],
	     toolbar:[{
	    	 text:'新增',  
             iconCls:'icon-add',  
             handler : function() {
                 openWin("新增", "${pageContext.request.contextPath}/manager/addDataDicPre", 960, 500);
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
});
	    
</script>
</div>

