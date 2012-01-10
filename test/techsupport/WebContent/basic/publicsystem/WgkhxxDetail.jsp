<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		daggleDiv(detailid);
		$("#q_khxxid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#khxxid").append(setNull(json.LWgkhxx[0].khxxid));
		$("#ywx").append(setNull(json.LWgkhxx[0].ywx));
		$("#ywm").append(setNull(json.LWgkhxx[0].ywm));
		$("#qzzldm").append(setNull(json.LWgkhxx[0].qzzldm));
		$("#qzzl").append(setNull(json.LWgkhxx[0].qzzl));
		$("#qzhm").append(setNull(json.LWgkhxx[0].qzhm));
		$("#zatlq").append(setNull(json.LWgkhxx[0].zatlq));
		$("#qfjg").append(setNull(json.LWgkhxx[0].qfjg));
		$("#rjrq").append(setNull(json.LWgkhxx[0].rjrq));
		$("#rjka").append(setNull(json.LWgkhxx[0].rjka));
	}	
</script>
<input type="hidden" id="q_khxxid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$("#Wgkhxx_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" cellpadding="3" cellspacing="0" class="detail" id="detail">
	<tr height="20">
		<td class="distd1">客户信息ID</td>
		<td class="detailtd2"><span id="khxxid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">英文姓</td>
		<td class="detailtd2"><span id="ywx"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">英文名</td>
		<td class="detailtd2"><span id="ywm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">签证种类代码</td>
		<td class="detailtd2"><span id="qzzldm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">签证种类</td>
		<td class="detailtd2"><span id="qzzl"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">签证号码</td>
		<td class="detailtd2"><span id="qzhm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">在华停留期至</td>
		<td class="detailtd2"><span id="zatlq"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">签发机关</td>
		<td class="detailtd2"><span id="qfjg"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">入境日期</td>
		<td class="detailtd2"><span id="rjrq"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">入境口岸</td>
		<td class="detailtd2"><span id="rjka"></span></td>
	</tr>
</table>