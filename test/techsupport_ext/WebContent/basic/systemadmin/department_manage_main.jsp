<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--<script type="text/javascript"-->
<!--	src="basic/systemadmin/js/department_manage_main.js"></script>-->
<script type="text/javascript">

Ext.onReady(function() {
	Ext.Loader.load(['basic/systemadmin/js/department_manage_main.js'],function(){
		var depament_manage_panel = new techsupport.deparmentmanage.DepartmentMain(
				{
					renderTo : 'department_manage_panel'
				});
		depament_manage_panel.show();
	});
});
		
</script>
<div id="department_manage_panel" style="width: 100%; height: 100%;"></div>

