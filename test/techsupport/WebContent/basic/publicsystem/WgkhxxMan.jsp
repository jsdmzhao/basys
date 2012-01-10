<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
$(document).ready(function() {
	daggleDiv(detailid);
	pageUrl="publicsystem/querylist_wgkhxx.action";
	divnid="WgkhxxData";
	tableid="WgkhxxTable";
	addUrl="publicsystem/insert_wgkhxx.action";
	addHtml="business/publicsystem/WgkhxxAdd.jsp";
	addWidth="800";
	delUrl="publicsystem/delete_wgkhxx.action";
	delid="d_khxxid";
	modHtml="business/publicsystem/WgkhxxModify.jsp";
	modUrl="publicsystem/modify_wgkhxx.action";
	modWidth="800";
	detailHtml="business/publicsystem/WgkhxxDetail.jsp";
	detailid="wgkhxx_detail";
	detailUrl="publicsystem/query_wgkhxx.action";
	detailWidth="800";
	loadPage(divnid);
		$("#p_zatlq").attr("readonly","true");
		$("#p_zatlq").datepicker();
		$("#p_rjrq").attr("readonly","true");
		$("#p_rjrq").datepicker();
	
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
										colWidths: ["10%","10%","10%","10%","10%","10%","10%","10%","10%","10%"]									
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_khxxid","Integer",-9999999999,9999999999,null,0,"客户信息ID"))
			return false;
		if (!checkControlValue("p_ywx","String",1,60,null,0,"英文姓"))
			return false;
		if (!checkControlValue("p_ywm","String",1,60,null,0,"英文名"))
			return false;
		if (!checkControlValue("p_qzzldm","String",1,40,null,0,"签证种类代码"))
			return false;
		if (!checkControlValue("p_qzzl","String",1,100,null,0,"签证种类"))
			return false;
		if (!checkControlValue("p_qzhm","String",1,20,null,0,"签证号码"))
			return false;
		if (!checkControlValue("p_zatlq","Date",null,null,null,0,"在华停留期至"))
			return false;
		if (!checkControlValue("p_qfjg","String",1,120,null,0,"签发机关"))
			return false;
		if (!checkControlValue("p_rjrq","Date",null,null,null,0,"入境日期"))
			return false;
		if (!checkControlValue("p_rjka","String",1,60,null,0,"入境口岸"))
			return false;
		return true;
	}
</script>

<body>
	
	<input type="hidden" id="d_khxxid" value="">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">查询选项</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="10%" class="pagedistd">客户信息ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_khxxid" value="0"></td>
					<td width="10%" class="pagedistd">英文姓</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ywx" value=""></td>
					<td width="10%" class="pagedistd">英文名</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ywm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">签证种类代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qzzldm" value=""></td>
					<td width="10%" class="pagedistd">签证种类</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qzzl" value=""></td>
					<td width="10%" class="pagedistd">签证号码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qzhm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">在华停留期至</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zatlq" value=""></td>
					<td width="10%" class="pagedistd">签发机关</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qfjg" value=""></td>
					<td width="10%" class="pagedistd">入境日期</td>
					<td width="23%" class="pagetd"><input type="text" id="p_rjrq" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">入境口岸</td>
					<td width="23%" class="pagetd"><input type="text" id="p_rjka" value=""></td>
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
<div id="wgkhxx_detail" class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="WgkhxxData" style="width:100%;">
	<table id="WgkhxxTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_ywx">英文姓</th>
	     	<th name="l_ywm">英文名</th>
	     	<th name="l_qzzldm">签证种类代码</th>
	     	<th name="l_qzzl">签证种类</th>
	     	<th name="l_qzhm">签证号码</th>
	     	<th name="l_zatlq">在华停留期至</th>
	     	<th name="l_qfjg">签发机关</th>
	     	<th name="l_rjrq">入境日期</th>
	     	<th name="l_rjka">入境口岸</th>
				<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>