//打开单个窗口
function openWin(title, url, width, height) {
	parent.parent.dialog = "dataForm";
	
	parent.$("#load").show();//显示
	parent.$("#winSrc").attr("src", url);
	
	var iframe = parent.document.getElementById("winSrc");
	if(iframe.attachEvent){  //ie浏览器
	    iframe.attachEvent("onreadystatechange", function() {  
	        //有时候会比较怪异 readyState状态会跳过 complete 所以我们loaded状态也要判断  
	        if (iframe.readyState === "complete" || iframe.readyState == "loaded") {  
	        	parent.$("#load").hide();//隐藏  
	        }  
	    });  
	}else{  //其他浏览器（Firefox,Opera,chrome等 ）
	    iframe.addEventListener("load", function() {  
	    	parent.$("#load").hide();//隐藏   
	    }, false);  
	} 
	
	parent.$('#dataForm').dialog({
		modal : true,
		iconCls:'icon-save',//图标
		title:title,//标题
		width:width,//宽度
		height:height,//高度
		cache:false,
		onClose:function(){
			parent.$("#winSrc").attr("src", "");
		}
	});
	
	parent.$('#dataForm').dialog("open");
}

//关闭窗口
function closeWin() {
	if(parent.parent.dialog == "dataForm") {
		if($('#dataForm')) {
			$('#dataForm').dialog("close");
		}
	}else if(parent.parent.dialog == "dataFormTabs") {
		if($("#dataFormTabs")) {
			$("#dataFormTabs").dialog("close");
		}
	}
}
//刷新datagrid数据
function reloadData(id) {
	//刷新  datagrid
	var topWin = window.top.document.getElementById("main").contentWindow;
	if(id) {
		var win = topWin.document.getElementById(id).contentWindow;
		win.tab.datagrid('reload');//刷新datagrid
		win.tab.datagrid('clearSelections');//清理选中
	}else{
		if(topWin.tab) {
			topWin.tab.datagrid('reload');//刷新datagrid
			topWin.tab.datagrid('clearSelections');//清理选中
		}
	}
	
}