<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		$("#p_baryid").attr("value",dataid);
		bary_setDetail();
	}); 

	function updatediv (json) { 
		$("#bary_hylb").append(setNull(json.LBaryxx[0].hylb));
		$("#bary_qymc").append(setNull(json.LBaryxx[0].qymc));
		$("#bary_xm").append(setNull(json.LBaryxx[0].xm));
		$("#bary_gmsfhm").append(setNull(json.LBaryxx[0].gmsfhm));
		$("#bary_hjdxzqh").append(setNull(json.LBaryxx[0].hjdxzqh));
		$("#bary_hjdxz").append(setNull(json.LBaryxx[0].hjdxz));
		$("#bary_sgrq").append(setNull(json.LBaryxx[0].sgrq));
		$("#bary_balx").append(setNull(json.LBaryxx[0].balx));
		$("#bary_fzjg").append(setNull(json.LBaryxx[0].fzjg));
		$("#bary_lrsj").append(setNull(json.LBaryxx[0].lrsj));
		$("#bary_zt").append(setNull(json.LBaryxx[0].zt));
		$("#bary_lrr").append(setNull(json.LBaryxx[0].lrr));
		$("#bary_lzyy").append(setNull(json.LBaryxx[0].lzyy));
		$("#bary_lzrq").append(setNull(json.LBaryxx[0].lzrq));
		
	}	
</script>
<input type="hidden" id="p_baryid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">保安人员信息明细</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#p_baryid").parent().hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" cellpadding="3" cellspacing="0" class="detail" id="detail">
	<tr height="20">
		<td class="distd1" width="11%">行业类别</td>
		<td class="detailtd2" width="21%"><span id="bary_hylb"></span></td>
		<td class="distd1" width="11%">企业名称</td>
		<td class="detailtd2" colspan="3" width="22%"><span id="bary_qymc"></span></td>
	</tr>
    <tr height="20">
		<td class="distd1" width="12%">姓名</td>
		<td class="detailtd2" width="21%"><span id="bary_xm"></span></td>
		<td class="distd1" width="11%">身份号码</td>
		<td class="detailtd2" width="22%"><span id="bary_gmsfhm"></span></td>
		<td class="distd1" width="13%">户籍地省市县</td>
		<td class="detailtd2" width="21%"><span id="bary_hjdxzqh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">户籍地详址</td>
		<td class="detailtd2" colspan="3" style="width:372px"><span id="bary_hjdxz"></span></td>
		<td class="distd1">上岗日期</td>
		<td class="detailtd2"><span id="bary_sgrq"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">保安类型</td>
		<td class="detailtd2"><span id="bary_balx"></span></td>
		<td class="distd1">发证机构</td>
		<td class="detailtd2"><span id="bary_fzjg"></span></td>
		<td class="distd1">填报人</td>
		<td class="detailtd2"><span id="bary_lrr"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">填报时间</td>
		<td class="detailtd2"><span id="bary_lrsj"></span></td>
		<td class="distd1">人员状态</td>
		<td class="detailtd2"><span id="bary_zt"></span></td>
		<td class="distd1">离职时间</td>
		<td class="detailtd2"><span id="bary_lzrq"></span></td>
	</tr>
	<tr height="30">
		<td class="distd1">离职原因</td>
		<td class="detailtd2" colspan="5" style="width:681px"><span id="bary_lzyy"></span></td>
	</tr>
</table>