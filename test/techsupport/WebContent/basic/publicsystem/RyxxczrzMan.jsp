<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
$(document).ready(function() {
	daggleDiv(detailid);
	pageUrl="publicsystem/querylist_ryxxczrz.action";
	divnid="RyxxczrzData";
	tableid="RyxxczrzTable";
	addUrl="publicsystem/insert_ryxxczrz.action";
	addHtml="business/publicsystem/RyxxczrzAdd.jsp";
	addWidth="800";
	delUrl="publicsystem/delete_ryxxczrz.action";
	delid="d_ryxxczrzid";
	modHtml="business/publicsystem/RyxxczrzModify.jsp";
	modUrl="publicsystem/modify_ryxxczrz.action";
	modWidth="800";
	detailHtml="business/publicsystem/RyxxczrzDetail.jsp";
	detailid="ryxxczrz_detail";
	detailUrl="publicsystem/query_ryxxczrz.action";
	detailWidth="800";
	loadPage(divnid);
		$("#p_czsj").attr("readonly","true");
		$("#p_czsj").datepicker();
	
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
		if (!checkControlValue("p_ryxxczrzid","Integer",-9999999999,9999999999,null,0,"人员信息操作日志ID"))
			return false;
		if (!checkControlValue("p_czsj","Date",null,null,null,0,"操作时间"))
			return false;
		if (!checkControlValue("p_czlx","String",1,40,null,0,"操作类型"))
			return false;
		if (!checkControlValue("p_cznr","String",1,2000,null,0,"操作内容"))
			return false;
		if (!checkControlValue("p_czr","String",1,30,null,0,"操作人"))
			return false;
		if (!checkControlValue("p_qybm","String",1,20,null,0,"企业编码"))
			return false;
		if (!checkControlValue("p_cyrybh","String",1,20,null,0,"从业人员编号"))
			return false;
		return true;
	}
</script>

<body>
	
	<input type="hidden" id="d_ryxxczrzid" value="">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">查询选项</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="10%" class="pagedistd">人员信息操作日志ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ryxxczrzid" value="0"></td>
					<td width="10%" class="pagedistd">操作时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_czsj" value=""></td>
					<td width="10%" class="pagedistd">操作类型</td>
					<td width="23%" class="pagetd"><input type="text" id="p_czlx" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">操作内容</td>
					<td width="23%" class="pagetd"><input type="text" id="p_cznr" value=""></td>
					<td width="10%" class="pagedistd">操作人</td>
					<td width="23%" class="pagetd"><input type="text" id="p_czr" value=""></td>
					<td width="10%" class="pagedistd">企业编码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qybm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">从业人员编号</td>
					<td width="23%" class="pagetd"><input type="text" id="p_cyrybh" value=""></td>
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
<div id="ryxxczrz_detail" class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="RyxxczrzData" style="width:100%;">
	<table id="RyxxczrzTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_czsj">操作时间</th>
	     	<th name="l_czlx">操作类型</th>
	     	<th name="l_cznr">操作内容</th>
	     	<th name="l_czr">操作人</th>
	     	<th name="l_qybm">企业编码</th>
	     	<th name="l_cyrybh">从业人员编号</th>
				<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>