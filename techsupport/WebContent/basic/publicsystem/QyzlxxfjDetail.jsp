<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_qyzlxxfjid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#qyzlxxfjid").append(setNull(json.LQyzlxxfj[0].qyzlxxfjid));
		$("#qyzlxxid").append(setNull(json.LQyzlxxfj[0].qyzlxxid));
		$("#fjmc").append(setNull(json.LQyzlxxfj[0].fjmc));
		$("#fjlx").append(setNull(json.LQyzlxxfj[0].fjlx));
		$("#fjnr").append(setNull(json.LQyzlxxfj[0].fjnr));
	}	
</script>
<input type="hidden" id="q_qyzlxxfjid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#qyzlxxfj_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" cellpadding="3" cellspacing="0" class="detail" id="detail">
	<tr height="20">
		<td class="distd1">企业质量信息附件ID</td>
		<td class="detailtd2"><span id="qyzlxxfjid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">企业质量信息ID</td>
		<td class="detailtd2"><span id="qyzlxxid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">附件名称</td>
		<td class="detailtd2"><span id="fjmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">附件类型</td>
		<td class="detailtd2"><span id="fjlx"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">附件内容</td>
		<td class="detailtd2"><span id="fjnr"></span></td>
	</tr>
</table>