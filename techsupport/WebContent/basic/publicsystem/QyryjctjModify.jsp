<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		daggleDiv(detailid);
		$("#q_qyryjctjid").attr("value",dataid);
		$("#m_qyryjctjid").attr("value",dataid);
		setDetail();
		$("#m_tjrq").attr("readonly","true");
		$("#m_tjrq").datepicker();
	}); 
	function updatediv (json) { 
		$("#m_qyryjctjid").attr("value",setNull(json.LQyryjctj[0].qyryjctjid));
		$("#m_hylbdm").attr("value",setNull(json.LQyryjctj[0].hylbdm));
		$("#m_hylb").attr("value",setNull(json.LQyryjctj[0].hylb));
		$("#m_tjrq").attr("value",setNull(json.LQyryjctj[0].tjrq));
		$("#m_cyrybh").attr("value",setNull(json.LQyryjctj[0].cyrybh));
		$("#m_cyrylbdm").attr("value",setNull(json.LQyryjctj[0].cyrylbdm));
		$("#m_cyrylbmc").attr("value",setNull(json.LQyryjctj[0].cyrylbmc));
		$("#m_xm").attr("value",setNull(json.LQyryjctj[0].xm));
		$("#m_zjhm").attr("value",setNull(json.LQyryjctj[0].zjhm));
		$("#m_dsjgmc").attr("value",setNull(json.LQyryjctj[0].dsjgmc));
		$("#m_fxjdm").attr("value",setNull(json.LQyryjctj[0].fxjdm));
		$("#m_dsjgdm").attr("value",setNull(json.LQyryjctj[0].dsjgdm));
		$("#m_fxjmc").attr("value",setNull(json.LQyryjctj[0].fxjmc));
		$("#m_gxdwdm").attr("value",setNull(json.LQyryjctj[0].gxdwdm));
		$("#m_gxdwmc").attr("value",setNull(json.LQyryjctj[0].gxdwmc));
		$("#m_qymc").attr("value",setNull(json.LQyryjctj[0].qymc));
		$("#m_qybm").attr("value",setNull(json.LQyryjctj[0].qybm));
		$("#m_jg").attr("value",setNull(json.LQyryjctj[0].jg));
		$("#m_fk").attr("value",setNull(json.LQyryjctj[0].fk));
		$("#m_jl").attr("value",setNull(json.LQyryjctj[0].jl));
		$("#m_jlbfk").attr("value",setNull(json.LQyryjctj[0].jlbfk));
		$("#m_zjxszr").attr("value",setNull(json.LQyryjctj[0].zjxszr));
		$("#m_xqcjhqzcj").attr("value",setNull(json.LQyryjctj[0].xqcjhqzcj));
		$("#m_qtfklx").attr("value",setNull(json.LQyryjctj[0].qtfklx));
		$("#m_xj").attr("value",setNull(json.LQyryjctj[0].xj));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_qyryjctjid","Integer",-9999999999,9999999999,null,0,"企业人员奖惩统计ID"))
			return false;
		if (!checkControlValue("m_hylbdm","String",1,2,null,0,"行业类别代码"))
			return false;
		if (!checkControlValue("m_hylb","String",1,40,null,0,"行业类别"))
			return false;
		if (!checkControlValue("m_tjrq","Date",null,null,null,0,"统计日期"))
			return false;
		if (!checkControlValue("m_cyrybh","String",1,20,null,0,"从业人员编号"))
			return false;
		if (!checkControlValue("m_cyrylbdm","String",1,2,null,0,"从业人员类别代码"))
			return false;
		if (!checkControlValue("m_cyrylbmc","String",1,30,null,0,"从业人员类别名称"))
			return false;
		if (!checkControlValue("m_xm","String",1,100,null,0,"姓名"))
			return false;
		if (!checkControlValue("m_zjhm","String",1,20,null,0,"证件号码"))
			return false;
		if (!checkControlValue("m_dsjgmc","String",1,60,null,0,"地市机关名称"))
			return false;
		if (!checkControlValue("m_fxjdm","String",1,20,null,0,"分县局代码"))
			return false;
		if (!checkControlValue("m_dsjgdm","String",1,20,null,0,"地市机关代码"))
			return false;
		if (!checkControlValue("m_fxjmc","String",1,60,null,0,"分县局名称"))
			return false;
		if (!checkControlValue("m_gxdwdm","String",1,20,null,0,"管辖单位代码"))
			return false;
		if (!checkControlValue("m_gxdwmc","String",1,60,null,0,"管辖单位名称"))
			return false;
		if (!checkControlValue("m_qymc","String",1,120,null,0,"企业名称"))
			return false;
		if (!checkControlValue("m_qybm","String",1,20,null,0,"企业编码"))
			return false;
		if (!checkControlValue("m_jg","Integer",-999999,999999,null,0,"警告"))
			return false;
		if (!checkControlValue("m_fk","Integer",-999999,999999,null,0,"罚款"))
			return false;
		if (!checkControlValue("m_jl","Integer",-999999,999999,null,0,"拘留"))
			return false;
		if (!checkControlValue("m_jlbfk","Integer",-999999,999999,null,0,"拘留并罚款"))
			return false;
		if (!checkControlValue("m_zjxszr","Integer",-999999,999999,null,0,"追究刑事责任"))
			return false;
		if (!checkControlValue("m_xqcjhqzcj","Integer",-999999,999999,null,0,"限期出境或驱逐出境"))
			return false;
		if (!checkControlValue("m_qtfklx","Integer",-999999,999999,null,0,"其他处罚类型"))
			return false;
		if (!checkControlValue("m_xj","Integer",-999999,999999,null,0,"小计"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_qyryjctjid">
<input type="hidden" id="m_qyryjctjid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td ><a href="#" id="closeDiv" onclick='$("#Qyryjctj_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">企业人员奖惩统计ID</td>
		<td class="detailtd"><input type="text" id="m_qyryjctjid" value="0"></td>
		<td class="distd">行业类别代码</td>
		<td class="detailtd"><input type="text" id="m_hylbdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">行业类别</td>
		<td class="detailtd"><input type="text" id="m_hylb" value=""></td>
		<td class="distd">统计日期</td>
		<td class="detailtd"><input type="text" id="m_tjrq" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">从业人员编号</td>
		<td class="detailtd"><input type="text" id="m_cyrybh" value=""></td>
		<td class="distd">从业人员类别代码</td>
		<td class="detailtd"><input type="text" id="m_cyrylbdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">从业人员类别名称</td>
		<td class="detailtd"><input type="text" id="m_cyrylbmc" value=""></td>
		<td class="distd">姓名</td>
		<td class="detailtd"><input type="text" id="m_xm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">证件号码</td>
		<td class="detailtd"><input type="text" id="m_zjhm" value=""></td>
		<td class="distd">地市机关名称</td>
		<td class="detailtd"><input type="text" id="m_dsjgmc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">分县局代码</td>
		<td class="detailtd"><input type="text" id="m_fxjdm" value=""></td>
		<td class="distd">地市机关代码</td>
		<td class="detailtd"><input type="text" id="m_dsjgdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">分县局名称</td>
		<td class="detailtd"><input type="text" id="m_fxjmc" value=""></td>
		<td class="distd">管辖单位代码</td>
		<td class="detailtd"><input type="text" id="m_gxdwdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">管辖单位名称</td>
		<td class="detailtd"><input type="text" id="m_gxdwmc" value=""></td>
		<td class="distd">企业名称</td>
		<td class="detailtd"><input type="text" id="m_qymc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">企业编码</td>
		<td class="detailtd"><input type="text" id="m_qybm" value=""></td>
		<td class="distd">警告</td>
		<td class="detailtd"><input type="text" id="m_jg" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">罚款</td>
		<td class="detailtd"><input type="text" id="m_fk" value="0"></td>
		<td class="distd">拘留</td>
		<td class="detailtd"><input type="text" id="m_jl" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">拘留并罚款</td>
		<td class="detailtd"><input type="text" id="m_jlbfk" value="0"></td>
		<td class="distd">追究刑事责任</td>
		<td class="detailtd"><input type="text" id="m_zjxszr" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">限期出境或驱逐出境</td>
		<td class="detailtd"><input type="text" id="m_xqcjhqzcj" value="0"></td>
		<td class="distd">其他处罚类型</td>
		<td class="detailtd"><input type="text" id="m_qtfklx" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">小计</td>
		<td class="detailtd"><input type="text" id="m_xj" value="0"></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td></tr>
</table>
