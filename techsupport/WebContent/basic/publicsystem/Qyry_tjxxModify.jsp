<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		daggleDiv(detailid);
		$("#q_qyid").attr("value",dataid);
		$("#m_qyid").attr("value",dataid);
		setDetail();
		$("#m_tijianrq").attr("readonly","true");
		$("#m_tijianrq").datepicker();
		$("#m_lrrq").attr("readonly","true");
		$("#m_lrrq").datepicker();
	}); 
	function updatediv (json) { 
		$("#m_qyid").attr("value",setNull(json.LQyry_tjxx[0].qyid));
		$("#m_ryid").attr("value",setNull(json.LQyry_tjxx[0].ryid));
		$("#m_tjxxid").attr("value",setNull(json.LQyry_tjxx[0].tjxxid));
		$("#m_tijianrq").attr("value",setNull(json.LQyry_tjxx[0].tijianrq));
		$("#m_tjzkjms").attr("value",setNull(json.LQyry_tjxx[0].tjzkjms));
		$("#m_lrr").attr("value",setNull(json.LQyry_tjxx[0].lrr));
		$("#m_lrrq").attr("value",setNull(json.LQyry_tjxx[0].lrrq));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_qyid","Integer",-9999999999,9999999999,null,0,"企业ID"))
			return false;
		if (!checkControlValue("m_ryid","Integer",-9999999999,9999999999,null,0,"从业人员ID"))
			return false;
		if (!checkControlValue("m_tjxxid","Integer",-9999999999,9999999999,null,0,"体检信息ID"))
			return false;
		if (!checkControlValue("m_tijianrq","Date",null,null,null,0,"体检日期"))
			return false;
		if (!checkControlValue("m_tjzkjms","String",1,2000,null,0,"体检状况及描述"))
			return false;
		if (!checkControlValue("m_lrr","String",1,100,null,0,"录入人"))
			return false;
		if (!checkControlValue("m_lrrq","Date",null,null,null,0,"录入日期"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_qyid">
<input type="hidden" id="m_qyid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td ><a href="#" id="closeDiv" onclick='$("#Qyry_tjxx_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">企业ID</td>
		<td class="detailtd"><input type="text" id="m_qyid" value="0"></td>
		<td class="distd">从业人员ID</td>
		<td class="detailtd"><input type="text" id="m_ryid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">体检信息ID</td>
		<td class="detailtd"><input type="text" id="m_tjxxid" value="0"></td>
		<td class="distd">体检日期</td>
		<td class="detailtd"><input type="text" id="m_tijianrq" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">体检状况及描述</td>
		<td class="detailtd"><input type="text" id="m_tjzkjms" value=""></td>
		<td class="distd">录入人</td>
		<td class="detailtd"><input type="text" id="m_lrr" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">录入日期</td>
		<td class="detailtd"><input type="text" id="m_lrrq" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td></tr>
</table>
