<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
$(document).ready(function() {
	daggleDiv(detailid);
	pageUrl="publicsystem/querylist_clxxry_zp.action";
	divnid="Clxxry_zpData";
	tableid="Clxxry_zpTable";
	addUrl="publicsystem/insert_clxxry_zp.action";
	addHtml="business/publicsystem/Clxxry_zpAdd.jsp";
	addWidth="800";
	delUrl="publicsystem/delete_clxxry_zp.action";
	delid="d_cljbxxid";
	modHtml="business/publicsystem/Clxxry_zpModify.jsp";
	modUrl="publicsystem/modify_clxxry_zp.action";
	modWidth="800";
	detailHtml="business/publicsystem/Clxxry_zpDetail.jsp";
	detailid="clxxry_zp_detail";
	detailUrl="publicsystem/query_clxxry_zp.action";
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
		if (!checkControlValue("p_cljbxxid","Integer",-9999999999,9999999999,null,0,"车辆基本信息ID"))
			return false;
		if (!checkControlValue("p_clxxryzpid","Integer",-9999999999,9999999999,null,0,"车辆信息人员照片ID"))
			return false;
		if (!checkControlValue("p_tpmc","String",1,100,null,0,"图片名称"))
			return false;
		if (!checkControlValue("p_tplx","String",1,40,null,0,"图片类型"))
			return false;
		if (!checkControlValue("p_tpnr","byte[]",,,,0,"图片内容"))
			return false;
		return true;
	}
</script>

<body>
	
	<input type="hidden" id="d_cljbxxid" value="">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">查询选项</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="10%" class="pagedistd">车辆基本信息ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_cljbxxid" value="0"></td>
					<td width="10%" class="pagedistd">车辆信息人员照片ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_clxxryzpid" value="0"></td>
					<td width="10%" class="pagedistd">图片名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_tpmc" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">图片类型</td>
					<td width="23%" class="pagetd"><input type="text" id="p_tplx" value=""></td>
					<td width="10%" class="pagedistd">图片内容</td>
					<td width="23%" class="pagetd"><input type="text" id="p_tpnr" value=""></td>
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
<div id="clxxry_zp_detail" class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="Clxxry_zpData" style="width:100%;">
	<table id="Clxxry_zpTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_clxxryzpid">车辆信息人员照片ID</th>
	     	<th name="l_tpmc">图片名称</th>
	     	<th name="l_tplx">图片类型</th>
	     	<th name="l_tpnr">图片内容</th>
				<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>