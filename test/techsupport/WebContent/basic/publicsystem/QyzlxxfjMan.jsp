<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
$(document).ready(function() {
	daggleDiv(detailid);
	pageUrl="publicsystem/querylist_qyzlxxfj.action";
	divnid="QyzlxxfjData";
	tableid="QyzlxxfjTable";
	addUrl="publicsystem/insert_qyzlxxfj.action";
	addHtml="business/publicsystem/QyzlxxfjAdd.jsp";
	addWidth="800";
	delUrl="publicsystem/delete_qyzlxxfj.action";
	delid="d_qyzlxxfjid";
	modHtml="business/publicsystem/QyzlxxfjModify.jsp";
	modUrl="publicsystem/modify_qyzlxxfj.action";
	modWidth="800";
	detailHtml="business/publicsystem/QyzlxxfjDetail.jsp";
	detailid="qyzlxxfj_detail";
	detailUrl="publicsystem/query_qyzlxxfj.action";
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
                                       ingridPageParams:sXML,
										pageNumber: pageno,
										colWidths: ["20%","20%","20%","20%","20%"]									
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_qyzlxxfjid","Integer",-9999999999,9999999999,null,0,"企业质量信息附件ID"))
			return false;
		if (!checkControlValue("p_qyzlxxid","Integer",-9999999999,9999999999,null,0,"企业质量信息ID"))
			return false;
		if (!checkControlValue("p_fjmc","String",1,100,null,0,"附件名称"))
			return false;
		if (!checkControlValue("p_fjlx","String",1,60,null,0,"附件类型"))
			return false;
		if (!checkControlValue("p_fjnr","byte[]",,,,0,"附件内容"))
			return false;
		return true;
	}
</script>

<body>
	
	<input type="hidden" id="d_qyzlxxfjid" value="">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">查询选项</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="10%" class="pagedistd">企业质量信息附件ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qyzlxxfjid" class="inputstyle" value="0"></td>
					<td width="10%" class="pagedistd">企业质量信息ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qyzlxxid" class="inputstyle" value="0"></td>
					<td width="10%" class="pagedistd">附件名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_fjmc" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">附件类型</td>
					<td width="23%" class="pagetd"><input type="text" id="p_fjlx" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">附件内容</td>
					<td width="23%" class="pagetd"><input type="text" id="p_fjnr" class="inputstyle" value=""></td>
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
<div id="qyzlxxfj_detail" class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="QyzlxxfjData" style="width:100%;">
	<table id="QyzlxxfjTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_qyzlxxid">企业质量信息ID</th>
	     	<th name="l_fjmc">附件名称</th>
	     	<th name="l_fjlx">附件类型</th>
	     	<th name="l_fjnr">附件内容</th>
				<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>