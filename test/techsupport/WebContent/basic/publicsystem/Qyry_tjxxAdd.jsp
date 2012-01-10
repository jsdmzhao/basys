<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
	daggleDiv(detailid);
		$("#a_tijianrq").attr("readonly","true");
		$("#a_tijianrq").datepicker();
		$("#a_lrrq").attr("readonly","true");
		$("#a_lrrq").datepicker();
	}); 
	function addVerify(){
		if (!checkControlValue("a_qyid","Integer",-9999999999,9999999999,null,0,"企业ID"))
			return false;
		if (!checkControlValue("a_ryid","Integer",-9999999999,9999999999,null,0,"从业人员ID"))
			return false;
		if (!checkControlValue("a_tjxxid","Integer",-9999999999,9999999999,null,0,"体检信息ID"))
			return false;
		if (!checkControlValue("a_tijianrq","Date",null,null,null,0,"体检日期"))
			return false;
		if (!checkControlValue("a_tjzkjms","String",1,2000,null,0,"体检状况及描述"))
			return false;
		if (!checkControlValue("a_lrr","String",1,100,null,0,"录入人"))
			return false;
		if (!checkControlValue("a_lrrq","Date",null,null,null,0,"录入日期"))
			return false;
		return true;
	}
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">新增</td>
      <td><a href="#" id="closeDiv" onclick='$("#Qyry_tjxx_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="add">
	<tr height="20">
		<td class="distd">企业ID</td>
		<td class="detailtd"><input type="text" id="a_qyid" value="0"></td>
		<td class="distd">从业人员ID</td>
		<td class="detailtd"><input type="text" id="a_ryid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">体检信息ID</td>
		<td class="detailtd"><input type="text" id="a_tjxxid" value="0"></td>
		<td class="distd">体检日期</td>
		<td class="detailtd"><input type="text" id="a_tijianrq" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">体检状况及描述</td>
		<td class="detailtd"><input type="text" id="a_tjzkjms" value=""></td>
		<td class="distd">录入人</td>
		<td class="detailtd"><input type="text" id="a_lrr" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">录入日期</td>
		<td class="detailtd"><input type="text" id="a_lrrq" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setadd();'>保存</a></td></tr>
</table>