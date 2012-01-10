<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		daggleDiv(detailid);
		$("#q_qyryjctjid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#qyryjctjid").append(setNull(json.LQyryjctj[0].qyryjctjid));
		$("#hylbdm").append(setNull(json.LQyryjctj[0].hylbdm));
		$("#hylb").append(setNull(json.LQyryjctj[0].hylb));
		$("#tjrq").append(setNull(json.LQyryjctj[0].tjrq));
		$("#cyrybh").append(setNull(json.LQyryjctj[0].cyrybh));
		$("#cyrylbdm").append(setNull(json.LQyryjctj[0].cyrylbdm));
		$("#cyrylbmc").append(setNull(json.LQyryjctj[0].cyrylbmc));
		$("#xm").append(setNull(json.LQyryjctj[0].xm));
		$("#zjhm").append(setNull(json.LQyryjctj[0].zjhm));
		$("#dsjgmc").append(setNull(json.LQyryjctj[0].dsjgmc));
		$("#fxjdm").append(setNull(json.LQyryjctj[0].fxjdm));
		$("#dsjgdm").append(setNull(json.LQyryjctj[0].dsjgdm));
		$("#fxjmc").append(setNull(json.LQyryjctj[0].fxjmc));
		$("#gxdwdm").append(setNull(json.LQyryjctj[0].gxdwdm));
		$("#gxdwmc").append(setNull(json.LQyryjctj[0].gxdwmc));
		$("#qymc").append(setNull(json.LQyryjctj[0].qymc));
		$("#qybm").append(setNull(json.LQyryjctj[0].qybm));
		$("#jg").append(setNull(json.LQyryjctj[0].jg));
		$("#fk").append(setNull(json.LQyryjctj[0].fk));
		$("#jl").append(setNull(json.LQyryjctj[0].jl));
		$("#jlbfk").append(setNull(json.LQyryjctj[0].jlbfk));
		$("#zjxszr").append(setNull(json.LQyryjctj[0].zjxszr));
		$("#xqcjhqzcj").append(setNull(json.LQyryjctj[0].xqcjhqzcj));
		$("#qtfklx").append(setNull(json.LQyryjctj[0].qtfklx));
		$("#xj").append(setNull(json.LQyryjctj[0].xj));
	}	
</script>
<input type="hidden" id="q_qyryjctjid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$("#Qyryjctj_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" cellpadding="3" cellspacing="0" class="detail" id="detail">
	<tr height="20">
		<td class="distd1">企业人员奖惩统计ID</td>
		<td class="detailtd2"><span id="qyryjctjid"></span></td>
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
		<td class="distd1">从业人员编号</td>
		<td class="detailtd2"><span id="cyrybh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">从业人员类别代码</td>
		<td class="detailtd2"><span id="cyrylbdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">从业人员类别名称</td>
		<td class="detailtd2"><span id="cyrylbmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">姓名</td>
		<td class="detailtd2"><span id="xm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">证件号码</td>
		<td class="detailtd2"><span id="zjhm"></span></td>
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
		<td class="distd1">地市机关代码</td>
		<td class="detailtd2"><span id="dsjgdm"></span></td>
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
		<td class="distd1">警告</td>
		<td class="detailtd2"><span id="jg"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">罚款</td>
		<td class="detailtd2"><span id="fk"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">拘留</td>
		<td class="detailtd2"><span id="jl"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">拘留并罚款</td>
		<td class="detailtd2"><span id="jlbfk"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">追究刑事责任</td>
		<td class="detailtd2"><span id="zjxszr"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">限期出境或驱逐出境</td>
		<td class="detailtd2"><span id="xqcjhqzcj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">其他处罚类型</td>
		<td class="detailtd2"><span id="qtfklx"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">小计</td>
		<td class="detailtd2"><span id="xj"></span></td>
	</tr>
</table>