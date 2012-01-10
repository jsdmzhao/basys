<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_qyyyzttjid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#qyyyzttjid").append(setNull(json.LQyyyzttj[0].qyyyzttjid));
		$("#tjrq").append(setNull(json.LQyyyzttj[0].tjrq));
		$("#hylbdm").append(setNull(json.LQyyyzttj[0].hylbdm));
		$("#hylb").append(setNull(json.LQyyyzttj[0].hylb));
		$("#dsjgdm").append(setNull(json.LQyyyzttj[0].dsjgdm));
		$("#dsjgmc").append(setNull(json.LQyyyzttj[0].dsjgmc));
		$("#fxjdm").append(setNull(json.LQyyyzttj[0].fxjdm));
		$("#fxjmc").append(setNull(json.LQyyyzttj[0].fxjmc));
		$("#gxdwdm").append(setNull(json.LQyyyzttj[0].gxdwdm));
		$("#gxdwmc").append(setNull(json.LQyyyzttj[0].gxdwmc));
		$("#yy").append(setNull(json.LQyyyzttj[0].yy));
		$("#zzty").append(setNull(json.LQyyyzttj[0].zzty));
		$("#llty").append(setNull(json.LQyyyzttj[0].llty));
		$("#xy").append(setNull(json.LQyyyzttj[0].xy));
		$("#zx").append(setNull(json.LQyyyzttj[0].zx));
		$("#qt").append(setNull(json.LQyyyzttj[0].qt));
		$("#hj").append(setNull(json.LQyyyzttj[0].hj));
	}	
</script>
<input type="hidden" id="q_qyyyzttjid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#qyyyzttj_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" cellpadding="3" cellspacing="0" class="detail" id="detail">
	<tr height="20">
		<td class="distd1">企业营业状态统计ID</td>
		<td class="detailtd2"><span id="qyyyzttjid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">统计日期</td>
		<td class="detailtd2"><span id="tjrq"></span></td>
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
		<td class="distd1">地市机关代码</td>
		<td class="detailtd2"><span id="dsjgdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">地市机关名称</td>
		<td class="detailtd2"><span id="dsjgmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">分县局代码</td>
		<td class="detailtd2"><span id="fxjdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">分县局名称</td>
		<td class="detailtd2"><span id="fxjmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">管辖单位代码</td>
		<td class="detailtd2"><span id="gxdwdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">管辖单位名称</td>
		<td class="detailtd2"><span id="gxdwmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">营业</td>
		<td class="detailtd2"><span id="yy"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">自主停业</td>
		<td class="detailtd2"><span id="zzty"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">勒令停业</td>
		<td class="detailtd2"><span id="llty"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">歇业</td>
		<td class="detailtd2"><span id="xy"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">注销</td>
		<td class="detailtd2"><span id="zx"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">其他</td>
		<td class="detailtd2"><span id="qt"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">合计</td>
		<td class="detailtd2"><span id="hj"></span></td>
	</tr>
</table>