<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		daggleDiv(detailid);
		$("#q_qyryxxtj").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#qyryxxtj").append(setNull(json.LQyryxxtj[0].qyryxxtj));
		$("#hylbdm").append(setNull(json.LQyryxxtj[0].hylbdm));
		$("#hylb").append(setNull(json.LQyryxxtj[0].hylb));
		$("#dsjgdm").append(setNull(json.LQyryxxtj[0].dsjgdm));
		$("#dsjgmc").append(setNull(json.LQyryxxtj[0].dsjgmc));
		$("#fxjdm").append(setNull(json.LQyryxxtj[0].fxjdm));
		$("#fxjmc").append(setNull(json.LQyryxxtj[0].fxjmc));
		$("#gxdwdm").append(setNull(json.LQyryxxtj[0].gxdwdm));
		$("#gxdwmc").append(setNull(json.LQyryxxtj[0].gxdwmc));
		$("#qymc").append(setNull(json.LQyryxxtj[0].qymc));
		$("#qybm").append(setNull(json.LQyryxxtj[0].qybm));
		$("#zrs").append(setNull(json.LQyryxxtj[0].zrs));
		$("#dyzcrs").append(setNull(json.LQyryxxtj[0].dyzcrs));
		$("#dylzrs").append(setNull(json.LQyryxxtj[0].dylzrs));
		$("#zjqrzcrs").append(setNull(json.LQyryxxtj[0].zjqrzcrs));
		$("#zjqrlzrs").append(setNull(json.LQyryxxtj[0].zjqrlzrs));
		$("#dqzzrs").append(setNull(json.LQyryxxtj[0].dqzzrs));
		$("#zdskb").append(setNull(json.LQyryxxtj[0].zdskb));
		$("#qyrsks").append(setNull(json.LQyryxxtj[0].qyrsks));
		$("#ztdm").append(setNull(json.LQyryxxtj[0].ztdm));
	}	
</script>
<input type="hidden" id="q_qyryxxtj">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$("#Qyryxxtj_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" cellpadding="3" cellspacing="0" class="detail" id="detail">
	<tr height="20">
		<td class="distd1">企业人员信息统计ID</td>
		<td class="detailtd2"><span id="qyryxxtj"></span></td>
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
		<td class="distd1">企业名称</td>
		<td class="detailtd2"><span id="qymc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">企业编码</td>
		<td class="detailtd2"><span id="qybm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">总人数</td>
		<td class="detailtd2"><span id="zrs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">当月注册人数</td>
		<td class="detailtd2"><span id="dyzcrs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">当月离职人数</td>
		<td class="detailtd2"><span id="dylzrs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">最近7日注册人数</td>
		<td class="detailtd2"><span id="zjqrzcrs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">最近7日离职人数</td>
		<td class="detailtd2"><span id="zjqrlzrs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">当前在职人数</td>
		<td class="detailtd2"><span id="dqzzrs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">最低刷卡比</td>
		<td class="detailtd2"><span id="zdskb"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">前一日刷卡数</td>
		<td class="detailtd2"><span id="qyrsks"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">状态代码</td>
		<td class="detailtd2"><span id="ztdm"></span></td>
	</tr>
</table>