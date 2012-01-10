<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_qyzlxxid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#qyzlxxid").append(setNull(json.LQyzlxx[0].qyzlxxid));
		$("#hylbdm").append(setNull(json.LQyzlxx[0].hylbdm));
		$("#hylb").append(setNull(json.LQyzlxx[0].hylb));
		$("#fbdwdm").append(setNull(json.LQyzlxx[0].fbdwdm));
		$("#fbdwmc").append(setNull(json.LQyzlxx[0].fbdwmc));
		$("#fbr").append(setNull(json.LQyzlxx[0].fbr));
		$("#fbsj").append(setNull(json.LQyzlxx[0].fbsj));
		// $("#scbz").append(setNull(json.LQyzlxx[0].scbz));
	}	
</script>
<input type="hidden" id="q_qyzlxxid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#qyzlxx_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" cellpadding="3" cellspacing="0" class="detail" id="detail">
	<tr height="20">
		<td class="distd1">企业质量信息ID</td>
		<td class="detailtd2"><span id="qyzlxxid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">行业类别代码</td>
		<td class="detailtd2"><span id="hylbdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">行业类别</td>
		<td class="detailtd2"><span id="hylb"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">发布单位代码</td>
		<td class="detailtd2"><span id="fbdwdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">发布单位名称</td>
		<td class="detailtd2"><span id="fbdwmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">发布人</td>
		<td class="detailtd2"><span id="fbr"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">发布时间</td>
		<td class="detailtd2"><span id="fbsj"></span></td>
	</tr>
<!--  	<tr height="20">
		<td class="distd1">删除标志</td>
		<td class="detailtd2"><span id="scbz"></span></td>
	</tr> -->
</table>