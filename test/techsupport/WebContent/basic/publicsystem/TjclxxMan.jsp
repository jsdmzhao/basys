<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
$(document).ready(function() {
	daggleDiv(detailid);
	pageUrl="publicsystem/querylist_tjclxx.action";
	divnid="TjclxxData";
	tableid="TjclxxTable";
	addUrl="publicsystem/insert_tjclxx.action";
	addHtml="business/publicsystem/TjclxxAdd.jsp";
	addWidth="800";
	delUrl="publicsystem/delete_tjclxx.action";
	delid="d_tjclxxid";
	modHtml="business/publicsystem/TjclxxModify.jsp";
	modUrl="publicsystem/modify_tjclxx.action";
	modWidth="800";
	detailHtml="business/publicsystem/TjclxxDetail.jsp";
	detailid="tjclxx_detail";
	detailUrl="publicsystem/query_tjclxx.action";
	detailWidth="800";
	loadPage(divnid);
		$("#p_tijiaorq").attr("readonly","true");
		$("#p_tijiaorq").datepicker();
	
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
										colWidths: ["12%","12%","12%","12%","12%","12%","12%","12%"]									
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_tjclxxid","Integer",-9999999999,9999999999,null,0,"提交材料信息ID"))
			return false;
		if (!checkControlValue("p_qyid","Integer",-9999999999,9999999999,null,0,"企业ID"))
			return false;
		if (!checkControlValue("p_qybaxxid","Integer",-9999999999,9999999999,null,0,"企业备案信息ID"))
			return false;
		if (!checkControlValue("p_tjcllxdm","String",1,2,null,0,"提交材料类型代码"))
			return false;
		if (!checkControlValue("p_tjcllx","String",1,100,null,0,"提交材料类型"))
			return false;
		if (!checkControlValue("p_tijiaorq","Date",null,null,null,0,"提交日期"))
			return false;
		if (!checkControlValue("p_tjrxm","String",1,100,null,0,"提交人姓名"))
			return false;
		if (!checkControlValue("p_tjclnr","byte[]",,,,0,"提交材料内容"))
			return false;
		return true;
	}
</script>

<body>
	
	<input type="hidden" id="d_tjclxxid" value="">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">查询选项</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="10%" class="pagedistd">提交材料信息ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_tjclxxid" value="0"></td>
					<td width="10%" class="pagedistd">企业ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qyid" value="0"></td>
					<td width="10%" class="pagedistd">企业备案信息ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qybaxxid" value="0"></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">提交材料类型代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_tjcllxdm" value=""></td>
					<td width="10%" class="pagedistd">提交材料类型</td>
					<td width="23%" class="pagetd"><input type="text" id="p_tjcllx" value=""></td>
					<td width="10%" class="pagedistd">提交日期</td>
					<td width="23%" class="pagetd"><input type="text" id="p_tijiaorq" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">提交人姓名</td>
					<td width="23%" class="pagetd"><input type="text" id="p_tjrxm" value=""></td>
					<td width="10%" class="pagedistd">提交材料内容</td>
					<td width="23%" class="pagetd"><input type="text" id="p_tjclnr" value=""></td>
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
<div id="tjclxx_detail" class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="TjclxxData" style="width:100%;">
	<table id="TjclxxTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_qyid">企业ID</th>
	     	<th name="l_qybaxxid">企业备案信息ID</th>
	     	<th name="l_tjcllxdm">提交材料类型代码</th>
	     	<th name="l_tjcllx">提交材料类型</th>
	     	<th name="l_tijiaorq">提交日期</th>
	     	<th name="l_tjrxm">提交人姓名</th>
	     	<th name="l_tjclnr">提交材料内容</th>
				<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>