<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="basic/systemadmin/js/department_manage_main.js"></script>
<script type="text/javascript">
	Ext.Loader.load(['basic/systemadmin/js/department_manage_main.js','basic/systemadmin/js/systemManageMain.js'],function(){
		Ext.onReady(function(){
			var systemManage = new techsupport.systemmanage.SystemMain({
				renderTo:'systemManageCt'
			});
			systemManage.show();
		});
	});
</script>
<div id="systemManageCt" style="width:100%; height:100%;"></div>