<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {
	pageUrl="basicsystem/querylist_bksj.action";
	divnid="BksjData";
	tableid="BksjTable";
	addUrl="basicsystem/insert_bksj.action";
	addHtml="business/basicsystem/BksjAdd.jsp";
	addWidth="800";
	delUrl="basicsystem/delete_bksj.action";
	delid="d_bkwpjbxxid";
	modHtml="business/basicsystem/BksjModify.jsp";
	modUrl="basicsystem/modify_bksj.action";
	modWidth="800";
	detailHtml="business/basicsystem/BksjDetail.jsp";
	detailid="bksj_detail";
	detailUrl="basicsystem/query_bksj.action";
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
										colWidths: ["16%","16%","16%","16%","16%","16%"]									
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_bkwpjbxxid","Integer",-9999999999,9999999999,null,0,"布控物品基本信息ID"))
			return false;
		if (!checkControlValue("p_bksjid","Integer",-9999999999,9999999999,null,0,"布控手机ID"))
			return false;
		if (!checkControlValue("p_sjch","String",1,30,null,0,"手机串号"))
			return false;
		if (!checkControlValue("p_pp","String",1,100,null,0,"品牌"))
			return false;
		if (!checkControlValue("p_xh","String",1,100,null,0,"型号"))
			return false;
		if (!checkControlValue("p_ys","String",1,60,null,0,"颜色"))
			return false;
		return true;
	}
</script>

<body>
	
	<input type="hidden" id="d_bkwpjbxxid" value="">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">查询选项</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="10%" class="pagedistd">布控物品基本信息ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bkwpjbxxid" value="0"></td>
					<td width="10%" class="pagedistd">布控手机ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bksjid" value="0"></td>
					<td width="10%" class="pagedistd">手机串号</td>
					<td width="23%" class="pagetd"><input type="text" id="p_sjch" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">品牌</td>
					<td width="23%" class="pagetd"><input type="text" id="p_pp" value=""></td>
					<td width="10%" class="pagedistd">型号</td>
					<td width="23%" class="pagetd"><input type="text" id="p_xh" value=""></td>
					<td width="10%" class="pagedistd">颜色</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ys" value=""></td>
				</tr>
    		<tr>
    		  <td colspan="6">
    		  	<table  border="0" align="right"  cellpadding="2"  cellspacing="0">
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
		<td height="3"></td>
	</tr>
</table>
<div id="bksj_detail" class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="BksjData" style="width:100%;">
	<table id="BksjTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_bksjid">布控手机ID</th>
	     	<th name="l_sjch">手机串号</th>
	     	<th name="l_pp">品牌</th>
	     	<th name="l_xh">型号</th>
	     	<th name="l_ys">颜色</th>
				<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>