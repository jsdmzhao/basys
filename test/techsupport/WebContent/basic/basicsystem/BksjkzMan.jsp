<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {
	pageUrl="basicsystem/querylist_bksjkz.action";
	divnid="BksjkzData";
	tableid="BksjkzTable";
	addUrl="basicsystem/insert_bksjkz.action";
	addHtml="business/basicsystem/BksjkzAdd.jsp";
	addWidth="800";
	delUrl="basicsystem/delete_bksjkz.action";
	delid="d_bjxxid2";
	modHtml="business/basicsystem/BksjkzModify.jsp";
	modUrl="basicsystem/modify_bksjkz.action";
	modWidth="800";
	detailHtml="business/basicsystem/BksjkzDetail.jsp";
	detailid="bksjkz_detail";
	detailUrl="basicsystem/query_bksjkz.action";
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
										colWidths: ["14%","14%","14%","14%","14%","14%","14%"]									
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_bjxxid2","Integer",-9999999999,9999999999,null,0,"报警信息ID"))
			return false;
		if (!checkControlValue("p_bkwpjbxxkzid","Integer",-9999999999,9999999999,null,0,"布控物品基本信息快照ID"))
			return false;
		if (!checkControlValue("p_bksjkzid","Integer",-9999999999,9999999999,null,0,"布控手机快照ID"))
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
	
	<input type="hidden" id="d_bjxxid2" value="">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">查询选项</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="10%" class="pagedistd">报警信息ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bjxxid2" value="0"></td>
					<td width="10%" class="pagedistd">布控物品基本信息快照ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bkwpjbxxkzid" value="0"></td>
					<td width="10%" class="pagedistd">布控手机快照ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bksjkzid" value="0"></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">手机串号</td>
					<td width="23%" class="pagetd"><input type="text" id="p_sjch" value=""></td>
					<td width="10%" class="pagedistd">品牌</td>
					<td width="23%" class="pagetd"><input type="text" id="p_pp" value=""></td>
					<td width="10%" class="pagedistd">型号</td>
					<td width="23%" class="pagetd"><input type="text" id="p_xh" value=""></td>
				</tr>
				<tr>
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
<div id="bksjkz_detail" class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="BksjkzData" style="width:100%;">
	<table id="BksjkzTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_bkwpjbxxkzid">布控物品基本信息快照ID</th>
	     	<th name="l_bksjkzid">布控手机快照ID</th>
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