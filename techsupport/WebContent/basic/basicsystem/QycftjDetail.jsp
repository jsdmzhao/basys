<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_qycftjid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#qycftjid").append(setNull(json.LQycftj[0].qycftjid));
		$("#hylbdm").append(setNull(json.LQycftj[0].hylbdm));
		$("#hylb").append(setNull(json.LQycftj[0].hylb));
		$("#tjrq").append(setNull(json.LQycftj[0].tjrq));
		$("#dsjgdm").append(setNull(json.LQycftj[0].dsjgdm));
		$("#dsjgmc").append(setNull(json.LQycftj[0].dsjgmc));
		$("#fxjdm").append(setNull(json.LQycftj[0].fxjdm));
		$("#fxjmc").append(setNull(json.LQycftj[0].fxjmc));
		$("#gxdwmc").append(setNull(json.LQycftj[0].gxdwmc));
		$("#gxdwdm").append(setNull(json.LQycftj[0].gxdwdm));
		$("#csbm").append(setNull(json.LQycftj[0].csbm));
		$("#csmc").append(setNull(json.LQycftj[0].csmc));
		$("#jgcs").append(setNull(json.LQycftj[0].jgcs));
		$("#fmcs").append(setNull(json.LQycftj[0].fmcs));
		$("#tdcs").append(setNull(json.LQycftj[0].tdcs));
		$("#zjcs").append(setNull(json.LQycftj[0].zjcs));
		$("#qtfmcs").append(setNull(json.LQycftj[0].qtfmcs));
	}	
</script>
<input type="hidden" id="q_qycftjid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$("#Qycftj_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" cellpadding="3" cellspacing="0" class="detail" id="detail">
	<tr height="20">
		<td class="distd1">企业处罚统计ID</td>
		<td class="detailtd2"><span id="qycftjid"></span></td>
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
		<td class="distd1">场所编码</td>
		<td class="detailtd2"><span id="csbm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">场所名称</td>
		<td class="detailtd2"><span id="csmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">警告次数</td>
		<td class="detailtd2"><span id="jgcs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">罚没次数</td>
		<td class="detailtd2"><span id="fmcs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">停吊次数</td>
		<td class="detailtd2"><span id="tdcs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">追究次数</td>
		<td class="detailtd2"><span id="zjcs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">其他处罚次数</td>
		<td class="detailtd2"><span id="qtfmcs"></span></td>
	</tr>
</table>