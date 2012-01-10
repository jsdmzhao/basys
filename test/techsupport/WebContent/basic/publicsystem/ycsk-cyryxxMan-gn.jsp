<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
<script type="text/javascript">
	var ycskCyrx_tables = "";
	var ycskCyrx_pageUrl="publicsystem/querylistYcsk_qysctj.action";
	var ycskCyrx_divnid="ycskCyrxListData";
	var ycskCyrx_tableid="ycskCyryxx";
	var ycskCyrx_detailHtml="basic/publicsystem/QyryxxDetail.jsp";
	var ycskCyrx_detailid="cyryxx_detail";
	var ycskCyrx_detailUrl="publicsystem/query_qyryxx.action";
	var ycskCyrx_detailWidth="700";
	
	$(document).ready(function() {
		ycskCyrx_loadPage(ycskCyrx_divnid);
		ycskCyrx_setPageList(1);
		daggleDiv("cyryxx_detail");
	});

	function ycskCyrx_setPageList(pageno,url){
		url=ycskCyrx_setList(pageno,url);
		var mygrid1 = $("#"+ycskCyrx_tableid).ingrid({ 
										url: url,
										ingridPageWidth: 800,
										height: 400,
										pageNumber: pageno,
										onRowSelect:null,
										ingridPageParams:sXML,
										sorting: false,
										colWidths: ["8%","20%","18%","22%","22%","10%"]
									});			
	}
	function ycskCyrx_loadPage(divpageid){
		ycskCyrx_tables=$("#"+divpageid).html();
		$("#"+ycskCyrx_detailid).hide();
		ycskCyrx_setPageList(1,'#');
	}
	function ycskCyrx_setList(pageno,url){
		$("#"+ycskCyrx_divnid).html(ycskCyrx_tables);
		setParams("x_");
		if (url==null || url=="undefined"){
			url=ycskCyrx_pageUrl;
		}
		return url;
	}

</script>

</head>
<body>
<input type="hidden" id="d_ryid" value="">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">一次刷卡从业人员</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$("#d_ryid").parent().hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td height="3"></td></tr>
</table>
<div id="cyryxx_detail" class="page-layout" src="#" style="z-index:2000; top:45px; left:0px;"></div>
<div id="ycskCyrxListData" style="width:100%;">
			<table id="ycskCyryxx" width="100%">
			  <thead>
			    <tr>
			     	<th name="l_xm">姓名</th>
			     	<th name="l_cyrybh">从业人员编号</th>
			     	<th name="l_zjhm">证件号码</th>
			     	<th name="l_ssqymc">所属场所</th>
			     	<th name="l_qymc">刷卡场所</th>
			     	<th name="l_sksj">刷卡日期</th>
			    </tr>
			  </thead>
			</table>
</div>
</body>
</html>