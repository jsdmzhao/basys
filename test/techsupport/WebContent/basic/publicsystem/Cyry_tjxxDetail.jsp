<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_ryid").attr("value",dataid);
			setDetail();
	}); 	
	function updatediv (json) { 
		$("#tijianrq").append(setNull(json.LCyry_tjxx[0].tijianrq));
		$("#tjzkjms").append(setNull(json.LCyry_tjxx[0].tjzkjms));
		$("#lrr").append(setNull(json.LCyry_tjxx[0].lrr));
		$("#lrrq").append(setNull(json.LCyry_tjxx[0].lrrq));
	}	
</script>
<input type="hidden" id="q_ryid">
<div align="right"><a href="#" id="closeDiv" onclick='$("#cyry_tjxx_detail").hide("show");' class="close"></a></div>
<table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
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