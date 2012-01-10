<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		daggleDiv(detailid);
		$("#q_qyscbcfid").attr("value",dataid);
		$("#m_qyscbcfid").attr("value",dataid);
		setDetail();
		$("#m_wdbrq").attr("readonly","true");
		$("#m_wdbrq").datepicker();
	}); 
	function updatediv (json) { 
		$("#m_qyscbcfid").attr("value",setNull(json.LQyscbcf[0].qyscbcfid));
		$("#m_hylbdm").attr("value",setNull(json.LQyscbcf[0].hylbdm));
		$("#m_hylb").attr("value",setNull(json.LQyscbcf[0].hylb));
		$("#m_wdbrq").attr("value",setNull(json.LQyscbcf[0].wdbrq));
		$("#m_dsjgdm").attr("value",setNull(json.LQyscbcf[0].dsjgdm));
		$("#m_dsjgmc").attr("value",setNull(json.LQyscbcf[0].dsjgmc));
		$("#m_fxjdm").attr("value",setNull(json.LQyscbcf[0].fxjdm));
		$("#m_fxjmc").attr("value",setNull(json.LQyscbcf[0].fxjmc));
		$("#m_gxdwdm").attr("value",setNull(json.LQyscbcf[0].gxdwdm));
		$("#m_gxdwmc").attr("value",setNull(json.LQyscbcf[0].gxdwmc));
		$("#m_qybm").attr("value",setNull(json.LQyscbcf[0].qybm));
		$("#m_qymc").attr("value",setNull(json.LQyscbcf[0].qymc));
		$("#m_lxdh").attr("value",setNull(json.LQyscbcf[0].lxdh));
		$("#m_zrs").attr("value",setNull(json.LQyscbcf[0].zrs));
		$("#m_sskrs").attr("value",setNull(json.LQyscbcf[0].sskrs));
		$("#m_hdskb").attr("value",setNull(json.LQyscbcf[0].hdskb));
		$("#m_sjsrb").attr("value",setNull(json.LQyscbcf[0].sjsrb));
		$("#m_ztdm").attr("value",setNull(json.LQyscbcf[0].ztdm));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_qyscbcfid","Integer",-9999999999,9999999999,null,0,"企业上传不充分ID"))
			return false;
		if (!checkControlValue("m_hylbdm","String",1,2,null,0,"行业类别代码"))
			return false;
		if (!checkControlValue("m_hylb","String",1,40,null,0,"行业类别"))
			return false;
		if (!checkControlValue("m_wdbrq","Date",null,null,null,0,"未达标日期"))
			return false;
		if (!checkControlValue("m_dsjgdm","String",1,20,null,0,"地市机关代码"))
			return false;
		if (!checkControlValue("m_dsjgmc","String",1,60,null,0,"地市机关名称"))
			return false;
		if (!checkControlValue("m_fxjdm","String",1,20,null,0,"分县局代码"))
			return false;
		if (!checkControlValue("m_fxjmc","String",1,60,null,0,"分县局名称"))
			return false;
		if (!checkControlValue("m_gxdwdm","String",1,20,null,0,"管辖单位代码"))
			return false;
		if (!checkControlValue("m_gxdwmc","String",1,60,null,0,"管辖单位名称"))
			return false;
		if (!checkControlValue("m_qybm","String",1,20,null,0,"企业编码"))
			return false;
		if (!checkControlValue("m_qymc","String",1,120,null,0,"企业名称"))
			return false;
		if (!checkControlValue("m_lxdh","String",1,30,null,0,"联系电话"))
			return false;
		if (!checkControlValue("m_zrs","Integer",-999999,999999,null,0,"总人数"))
			return false;
		if (!checkControlValue("m_sskrs","Integer",-999999,999999,null,0,"实刷卡人数"))
			return false;
		if (!checkControlValue("m_hdskb","Float",-999.99,999.99,2,0,"核定刷卡比"))
			return false;
		if (!checkControlValue("m_sjsrb","Float",-999.99,999.99,2,0,"实际刷卡比"))
			return false;
		if (!checkControlValue("m_ztdm","String",1,2,null,0,"状态代码"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_qyscbcfid">
<input type="hidden" id="m_qyscbcfid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td ><a href="#" id="closeDiv" onclick='$("#Qyscbcf_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">企业上传不充分ID</td>
		<td class="detailtd"><input type="text" id="m_qyscbcfid" value="0"></td>
		<td class="distd">行业类别代码</td>
		<td class="detailtd"><input type="text" id="m_hylbdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">行业类别</td>
		<td class="detailtd"><input type="text" id="m_hylb" value=""></td>
		<td class="distd">未达标日期</td>
		<td class="detailtd"><input type="text" id="m_wdbrq" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">地市机关代码</td>
		<td class="detailtd"><input type="text" id="m_dsjgdm" value=""></td>
		<td class="distd">地市机关名称</td>
		<td class="detailtd"><input type="text" id="m_dsjgmc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">分县局代码</td>
		<td class="detailtd"><input type="text" id="m_fxjdm" value=""></td>
		<td class="distd">分县局名称</td>
		<td class="detailtd"><input type="text" id="m_fxjmc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">管辖单位代码</td>
		<td class="detailtd"><input type="text" id="m_gxdwdm" value=""></td>
		<td class="distd">管辖单位名称</td>
		<td class="detailtd"><input type="text" id="m_gxdwmc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">企业编码</td>
		<td class="detailtd"><input type="text" id="m_qybm" value=""></td>
		<td class="distd">企业名称</td>
		<td class="detailtd"><input type="text" id="m_qymc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">联系电话</td>
		<td class="detailtd"><input type="text" id="m_lxdh" value=""></td>
		<td class="distd">总人数</td>
		<td class="detailtd"><input type="text" id="m_zrs" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">实刷卡人数</td>
		<td class="detailtd"><input type="text" id="m_sskrs" value="0"></td>
		<td class="distd">核定刷卡比</td>
		<td class="detailtd"><input type="text" id="m_hdskb" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">实际刷卡比</td>
		<td class="detailtd"><input type="text" id="m_sjsrb" value="0"></td>
		<td class="distd">状态代码</td>
		<td class="detailtd"><input type="text" id="m_ztdm" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td></tr>
</table>
