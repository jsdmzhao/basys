<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
$(document).ready(function() {
	daggleDiv("bwryxx_detail");
	pageUrl="publicsystem/querylist_bwryxx.action";
	divnid="BwryxxData";
	tableid="BwryxxTable";
	addUrl="publicsystem/insert_bwryxx.action";
	delUrl="publicsystem/delete_bwryxx.action";
	delid="d_qyid";
	modHtml="business/publicsystem/BwryxxModify.jsp";
	modUrl="publicsystem/modify_bwryxx.action";
	modWidth="800";
	detailHtml="business/publicsystem/BwryxxDetail.jsp";
	detailid="bwryxx_detail";
	detailUrl="publicsystem/query_bwryxx.action";
	detailWidth="800";
	/*
	$("#p_csrq").attr("readonly","true");
	$("#p_csrq").datepicker();
	$("#p_sgrq").attr("readonly","true");
	$("#p_sgrq").datepicker();
	$("#p_lzrq").attr("readonly","true");
	$("#p_lzrq").datepicker();
	$("#p_lrsj").attr("readonly","true");
	$("#p_lrsj").datepicker();
	*/
	setPageList_bwryxx("#");
}); 
	
function setPageList_bwryxx(pageno,url){	
	//if (manVerify()){
		url=setList(pageno,url);
		var mygrid1 = $("#"+tableid).ingrid({ 
										url: url,	
										height: 250,
                                       	ingridPageParams:sXML,
										pageNumber: pageno,
										hideColIndex:[5,6,7,8,9,10,11,12,13,14],
										colWidths: ["16%","16%","16%","20%","16%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","16%"]									
									});				
		//}
}	
/*
	function manVerify(){
		if (!checkControlValue("p_qyid","Integer",-9999999999,9999999999,null,0,"企业ID"))
			return false;
		if (!checkControlValue("p_bwryid","Integer",-9999999999,9999999999,null,0,"保卫人员ID"))
			return false;
		if (!checkControlValue("p_xm","String",1,100,null,0,"姓名"))
			return false;
		if (!checkControlValue("p_csrq","Date",null,null,null,0,"出生日期"))
			return false;
		if (!checkControlValue("p_xbdm","String",1,2,null,0,"性别代码"))
			return false;
		if (!checkControlValue("p_xb","String",1,2,null,0,"性别"))
			return false;
		if (!checkControlValue("p_hjdxzqhdm","String",1,10,null,0,"户籍地行政区划代码"))
			return false;
		if (!checkControlValue("p_hjdxzqh","String",1,200,null,0,"户籍地行政区划"))
			return false;
		if (!checkControlValue("p_hjdxz","String",1,200,null,0,"户籍地详址"))
			return false;
		if (!checkControlValue("p_gmsfhm","String",1,20,null,0,"公民身份号码"))
			return false;
		if (!checkControlValue("p_sgrq","Date",null,null,null,0,"上岗日期"))
			return false;
		if (!checkControlValue("p_lzyy","String",1,200,null,0,"离职原因"))
			return false;
		if (!checkControlValue("p_lzrq","Date",null,null,null,0,"离职日期"))
			return false;
		if (!checkControlValue("p_bz","String",1,2000,null,0,"备注"))
			return false;
		if (!checkControlValue("p_zt","String",1,10,null,0,"状态"))
			return false;
		if (!checkControlValue("p_lrr","String",1,100,null,0,"录入人"))
			return false;
		if (!checkControlValue("p_lrsj","Date",null,null,null,0,"录入时间"))
			return false;
		return true;
	}
	*/

	function setAddPage_bwryxx(){
		setWidth("bwryxx_detail","800");
		setUrl("bwryxx_detail","business/publicsystem/BwryxxAdd.jsp");
	}
</script>
	<input type="hidden" id="d_qyid" />
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
<!--<tr>
		<td class="queryfont">查询选项</td>
	</tr>
-->
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
    	<!-- 
				<tr>
					<td width="10%" class="pagedistd">企业ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qyid" class="inputstyle" value="0"></td>
					<td width="10%" class="pagedistd">保卫人员ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bwryid" class="inputstyle" value="0"></td>
					<td width="10%" class="pagedistd">姓名</td>
					<td width="23%" class="pagetd"><input type="text" id="p_xm" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">出生日期</td>
					<td width="23%" class="pagetd"><input type="text" id="p_csrq" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">性别代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_xbdm" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">性别</td>
					<td width="23%" class="pagetd"><input type="text" id="p_xb" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">户籍地行政区划代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hjdxzqhdm" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">户籍地行政区划</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hjdxzqh" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">户籍地详址</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hjdxz" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">公民身份号码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_gmsfhm" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">上岗日期</td>
					<td width="23%" class="pagetd"><input type="text" id="p_sgrq" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">离职原因</td>
					<td width="23%" class="pagetd"><input type="text" id="p_lzyy" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">离职日期</td>
					<td width="23%" class="pagetd"><input type="text" id="p_lzrq" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">备注</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bz" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">状态</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zt" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">录入人</td>
					<td width="23%" class="pagetd"><input type="text" id="p_lrr" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">录入时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_lrsj" class="inputstyle" value=""></td>
				</tr> -->
    		<tr>
    		  <td>
    		  	<table  border="0" align="right"  cellpadding="2"  cellspacing="0">
    		    	<tr>
<!--    		    	  <td width="50%" ><a href="#" class="searchbutton" id="querys" onclick="setPageList(1);">查询</a></td>-->
    		    	  <td><a href="#" class="addbutton"  onclick='setAddPage_bwryxx()'>添加</a></td>
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
<div id="bwryxx_detail" class="page-layout" src="#"
		style="top:180px; left:160px;display:none">
</div>	

<div id="BwryxxData" style="width:100%;">
	<table id="BwryxxTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_xm">保卫人员姓名</th>
	     	<th name="l_gmsfhm">保卫人员身份证号</th>
	     	<th name="l_hjdxzqh">户籍地省市县</th>
	     	<th name="l_hjdxz">户籍地详址</th>
	     	<th name="l_sgrq">上岗日期</th>
	     	
	     	<th name="l_csrq">出生日期</th>
	     	<th name="l_xbdm">性别代码</th>
	     	<th name="l_xb">性别</th>
	     	<th name="l_hjdxzqhdm">户籍地行政区划代码</th>
	     	<th name="l_lzyy">离职原因</th>
	     	<th name="l_lzrq">离职日期</th>
	     	<th name="l_bz">备注</th>
	     	<th name="l_zt">状态</th>
	     	<th name="l_lrr">录入人</th>
	     	<th name="l_lrsj">录入时间</th>
			<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>