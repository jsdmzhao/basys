<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		daggleDiv(detailid);
		$("#q_qyxxczrzid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#qyxxczrzid").append(setNull(json.LQyxxczrz[0].qyxxczrzid));
		$("#czsj").append(setNull(json.LQyxxczrz[0].czsj));
		$("#czlx").append(setNull(json.LQyxxczrz[0].czlx));
		$("#cznr").append(setNull(json.LQyxxczrz[0].cznr));
		$("#czr").append(setNull(json.LQyxxczrz[0].czr));
		$("#qybm").append(setNull(json.LQyxxczrz[0].qybm));
	}	
</script>
<input type="hidden" id="q_qyxxczrzid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$("#Qyxxczrz_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" cellpadding="3" cellspacing="0" class="detail" id="detail">
	<tr height="20">
		<td class="distd1">企业信息操作日志ID</td>
		<td class="detailtd2"><span id="qyxxczrzid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">操作时间</td>
		<td class="detailtd2"><span id="czsj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">操作类型</td>
		<td class="detailtd2"><span id="czlx"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">操作内容</td>
		<td class="detailtd2"><span id="cznr"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">操作人</td>
		<td class="detailtd2"><span id="czr"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">企业编码</td>
		<td class="detailtd2"><span id="qybm"></span></td>
	</tr>
</table>