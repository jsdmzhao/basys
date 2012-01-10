<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
<script type="text/javascript">
	var dcskCyrx_tables = "";
	var dcskCyrx_pageUrl="publicsystem/querylistDcsk_qysctj.action";
	var dcskCyrx_divnid="dcskCyrxListData";
	var dcskCyrx_tableid="ycskCyryxx";
	var dcskCyrx_detailHtml="basic/publicsystem/QyryxxDetail.jsp";
	var dcskCyrx_detailid="cyryxx_detail";
	var dcskCyrx_detailUrl="publicsystem/query_qyryxx.action";
	var dcskCyrx_detailWidth="700";
	
	$(document).ready(function() {
		dcskCyrx_loadPage(dcskCyrx_divnid);
		dcskCyrx_setPageList(1);
		daggleDiv("cyryxx_detail");
	});

	function dcskCyrx_setPageList(pageno,url){
		url=dcskCyrx_setList(pageno,url);
		var mygrid1 = $("#"+dcskCyrx_tableid).ingrid({ 
										url: url,
										ingridPageWidth: 800,
										height: 400,
										pageNumber: pageno,
										onRowSelect: function(tr, selected){
											var str = selected ? 'SELECTED' : 'UNSELECTED';
											if(sFlag=="true"){
												if ($(tr).attr('_selected')=="true"){
													ycsk_setQuery($(tr).attr("id")); 	
												}
											}else{
												sFlag="true";
											}
											rowselect=$(tr).attr('rowindex');
										},
										ingridPageParams:sXML,
										sorting: false,
										colWidths: ["8%","20%","18%","20%","20%","10%","4%"]
									});			
	}
	function dcskCyrx_loadPage(divpageid){
		dcskCyrx_tables=$("#"+divpageid).html();
		$("#"+dcskCyrx_detailid).hide();
		dcskCyrx_setPageList(1,'#');
	}
	function dcskCyrx_setList(pageno,url){
		$("#"+dcskCyrx_divnid).html(dcskCyrx_tables);
		setParams("x_");
		if (url==null || url=="undefined"){
			url=dcskCyrx_pageUrl;
		}
		return url;
	}
	
	//人员信息
	function ycsk_setQuery(id){ 
		$("#"+dcskCyrx_detailid).empty();
		dataid=id;
		cyrysetWidth(dcskCyrx_detailid,dcskCyrx_detailWidth);
		setUrl(dcskCyrx_detailid,dcskCyrx_detailHtml);
		bindDocument(dcskCyrx_detailid);
	}
	function cyrysetWidth(divid,sWidth){
		$("#"+divid).css("width",sWidth+"px");
		$("#"+divid).css("left","50px");
	}
	//var detailUrl="publicsystem/query_qyryxx.action";
	//function Qyryxx_setDetail(){
	//	var child=new Array(dcskCyrx_detailid);
	//	setParams("q_",child);
	//	jQuery.post(detailUrl,params,updatediv,"json");
	//}
</script>

</head>
<body>
<input type="hidden" id="d_ryid" value="">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">多次刷卡从业人员</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$("#d_ryid").parent().hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td height="3"></td></tr>
</table>
<div id="cyryxx_detail" class="page-layout" src="#" style="z-index:2000; top:45px; left:0px;"></div>
<div id="dcskCyrxListData" style="width:100%;">
			<table id="ycskCyryxx" width="100%">
			  <thead>
			    <tr>
			     	<th name="l_xm">姓名</th>
			     	<th name="l_cyrybh">从业人员编号</th>
			     	<th name="l_zjhm">证件号码</th>
			     	<th name="l_ssqymc">所属场所</th>
			     	<th name="l_qymc">刷卡场所</th>
			     	<th name="l_sksj">刷卡日期</th>
			     	<th name="l_skcs">刷卡次数</th>
			    </tr>
			  </thead>
			</table>
</div>
</body>
</html>