<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		daggleDiv(detailid);
		$("#q_qyid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#qyid").append(setNull(json.LQyry_tjxx[0].qyid));
		$("#ryid").append(setNull(json.LQyry_tjxx[0].ryid));
		$("#tjxxid").append(setNull(json.LQyry_tjxx[0].tjxxid));
		$("#tijianrq").append(setNull(json.LQyry_tjxx[0].tijianrq));
		$("#tjzkjms").append(setNull(json.LQyry_tjxx[0].tjzkjms));
		$("#lrr").append(setNull(json.LQyry_tjxx[0].lrr));
		$("#lrrq").append(setNull(json.LQyry_tjxx[0].lrrq));
	}	
</script>
<input type="hidden" id="q_qyid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$("#Qyry_tjxx_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" cellpadding="3" cellspacing="0" class="detail" id="detail">
	<tr height="20">
		<td class="distd1">企业ID</td>
		<td class="detailtd2"><span id="qyid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">从业人员ID</td>
		<td class="detailtd2"><span id="ryid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">体检信息ID</td>
		<td class="detailtd2"><span id="tjxxid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">体检日期</td>
		<td class="detailtd2"><span id="tijianrq"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">体检状况及描述</td>
		<td class="detailtd2"><span id="tjzkjms"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">录入人</td>
		<td class="detailtd2"><span id="lrr"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">录入日期</td>
		<td class="detailtd2"><span id="lrrq"></span></td>
	</tr>
</table>