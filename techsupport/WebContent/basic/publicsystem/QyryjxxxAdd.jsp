<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		$("#a_csrq").attr("readonly","true");
		$("#a_csrq").datepicker();
		$("#a_lrsj").attr("readonly","true");
		$("#a_lrsj").datepicker();
	}); 
	function addVerify(){
		if (!checkControlValue("a_qyryjxid","Integer",-9999999999,9999999999,null,0,"企业业人员简项ID"))
			return false;
		if (!checkControlValue("a_qyid","Integer",-9999999999,9999999999,null,0,"企业ID"))
			return false;
		if (!checkControlValue("a_hylbdm","String",1,3,null,0,"行业类别代码"))
			return false;
		if (!checkControlValue("a_hylb","String",1,40,null,0,"行业类别"))
			return false;
		if (!checkControlValue("a_cyrybh","String",1,30,null,0,"从业人员编号"))
			return false;
		if (!checkControlValue("a_xm","String",1,100,null,0,"姓名"))
			return false;
		if (!checkControlValue("a_xmpy","String",1,60,null,0,"姓名拼音"))
			return false;
		if (!checkControlValue("a_gjdm","String",1,40,null,0,"国籍代码"))
			return false;
		if (!checkControlValue("a_gj","String",1,100,null,0,"国籍"))
			return false;
		if (!checkControlValue("a_xbdm","String",1,2,null,0,"性别代码"))
			return false;
		if (!checkControlValue("a_xb","String",1,2,null,0,"性别"))
			return false;
		if (!checkControlValue("a_csrq","Date",null,null,null,0,"出生日期"))
			return false;
		if (!checkControlValue("a_hjdxzqh","String",1,200,null,0,"户籍地行政区划"))
			return false;
		if (!checkControlValue("a_hjdxzqhdm","String",1,10,null,0,"户籍地行政区划代码"))
			return false;
		if (!checkControlValue("a_cyzjdm","String",1,40,null,0,"常用证件代码"))
			return false;
		if (!checkControlValue("a_cyzj","String",1,100,null,0,"常用证件"))
			return false;
		if (!checkControlValue("a_zjhm","String",1,20,null,0,"证件号码"))
			return false;
		if (!checkControlValue("a_lrsj","Date",null,null,null,0,"录入时间"))
			return false;
		if (!checkControlValue("a_lrr","String",1,100,null,0,"录入人"))
			return false;
		if (!checkControlValue("a_lrdwbm","String",1,20,null,0,"录入单位编码"))
			return false;
		if (!checkControlValue("a_lrdwmc","String",1,60,null,0,"录入单位名称"))
			return false;
		if (!checkControlValue("a_zt","String",1,10,null,0,"状态"))
			return false;
		return true;
	}
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">新增</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#qyryjxxx_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="add">
	<tr height="20">
		<td class="distd">企业业人员简项ID</td>
		<td class="detailtd"><input type="text" id="a_qyryjxid" class="inputstyle" value="0"></td>
		<td class="distd">企业ID</td>
		<td class="detailtd"><input type="text" id="a_qyid" class="inputstyle" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">行业类别代码</td>
		<td class="detailtd"><input type="text" id="a_hylbdm" class="inputstyle" value=""></td>
		<td class="distd">行业类别</td>
		<td class="detailtd"><input type="text" id="a_hylb" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">从业人员编号</td>
		<td class="detailtd"><input type="text" id="a_cyrybh" class="inputstyle" value=""></td>
		<td class="distd">姓名</td>
		<td class="detailtd"><input type="text" id="a_xm" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">姓名拼音</td>
		<td class="detailtd"><input type="text" id="a_xmpy" class="inputstyle" value=""></td>
		<td class="distd">国籍代码</td>
		<td class="detailtd"><input type="text" id="a_gjdm" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">国籍</td>
		<td class="detailtd"><input type="text" id="a_gj" class="inputstyle" value=""></td>
		<td class="distd">性别代码</td>
		<td class="detailtd"><input type="text" id="a_xbdm" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">性别</td>
		<td class="detailtd"><input type="text" id="a_xb" class="inputstyle" value=""></td>
		<td class="distd">出生日期</td>
		<td class="detailtd"><input type="text" id="a_csrq" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">户籍地行政区划</td>
		<td class="detailtd"><input type="text" id="a_hjdxzqh" class="inputstyle" value=""></td>
		<td class="distd">户籍地行政区划代码</td>
		<td class="detailtd"><input type="text" id="a_hjdxzqhdm" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">常用证件代码</td>
		<td class="detailtd"><input type="text" id="a_cyzjdm" class="inputstyle" value=""></td>
		<td class="distd">常用证件</td>
		<td class="detailtd"><input type="text" id="a_cyzj" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">证件号码</td>
		<td class="detailtd"><input type="text" id="a_zjhm" class="inputstyle" value=""></td>
		<td class="distd">录入时间</td>
		<td class="detailtd"><input type="text" id="a_lrsj" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">录入人</td>
		<td class="detailtd"><input type="text" id="a_lrr" class="inputstyle" value=""></td>
		<td class="distd">录入单位编码</td>
		<td class="detailtd"><input type="text" id="a_lrdwbm" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">录入单位名称</td>
		<td class="detailtd"><input type="text" id="a_lrdwmc" class="inputstyle" value=""></td>
		<td class="distd">状态</td>
		<td class="detailtd"><input type="text" id="a_zt" class="inputstyle" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setadd();'>保存</a></td></tr>
</table>