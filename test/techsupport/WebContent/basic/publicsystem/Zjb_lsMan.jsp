<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
$(document).ready(function() {
	daggleDiv(detailid);
	pageUrl="publicsystem/querylist_zjb_ls.action";
	divnid="Zjb_lsData";
	tableid="Zjb_lsTable";
	addUrl="publicsystem/insert_zjb_ls.action";
	addHtml="business/publicsystem/Zjb_lsAdd.jsp";
	addWidth="800";
	delUrl="publicsystem/delete_zjb_ls.action";
	delid="d_qyid";
	modHtml="business/publicsystem/Zjb_lsModify.jsp";
	modUrl="publicsystem/modify_zjb_ls.action";
	modWidth="800";
	detailHtml="business/publicsystem/Zjb_lsDetail.jsp";
	detailid="zjb_ls_detail";
	detailUrl="publicsystem/query_zjb_ls.action";
	detailWidth="800";
	loadPage(divnid);
		$("#p_qsrq").attr("readonly","true");
		$("#p_qsrq").datepicker();
		$("#p_jzrq").attr("readonly","true");
		$("#p_jzrq").datepicker();
	
}); 
	
function setPageList(pageno,url){	
	if (manVerify()){
		url=setList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+tableid).ingrid({ 
										url: url,	
										height: 250,
										pageNumber: pageno,
										colWidths: ["11%","11%","11%","11%","11%","11%","11%","11%","11%"]									
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_qyid","Integer",-9999999999,9999999999,null,0,"企业ID"))
			return false;
		if (!checkControlValue("p_qylsid","Integer",-9999999999,9999999999,null,0,"企业历史ID"))
			return false;
		if (!checkControlValue("p_zjlsid","Integer",-9999999999,9999999999,null,0,"证件历史ID"))
			return false;
		if (!checkControlValue("p_fk_zjid","Integer",-9999999999,9999999999,null,0,"证件ID"))
			return false;
		if (!checkControlValue("p_zjfl","String",1,40,null,0,"证件分类"))
			return false;
		if (!checkControlValue("p_zjbh","String",1,60,null,0,"证件编号"))
			return false;
		if (!checkControlValue("p_fzjg","String",1,60,null,0,"发证机关"))
			return false;
		if (!checkControlValue("p_qsrq","Date",null,null,null,0,"起始日期"))
			return false;
		if (!checkControlValue("p_jzrq","Date",null,null,null,0,"截止日期"))
			return false;
		return true;
	}
</script>

<body>
	
	<input type="hidden" id="d_qyid" value="">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">查询选项</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="10%" class="pagedistd">企业ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qyid" value="0"></td>
					<td width="10%" class="pagedistd">企业历史ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qylsid" value="0"></td>
					<td width="10%" class="pagedistd">证件历史ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zjlsid" value="0"></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">证件ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_fk_zjid" value="0"></td>
					<td width="10%" class="pagedistd">证件分类</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zjfl" value=""></td>
					<td width="10%" class="pagedistd">证件编号</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zjbh" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">发证机关</td>
					<td width="23%" class="pagetd"><input type="text" id="p_fzjg" value=""></td>
					<td width="10%" class="pagedistd">起始日期</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qsrq" value=""></td>
					<td width="10%" class="pagedistd">截止日期</td>
					<td width="23%" class="pagetd"><input type="text" id="p_jzrq" value=""></td>
				</tr>
    		<tr>
    		  <td colspan="6">
    		  	<table  border="0" align="right"  cellpadding="2"  cellspacing="0">
    		    	<tr>
    		    	  <td width="50%" ><a href="#" class="searchbutton" id="querys" onclick="setPageList(1);">查询</a></td>
    		    	  <td width="50%" ><a href="#" class="addbutton" onclick='setAddPage()'>添加</a></td>
    		    	</tr>
    		  	</table>
    		  </td>
    		</tr>
    	</table>
    </td>
  </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="3"></td>
	</tr>
</table>
<div id="zjb_ls_detail" class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="Zjb_lsData" style="width:100%;">
	<table id="Zjb_lsTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_qylsid">企业历史ID</th>
	     	<th name="l_zjlsid">证件历史ID</th>
	     	<th name="l_fk_zjid">证件ID</th>
	     	<th name="l_zjfl">证件分类</th>
	     	<th name="l_zjbh">证件编号</th>
	     	<th name="l_fzjg">发证机关</th>
	     	<th name="l_qsrq">起始日期</th>
	     	<th name="l_jzrq">截止日期</th>
				<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>