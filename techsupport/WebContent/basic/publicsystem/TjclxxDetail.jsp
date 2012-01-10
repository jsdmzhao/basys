<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		daggleDiv(detailid);
		$("#q_tjclxxid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#tjclxxid").append(setNull(json.LTjclxx[0].tjclxxid));
		$("#qyid").append(setNull(json.LTjclxx[0].qyid));
		$("#qybaxxid").append(setNull(json.LTjclxx[0].qybaxxid));
		$("#tjcllxdm").append(setNull(json.LTjclxx[0].tjcllxdm));
		$("#tjcllx").append(setNull(json.LTjclxx[0].tjcllx));
		$("#tijiaorq").append(setNull(json.LTjclxx[0].tijiaorq));
		$("#tjrxm").append(setNull(json.LTjclxx[0].tjrxm));
		$("#tjclnr").append(setNull(json.LTjclxx[0].tjclnr));
	}	
</script>
<input type="hidden" id="q_tjclxxid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$("#Tjclxx_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" cellpadding="3" cellspacing="0" class="detail" id="detail">
	<tr height="20">
		<td class="distd1">提交材料信息ID</td>
		<td class="detailtd2"><span id="tjclxxid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">企业ID</td>
		<td class="detailtd2"><span id="qyid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">企业备案信息ID</td>
		<td class="detailtd2"><span id="qybaxxid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">提交材料类型代码</td>
		<td class="detailtd2"><span id="tjcllxdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">提交材料类型</td>
		<td class="detailtd2"><span id="tjcllx"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">提交日期</td>
		<td class="detailtd2"><span id="tijiaorq"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">提交人姓名</td>
		<td class="detailtd2"><span id="tjrxm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">提交材料内容</td>
		<td class="detailtd2"><span id="tjclnr"></span></td>
	</tr>
</table>