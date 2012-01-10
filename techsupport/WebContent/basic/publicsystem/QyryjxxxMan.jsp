<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
$(document).ready(function() {
	daggleDiv(detailid);
	pageUrl="publicsystem/querylist_qyryjxxx.action";
	divnid="QyryjxxxData";
	tableid="QyryjxxxTable";
	addUrl="publicsystem/insert_qyryjxxx.action";
	addHtml="business/publicsystem/QyryjxxxAdd.jsp";
	addWidth="800";
	delUrl="publicsystem/delete_qyryjxxx.action";
	delid="d_qyryjxid";
	modHtml="business/publicsystem/QyryjxxxModify.jsp";
	modUrl="publicsystem/modify_qyryjxxx.action";
	modWidth="800";
	detailHtml="business/publicsystem/QyryjxxxDetail.jsp";
	detailid="qyryjxxx_detail";
	detailUrl="publicsystem/query_qyryjxxx.action";
	detailWidth="800";
	loadPage(divnid);
		$("#p_csrq").attr("readonly","true");
		$("#p_csrq").datepicker();
		$("#p_lrsj").attr("readonly","true");
		$("#p_lrsj").datepicker();
	
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
										colWidths: ["4%","4%","4%","4%","4%","4%","4%","4%","4%","4%","4%","4%","4%","4%","4%","4%","4%","4%","4%","4%","4%","4%"]									
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_qyryjxid","Integer",-9999999999,9999999999,null,0,"企业业人员简项ID"))
			return false;
		if (!checkControlValue("p_qyid","Integer",-9999999999,9999999999,null,0,"企业ID"))
			return false;
		if (!checkControlValue("p_hylbdm","String",1,3,null,0,"行业类别代码"))
			return false;
		if (!checkControlValue("p_hylb","String",1,40,null,0,"行业类别"))
			return false;
		if (!checkControlValue("p_cyrybh","String",1,30,null,0,"从业人员编号"))
			return false;
		if (!checkControlValue("p_xm","String",1,100,null,0,"姓名"))
			return false;
		if (!checkControlValue("p_xmpy","String",1,60,null,0,"姓名拼音"))
			return false;
		if (!checkControlValue("p_gjdm","String",1,40,null,0,"国籍代码"))
			return false;
		if (!checkControlValue("p_gj","String",1,100,null,0,"国籍"))
			return false;
		if (!checkControlValue("p_xbdm","String",1,2,null,0,"性别代码"))
			return false;
		if (!checkControlValue("p_xb","String",1,2,null,0,"性别"))
			return false;
		if (!checkControlValue("p_csrq","Date",null,null,null,0,"出生日期"))
			return false;
		if (!checkControlValue("p_hjdxzqh","String",1,200,null,0,"户籍地行政区划"))
			return false;
		if (!checkControlValue("p_hjdxzqhdm","String",1,10,null,0,"户籍地行政区划代码"))
			return false;
		if (!checkControlValue("p_cyzjdm","String",1,40,null,0,"常用证件代码"))
			return false;
		if (!checkControlValue("p_cyzj","String",1,100,null,0,"常用证件"))
			return false;
		if (!checkControlValue("p_zjhm","String",1,20,null,0,"证件号码"))
			return false;
		if (!checkControlValue("p_lrsj","Date",null,null,null,0,"录入时间"))
			return false;
		if (!checkControlValue("p_lrr","String",1,100,null,0,"录入人"))
			return false;
		if (!checkControlValue("p_lrdwbm","String",1,20,null,0,"录入单位编码"))
			return false;
		if (!checkControlValue("p_lrdwmc","String",1,60,null,0,"录入单位名称"))
			return false;
		if (!checkControlValue("p_zt","String",1,10,null,0,"状态"))
			return false;
		return true;
	}
</script>

<body>
	
	<input type="hidden" id="d_qyryjxid" value="">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">查询选项</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="10%" class="pagedistd">企业业人员简项ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qyryjxid" class="inputstyle" value="0"></td>
					<td width="10%" class="pagedistd">企业ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qyid" class="inputstyle" value="0"></td>
					<td width="10%" class="pagedistd">行业类别代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hylbdm" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">行业类别</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hylb" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">从业人员编号</td>
					<td width="23%" class="pagetd"><input type="text" id="p_cyrybh" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">姓名</td>
					<td width="23%" class="pagetd"><input type="text" id="p_xm" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">姓名拼音</td>
					<td width="23%" class="pagetd"><input type="text" id="p_xmpy" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">国籍代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_gjdm" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">国籍</td>
					<td width="23%" class="pagetd"><input type="text" id="p_gj" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">性别代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_xbdm" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">性别</td>
					<td width="23%" class="pagetd"><input type="text" id="p_xb" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">出生日期</td>
					<td width="23%" class="pagetd"><input type="text" id="p_csrq" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">户籍地行政区划</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hjdxzqh" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">户籍地行政区划代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hjdxzqhdm" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">常用证件代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_cyzjdm" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">常用证件</td>
					<td width="23%" class="pagetd"><input type="text" id="p_cyzj" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">证件号码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zjhm" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">录入时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_lrsj" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">录入人</td>
					<td width="23%" class="pagetd"><input type="text" id="p_lrr" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">录入单位编码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_lrdwbm" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">录入单位名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_lrdwmc" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">状态</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zt" class="inputstyle" value=""></td>
				</tr>
    		<tr>
    		  <td colspan="6">
    		  	<table  border="0" align="right"  cellpadding="2"  cellspacing="0">
    		    	<tr>
    		    	  <td width="50%" ><a href="#" class="searchbutton" id="querys" onclick="setPageList(1);">查询</a></td>
    		    	  <td width="50%" ><a href="#" class="submitbutton" onclick='setAddPage()'>添加</a></td>
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
<div id="qyryjxxx_detail" class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="QyryjxxxData" style="width:100%;">
	<table id="QyryjxxxTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_qyid">企业ID</th>
	     	<th name="l_hylbdm">行业类别代码</th>
	     	<th name="l_hylb">行业类别</th>
	     	<th name="l_cyrybh">从业人员编号</th>
	     	<th name="l_xm">姓名</th>
	     	<th name="l_xmpy">姓名拼音</th>
	     	<th name="l_gjdm">国籍代码</th>
	     	<th name="l_gj">国籍</th>
	     	<th name="l_xbdm">性别代码</th>
	     	<th name="l_xb">性别</th>
	     	<th name="l_csrq">出生日期</th>
	     	<th name="l_hjdxzqh">户籍地行政区划</th>
	     	<th name="l_hjdxzqhdm">户籍地行政区划代码</th>
	     	<th name="l_cyzjdm">常用证件代码</th>
	     	<th name="l_cyzj">常用证件</th>
	     	<th name="l_zjhm">证件号码</th>
	     	<th name="l_lrsj">录入时间</th>
	     	<th name="l_lrr">录入人</th>
	     	<th name="l_lrdwbm">录入单位编码</th>
	     	<th name="l_lrdwmc">录入单位名称</th>
	     	<th name="l_zt">状态</th>
				<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>