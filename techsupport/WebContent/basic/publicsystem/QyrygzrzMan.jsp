<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
$(document).ready(function() {
	daggleDiv(detailid);
	pageUrl="publicsystem/querylist_qyrygzrz.action";
	divnid="QyrygzrzData";
	tableid="QyrygzrzTable";
	addUrl="publicsystem/insert_qyrygzrz.action";
	addHtml="business/publicsystem/QyrygzrzAdd.jsp";
	addWidth="800";
	delUrl="publicsystem/delete_qyrygzrz.action";
	delid="d_qyid";
	modHtml="business/publicsystem/QyrygzrzModify.jsp";
	modUrl="publicsystem/modify_qyrygzrz.action";
	modWidth="800";
	detailHtml="business/publicsystem/QyrygzrzDetail.jsp";
	detailid="qyrygzrz_detail";
	detailUrl="publicsystem/query_qyrygzrz.action";
	detailWidth="800";
	loadPage(divnid);
		$("#p_gzkssj").attr("readonly","true");
		$("#p_gzkssj").datepicker();
		$("#p_gzjssj").attr("readonly","true");
		$("#p_gzjssj").datepicker();
	
}); 
	
function setPageList(pageno,url){	
	if (manVerify()){
		url=setList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+tableid).ingrid({ 
										url: url,	
										height: 250,
                                       ingridPageParams:sXML,
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
		if (!checkControlValue("p_qyrygzrzid","Integer",-9999999999,9999999999,null,0,"企业人员工作日志ID"))
			return false;
		if (!checkControlValue("p_gzkssj","Date",null,null,null,0,"工作开始时间"))
			return false;
		if (!checkControlValue("p_gzjssj","Date",null,null,null,0,"工作结束时间"))
			return false;
		if (!checkControlValue("p_gzdd","String",1,100,null,0,"工作地点"))
			return false;
		if (!checkControlValue("p_gwxx","String",1,300,null,0,"岗位信息"))
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
					<td width="23%" class="pagetd"><input type="text" id="p_qyid" class="inputstyle" value="0"></td>
					<td width="10%" class="pagedistd">从业人员ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ryid" class="inputstyle" value="0"></td>
					<td width="10%" class="pagedistd">企业人员工作日志ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qyrygzrzid" class="inputstyle" value="0"></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">工作开始时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_gzkssj" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">工作结束时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_gzjssj" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">工作地点</td>
					<td width="23%" class="pagetd"><input type="text" id="p_gzdd" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">岗位信息</td>
					<td width="23%" class="pagetd"><input type="text" id="p_gwxx" class="inputstyle" value=""></td>
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
<div id="qyrygzrz_detail" class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="QyrygzrzData" style="width:100%;">
	<table id="QyrygzrzTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_ryid">从业人员ID</th>
	     	<th name="l_qyrygzrzid">企业人员工作日志ID</th>
	     	<th name="l_gzkssj">工作开始时间</th>
	     	<th name="l_gzjssj">工作结束时间</th>
	     	<th name="l_gzdd">工作地点</th>
	     	<th name="l_gwxx">岗位信息</th>
				<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>