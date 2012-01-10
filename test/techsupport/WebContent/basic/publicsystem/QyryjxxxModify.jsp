<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_qyryjxid").attr("value",dataid);
		$("#m_qyryjxid").attr("value",dataid);
		setDetail();
		$("#m_csrq").attr("readonly","true");
		$("#m_csrq").datepicker();
		$("#m_lrsj").attr("readonly","true");
		$("#m_lrsj").datepicker();
	}); 
	function updatediv (json) { 
		$("#m_qyryjxid").attr("value",setNull(json.LQyryjxxx[0].qyryjxid));
		$("#m_qyid").attr("value",setNull(json.LQyryjxxx[0].qyid));
		$("#m_hylbdm").attr("value",setNull(json.LQyryjxxx[0].hylbdm));
		$("#m_hylb").attr("value",setNull(json.LQyryjxxx[0].hylb));
		$("#m_cyrybh").attr("value",setNull(json.LQyryjxxx[0].cyrybh));
		$("#m_xm").attr("value",setNull(json.LQyryjxxx[0].xm));
		$("#m_xmpy").attr("value",setNull(json.LQyryjxxx[0].xmpy));
		$("#m_gjdm").attr("value",setNull(json.LQyryjxxx[0].gjdm));
		$("#m_gj").attr("value",setNull(json.LQyryjxxx[0].gj));
		$("#m_xbdm").attr("value",setNull(json.LQyryjxxx[0].xbdm));
		$("#m_xb").attr("value",setNull(json.LQyryjxxx[0].xb));
		$("#m_csrq").attr("value",setNull(json.LQyryjxxx[0].csrq));
		$("#m_hjdxzqh").attr("value",setNull(json.LQyryjxxx[0].hjdxzqh));
		$("#m_hjdxzqhdm").attr("value",setNull(json.LQyryjxxx[0].hjdxzqhdm));
		$("#m_cyzjdm").attr("value",setNull(json.LQyryjxxx[0].cyzjdm));
		$("#m_cyzj").attr("value",setNull(json.LQyryjxxx[0].cyzj));
		$("#m_zjhm").attr("value",setNull(json.LQyryjxxx[0].zjhm));
		$("#m_lrsj").attr("value",setNull(json.LQyryjxxx[0].lrsj));
		$("#m_lrr").attr("value",setNull(json.LQyryjxxx[0].lrr));
		$("#m_lrdwbm").attr("value",setNull(json.LQyryjxxx[0].lrdwbm));
		$("#m_lrdwmc").attr("value",setNull(json.LQyryjxxx[0].lrdwmc));
		$("#m_zt").attr("value",setNull(json.LQyryjxxx[0].zt));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_qyryjxid","Integer",-9999999999,9999999999,null,0,"企业业人员简项ID"))
			return false;
		if (!checkControlValue("m_qyid","Integer",-9999999999,9999999999,null,0,"企业ID"))
			return false;
		if (!checkControlValue("m_hylbdm","String",1,3,null,0,"行业类别代码"))
			return false;
		if (!checkControlValue("m_hylb","String",1,40,null,0,"行业类别"))
			return false;
		if (!checkControlValue("m_cyrybh","String",1,30,null,0,"从业人员编号"))
			return false;
		if (!checkControlValue("m_xm","String",1,100,null,0,"姓名"))
			return false;
		if (!checkControlValue("m_xmpy","String",1,60,null,0,"姓名拼音"))
			return false;
		if (!checkControlValue("m_gjdm","String",1,40,null,0,"国籍代码"))
			return false;
		if (!checkControlValue("m_gj","String",1,100,null,0,"国籍"))
			return false;
		if (!checkControlValue("m_xbdm","String",1,2,null,0,"性别代码"))
			return false;
		if (!checkControlValue("m_xb","String",1,2,null,0,"性别"))
			return false;
		if (!checkControlValue("m_csrq","Date",null,null,null,0,"出生日期"))
			return false;
		if (!checkControlValue("m_hjdxzqh","String",1,200,null,0,"户籍地行政区划"))
			return false;
		if (!checkControlValue("m_hjdxzqhdm","String",1,10,null,0,"户籍地行政区划代码"))
			return false;
		if (!checkControlValue("m_cyzjdm","String",1,40,null,0,"常用证件代码"))
			return false;
		if (!checkControlValue("m_cyzj","String",1,100,null,0,"常用证件"))
			return false;
		if (!checkControlValue("m_zjhm","String",1,20,null,0,"证件号码"))
			return false;
		if (!checkControlValue("m_lrsj","Date",null,null,null,0,"录入时间"))
			return false;
		if (!checkControlValue("m_lrr","String",1,100,null,0,"录入人"))
			return false;
		if (!checkControlValue("m_lrdwbm","String",1,20,null,0,"录入单位编码"))
			return false;
		if (!checkControlValue("m_lrdwmc","String",1,60,null,0,"录入单位名称"))
			return false;
		if (!checkControlValue("m_zt","String",1,10,null,0,"状态"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_qyryjxid">
<input type="hidden" id="m_qyryjxid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#qyryjxxx_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">企业业人员简项ID</td>
		<td class="detailtd"><input type="text" id="m_qyryjxid" class="inputstyle" value="0"></td>
		<td class="distd">企业ID</td>
		<td class="detailtd"><input type="text" id="m_qyid" class="inputstyle" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">行业类别代码</td>
		<td class="detailtd"><input type="text" id="m_hylbdm" class="inputstyle" value=""></td>
		<td class="distd">行业类别</td>
		<td class="detailtd"><input type="text" id="m_hylb" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">从业人员编号</td>
		<td class="detailtd"><input type="text" id="m_cyrybh" class="inputstyle" value=""></td>
		<td class="distd">姓名</td>
		<td class="detailtd"><input type="text" id="m_xm" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">姓名拼音</td>
		<td class="detailtd"><input type="text" id="m_xmpy" class="inputstyle" value=""></td>
		<td class="distd">国籍代码</td>
		<td class="detailtd"><input type="text" id="m_gjdm" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">国籍</td>
		<td class="detailtd"><input type="text" id="m_gj" class="inputstyle" value=""></td>
		<td class="distd">性别代码</td>
		<td class="detailtd"><input type="text" id="m_xbdm" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">性别</td>
		<td class="detailtd"><input type="text" id="m_xb" class="inputstyle" value=""></td>
		<td class="distd">出生日期</td>
		<td class="detailtd"><input type="text" id="m_csrq" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">户籍地行政区划</td>
		<td class="detailtd"><input type="text" id="m_hjdxzqh" class="inputstyle" value=""></td>
		<td class="distd">户籍地行政区划代码</td>
		<td class="detailtd"><input type="text" id="m_hjdxzqhdm" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">常用证件代码</td>
		<td class="detailtd"><input type="text" id="m_cyzjdm" class="inputstyle" value=""></td>
		<td class="distd">常用证件</td>
		<td class="detailtd"><input type="text" id="m_cyzj" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">证件号码</td>
		<td class="detailtd"><input type="text" id="m_zjhm" class="inputstyle" value=""></td>
		<td class="distd">录入时间</td>
		<td class="detailtd"><input type="text" id="m_lrsj" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">录入人</td>
		<td class="detailtd"><input type="text" id="m_lrr" class="inputstyle" value=""></td>
		<td class="distd">录入单位编码</td>
		<td class="detailtd"><input type="text" id="m_lrdwbm" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">录入单位名称</td>
		<td class="detailtd"><input type="text" id="m_lrdwmc" class="inputstyle" value=""></td>
		<td class="distd">状态</td>
		<td class="detailtd"><input type="text" id="m_zt" class="inputstyle" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td></tr>
</table>
