<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
$(document).ready(function() {
	daggleDiv(detailid);
	pageUrl="publicsystem/querylist_khxx.action";
	divnid="KhxxData";
	tableid="KhxxTable";
	addUrl="publicsystem/insert_khxx.action";
	addHtml="business/publicsystem/KhxxAdd.jsp";
	addWidth="800";
	delUrl="publicsystem/delete_khxx.action";
	delid="d_khxxid";
	modHtml="business/publicsystem/KhxxModify.jsp";
	modUrl="publicsystem/modify_khxx.action";
	modWidth="800";
	detailHtml="business/publicsystem/KhxxDetail.jsp";
	detailid="khxx_detail";
	detailUrl="publicsystem/query_khxx.action";
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
										colWidths: ["7%","7%","7%","7%","7%","7%","7%","7%","7%","7%","7%","7%","7%"]									
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_khxxid","Integer",-9999999999,9999999999,null,0,"客户信息ID"))
			return false;
		if (!checkControlValue("p_xm","String",1,100,null,0,"姓名"))
			return false;
		if (!checkControlValue("p_lxdh","String",1,30,null,0,"联系电话"))
			return false;
		if (!checkControlValue("p_mzdm","String",1,40,null,0,"民族代码"))
			return false;
		if (!checkControlValue("p_minzu","String",1,20,null,0,"民族"))
			return false;
		if (!checkControlValue("p_xbdm","String",1,2,null,0,"性别代码"))
			return false;
		if (!checkControlValue("p_xb","String",1,2,null,0,"性别"))
			return false;
		if (!checkControlValue("p_hjdxz","String",1,200,null,0,"户籍地详址"))
			return false;
		if (!checkControlValue("p_cyzjdm","String",1,40,null,0,"常用证件代码"))
			return false;
		if (!checkControlValue("p_cyzj","String",1,100,null,0,"常用证件"))
			return false;
		if (!checkControlValue("p_zjhm","String",1,20,null,0,"证件号码"))
			return false;
		if (!checkControlValue("p_biduiflag","String",1,1,null,0,"比对标志"))
			return false;
		if (!checkControlValue("p_zt","String",1,10,null,0,"状态"))
			return false;
		return true;
	}
</script>

<body>
	
	<input type="hidden" id="d_khxxid" value="">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">查询选项</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="10%" class="pagedistd">客户信息ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_khxxid" value="0"></td>
					<td width="10%" class="pagedistd">姓名</td>
					<td width="23%" class="pagetd"><input type="text" id="p_xm" value=""></td>
					<td width="10%" class="pagedistd">联系电话</td>
					<td width="23%" class="pagetd"><input type="text" id="p_lxdh" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">民族代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_mzdm" value=""></td>
					<td width="10%" class="pagedistd">民族</td>
					<td width="23%" class="pagetd"><input type="text" id="p_minzu" value=""></td>
					<td width="10%" class="pagedistd">性别代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_xbdm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">性别</td>
					<td width="23%" class="pagetd"><input type="text" id="p_xb" value=""></td>
					<td width="10%" class="pagedistd">户籍地详址</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hjdxz" value=""></td>
					<td width="10%" class="pagedistd">常用证件代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_cyzjdm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">常用证件</td>
					<td width="23%" class="pagetd"><input type="text" id="p_cyzj" value=""></td>
					<td width="10%" class="pagedistd">证件号码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zjhm" value=""></td>
					<td width="10%" class="pagedistd">比对标志</td>
					<td width="23%" class="pagetd"><input type="text" id="p_biduiflag" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">状态</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zt" value=""></td>
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
<div id="khxx_detail" class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="KhxxData" style="width:100%;">
	<table id="KhxxTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_xm">姓名</th>
	     	<th name="l_lxdh">联系电话</th>
	     	<th name="l_mzdm">民族代码</th>
	     	<th name="l_minzu">民族</th>
	     	<th name="l_xbdm">性别代码</th>
	     	<th name="l_xb">性别</th>
	     	<th name="l_hjdxz">户籍地详址</th>
	     	<th name="l_cyzjdm">常用证件代码</th>
	     	<th name="l_cyzj">常用证件</th>
	     	<th name="l_zjhm">证件号码</th>
	     	<th name="l_biduiflag">比对标志</th>
	     	<th name="l_zt">状态</th>
				<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>