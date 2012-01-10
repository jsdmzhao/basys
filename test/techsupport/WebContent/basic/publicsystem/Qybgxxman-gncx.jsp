<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
<script type="text/javascript">
	var QybgxxCx_dataid=""
	var QybgxxCx_tables="";
	var QybgxxCx_pageUrl="publicsystem/queryListByGad_qybgxx.action";
	var QybgxxCx_divnid="QybgxxCxData";
	var QybgxxCx_tableid="QybgxxCxTable";
	var QybgxxCx_addUrl="publicsystem/insert_qybgxx.action";
	var QybgxxCx_addHtml="business/publicsystem/QybgxxAdd.jsp";
	var QybgxxCx_addWidth="800";
	var QybgxxCx_delUrl="publicsystem/delete_qybgxx.action";
	var QybgxxCx_delid="d_qyid";
	var QybgxxCx_modHtml="business/publicsystem/QybgxxModify.jsp";
	var QybgxxCx_modUrl="publicsystem/modify_qybgxx.action";
	var QybgxxCx_modWidth="800";
	var QybgxxCx_detailHtml="basic/publicsystem/QybgxxDetail.jsp";
	var QybgxxCx_detailid="QybgxxCx_detail1";
	var QybgxxCx_detailUrl="publicsystem/query_qybgxx.action";
	var QybgxxCx_detailWidth="800";
	var QybgxxCx_qybm = "";
	$(document).ready(function() {
		QybgxxCx_loadPage(QybgxxCx_divnid);
		$("#p_gxdwmc").click(function(){ //治安管理机构
			getGxdw("p_gxdwmc","p_gxdwbm");
		});
		$("#BQ_qyzflbm").selectBox({code:"dm_ylcsfl(bzh)"});
		$("#BQ_qybglb").selectBox({code:"dm_bglb"});
		$("#p_bgrqf").attr("readonly","true").datepicker();
		$("#p_bgrqt").attr("readonly","true").datepicker();
		daggleDiv(QybgxxCx_detailid);
	});
	$('#BQ_qyzflbm').change(function(){
  	    $('#p_qyzflbm').val($('#BQ_qyzflbm').attr('value')) ;
	});
	$('#BQ_qybglb').change(function(){
  	    $('#p_bglxdm').val($('#BQ_qybglb').attr('value')) ;
	});
	//服务场所筛选框
	$("#p_qymc").click(function(){
	 	dataid="J";
		getTy_item_super("p_qymc","p_qybm",'','','','1');
	});
	function QybgxxCx_loadPage(divpageid){
		QybgxxCx_tables=$("#"+divpageid).html();
		$("#"+QybgxxCx_detailid).hide();
		QybgxxCx_setPageList(1,'#');
	}
	function QybgxxCx_setList(pageno,url){
		$("#"+QybgxxCx_divnid).html(QybgxxCx_tables);	
		setParams("p_");
		if (url==null || url=="undefined"){
			url=QybgxxCx_pageUrl;
		}
		return url;
	}
	function QybgxxCx_setPageList(pageno,url){
		url=QybgxxCx_setList(pageno,url);
		var mygrid1 = $("#"+QybgxxCx_tableid).ingrid({
										url: url,
										ingridPageParams:sXML,
										height: pageHeight-276,
										onRowSelect: function(tr, selected){
										},
										onTdSelect: function(tr){
											obj = $(tr).find("td").eq(0); //企业编码
											QybgxxCx_qybm = obj.text();
											obj.html("<a href='#' class='hyperlink' onClick=QybgxxCx_queryQyxx('"+QybgxxCx_qybm+"');>"+obj.text()+"</a>");
											obj = $(tr).find("td").eq(1); //企业名称
											obj.html("<a href='#' class='hyperlink' onClick=QybgxxCx_queryQyxx('"+QybgxxCx_qybm+"');>"+obj.text()+"</a>");
										},
										pageNumber: pageno,
										colWidths: ["12%","20%","14%","16%","12%","11%","11%","4%"]
									});				
	}
	var Qybgxx_dataid = '';
	var Qybgxx_detailUrl="publicsystem/query_qybgxx.action";
	function QybgxxCx_queryDetail(id){ //查看
		Qybgxx_dataid=id;
		setWidth(QybgxxCx_detailid,QybgxxCx_detailWidth);
		setUrl(QybgxxCx_detailid,QybgxxCx_detailHtml);
		bindDocument(QybgxxCx_detailid);
	}
	
	var glcxcsxx_detailHtml="business/Ylfwzagl/YlcsjbxxDetail.jsp";
	var glcxcsxx_detailWidth="990";
	var qyjbxx_requestType="detail";
	var qyjbxx_dataid = "";
	function QybgxxCx_queryQyxx(qybm){
		qyjbxx_dataid = "qybm_"+qybm;
		setWidth(QybgxxCx_detailid,glcxcsxx_detailWidth);
		setUrl(QybgxxCx_detailid,glcxcsxx_detailHtml);
		bindDocument(QybgxxCx_detailid);
	}
</script>
<body>
<input type="hidden" id="p_qybgGacxFlag" value="1">
<input type="hidden" id="p_qyzflbm">
<input type="hidden" id="p_bglxdm">
<input type="hidden" id="p_gxdwbm">
<input type="hidden" id="p_qybm">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
	<tr><td class="queryfont">查询数据项</td></tr>
	<tr>
        <td class="tdbg">
        
        <table width="100%" border="0" cellspacing="0" cellpadding="2">
			<tr>  
				<td width="12%" class="pagedistd">场所分类</td>
				<td width="23%" class="pagetd"><select name="select" id="BQ_qyzflbm"><option></option></select></td>
				<td width="10%" class="pagedistd">治安管理机构</td>
				<td width="23%" class="pagetd"><input type="text" class="inputstyle" id="p_gxdwmc" readonly></td>
				<td width="10%" class="pagedistd">场所名称</td>
				<td width="21%" class="pagetd"><input type="text" class="inputstyle" id="p_qymc" readonly></td>
			</tr>
			<tr>  
				<td class="pagedistd">营业执照号</td>
				<td class="pagetd"><input type="text" class="inputstyle" id="p_zjbh"></td>
				<td class="pagedistd">法人姓名</td>
				<td class="pagetd"><input type="text" class="inputstyle" id="p_frdb"></td>
				<td class="pagedistd">经营地址</td>
				<td class="pagetd"><input type="text" class="inputstyle" id="p_jydz"></td>
			</tr>
			<tr>  
				<td class="pagedistd">变更登记序号</td>
				<td class="pagetd"><input type="text" class="inputstyle" id="p_bgdjxh"></td>
				<td class="pagedistd">变更类型</td>
				<td class="pagetd"><select name="select" id="BQ_qybglb"><option></option></select></td>
				<td class="pagedistd">变更原因</td>
				<td class="pagetd"><input type="text" class="inputstyle" id="p_bgyy"></td>
			</tr>
			<tr>
            	<td class="pagedistd">变更日期</td>
            	<td class="pagetd">
					<input type="text" class="inputstyle1" id="p_bgrqf"> 至 
					<input type="text" class="inputstyle1" id="p_bgrqt"></td>
            	<td colspan="4">
		            <table  border="0" align="right" cellpadding="0" cellspacing="0">
						<tr>
							<td width="62px"><a href="#" class="searchbutton" id="querys" onClick="QybgxxCx_setPageList(1);">查询</a></td>
						</tr>
					</table>
            	</td>
          </tr>
        </table>
	</td>
</tr>
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td height="3"></td></tr>
</table>
	
<div id="QybgxxCx_detail1" class="page-layout" src="#" style="top:10px;"></div>

<div id="QybgxxCxData" style="width:100%;">
	<table id="QybgxxCxTable" width="100%">
	  <thead>
	    <tr>       
	     	<th>场所备案编号</th>
			<th>场所名称</th>
			<th>场所分类</th>
			<th>变更登记序号</th>
			<th>变更类型</th>
			<th>变更原因</th>
			<th>变更日期</th>
			<th>操作</th>
	    </tr>
	  </thead>
	</table>	
</div>

</body>
</html>