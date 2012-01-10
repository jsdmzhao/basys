<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.aisino2.common.DateUtil"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page import="com.aisino2.sysadmin.domain.User"%>
<%@ page import="com.aisino2.sysadmin.Constants"%>
<%@include file="../../public/common.jsp" %>
<%
User user = new User();
String userName = null;
//获得登录用户session
user = (User) session.getAttribute(Constants.userKey);
if (user == null)
	response.sendRedirect("login.jsp");
else
	userName = user.getUsername(); 
String lrsj = DateUtil.getDateTime();
%>
<script type="text/javascript">
	$(document).ready(function() {
	    bc_bottonMoveRight(4); 
		$("#bwry_sgrq").attr("readonly",true).datepicker();
	}); 
	function addVerify_bwryxx(){
		if (!checkControlValue("bwry_xm","String",1,100,null,1,"姓 名"))
			return false;
		if (!checkControlValue("bwry_gmsfhm","String",1,20,null,1,"身份证号"))
			return false;
		if(!bwry_valCyryZjhmFront($("#bwry_gmsfhm").val(),null))
			return false;
		if (!checkControlValue("bwry_hjdxzqh","String",1,200,null,1,"户籍地省市县"))
			return false;
		if (!checkControlValue("bwry_hjdxz","String",1,200,null,1,"户籍地详址"))
			return false;
		if (!checkControlValue("bwry_sgrq","Date",null,null,null,1,"上岗日期"))
			return false;
		if (!checkControlValue("bwry_lrr","String",1,100,null,0,"填报人"))
			return false;
		if (!checkControlValue("bwry_bz","String",1,2000,null,0,"备注"))
			return false;
		return true;
	}

	$("#bwry_hjdxzqh").click(function(){
		getDict_item("bwry_hjdxzqh","bwry_hjdxzqhdm","dm_xzqh");
	});

	$("#bwry_gmsfhm").blur(function(){
		if(!checkIdCardNo("bwry_gmsfhm"))
			jAlert("身份证号不正确！","验证信息");

		getHjsxDD($(this).val(),"dm_xzqh","bwry_hjdxzqhdm","bwry_hjdxzqh");
	});
	
	function setAdd_bwryxx(){
		if(addVerify_bwryxx()){
			dataid="bwryid";
			var child=new Array("BwryxxListData");
			setParams("bwry_",child);
			setPageList_bwryxx(1);
			$("#bwryxx_detail").hideAndRemove("show");
		}
	}
	
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">保卫人员信息添加</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#bwryxx_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="add">
	<tr height="20">
		<td class="red" width="12%">姓名</td>
		<td class="pagetd1" width="21%"><input type="text" id="bwry_xm" class="inputstyle" /></td>
		<td class="red" width="11%">身份证号</td>
		<td class="pagetd1" width="22%"><input type="text" id="bwry_gmsfhm" class="inputstyle" /></td>
		<td class="red" width="13%">户籍地省市县</td>
		<td class="pagetd1" width="21%">
		<input type="text" id="bwry_hjdxzqh" class="inputstyle" readonly />
		<input type="hidden" id="bwry_hjdxzqhdm" />
		</td>
	</tr>
	<tr height="20">
		<td class="red">户籍地详址</td>
		<td class="pagetd1" colspan="3"><input type="text" id="bwry_hjdxz" class="inputstyle3" style="width:98.7%" /></td>
		<td class="red">上岗日期</td>
		<td class="pagetd1"><input type="text" id="bwry_sgrq" class="inputstyle" /></td>
	</tr>
	<tr height="20" style="display:none">
		<td class="pagedistd1">填报人</td>
		<td class="pagetd1"><input type="text" id="bwry_lrr" class="readonly" value="<%=userName %>" /></td>
		<td class="pagedistd1">填报时间</td>
		<td class="pagetd1" colspan="3"><input type="text" id="bwry_lrsj" class="readonly" value="<%=lrsj %>" /></td>
	</tr>
	<tr height="20">
		<td class="pagedistd1">备注</td>
		<td class="pagetd1" colspan="5"><textarea id="bwry_bz" style="width:98.7%" value=""></textarea></td>
	</tr>
<tr height="25" align="center">
<td  colspan="6"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setAdd_bwryxx();'>保存</a></td></tr>
</table>