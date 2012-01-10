<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
$(document).ready(function() {
	daggleDiv(detailid);
	pageUrl="publicsystem/querylist_qybcbaxx.action";
	divnid="QybcbaxxData";
	tableid="QybcbaxxTable";
	addUrl="publicsystem/insert_qybcbaxx.action";
	addHtml="business/publicsystem/QybcbaxxAdd.jsp";
	addWidth="800";
	delUrl="publicsystem/delete_qybcbaxx.action";
	delid="d_qyid";
	modHtml="business/publicsystem/QybcbaxxModify.jsp";
	modUrl="publicsystem/modify_qybcbaxx.action";
	modWidth="800";
	detailHtml="business/publicsystem/QybcbaxxDetail.jsp";
	detailid="qybcbaxx_detail";
	detailUrl="publicsystem/query_qybcbaxx.action";
	detailWidth="800";
	loadPage(divnid);
		$("#p_bbgzrq").attr("readonly","true");
		$("#p_bbgzrq").datepicker();
		$("#p_bbwcrq").attr("readonly","true");
		$("#p_bbwcrq").datepicker();
	
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
										colWidths: ["20%","20%","20%","20%","20%"]									
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_qyid","Integer",-9999999999,9999999999,null,0,"企业ID"))
			return false;
		if (!checkControlValue("p_qybaxxid","Integer",-9999999999,9999999999,null,0,"企业备案信息ID"))
			return false;
		if (!checkControlValue("p_bbgzrq","Date",null,null,null,0,"补备告知日期"))
			return false;
		if (!checkControlValue("p_bbyy","String",1,2000,null,0,"补备原因"))
			return false;
		if (!checkControlValue("p_bbwcrq","Date",null,null,null,0,"补备完成日期"))
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
					<td width="10%" class="pagedistd">企业备案信息ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qybaxxid" value="0"></td>
					<td width="10%" class="pagedistd">补备告知日期</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bbgzrq" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">补备原因</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bbyy" value=""></td>
					<td width="10%" class="pagedistd">补备完成日期</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bbwcrq" value=""></td>
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
<div id="qybcbaxx_detail" class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="QybcbaxxData" style="width:100%;">
	<table id="QybcbaxxTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_qybaxxid">企业备案信息ID</th>
	     	<th name="l_bbgzrq">补备告知日期</th>
	     	<th name="l_bbyy">补备原因</th>
	     	<th name="l_bbwcrq">补备完成日期</th>
				<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>