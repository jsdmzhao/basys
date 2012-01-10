<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {
	pageUrl="basicsystem/querylist_xctbhf.action";
	divnid="XctbhfData";
	tableid="XctbhfTable";
	addUrl="basicsystem/insert_xctbhf.action";
	addHtml="basic/basicsystem/XctbhfAdd.jsp";
	addWidth="500";
	delUrl="basicsystem/delete_xctbhf.action";
	delid="d_tbid";
	modHtml="basic/basicsystem/XctbhfModify.jsp";
	modUrl="basicsystem/modify_xctbhf.action";
	modWidth="500";
	detailHtml="basic/basicsystem/XctbhfDetail.jsp";
	detailid="xctbhf_detail";
	detailUrl="basicsystem/query_xctbhf.action";
	detailWidth="300";
	loadPage(divnid);
		$("#p_hfsj").attr("readonly","true");
		$("#p_hfsj").datepicker();
	
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
										colWidths: ["16%","16%","16%","16%","16%","16%"]									
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_tbid","Integer",-9999999999,9999999999,null,0,"通报ID"))
			return false;
		if (!checkControlValue("p_jsdwid","Integer",-9999999999,9999999999,null,0,"接收单位ID"))
			return false;
		if (!checkControlValue("p_hfid","Integer",-9999999999,9999999999,null,0,"回复ID"))
			return false;
		if (!checkControlValue("p_hfsj","Date",null,null,null,0,"回复时间"))
			return false;
		if (!checkControlValue("p_hfnr","String",1,2000,null,0,"回复内容"))
			return false;
		if (!checkControlValue("p_hfr","String",1,100,null,0,"回复人"))
			return false;
		return true;
	}
</script>

<body>
	
	<input type="hidden" id="d_tbid" value="">
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
					<td width="10%" class="pagedistd">通报ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_tbid" value="0"></td>
					<td width="10%" class="pagedistd">接收单位ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_jsdwid" value="0"></td>
					<td width="10%" class="pagedistd">回复ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hfid" value="0"></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">回复时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hfsj" value=""></td>
					<td width="10%" class="pagedistd">回复内容</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hfnr" value=""></td>
					<td width="10%" class="pagedistd">回复人</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hfr" value=""></td>
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
<div id="xctbhf_detail"  class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="XctbhfData" style="width:97%; padding-right:17px;">
	<table id="XctbhfTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_jsdwid">接收单位ID</th>
	     	<th name="l_hfid">回复ID</th>
	     	<th name="l_hfsj">回复时间</th>
	     	<th name="l_hfnr">回复内容</th>
	     	<th name="l_hfr">回复人</th>
				<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>