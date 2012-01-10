<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
<title>提交材料 - 场所备案</title>
<script type="text/javascript">
	var baxxtjcl_tables = "";
	var baxxtjcl_pageUrl="publicsystem/querylistTjcl_qybaxx.action";
	var baxxtjcl_divnid="BaxxTjclListData";
	var baxxtjcl_tableid="lBaxxTjcl";
	var table_width = 892;
	var tableHgightBaxx = 90;
	if(typeof newTableWidth!="undefined" && newTableWidth!="")
		table_width = newTableWidth;
	$(document).ready(function() {
		if(setNull($("#tjclqyjbxx").attr("value"))!=''){
			tableHgightBaxx = setNull($("#tjclqyjbxx").attr("value"));
		}
		baxxtjcl_loadPage(baxxtjcl_divnid);
		baxxtjcl_setPageList(1);
	}); 
	
	function baxxtjcl_setPageList(pageno,url){
		url=baxxtjcl_setList(pageno,url);
		var baxxtjcl_mygrid1 = $("#"+baxxtjcl_tableid).ingrid({
										tableid:"grid_baxxtjTable",
										url: url,
										ingridPageParams:sXML,
										ingridPageWidth: table_width,
										height: tableHgightBaxx*1,
										pageNumber: pageno,
										sorting: false,
										paging: false,
										ingridComplete:function(){
											CompleteEnd();
										},
										onRowSelect: function(tr, selected){},
										colWidths: ["45%","15%","20%","20%"]
									});				
	}
	function baxxtjcl_loadPage(divpageid){
		baxxtjcl_tables=$("#"+divpageid).html();
		baxxtjcl_setPageList(1,'#');
	}
	function baxxtjcl_setList(pageno,url){
		$("#"+baxxtjcl_divnid).html(baxxtjcl_tables);
		if (url==null || url=="undefined"){
			url=baxxtjcl_pageUrl;
		}
		return url;
	}
</script>
</head>
<body>
<div id="BaxxTjclListData" style="width:100%;">
	<table id="lBaxxTjcl" width="100%">
	  <thead>
	    <tr>
	     	<th name="l_display_name">提交材料类型</th>
	     	<th name="l_append_value">是否提交</th>
	     	<th name="l_item_simplepin">提交人</th>
	     	<th name="l_query_simplepin">提交日期</th>
	    </tr>
	  </thead>
	</table>	
</div>
</body>
</html>