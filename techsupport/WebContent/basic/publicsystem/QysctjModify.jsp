<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		daggleDiv(detailid);
		$("#q_qysctjid").attr("value",dataid);
		$("#m_qysctjid").attr("value",dataid);
		setDetail();
		$("#m_tjrq").attr("readonly","true");
		$("#m_tjrq").datepicker();
	}); 
	function updatediv (json) { 
		$("#m_qysctjid").attr("value",setNull(json.LQysctj[0].qysctjid));
		$("#m_hylbdm").attr("value",setNull(json.LQysctj[0].hylbdm));
		$("#m_hylb").attr("value",setNull(json.LQysctj[0].hylb));
		$("#m_tjrq").attr("value",setNull(json.LQysctj[0].tjrq));
		$("#m_dsjgdm").attr("value",setNull(json.LQysctj[0].dsjgdm));
		$("#m_dsjgmc").attr("value",setNull(json.LQysctj[0].dsjgmc));
		$("#m_fxjdm").attr("value",setNull(json.LQysctj[0].fxjdm));
		$("#m_fxjmc").attr("value",setNull(json.LQysctj[0].fxjmc));
		$("#m_gxdwmc").attr("value",setNull(json.LQysctj[0].gxdwmc));
		$("#m_gxdwdm").attr("value",setNull(json.LQysctj[0].gxdwdm));
		$("#m_qybm").attr("value",setNull(json.LQysctj[0].qybm));
		$("#m_qymc").attr("value",setNull(json.LQysctj[0].qymc));
		$("#m_lxdh").attr("value",setNull(json.LQysctj[0].lxdh));
		$("#m_sfdb").attr("value",setNull(json.LQysctj[0].sfdb));
		$("#m_zrs").attr("value",setNull(json.LQysctj[0].zrs));
		$("#m_gzrs").attr("value",setNull(json.LQysctj[0].gzrs));
		$("#m_sskrs").attr("value",setNull(json.LQysctj[0].sskrs));
		$("#m_zdskb").attr("value",setNull(json.LQysctj[0].zdskb));
		$("#m_ycskrs").attr("value",setNull(json.LQysctj[0].ycskrs));
		$("#m_dcskrs").attr("value",setNull(json.LQysctj[0].dcskrs));
		$("#m_bcsskrs").attr("value",setNull(json.LQysctj[0].bcsskrs));
		$("#m_ztskrs").attr("value",setNull(json.LQysctj[0].ztskrs));
		$("#m_zskb").attr("value",setNull(json.LQysctj[0].zskb));
		$("#m_ycskb").attr("value",setNull(json.LQysctj[0].ycskb));
		$("#m_dcskb").attr("value",setNull(json.LQysctj[0].dcskb));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_qysctjid","Integer",-9999999999,9999999999,null,0,"企业上传统计ID"))
			return false;
		if (!checkControlValue("m_hylbdm","String",1,2,null,0,"行业类别代码"))
			return false;
		if (!checkControlValue("m_hylb","String",1,40,null,0,"行业类别"))
			return false;
		if (!checkControlValue("m_tjrq","Date",null,null,null,0,"统计日期"))
			return false;
		if (!checkControlValue("m_dsjgdm","String",1,20,null,0,"地市机关代码"))
			return false;
		if (!checkControlValue("m_dsjgmc","String",1,60,null,0,"地市机关名称"))
			return false;
		if (!checkControlValue("m_fxjdm","String",1,20,null,0,"分县局代码"))
			return false;
		if (!checkControlValue("m_fxjmc","String",1,60,null,0,"分县局名称"))
			return false;
		if (!checkControlValue("m_gxdwmc","String",1,60,null,0,"管辖单位名称"))
			return false;
		if (!checkControlValue("m_gxdwdm","String",1,20,null,0,"管辖单位代码"))
			return false;
		if (!checkControlValue("m_qybm","String",1,20,null,0,"企业编码"))
			return false;
		if (!checkControlValue("m_qymc","String",1,120,null,0,"企业名称"))
			return false;
		if (!checkControlValue("m_lxdh","String",1,30,null,0,"联系电话"))
			return false;
		if (!checkControlValue("m_sfdb","Integer",-99,99,null,0,"是否达标"))
			return false;
		if (!checkControlValue("m_zrs","Integer",-999999,999999,null,0,"总人数"))
			return false;
		if (!checkControlValue("m_gzrs","Integer",-999999,999999,null,0,"工作人数"))
			return false;
		if (!checkControlValue("m_sskrs","Integer",-999999,999999,null,0,"实刷卡人数"))
			return false;
		if (!checkControlValue("m_zdskb","Float",-999.99,999.99,2,0,"最低刷卡比"))
			return false;
		if (!checkControlValue("m_ycskrs","Integer",-999999,999999,null,0,"一次刷卡人数"))
			return false;
		if (!checkControlValue("m_dcskrs","Integer",-999999,999999,null,0,"多次刷卡人数"))
			return false;
		if (!checkControlValue("m_bcsskrs","Integer",-999999,999999,null,0,"本场所刷卡人数"))
			return false;
		if (!checkControlValue("m_ztskrs","Integer",-999999,999999,null,0,"走台刷卡人数"))
			return false;
		if (!checkControlValue("m_zskb","Float",-999.99,999.99,2,0,"总刷卡比"))
			return false;
		if (!checkControlValue("m_ycskb","Float",-999.99,999.99,2,0,"一次刷卡率"))
			return false;
		if (!checkControlValue("m_dcskb","Float",-999.99,999.99,2,0,"多次刷卡率"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_qysctjid">
<input type="hidden" id="m_qysctjid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td ><a href="#" id="closeDiv" onclick='$("#Qysctj_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">企业上传统计ID</td>
		<td class="detailtd"><input type="text" id="m_qysctjid" value="0"></td>
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
		<td class="distd">管辖单位名称</td>
		<td class="detailtd"><input type="text" id="m_gxdwmc" value=""></td>
		<td class="distd">管辖单位代码</td>
		<td class="detailtd"><input type="text" id="m_gxdwdm" value=""></td>
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
		<td class="distd">是否达标</td>
		<td class="detailtd"><input type="text" id="m_sfdb" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">总人数</td>
		<td class="detailtd"><input type="text" id="m_zrs" value="0"></td>
		<td class="distd">工作人数</td>
		<td class="detailtd"><input type="text" id="m_gzrs" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">实刷卡人数</td>
		<td class="detailtd"><input type="text" id="m_sskrs" value="0"></td>
		<td class="distd">最低刷卡比</td>
		<td class="detailtd"><input type="text" id="m_zdskb" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">一次刷卡人数</td>
		<td class="detailtd"><input type="text" id="m_ycskrs" value="0"></td>
		<td class="distd">多次刷卡人数</td>
		<td class="detailtd"><input type="text" id="m_dcskrs" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">本场所刷卡人数</td>
		<td class="detailtd"><input type="text" id="m_bcsskrs" value="0"></td>
		<td class="distd">走台刷卡人数</td>
		<td class="detailtd"><input type="text" id="m_ztskrs" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">总刷卡比</td>
		<td class="detailtd"><input type="text" id="m_zskb" value="0"></td>
		<td class="distd">一次刷卡率</td>
		<td class="detailtd"><input type="text" id="m_ycskb" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">多次刷卡率</td>
		<td class="detailtd"><input type="text" id="m_dcskb" value="0"></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td></tr>
</table>
