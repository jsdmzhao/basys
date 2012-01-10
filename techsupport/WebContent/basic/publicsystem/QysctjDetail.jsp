<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		daggleDiv(detailid);
		$("#q_qysctjid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#qysctjid").append(setNull(json.LQysctj[0].qysctjid));
		$("#hylbdm").append(setNull(json.LQysctj[0].hylbdm));
		$("#hylb").append(setNull(json.LQysctj[0].hylb));
		$("#tjrq").append(setNull(json.LQysctj[0].tjrq));
		$("#dsjgdm").append(setNull(json.LQysctj[0].dsjgdm));
		$("#dsjgmc").append(setNull(json.LQysctj[0].dsjgmc));
		$("#fxjdm").append(setNull(json.LQysctj[0].fxjdm));
		$("#fxjmc").append(setNull(json.LQysctj[0].fxjmc));
		$("#gxdwmc").append(setNull(json.LQysctj[0].gxdwmc));
		$("#gxdwdm").append(setNull(json.LQysctj[0].gxdwdm));
		$("#qybm").append(setNull(json.LQysctj[0].qybm));
		$("#qymc").append(setNull(json.LQysctj[0].qymc));
		$("#lxdh").append(setNull(json.LQysctj[0].lxdh));
		$("#sfdb").append(setNull(json.LQysctj[0].sfdb));
		$("#zrs").append(setNull(json.LQysctj[0].zrs));
		$("#gzrs").append(setNull(json.LQysctj[0].gzrs));
		$("#sskrs").append(setNull(json.LQysctj[0].sskrs));
		$("#zdskb").append(setNull(json.LQysctj[0].zdskb));
		$("#ycskrs").append(setNull(json.LQysctj[0].ycskrs));
		$("#dcskrs").append(setNull(json.LQysctj[0].dcskrs));
		$("#bcsskrs").append(setNull(json.LQysctj[0].bcsskrs));
		$("#ztskrs").append(setNull(json.LQysctj[0].ztskrs));
		$("#zskb").append(setNull(json.LQysctj[0].zskb));
		$("#ycskb").append(setNull(json.LQysctj[0].ycskb));
		$("#dcskb").append(setNull(json.LQysctj[0].dcskb));
	}	
</script>
<input type="hidden" id="q_qysctjid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$("#Qysctj_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" cellpadding="3" cellspacing="0" class="detail" id="detail">
	<tr height="20">
		<td class="distd1">企业上传统计ID</td>
		<td class="detailtd2"><span id="qysctjid"></span></td>
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
		<td class="distd1">统计日期</td>
		<td class="detailtd2"><span id="tjrq"></span></td>
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
		<td class="distd1">管辖单位名称</td>
		<td class="detailtd2"><span id="gxdwmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">管辖单位代码</td>
		<td class="detailtd2"><span id="gxdwdm"></span></td>
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
		<td class="distd1">是否达标</td>
		<td class="detailtd2"><span id="sfdb"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">总人数</td>
		<td class="detailtd2"><span id="zrs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">工作人数</td>
		<td class="detailtd2"><span id="gzrs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">实刷卡人数</td>
		<td class="detailtd2"><span id="sskrs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">最低刷卡比</td>
		<td class="detailtd2"><span id="zdskb"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">一次刷卡人数</td>
		<td class="detailtd2"><span id="ycskrs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">多次刷卡人数</td>
		<td class="detailtd2"><span id="dcskrs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">本场所刷卡人数</td>
		<td class="detailtd2"><span id="bcsskrs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">走台刷卡人数</td>
		<td class="detailtd2"><span id="ztskrs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">总刷卡比</td>
		<td class="detailtd2"><span id="zskb"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">一次刷卡率</td>
		<td class="detailtd2"><span id="ycskb"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">多次刷卡率</td>
		<td class="detailtd2"><span id="dcskb"></span></td>
	</tr>
</table>