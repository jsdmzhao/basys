<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
$(document).ready(function() {
	daggleDiv(detailid);
	pageUrl="publicsystem/querylist_qyry_tjxx.action";
	divnid="Qyry_tjxxData";
	tableid="Qyry_tjxxTable";
	addUrl="publicsystem/insert_qyry_tjxx.action";
	addHtml="business/publicsystem/Qyry_tjxxAdd.jsp";
	addWidth="800";
	delUrl="publicsystem/delete_qyry_tjxx.action";
	delid="d_qyid";
	modHtml="business/publicsystem/Qyry_tjxxModify.jsp";
	modUrl="publicsystem/modify_qyry_tjxx.action";
	modWidth="800";
	detailHtml="business/publicsystem/Qyry_tjxxDetail.jsp";
	detailid="qyry_tjxx_detail";
	detailUrl="publicsystem/query_qyry_tjxx.action";
	detailWidth="800";
	loadPage(divnid);
		$("#p_tijianrq").attr("readonly","true");
		$("#p_tijianrq").datepicker();
		$("#p_lrrq").attr("readonly","true");
		$("#p_lrrq").datepicker();
	
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
										colWidths: ["14%","14%","14%","14%","14%","14%","14%"]									
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_qyid","Integer",-9999999999,9999999999,null,0,"企业ID"))
			return false;
		if (!checkControlValue("p_ryid","Integer",-9999999999,9999999999,null,0,"从业人员ID"))
			return false;
		if (!checkControlValue("p_tjxxid","Integer",-9999999999,9999999999,null,0,"体检信息ID"))
			return false;
		if (!checkControlValue("p_tijianrq","Date",null,null,null,0,"体检日期"))
			return false;
		if (!checkControlValue("p_tjzkjms","String",1,2000,null,0,"体检状况及描述"))
			return false;
		if (!checkControlValue("p_lrr","String",1,100,null,0,"录入人"))
			return false;
		if (!checkControlValue("p_lrrq","Date",null,null,null,0,"录入日期"))
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
					<td width="10%" class="pagedistd">从业人员ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ryid" value="0"></td>
					<td width="10%" class="pagedistd">体检信息ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_tjxxid" value="0"></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">体检日期</td>
					<td width="23%" class="pagetd"><input type="text" id="p_tijianrq" value=""></td>
					<td width="10%" class="pagedistd">体检状况及描述</td>
					<td width="23%" class="pagetd"><input type="text" id="p_tjzkjms" value=""></td>
					<td width="10%" class="pagedistd">录入人</td>
					<td width="23%" class="pagetd"><input type="text" id="p_lrr" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">录入日期</td>
					<td width="23%" class="pagetd"><input type="text" id="p_lrrq" value=""></td>
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
<div id="qyry_tjxx_detail" class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="Qyry_tjxxData" style="width:100%;">
	<table id="Qyry_tjxxTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_ryid">从业人员ID</th>
	     	<th name="l_tjxxid">体检信息ID</th>
	     	<th name="l_tijianrq">体检日期</th>
	     	<th name="l_tjzkjms">体检状况及描述</th>
	     	<th name="l_lrr">录入人</th>
	     	<th name="l_lrrq">录入日期</th>
				<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>