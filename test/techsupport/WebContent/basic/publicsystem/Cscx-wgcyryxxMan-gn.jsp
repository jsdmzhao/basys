<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
<script type="text/javascript">
	var gzrzPageDiv = "wgcyryxx_detail"; //关闭工作日志的div名字
	var cscxWgcyrx_tables = "";
	var cscxWgcyrx_dataid = "";
	var cscxWgcyrx_pageUrl="publicsystem/querylistGadCscx_publicwgcyryxx.action";
	var cscxWgcyrx_divnid="cscxWgcyrxListData";
	var cscxWgcyrx_tableid="cscxWgCyryxx";
	var cscxWgcyrx_detailHtml="basic/publicsystem/WgcyryxxDetail.jsp";
	var cscxWgcyrx_detailid="wgcyryxx_detail";
	var cscxWgcyrx_detailUrl="publicsystem/query_publicwgcyryxx.action";
	var cscxWgcyrx_detailWidth="700";
	
	var cscxCyrx_wgRyHtml="basic/publicsystem/WgcyryxxDetail.jsp"; //境外人员信息
	var cscxCyrx_wgRyWidth="700";
	var cscxCyrx_wgRyGzrzHtml="business/Ylfwzagl/CyrygzrzMan.jsp"; //境外人员工作日志
	var cscxCyrx_wgRyGzrzWidth="700";
	
	$(document).ready(function() {
		cscxWgcyrx_loadPage(cscxWgcyrx_divnid);
		cscxWgcyrx_setPageList(1);
		$("#cyryxx_detail").hide();
		
		 daggleDiv("wgcyryxx_detail");
	}); 
	
	function cscxWgcyrx_setPageList(pageno,url){
		url=cscxWgcyrx_setList(pageno,url);
		var mygrid1 = $("#"+cscxWgcyrx_tableid).ingrid({
										url: url,
										ingridPageParams:sXML,
										height: 400,
										ingridPageWidth: 800,
										pageNumber: pageno,
										colClasses: ['grid-col-style2','grid-col-style2'],
										colIndex: [0,1],
										hideColIndex:[5],	
										onRowSelect: function(tr, selected){
										},
										onTdSelect: function(tr){
											$(tr).find("td").click(function(){
												if (sFlag=="true"){
													var tdnum = $(tr).find("td").index(this);
													if(tdnum!=$(tr).find("td").length-1&&(tdnum==0||tdnum==1)){
														cscx_setWgryxx($(tr).attr("id"));
													}
												}else{
													sFlag="true";
												}
											});	
										},
										colWidths: ["20%","26%","23%","13%","19%","0%"]
									});
	}
	function cscxWgcyrx_loadPage(divpageid){
		cscxWgcyrx_tables=$("#"+divpageid).html();
		$("#"+cscxWgcyrx_detailid).hide();
		cscxWgcyrx_setPageList(1,'#');
	}
	function cscxWgcyrx_setList(pageno,url){
		$("#"+cscxWgcyrx_divnid).html(cscxWgcyrx_tables);
		setParams("c_");
		if (url==null || url=="undefined"){
			url=cscxWgcyrx_pageUrl;
		}
		return url;
	}
	var gwcyry_timeFlag = true;
	function cscx_setWgryxx(id){ //人员信息
		if(gwcyry_timeFlag){
			gwcyry_timeFlag = false;
			dataid=id;
			detailUrl="publicsystem/query_publicwgcyryxx.action";
			wgcyrysetWidth(cscxWgcyrx_detailid,cscxCyrx_wgRyWidth);
			setUrl(cscxWgcyrx_detailid,cscxCyrx_wgRyHtml);
			//bindDocument(cscxWgcyrx_detailid);
			setTimeout(function(){gwcyry_timeFlag = true;},800);
		}
	}
	function set_CscxWgCygj(id){ //从业轨迹
		if(gwcyry_timeFlag){
			gwcyry_timeFlag = false;
			detailHeight=$("#"+cscxCyrx_detailid).css("height");
			dataid=$("#"+id).find("td").eq(1).text();
			wgcyrysetWidth(cscxWgcyrx_detailid,cscxCyrx_wgRyGzrzWidth);
			setUrl(cscxWgcyrx_detailid,"business/Ylfwzagl/CyrycygjMan.jsp");
			var cyryxx_detailidOffset = $("#"+cscxWgcyrx_detailid).offset();
			detailidTopOffset=cyryxx_detailidOffset.top;
			detailidLeftOffset=cyryxx_detailidOffset.left;
			//bindDocument(cscxWgcyrx_detailid);
			setTimeout(function(){gwcyry_timeFlag = true;},800);
		}
	}
	function set_CscxWgGzrz(id){ //工作日志
		if(gwcyry_timeFlag){
			gwcyry_timeFlag = false;
			var cyrybh = $("#"+id).find("td").eq(2).text();
			dataid=cyrybh;
			wgcyrysetWidth(cscxWgcyrx_detailid,cscxCyrx_wgRyGzrzWidth);
			setUrl(cscxWgcyrx_detailid,cscxCyrx_wgRyGzrzHtml);
			var cyryxx_detailidOffset = $("#"+cscxWgcyrx_detailid).offset();
			detailidTopOffset=cyryxx_detailidOffset.top;
			detailidLeftOffset=cyryxx_detailidOffset.left;
			//bindDocument(cscxWgcyrx_detailid);
			setTimeout(function(){gwcyry_timeFlag = true;},800);
		}
	}
	function wgcyrysetWidth(divid,sWidth){
		$("#"+divid).css("width",sWidth+"px");
		$("#"+divid).css("left","50px");
	}
	
	var detailUrl="publicsystem/query_qyryxx.action";
	function Qyryxx_setDetail(){
		var child=new Array(cscxCyrx_detailid);
		setParams("q_",child);
		jQuery.post(detailUrl,params,updatediv,"json");
	}
	
	
</script>
</head>
<body>
<input type="hidden" id="d_ryid" value="">
<input type="hidden" id="d_qyid" value="">
<div id="wgcyryxx_detail"  class="page-layout" src="#"
		style="top:15px;">
</div>	
<div id="cscxWgcyrxListData" style="width:100%;">
	<table id="cscxWgCyryxx" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_xm">英文名.英文姓</th>
			<th name="l_zjhm">护照号</th>
			<th name="l_cyrybh">从业人员编号</th>
			<th name="l_xb">性别</th>
			<th name="l_cylb">从业类别</th>
			<th name="">操作</th>
	    </tr>
	  </thead>
	</table>	
</div>
</body>
</html>