<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_qyryjxid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#qyryjxid").append(setNull(json.LQyryjxxx[0].qyryjxid));
		$("#qyid").append(setNull(json.LQyryjxxx[0].qyid));
		$("#hylbdm").append(setNull(json.LQyryjxxx[0].hylbdm));
		$("#hylb").append(setNull(json.LQyryjxxx[0].hylb));
		$("#cyrybh").append(setNull(json.LQyryjxxx[0].cyrybh));
		$("#xm").append(setNull(json.LQyryjxxx[0].xm));
		$("#xmpy").append(setNull(json.LQyryjxxx[0].xmpy));
		$("#gjdm").append(setNull(json.LQyryjxxx[0].gjdm));
		$("#gj").append(setNull(json.LQyryjxxx[0].gj));
		$("#xbdm").append(setNull(json.LQyryjxxx[0].xbdm));
		$("#xb").append(setNull(json.LQyryjxxx[0].xb));
		$("#csrq").append(setNull(json.LQyryjxxx[0].csrq));
		$("#hjdxzqh").append(setNull(json.LQyryjxxx[0].hjdxzqh));
		$("#hjdxzqhdm").append(setNull(json.LQyryjxxx[0].hjdxzqhdm));
		$("#cyzjdm").append(setNull(json.LQyryjxxx[0].cyzjdm));
		$("#cyzj").append(setNull(json.LQyryjxxx[0].cyzj));
		$("#zjhm").append(setNull(json.LQyryjxxx[0].zjhm));
		$("#lrsj").append(setNull(json.LQyryjxxx[0].lrsj));
		$("#lrr").append(setNull(json.LQyryjxxx[0].lrr));
		$("#lrdwbm").append(setNull(json.LQyryjxxx[0].lrdwbm));
		$("#lrdwmc").append(setNull(json.LQyryjxxx[0].lrdwmc));
		$("#zt").append(setNull(json.LQyryjxxx[0].zt));
	}	
</script>
<input type="hidden" id="q_qyryjxid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#qyryjxxx_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" cellpadding="3" cellspacing="0" class="detail" id="detail">
	<tr height="20">
		<td class="distd1">企业业人员简项ID</td>
		<td class="detailtd2"><span id="qyryjxid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">企业ID</td>
		<td class="detailtd2"><span id="qyid"></span></td>
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
		<td class="distd1">从业人员编号</td>
		<td class="detailtd2"><span id="cyrybh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">姓名</td>
		<td class="detailtd2"><span id="xm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">姓名拼音</td>
		<td class="detailtd2"><span id="xmpy"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">国籍代码</td>
		<td class="detailtd2"><span id="gjdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">国籍</td>
		<td class="detailtd2"><span id="gj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">性别代码</td>
		<td class="detailtd2"><span id="xbdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">性别</td>
		<td class="detailtd2"><span id="xb"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">出生日期</td>
		<td class="detailtd2"><span id="csrq"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">户籍地行政区划</td>
		<td class="detailtd2"><span id="hjdxzqh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">户籍地行政区划代码</td>
		<td class="detailtd2"><span id="hjdxzqhdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">常用证件代码</td>
		<td class="detailtd2"><span id="cyzjdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">常用证件</td>
		<td class="detailtd2"><span id="cyzj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">证件号码</td>
		<td class="detailtd2"><span id="zjhm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">录入时间</td>
		<td class="detailtd2"><span id="lrsj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">录入人</td>
		<td class="detailtd2"><span id="lrr"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">录入单位编码</td>
		<td class="detailtd2"><span id="lrdwbm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">录入单位名称</td>
		<td class="detailtd2"><span id="lrdwmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">状态</td>
		<td class="detailtd2"><span id="zt"></span></td>
	</tr>
</table>