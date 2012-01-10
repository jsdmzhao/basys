<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_qycftjid").attr("value",dataid);
		$("#m_qycftjid").attr("value",dataid);
		setDetail();
		$("#m_tjrq").attr("readonly","true");
		$("#m_tjrq").datepicker();
	}); 
	function updatediv (json) { 
		$("#m_qycftjid").attr("value",setNull(json.LQycftj[0].qycftjid));
		$("#m_hylbdm").attr("value",setNull(json.LQycftj[0].hylbdm));
		$("#m_hylb").attr("value",setNull(json.LQycftj[0].hylb));
		$("#m_tjrq").attr("value",setNull(json.LQycftj[0].tjrq));
		$("#m_dsjgdm").attr("value",setNull(json.LQycftj[0].dsjgdm));
		$("#m_dsjgmc").attr("value",setNull(json.LQycftj[0].dsjgmc));
		$("#m_fxjdm").attr("value",setNull(json.LQycftj[0].fxjdm));
		$("#m_fxjmc").attr("value",setNull(json.LQycftj[0].fxjmc));
		$("#m_gxdwmc").attr("value",setNull(json.LQycftj[0].gxdwmc));
		$("#m_gxdwdm").attr("value",setNull(json.LQycftj[0].gxdwdm));
		$("#m_csbm").attr("value",setNull(json.LQycftj[0].csbm));
		$("#m_csmc").attr("value",setNull(json.LQycftj[0].csmc));
		$("#m_jgcs").attr("value",setNull(json.LQycftj[0].jgcs));
		$("#m_fmcs").attr("value",setNull(json.LQycftj[0].fmcs));
		$("#m_tdcs").attr("value",setNull(json.LQycftj[0].tdcs));
		$("#m_zjcs").attr("value",setNull(json.LQycftj[0].zjcs));
		$("#m_qtfmcs").attr("value",setNull(json.LQycftj[0].qtfmcs));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_qycftjid","Integer",-9999999999,9999999999,null,0,"企业处罚统计ID"))
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
		if (!checkControlValue("m_csbm","String",1,20,null,0,"场所编码"))
			return false;
		if (!checkControlValue("m_csmc","String",1,120,null,0,"场所名称"))
			return false;
		if (!checkControlValue("m_jgcs","Integer",-999999,999999,null,0,"警告次数"))
			return false;
		if (!checkControlValue("m_fmcs","Integer",-999999,999999,null,0,"罚没次数"))
			return false;
		if (!checkControlValue("m_tdcs","Integer",-999999,999999,null,0,"停吊次数"))
			return false;
		if (!checkControlValue("m_zjcs","Integer",-999999,999999,null,0,"追究次数"))
			return false;
		if (!checkControlValue("m_qtfmcs","Integer",-999999,999999,null,0,"其他处罚次数"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_qycftjid">
<input type="hidden" id="m_qycftjid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td ><a href="#" id="closeDiv" onclick='$("#Qycftj_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">企业处罚统计ID</td>
		<td class="detailtd"><input type="text" id="m_qycftjid" value="0"></td>
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
		<td class="distd">场所编码</td>
		<td class="detailtd"><input type="text" id="m_csbm" value=""></td>
		<td class="distd">场所名称</td>
		<td class="detailtd"><input type="text" id="m_csmc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">警告次数</td>
		<td class="detailtd"><input type="text" id="m_jgcs" value="0"></td>
		<td class="distd">罚没次数</td>
		<td class="detailtd"><input type="text" id="m_fmcs" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">停吊次数</td>
		<td class="detailtd"><input type="text" id="m_tdcs" value="0"></td>
		<td class="distd">追究次数</td>
		<td class="detailtd"><input type="text" id="m_zjcs" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">其他处罚次数</td>
		<td class="detailtd"><input type="text" id="m_qtfmcs" value="0"></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td></tr>
</table>
