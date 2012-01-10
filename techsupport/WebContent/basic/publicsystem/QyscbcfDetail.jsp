<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		daggleDiv(detailid);
		$("#q_qyscbcfid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#qyscbcfid").append(setNull(json.LQyscbcf[0].qyscbcfid));
		$("#hylbdm").append(setNull(json.LQyscbcf[0].hylbdm));
		$("#hylb").append(setNull(json.LQyscbcf[0].hylb));
		$("#wdbrq").append(setNull(json.LQyscbcf[0].wdbrq));
		$("#dsjgdm").append(setNull(json.LQyscbcf[0].dsjgdm));
		$("#dsjgmc").append(setNull(json.LQyscbcf[0].dsjgmc));
		$("#fxjdm").append(setNull(json.LQyscbcf[0].fxjdm));
		$("#fxjmc").append(setNull(json.LQyscbcf[0].fxjmc));
		$("#gxdwdm").append(setNull(json.LQyscbcf[0].gxdwdm));
		$("#gxdwmc").append(setNull(json.LQyscbcf[0].gxdwmc));
		$("#qybm").append(setNull(json.LQyscbcf[0].qybm));
		$("#qymc").append(setNull(json.LQyscbcf[0].qymc));
		$("#lxdh").append(setNull(json.LQyscbcf[0].lxdh));
		$("#zrs").append(setNull(json.LQyscbcf[0].zrs));
		$("#sskrs").append(setNull(json.LQyscbcf[0].sskrs));
		$("#hdskb").append(setNull(json.LQyscbcf[0].hdskb));
		$("#sjsrb").append(setNull(json.LQyscbcf[0].sjsrb));
		$("#ztdm").append(setNull(json.LQyscbcf[0].ztdm));
	}	
</script>
<input type="hidden" id="q_qyscbcfid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$("#Qyscbcf_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" cellpadding="3" cellspacing="0" class="detail" id="detail">
	<tr height="20">
		<td class="distd1">企业上传不充分ID</td>
		<td class="detailtd2"><span id="qyscbcfid"></span></td>
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
		<td class="distd1">未达标日期</td>
		<td class="detailtd2"><span id="wdbrq"></span></td>
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
		<td class="distd1">企业编码</td>
		<td class="detailtd2"><span id="qybm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">企业名称</td>
		<td class="detailtd2"><span id="qymc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">联系电话</td>
		<td class="detailtd2"><span id="lxdh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">总人数</td>
		<td class="detailtd2"><span id="zrs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">实刷卡人数</td>
		<td class="detailtd2"><span id="sskrs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">核定刷卡比</td>
		<td class="detailtd2"><span id="hdskb"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">实际刷卡比</td>
		<td class="detailtd2"><span id="sjsrb"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">状态代码</td>
		<td class="detailtd2"><span id="ztdm"></span></td>
	</tr>
</table>