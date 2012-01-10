<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
<script type="text/javascript">
	var qyjbxx_tables = "";
	$(document).ready(function() {
		daggleDiv("qyjbxx_detail");
		qyjbxx_loadPage("QyjbxxData");
		qyjbxx_setPageList(1);
	});
	function qyjbxx_loadPage(divpageid){
		qyjbxx_tables=$("#QyjbxxData").html();
		//$("#QyjbxxData").hide();
		qyjbxx_setPageList(1,'#');
		
	}
	function qyjbxx_setList(pageno,url){	
		$("#QyjbxxData").html(qyjbxx_tables);
		createXML("x_");
		if (url==null || url=="undefined"){
			url="publicsystem/querySkwscmxList_wscqy.action";
		}
		return url;
	}
	function qyjbxx_setPageList(pageno,url){
		url=qyjbxx_setList(pageno,url);
		var mygrid1 = $("#QyjbxxTable").ingrid({
				url: url,
				ingridPageParams:sXML,
				height: 300,
				ingridPageWidth: 1000,
				pageNumber: pageno,
				onRowSelect: null,
				colWidths: ["8%","32%","13%","8%","8%","14%","8%","10%"]									
		});
	}
</script>

</head>
<body>
<div id="QyxxClose"></div>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">刷卡统计未上传场所信息</td>
      <td align="right" class="title1"><a href="#" onclick="$('#QyxxClose').parent().hideAndRemove(&quot;show&quot;);" class="close"></a></td>
    </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td height="3"></td></tr>
</table>
<div id="qyjbxx_detail" class="page-layout" src="#" style="z-index:2000; top:-50px; left:0px; display:none;"></div>
<div id="QyjbxxData" style="width:100%;">
	<table id="QyjbxxTable" width="100%">
	  <thead>
	    <tr>
	    	<th>日期</th>
	    	<th>场所名称</th>
	     	<th>场所备案编号</th>
	     	<th>总人数</th>
	     	<th>联系电话</th>
	     	<th>场所类别</th>
	     	<th>场所状态</th>
	     	<th>场所治安级别</th>
	    </tr>
	  </thead>
	</table>	
</div>
</body>
</html>