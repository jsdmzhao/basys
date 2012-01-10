<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
$(document).ready(function() {
	daggleDiv(detailid);
	pageUrl="publicsystem/querylist_qyffl.action";
	divnid="QyfflData";
	tableid="QyfflTable";
	addUrl="publicsystem/insert_qyffl.action";
	addHtml="business/publicsystem/QyfflAdd.jsp";
	addWidth="800";
	delUrl="publicsystem/delete_qyffl.action";
	delid="d_qyflid";
	modHtml="business/publicsystem/QyfflModify.jsp";
	modUrl="publicsystem/modify_qyffl.action";
	modWidth="800";
	detailHtml="business/publicsystem/QyfflDetail.jsp";
	detailid="qyffl_detail";
	detailUrl="publicsystem/query_qyffl.action";
	detailWidth="800";
	loadPage(divnid);
	
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
		if (!checkControlValue("p_qyflid","Integer",-9999999999,9999999999,null,0,"企业分类ID"))
			return false;
		if (!checkControlValue("p_qyid","Integer",-9999999999,9999999999,null,0,"企业ID"))
			return false;
		if (!checkControlValue("p_qyflbm","String",1,4,null,0,"企业分类编码"))
			return false;
		if (!checkControlValue("p_sjcsflmc","String",1,200,null,0,"上级场所分类名称"))
			return false;
		if (!checkControlValue("p_qyflmc","String",1,300,null,0,"企业分类名称"))
			return false;
		return true;
	}
</script>

<body>
	
	<input type="hidden" id="d_qyflid" value="">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">查询选项</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="10%" class="pagedistd">企业分类ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qyflid" value="0"></td>
					<td width="10%" class="pagedistd">企业ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qyid" value="0"></td>
					<td width="10%" class="pagedistd">企业分类编码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qyflbm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">上级场所分类名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_sjcsflmc" value=""></td>
					<td width="10%" class="pagedistd">企业分类名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qyflmc" value=""></td>
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
<div id="qyffl_detail" class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="QyfflData" style="width:100%;">
	<table id="QyfflTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_qyid">企业ID</th>
	     	<th name="l_qyflbm">企业分类编码</th>
	     	<th name="l_sjcsflmc">上级场所分类名称</th>
	     	<th name="l_qyflmc">企业分类名称</th>
				<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>