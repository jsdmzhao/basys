<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		daggleDiv(detailid);
		$("#q_wscqyid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#wscqyid").append(setNull(json.LWscqy[0].wscqyid));
		$("#hylbdm").append(setNull(json.LWscqy[0].hylbdm));
		$("#hylb").append(setNull(json.LWscqy[0].hylb));
		$("#wscrq").append(setNull(json.LWscqy[0].wscrq));
		$("#dsjgdm").append(setNull(json.LWscqy[0].dsjgdm));
		$("#dsjgmc").append(setNull(json.LWscqy[0].dsjgmc));
		$("#fxjdm").append(setNull(json.LWscqy[0].fxjdm));
		$("#fxjmc").append(setNull(json.LWscqy[0].fxjmc));
		$("#gxdwdm").append(setNull(json.LWscqy[0].gxdwdm));
		$("#gxdwmc").append(setNull(json.LWscqy[0].gxdwmc));
		$("#qybm").append(setNull(json.LWscqy[0].qybm));
		$("#qymc").append(setNull(json.LWscqy[0].qymc));
		$("#lxdh").append(setNull(json.LWscqy[0].lxdh));
		$("#ztdm").append(setNull(json.LWscqy[0].ztdm));
	}	
</script>
<input type="hidden" id="q_wscqyid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$("#Wscqy_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" cellpadding="3" cellspacing="0" class="detail" id="detail">
	<tr height="20">
		<td class="distd1">未上传企业ID</td>
		<td class="detailtd2"><span id="wscqyid"></span></td>
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
		<td class="distd1">未上传日期</td>
		<td class="detailtd2"><span id="wscrq"></span></td>
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
		<td class="distd1">状态代码</td>
		<td class="detailtd2"><span id="ztdm"></span></td>
	</tr>
</table>