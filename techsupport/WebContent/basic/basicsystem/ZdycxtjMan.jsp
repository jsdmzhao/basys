<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {
	pageUrl="basicsystem/querylist_zdycxtj.action";
	divnid="ZdycxtjData";
	tableid="ZdycxtjTable";
	addUrl="basicsystem/insert_zdycxtj.action";
	addHtml="business/basicsystem/ZdycxtjAdd.jsp";
	addWidth="500";
	delUrl="basicsystem/delete_zdycxtj.action";
	delid="d_zdycxtjid";
	modHtml="business/basicsystem/ZdycxtjModify.jsp";
	modUrl="basicsystem/modify_zdycxtj.action";
	modWidth="500";
	detailHtml="business/basicsystem/ZdycxtjDetail.jsp";
	detailid="zdycxtj_detail";
	detailUrl="basicsystem/query_zdycxtj.action";
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
										colWidths: ["25%","25%","25%","25%"]									
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_zdycxtjid","Integer",-9999999999,9999999999,null,0,"自定义查询条件ID"))
			return false;
		if (!checkControlValue("p_gjcxfaid","Integer",-9999999999,9999999999,null,0,"高级查询方案ID"))
			return false;
		if (!checkControlValue("p_cxtj","String",1,2000,null,0,"查询条件"))
			return false;
		if (!checkControlValue("p_cxpx","String",1,2000,null,0,"查询排序"))
			return false;
		return true;
	}
</script>

<body>
	
	<input type="hidden" id="d_zdycxtjid" value="">
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
					<td width="10%" class="pagedistd">自定义查询条件ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zdycxtjid" value="0"></td>
					<td width="10%" class="pagedistd">高级查询方案ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_gjcxfaid" value="0"></td>
					<td width="10%" class="pagedistd">查询条件</td>
					<td width="23%" class="pagetd"><input type="text" id="p_cxtj" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">查询排序</td>
					<td width="23%" class="pagetd"><input type="text" id="p_cxpx" value=""></td>
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
<div id="zdycxtj_detail"  class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="ZdycxtjData" style="width:97%; padding-right:17px;">
	<table id="ZdycxtjTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_gjcxfaid">高级查询方案ID</th>
	     	<th name="l_cxtj">查询条件</th>
	     	<th name="l_cxpx">查询排序</th>
				<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>