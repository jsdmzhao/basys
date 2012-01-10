<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		daggleDiv(detailid);
		$("#q_qyflid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#qyflid").append(setNull(json.LQyffl[0].qyflid));
		$("#qyid").append(setNull(json.LQyffl[0].qyid));
		$("#qyflbm").append(setNull(json.LQyffl[0].qyflbm));
		$("#sjcsflmc").append(setNull(json.LQyffl[0].sjcsflmc));
		$("#qyflmc").append(setNull(json.LQyffl[0].qyflmc));
	}	
</script>
<input type="hidden" id="q_qyflid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$("#Qyffl_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" cellpadding="3" cellspacing="0" class="detail" id="detail">
	<tr height="20">
		<td class="distd1">企业分类ID</td>
		<td class="detailtd2"><span id="qyflid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">企业ID</td>
		<td class="detailtd2"><span id="qyid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">企业分类编码</td>
		<td class="detailtd2"><span id="qyflbm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">上级场所分类名称</td>
		<td class="detailtd2"><span id="sjcsflmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">企业分类名称</td>
		<td class="detailtd2"><span id="qyflmc"></span></td>
	</tr>
</table>