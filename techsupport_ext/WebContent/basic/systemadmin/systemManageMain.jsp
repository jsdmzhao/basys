<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	Ext.Loader.load(['basic/systemadmin/js/department_manage_main.js','basic/systemadmin/js/systemManegeMain.js'],function(){
		Ext.onReady(function(){
			techsupport.systemmanage.SystemMain({
				renderTo:'systemManageCt'
			});
		});
	});
</script>
<div id="systemManageCt"></div>