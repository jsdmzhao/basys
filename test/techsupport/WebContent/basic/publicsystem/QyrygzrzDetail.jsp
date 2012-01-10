<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_qyid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#qyid").append(setNull(json.LQyrygzrz[0].qyid));
		$("#ryid").append(setNull(json.LQyrygzrz[0].ryid));
		$("#qyrygzrzid").append(setNull(json.LQyrygzrz[0].qyrygzrzid));
		$("#gzkssj").append(setNull(json.LQyrygzrz[0].gzkssj));
		$("#gzjssj").append(setNull(json.LQyrygzrz[0].gzjssj));
		$("#gzdd").append(setNull(json.LQyrygzrz[0].gzdd));
		$("#gwxx").append(setNull(json.LQyrygzrz[0].gwxx));
	}	
</script>
<input type="hidden" id="q_qyid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#qyrygzrz_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" cellpadding="3" cellspacing="0" class="detail" id="detail">
	<tr height="20">
		<td class="distd1">企业ID</td>
		<td class="detailtd2"><span id="qyid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">从业人员ID</td>
		<td class="detailtd2"><span id="ryid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">企业人员工作日志ID</td>
		<td class="detailtd2"><span id="qyrygzrzid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">工作开始时间</td>
		<td class="detailtd2"><span id="gzkssj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">工作结束时间</td>
		<td class="detailtd2"><span id="gzjssj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">工作地点</td>
		<td class="detailtd2"><span id="gzdd"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">岗位信息</td>
		<td class="detailtd2"><span id="gwxx"></span></td>
	</tr>
</table>