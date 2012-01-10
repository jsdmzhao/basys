<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		$("#p_bwryid").attr("value",dataid);
		bary_setDetail();
	}); 

	function updatediv (json) { 
		$("#bwry_hylb").append(setNull(json.LBwryxx[0].hylb));
		$("#bwry_qymc").append(setNull(json.LBwryxx[0].qymc));
		$("#bwry_xm").append(setNull(json.LBwryxx[0].xm));
		$("#bwry_gmsfhm").append(setNull(json.LBwryxx[0].gmsfhm));
		$("#bwry_hjdxzqh").append(setNull(json.LBwryxx[0].hjdxzqh));
		$("#bwry_hjdxz").append(setNull(json.LBwryxx[0].hjdxz));
		$("#bwry_sgrq").append(setNull(json.LBwryxx[0].sgrq));
		$("#bwry_lrsj").append(setNull(json.LBwryxx[0].lrsj));
		$("#bwry_zt").append(setNull(json.LBwryxx[0].zt));
		$("#bwry_lrr").append(setNull(json.LBwryxx[0].lrr));
		$("#bwry_lzyy").append(setNull(json.LBwryxx[0].lzyy));
		$("#bwry_lzrq").append(setNull(json.LBwryxx[0].lzrq));
		
	}	
</script>
<input type="hidden" id="p_bwryid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">保卫人员信息明细</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#p_bwryid").parent().hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" cellpadding="3" cellspacing="0" class="detail" id="detail">
	<tr height="20">
		<td class="distd1" width="11%">行业类别</td>
		<td class="detailtd2" width="21%"><span id="bwry_hylb"></span></td>
		<td class="distd1" width="11%">企业名称</td>
		<td class="detailtd2" colspan="3" width="22%"><span id="bwry_qymc"></span></td>
	</tr>
    <tr height="20">
		<td class="distd1" width="12%">姓名</td>
		<td class="detailtd2" width="21%"><span id="bwry_xm"></span></td>
		<td class="distd1" width="11%">身份号码</td>
		<td class="detailtd2" width="22%"><span id="bwry_gmsfhm"></span></td>
		<td class="distd1" width="13%">户籍地省市县</td>
		<td class="detailtd2" width="21%"><span id="bwry_hjdxzqh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">户籍地详址</td>
		<td class="detailtd2" colspan="3" style="width:372px"><span id="bwry_hjdxz"></span></td>
		<td class="distd1">上岗日期</td>
		<td class="detailtd2"><span id="bwry_sgrq"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">填报人</td>
		<td class="detailtd2" ><span id="bwry_lrr"></span></td>
		<td class="distd1">填报时间</td>
		<td class="detailtd2" colspan="3"><span id="bwry_lrsj"></span></td>
	</tr>
	<tr height="20">
		
		<td class="distd1">人员状态</td>
		<td class="detailtd2"><span id="bwry_zt"></span></td>
		<td class="distd1">离职时间</td>
		<td class="detailtd2" colspan="3"><span id="bwry_lzrq"></span></td>
	</tr>
	<tr height="30">
		<td class="distd1">离职原因</td>
		<td class="detailtd2" colspan="5" style="width:681px"><span id="bwry_lzyy"></span></td>
	</tr>
</table>