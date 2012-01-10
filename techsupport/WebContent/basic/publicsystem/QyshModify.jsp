<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		daggleDiv(detailid);
		$("#q_qyshid").attr("value",dataid);
		$("#m_qyshid").attr("value",dataid);
		setDetail();
		$("#m_shsj").attr("readonly","true");
		$("#m_shsj").datepicker();
	}); 
	function updatediv (json) { 
		$("#m_qyshid").attr("value",setNull(json.LQysh[0].qyshid));
		$("#m_qyid").attr("value",setNull(json.LQysh[0].qyid));
		$("#m_shsj").attr("value",setNull(json.LQysh[0].shsj));
		$("#m_shr").attr("value",setNull(json.LQysh[0].shr));
		$("#m_shdwdm").attr("value",setNull(json.LQysh[0].shdwdm));
		$("#m_shdwmc").attr("value",setNull(json.LQysh[0].shdwmc));
		$("#m_shsbyy").attr("value",setNull(json.LQysh[0].shsbyy));
		$("#m_sjshid").attr("value",setNull(json.LQysh[0].sjshid));
		$("#m_shzt").attr("value",setNull(json.LQysh[0].shzt));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_qyshid","Integer",-9999999999,9999999999,null,0,"企业审核ID"))
			return false;
		if (!checkControlValue("m_qyid","Integer",-9999999999,9999999999,null,0,"企业ID"))
			return false;
		if (!checkControlValue("m_shsj","Date",null,null,null,0,"审核时间"))
			return false;
		if (!checkControlValue("m_shr","String",1,60,null,0,"审核人"))
			return false;
		if (!checkControlValue("m_shdwdm","String",1,20,null,0,"审核单位代码"))
			return false;
		if (!checkControlValue("m_shdwmc","String",1,60,null,0,"审核单位名称"))
			return false;
		if (!checkControlValue("m_shsbyy","String",1,2000,null,0,"审核失败原因"))
			return false;
		if (!checkControlValue("m_sjshid","Integer",-9999999999,9999999999,null,0,"上级审核ID"))
			return false;
		if (!checkControlValue("m_shzt","String",1,2,null,0,"审核状态"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_qyshid">
<input type="hidden" id="m_qyshid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td ><a href="#" id="closeDiv" onclick='$("#Qysh_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">企业审核ID</td>
		<td class="detailtd"><input type="text" id="m_qyshid" value="0"></td>
		<td class="distd">企业ID</td>
		<td class="detailtd"><input type="text" id="m_qyid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">审核时间</td>
		<td class="detailtd"><input type="text" id="m_shsj" value=""></td>
		<td class="distd">审核人</td>
		<td class="detailtd"><input type="text" id="m_shr" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">审核单位代码</td>
		<td class="detailtd"><input type="text" id="m_shdwdm" value=""></td>
		<td class="distd">审核单位名称</td>
		<td class="detailtd"><input type="text" id="m_shdwmc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">审核失败原因</td>
		<td class="detailtd"><input type="text" id="m_shsbyy" value=""></td>
		<td class="distd">上级审核ID</td>
		<td class="detailtd"><input type="text" id="m_sjshid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">审核状态</td>
		<td class="detailtd"><input type="text" id="m_shzt" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td></tr>
</table>
