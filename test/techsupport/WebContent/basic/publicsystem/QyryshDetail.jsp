<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		daggleDiv(detailid);
		$("#q_ryshid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#ryshid").append(setNull(json.LQyrysh[0].ryshid));
		$("#qyid").append(setNull(json.LQyrysh[0].qyid));
		$("#ryid").append(setNull(json.LQyrysh[0].ryid));
		$("#shsj").append(setNull(json.LQyrysh[0].shsj));
		$("#shr").append(setNull(json.LQyrysh[0].shr));
		$("#shdwdm").append(setNull(json.LQyrysh[0].shdwdm));
		$("#shdwmc").append(setNull(json.LQyrysh[0].shdwmc));
		$("#shsbyy").append(setNull(json.LQyrysh[0].shsbyy));
		$("#sjshid").append(setNull(json.LQyrysh[0].sjshid));
		$("#shzt").append(setNull(json.LQyrysh[0].shzt));
	}	
</script>
<input type="hidden" id="q_ryshid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$("#Qyrysh_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" cellpadding="3" cellspacing="0" class="detail" id="detail">
	<tr height="20">
		<td class="distd1">人员审核ID</td>
		<td class="detailtd2"><span id="ryshid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">企业ID</td>
		<td class="detailtd2"><span id="qyid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">从业人员ID</td>
		<td class="detailtd2"><span id="ryid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">审核时间</td>
		<td class="detailtd2"><span id="shsj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">审核人</td>
		<td class="detailtd2"><span id="shr"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">审核单位代码</td>
		<td class="detailtd2"><span id="shdwdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">审核单位名称</td>
		<td class="detailtd2"><span id="shdwmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">审核失败原因</td>
		<td class="detailtd2"><span id="shsbyy"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">上级审核ID</td>
		<td class="detailtd2"><span id="sjshid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">审核状态</td>
		<td class="detailtd2"><span id="shzt"></span></td>
	</tr>
</table>