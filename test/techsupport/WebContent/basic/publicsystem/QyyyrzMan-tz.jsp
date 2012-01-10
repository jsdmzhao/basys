<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	var ksyysj,jsyysj;
	$(document).ready(function() {
		var d = new Date();
		$("#p_jsyysj").attr("value",backStrDate(d));
		d.setDate(d.getDate()-30);
		$("#p_ksyysj").attr("value",backStrDate(d));
		yyrzzt_tables = "";
		yyrzzt_pageUrl="publicsystem/querylist_qyyyrz.action";
		yyrzzt_divnid="QyyyrzData";
		yyrzzt_tableid="QyyyrzTable";
		yyrzzt_loadPage(yyrzzt_divnid);
		yyrzzt_setPageList(1);
	});
	function yyrzzt_setPageList(pageno,url){
		url=yyrzzt_setList(pageno,url);
		var mygrid1 = $("#"+yyrzzt_tableid).ingrid({
			url: url,
			height: 100,
			ingridPageWidth : pageWidth-16,
			ingridPageParams:sXML,
			pageNumber: pageno,
			onRowSelect:null,
			sorting: false,
			isPlayResultNull: false,
			hideColIndex: [6],
			colWidths: ["14%","19%","19%","12%","18%","18%","0%"]
		});
	}
	function yyrzzt_loadPage(divpageid){
		$("#"+detailid).hide();
		yyrzzt_tables=$("#"+divpageid).html();
		yyrzzt_setPageList(1,'#');
	}
	function yyrzzt_setList(pageno,url){
		$("#"+yyrzzt_divnid).html(yyrzzt_tables);	
		createXML("p_");
		if (url==null || url=="undefined"){
			url=yyrzzt_pageUrl;
		}
		return url;
	}
</script>

<body>
<input type="hidden" id="d_yyrzid" value="">
<input type="hidden" id="p_yyrzid" value="">
<input type="hidden" id="p_ksyysj">
<input type="hidden" id="p_jsyysj">
<div id="QyyyrzData" style="width:100%;">
	<table id="QyyyrzTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_riqi">登记日期</th>
	     	<th name="l_ksyysj">营业开始时间</th>
	     	<th name="l_jsyysj">营业结束时间</th>
	     	<th name="l_csfe">场所负责人</th>
	     	<th name="l_sffsaj">治安、刑事或事故</th>
	     	<th name="l_sfglbmjc">管理部门检查</th>
			<th name="">操作</th>
	    </tr>
	  </thead>
	</table>	
</div>
</body>