<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<html>
<head>
<script type="text/javascript">
    var pmt_tables = "";
	var pmt_dataid = "";
	var pmt_pageUrl="publicsystem/querylist_pmt.action";
	var pmt_divnid="PmtListData";
	var pmt_tableid="table1";
	var pmt_addUrl="publicsystem/insert_pmt.action";
	var pmt_addHtml="basic/publicsystem/PmtAdd.jsp";
	var pmt_addWidth="310";
	var pmt_delUrl="publicsystem/delete_pmt.action";
	var pmt_delid="d_qyid";
	var pmt_modHtml="basic/publicsystem/PmtModify.jsp";
	var pmt_modUrl="publicsystem/modify_pmt.action";
	var pmt_detailHtml="basic/publicsystem/PmtDetail.jsp";
	var pmt_detailid="pmt_detail";
	var pmt_detailUrl="publicsystem/query_pmt.action";
	var pmt_detailWidth="310";
	var pmt_ingrid_height = 63;
$(document).ready(function() {
	$("#p_pmtRequetType").attr("value",qyjbxx_requestType);
		pmt_loadPage(pmt_divnid);
		dataid="sPmtid"; //公用变量 目的取得pmtID
		if(qyjbxx_requestType!='add'){ //非添加都请求
			createXML("p_"); //主要获取场所ID和请求动作
			pmt_setPageList(1);
		}
		if(qyjbxx_requestType=='detail'){ //详细信息不给添加按钮
			document.getElementById('pmt_add').style.display='none';
			pmt_ingrid_height = 80;
		}
	daggleDiv(pmt_detailid);
}); 
	
function pmt_setPageList(pageno,url){	
		url=pmt_setList(pageno,url);
		var hideCol=[0];
		var colWidth=["0%","96%","4%"];

		if(qyjbxx_requestType=='detail'){
		    hideCol=[0,2];
		    colWidth=["0%","100%","0%"];
		}
		var mygrid1 = $("#"+pmt_tableid).ingrid({ 
											ingridPageParams:sXML,
											ingridPageWidth: 998,
											url: url,	
											height: pmt_ingrid_height,
											pageNumber: pageno,
											sorting: false,
											paging: false,
											isPlayResultNull: false,
											onRowSelect: function(tr, selected){
												var str = selected ? 'SELECTED' : 'UNSELECTED';
												if (sFlag=="true"){
													if ($(tr).attr('_selected')=="true"){
														pmt_setQuery($(tr).attr("id")); 
													}
												}else{
													sFlag="true";
												}
											},
											havaWaiDivGunDong: true,
											hideColIndex:hideCol,
											colWidths: colWidth									
									});				
	}
	function pmt_loadPage(divpageid){
		pmt_tables=$("#"+divpageid).html();
		$("#"+pmt_detailid).hide();
		pmt_setPageList(1,'#');
	}
	function pmt_setList(pageno,url){	
		$("#"+pmt_divnid).html(pmt_tables);
		if (url==null || url=="undefined"){
			url=pmt_pageUrl;
		}
		return url;
	}
	function pmt_setAddPage(){
		closeAllDiv();
		setWidth(pmt_detailid,pmt_addWidth);
		setUrl(pmt_detailid,pmt_addHtml);
		//bindDocument(pmt_detailid);
	}
	function pmt_setAdd(){ //添加
		if (pmt_addVerify()){
			var child=new Array(pmt_divnid);
			setParams("a_",child);
			pmt_setPageList(1,pmt_addUrl);
			if($("#pmt_checkbox").attr("checked")==false){
				$("#pmt_detail").hide("show");
			} else {
				$("#pmtPho").attr("src","images/pic.gif");
				$("#bq_pmtlx").setValue(""); //全部
			}
		}else{
			return pmt_addVerify();
		}	
	}
	function pmt_setQuery1(id){ //查看
		closeAllDiv();
		pmt_dataid=id;
		setWidth(pmt_detailid,pmt_detailWidth);
		setUrl(pmt_detailid,pmt_detailHtml);
		//bindDocument(pmt_detailid);
	}
	function pmt_setQuery(id){ //查看
		closeAllDiv();
		pmt_dataid=id;
		setWidth(pmt_detailid,pmt_detailWidth);
		setUrl(pmt_detailid,pmt_detailHtml);
		//bindDocument(pmt_detailid);
	}
	function pmt_setDetail(){
		var child=new Array(pmt_divnid);
		setParams("q_",child);
		jQuery.post(pmt_detailUrl,params,pmt_updatediv,"json");
	}
	function pmt_setDelete(id){ //删除
		sFlag="false";
		jConfirm('确定删除吗？', '删除提示', function(r) {
	    	if(r==true){
				$("#d_sPmtid").attr("value",id);
				$("#d_qyid").attr("value",'0');
				var child=new Array(pmt_divnid);
				setParams("d_",child);
				pmt_setPageList(1,pmt_delUrl);
			}else{
			   return false;
			}
		});
	}
</script>
</head>
<body>
<input type="hidden" id="d_sPmtid">
<input type="hidden" id="p_pmtRequetType" value="">
<table width="998px" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td style="color:#004499; font-size:12px; font-weight:bold;">&nbsp;平面图信息</td>
    <td align="right" id="pmt_add">
    <table width="62" border="0" align="right" cellpadding="0" cellspacing="0">
		<tr>
			<td ><a href="#" class="addbutton"  onclick='pmt_setAddPage();'>添加</a></td>
		</tr>
	</table>
    </td>
  </tr>
</table>
<div id="pmt_detail"  class="page-layout" src="#"
		style="top:100px; left:160px; width:500px;">
</div>	

<div id="PmtListData" style="width:100%;">
	<table id="table1" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_pmtlxdm">平面图类型代码</th>
	     	<th name="l_pmtlxmc">平面图类型名称</th>
			<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>
</body>
</html>