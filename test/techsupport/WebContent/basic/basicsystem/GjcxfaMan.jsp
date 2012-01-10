<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {
	pageUrl="basicsystem/querylist_gjcxfa.action";
	divnid="GjcxfaData";
	tableid="GjcxfaTable";
	addUrl="basicsystem/insert_gjcxfa.action";
	addHtml="business/basicsystem/GjcxfaAdd.jsp";
	addWidth="500";
	delUrl="basicsystem/delete_gjcxfa.action";
	delid="d_gjcxfaid";
	modHtml="business/basicsystem/GjcxfaModify.jsp";
	modUrl="basicsystem/modify_gjcxfa.action";
	modWidth="500";
	detailHtml="business/basicsystem/GjcxfaDetail.jsp";
	detailid="gjcxfa_detail";
	detailUrl="basicsystem/query_gjcxfa.action";
	detailWidth="300";
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
		if (!checkControlValue("p_gjcxfaid","Integer",-9999999999,9999999999,null,0,"高级查询方案ID"))
			return false;
		if (!checkControlValue("p_gjcxfamc","String",1,100,null,0,"高级查询方案名称"))
			return false;
		if (!checkControlValue("p_ssyhzh","String",1,60,null,0,"所属用户帐号"))
			return false;
		if (!checkControlValue("p_ssgnmc","String",1,100,null,0,"所属功能名称"))
			return false;
		if (!checkControlValue("p_gjcxlx","String",1,20,null,0,"高级查询类型"))
			return false;
		return true;
	}
</script>

<body>
	
	<input type="hidden" id="d_gjcxfaid" value="">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="6"></td>
  </tr>
</table>
<table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#c1d0dd">
  <tr>
    <td class="queryfont">查询选项</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="10%" class="pagedistd">高级查询方案ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_gjcxfaid" value="0"></td>
					<td width="10%" class="pagedistd">高级查询方案名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_gjcxfamc" value=""></td>
					<td width="10%" class="pagedistd">所属用户帐号</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ssyhzh" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">所属功能名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ssgnmc" value=""></td>
					<td width="10%" class="pagedistd">高级查询类型</td>
					<td width="23%" class="pagetd"><input type="text" id="p_gjcxlx" value=""></td>
				</tr>
    		<tr>
    		  <td colspan="6">
    		  	<table width="124" border="0" align="right" cellpadding="0" cellspacing="0">
    		    	<tr>
    		    	  <td width="50%" class="querybutton"><a href="#" class="querybuttonfont" id="querys" onclick="setPageList(1);">查询</a></td>
    		    	  <td width="50%" class="addbutton"><a href="#" class="addbutton" onclick='setAddPage()'>添加</a></td>
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
		<td height="6"></td>
	</tr>
</table>
<div id="gjcxfa_detail"  class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="GjcxfaData" style="width:97%; padding-right:17px;">
	<table id="GjcxfaTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_gjcxfamc">高级查询方案名称</th>
	     	<th name="l_ssyhzh">所属用户帐号</th>
	     	<th name="l_ssgnmc">所属功能名称</th>
	     	<th name="l_gjcxlx">高级查询类型</th>
				<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>