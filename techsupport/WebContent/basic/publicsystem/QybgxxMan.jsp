<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		var Qybgxx_dataid=""
		var Qybgxx_tables="";
		Qybgxx_pageUrl="publicsystem/queryforlist_qybgxx.action";
		Qybgxx_divnid="QybgxxData";
		Qybgxx_tableid="QybgxxTable";
		Qybgxx_addUrl="publicsystem/insert_qybgxx.action";
		Qybgxx_addHtml="business/publicsystem/QybgxxAdd.jsp";
		Qybgxx_addWidth="800";
		Qybgxx_delUrl="publicsystem/delete_qybgxx.action";
		Qybgxx_delid="d_qyid";
		Qybgxx_modHtml="business/publicsystem/QybgxxModify.jsp";
		Qybgxx_modUrl="publicsystem/modify_qybgxx.action";
		Qybgxx_modWidth="800";
		Qybgxx_detailHtml="basic/publicsystem/QybgxxDetail.jsp";
		Qybgxx_detailid="qybgxx_detail1";
		Qybgxx_detailUrl="publicsystem/query_qybgxx.action";
		Qybgxx_detailWidth="800";
		Qybgxx_loadPage(Qybgxx_divnid);
		daggleDiv(Qybgxx_detailid);
		Qybgxx_setPageList(1);
		
	});
	function Qybgxx_loadPage(divpageid){
		Qybgxx_tables=$("#"+divpageid).html();
		$("#"+Qybgxx_detailid).hide();
		Qybgxx_setPageList(1,'#');
	}
	function Qybgxx_setList(pageno,url){
		$("#"+Qybgxx_divnid).html(Qybgxx_tables);	
		setParams("s_");
		if (url==null || url=="undefined"){
			url=Qybgxx_pageUrl;
		}
		return url;
	}
	function Qybgxx_setPageList(pageno,url){
		url=Qybgxx_setList(pageno,url);
		var mygrid1 = $("#"+Qybgxx_tableid).ingrid({
										url: url,
										ingridPageParams:sXML,
										ingridPageWidth: 998,
										height: 330,
										pageNumber: pageno,
										sorting: false,
										paging: false,
										isPlayResultNull: false,
										onRowSelect: function(tr, selected){
												var str = selected?'SELECTED':'UNSELECTED';
												if(sFlag=="true"){
													if ($(tr).attr('_selected')=="true"){
														Qybgxx_queryDetail($(tr).attr("id")); 	
													}
												}else{
													sFlag="true";
												}
										},
										colWidths: ["20%","20%","20%","40%"]									
									});				
	}
	function Qybgxx_queryDetail(id){ //查看
		Qybgxx_dataid=id;
		$("#"+Qybgxx_detailid).css("width",Qybgxx_detailWidth+"px");
		$("#"+Qybgxx_detailid).css("left","100px");
		setUrl(Qybgxx_detailid,Qybgxx_detailHtml);
		bindDocument(Qybgxx_detailid);
	}
</script>

<body>
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">变更详情列表</td>
  </tr>
</table>
<div id="qybgxx_detail1" class="page-layout" src="#" style="top:50px; left:10px;"></div>

<div id="QybgxxData" style="width:100%;">
	<table id="QybgxxTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_bgdjxh">变更登记序号</th>
	     	<th name="l_bglx">变更类型</th>
	     	<th name="l_bgrq">变更日期</th>
	     	<th name="l_bgyy">变更原因</th>
	    </tr>
	  </thead>
	</table>	
</div>
</body>
