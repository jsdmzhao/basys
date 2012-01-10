<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		daggleDiv(detailid);
		$("#q_zjid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#zjid").append(setNull(json.LQyzjb[0].zjid));
		$("#qyid").append(setNull(json.LQyzjb[0].qyid));
		$("#zjfl").append(setNull(json.LQyzjb[0].zjfl));
		$("#zjbh").append(setNull(json.LQyzjb[0].zjbh));
		$("#fzjg").append(setNull(json.LQyzjb[0].fzjg));
		$("#qsrq").append(setNull(json.LQyzjb[0].qsrq));
		$("#jzrq").append(setNull(json.LQyzjb[0].jzrq));
	}	
</script>
<input type="hidden" id="q_zjid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$("#Qyzjb_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" cellpadding="3" cellspacing="0" class="detail" id="detail">
	<tr height="20">
		<td class="distd1">证件ID</td>
		<td class="detailtd2"><span id="zjid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">企业ID</td>
		<td class="detailtd2"><span id="qyid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">证件分类</td>
		<td class="detailtd2"><span id="zjfl"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">证件编号</td>
		<td class="detailtd2"><span id="zjbh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">发证机关</td>
		<td class="detailtd2"><span id="fzjg"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">起始日期</td>
		<td class="detailtd2"><span id="qsrq"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">截止日期</td>
		<td class="detailtd2"><span id="jzrq"></span></td>
	</tr>
</table>