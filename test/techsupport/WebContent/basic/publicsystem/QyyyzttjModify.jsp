<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_qyyyzttjid").attr("value",dataid);
		$("#m_qyyyzttjid").attr("value",dataid);
		setDetail();
		$("#m_tjrq").attr("readonly","true");
		$("#m_tjrq").datepicker();
	}); 
	function updatediv (json) { 
		$("#m_qyyyzttjid").attr("value",setNull(json.LQyyyzttj[0].qyyyzttjid));
		$("#m_tjrq").attr("value",setNull(json.LQyyyzttj[0].tjrq));
		$("#m_hylbdm").attr("value",setNull(json.LQyyyzttj[0].hylbdm));
		$("#m_hylb").attr("value",setNull(json.LQyyyzttj[0].hylb));
		$("#m_dsjgdm").attr("value",setNull(json.LQyyyzttj[0].dsjgdm));
		$("#m_dsjgmc").attr("value",setNull(json.LQyyyzttj[0].dsjgmc));
		$("#m_fxjdm").attr("value",setNull(json.LQyyyzttj[0].fxjdm));
		$("#m_fxjmc").attr("value",setNull(json.LQyyyzttj[0].fxjmc));
		$("#m_gxdwdm").attr("value",setNull(json.LQyyyzttj[0].gxdwdm));
		$("#m_gxdwmc").attr("value",setNull(json.LQyyyzttj[0].gxdwmc));
		$("#m_yy").attr("value",setNull(json.LQyyyzttj[0].yy));
		$("#m_zzty").attr("value",setNull(json.LQyyyzttj[0].zzty));
		$("#m_llty").attr("value",setNull(json.LQyyyzttj[0].llty));
		$("#m_xy").attr("value",setNull(json.LQyyyzttj[0].xy));
		$("#m_zx").attr("value",setNull(json.LQyyyzttj[0].zx));
		$("#m_qt").attr("value",setNull(json.LQyyyzttj[0].qt));
		$("#m_hj").attr("value",setNull(json.LQyyyzttj[0].hj));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_qyyyzttjid","Integer",-9999999999,9999999999,null,0,"企业营业状态统计ID"))
			return false;
		if (!checkControlValue("m_tjrq","Date",null,null,null,0,"统计日期"))
			return false;
		if (!checkControlValue("m_hylbdm","String",1,3,null,0,"行业类别代码"))
			return false;
		if (!checkControlValue("m_hylb","String",1,40,null,0,"行业类别"))
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
		if (!checkControlValue("m_yy","Integer",-999999,999999,null,0,"营业"))
			return false;
		if (!checkControlValue("m_zzty","Integer",-999999,999999,null,0,"自主停业"))
			return false;
		if (!checkControlValue("m_llty","Integer",-999999,999999,null,0,"勒令停业"))
			return false;
		if (!checkControlValue("m_xy","Integer",-999999,999999,null,0,"歇业"))
			return false;
		if (!checkControlValue("m_zx","Integer",-999999,999999,null,0,"注销"))
			return false;
		if (!checkControlValue("m_qt","Integer",-999999,999999,null,0,"其他"))
			return false;
		if (!checkControlValue("m_hj","Integer",-999999,999999,null,0,"合计"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_qyyyzttjid">
<input type="hidden" id="m_qyyyzttjid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#qyyyzttj_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">企业营业状态统计ID</td>
		<td class="detailtd"><input type="text" id="m_qyyyzttjid" class="inputstyle" value="0"></td>
		<td class="distd">统计日期</td>
		<td class="detailtd"><input type="text" id="m_tjrq" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">行业类别代码</td>
		<td class="detailtd"><input type="text" id="m_hylbdm" class="inputstyle" value=""></td>
		<td class="distd">行业类别</td>
		<td class="detailtd"><input type="text" id="m_hylb" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">地市机关代码</td>
		<td class="detailtd"><input type="text" id="m_dsjgdm" class="inputstyle" value=""></td>
		<td class="distd">地市机关名称</td>
		<td class="detailtd"><input type="text" id="m_dsjgmc" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">分县局代码</td>
		<td class="detailtd"><input type="text" id="m_fxjdm" class="inputstyle" value=""></td>
		<td class="distd">分县局名称</td>
		<td class="detailtd"><input type="text" id="m_fxjmc" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">管辖单位代码</td>
		<td class="detailtd"><input type="text" id="m_gxdwdm" class="inputstyle" value=""></td>
		<td class="distd">管辖单位名称</td>
		<td class="detailtd"><input type="text" id="m_gxdwmc" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">营业</td>
		<td class="detailtd"><input type="text" id="m_yy" class="inputstyle" value="0"></td>
		<td class="distd">自主停业</td>
		<td class="detailtd"><input type="text" id="m_zzty" class="inputstyle" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">勒令停业</td>
		<td class="detailtd"><input type="text" id="m_llty" class="inputstyle" value="0"></td>
		<td class="distd">歇业</td>
		<td class="detailtd"><input type="text" id="m_xy" class="inputstyle" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">注销</td>
		<td class="detailtd"><input type="text" id="m_zx" class="inputstyle" value="0"></td>
		<td class="distd">其他</td>
		<td class="detailtd"><input type="text" id="m_qt" class="inputstyle" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">合计</td>
		<td class="detailtd"><input type="text" id="m_hj" class="inputstyle" value="0"></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td></tr>
</table>
