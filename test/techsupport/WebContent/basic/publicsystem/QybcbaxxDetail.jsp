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
		$("#qyid").append(setNull(json.LQybcbaxx[0].qyid));
		$("#qybaxxid").append(setNull(json.LQybcbaxx[0].qybaxxid));
		$("#bbgzrq").append(setNull(json.LQybcbaxx[0].bbgzrq));
		$("#bbyy").append(setNull(json.LQybcbaxx[0].bbyy));
		$("#bbwcrq").append(setNull(json.LQybcbaxx[0].bbwcrq));
	}	
</script>
<input type="hidden" id="q_qyid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$("#Qybcbaxx_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" cellpadding="3" cellspacing="0" class="detail" id="detail">
	<tr height="20">
		<td class="distd1">企业ID</td>
		<td class="detailtd2"><span id="qyid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">企业备案信息ID</td>
		<td class="detailtd2"><span id="qybaxxid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">补备告知日期</td>
		<td class="detailtd2"><span id="bbgzrq"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">补备原因</td>
		<td class="detailtd2"><span id="bbyy"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">补备完成日期</td>
		<td class="detailtd2"><span id="bbwcrq"></span></td>
	</tr>
</table>