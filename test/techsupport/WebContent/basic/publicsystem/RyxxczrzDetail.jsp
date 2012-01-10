<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		daggleDiv(detailid);
		$("#q_ryxxczrzid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#ryxxczrzid").append(setNull(json.LRyxxczrz[0].ryxxczrzid));
		$("#czsj").append(setNull(json.LRyxxczrz[0].czsj));
		$("#czlx").append(setNull(json.LRyxxczrz[0].czlx));
		$("#cznr").append(setNull(json.LRyxxczrz[0].cznr));
		$("#czr").append(setNull(json.LRyxxczrz[0].czr));
		$("#qybm").append(setNull(json.LRyxxczrz[0].qybm));
		$("#cyrybh").append(setNull(json.LRyxxczrz[0].cyrybh));
	}	
</script>
<input type="hidden" id="q_ryxxczrzid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$("#Ryxxczrz_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" cellpadding="3" cellspacing="0" class="detail" id="detail">
	<tr height="20">
		<td class="distd1">人员信息操作日志ID</td>
		<td class="detailtd2"><span id="ryxxczrzid"></span></td>
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
	<tr height="20">
		<td class="distd1">从业人员编号</td>
		<td class="detailtd2"><span id="cyrybh"></span></td>
	</tr>
</table>