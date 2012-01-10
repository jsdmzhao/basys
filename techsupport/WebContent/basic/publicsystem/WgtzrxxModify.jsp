<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		daggleDiv(detailid);
		$("#q_wgtzrxxid").attr("value",dataid);
		$("#m_wgtzrxxid").attr("value",dataid);
		setDetail();
	}); 
	function updatediv (json) { 
		$("#m_wgtzrxxid").attr("value",setNull(json.LWgtzrxx[0].wgtzrxxid));
		$("#m_qyid").attr("value",setNull(json.LWgtzrxx[0].qyid));
		$("#m_tzzxm").attr("value",setNull(json.LWgtzrxx[0].tzzxm));
		$("#m_lxdh").attr("value",setNull(json.LWgtzrxx[0].lxdh));
		$("#m_gjdm").attr("value",setNull(json.LWgtzrxx[0].gjdm));
		$("#m_gj").attr("value",setNull(json.LWgtzrxx[0].gj));
		$("#m_qzzldm").attr("value",setNull(json.LWgtzrxx[0].qzzldm));
		$("#m_qzzlmc").attr("value",setNull(json.LWgtzrxx[0].qzzlmc));
		$("#m_qzhm").attr("value",setNull(json.LWgtzrxx[0].qzhm));
		$("#m_hzzldm").attr("value",setNull(json.LWgtzrxx[0].hzzldm));
		$("#m_hzzlmc").attr("value",setNull(json.LWgtzrxx[0].hzzlmc));
		$("#m_hzhm").attr("value",setNull(json.LWgtzrxx[0].hzhm));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_wgtzrxxid","Integer",-9999999999,9999999999,null,0,"境外投资人信息ID"))
			return false;
		if (!checkControlValue("m_qyid","Integer",-9999999999,9999999999,null,0,"企业ID"))
			return false;
		if (!checkControlValue("m_tzzxm","String",1,100,null,0,"投资者姓名"))
			return false;
		if (!checkControlValue("m_lxdh","String",1,30,null,0,"联系电话"))
			return false;
		if (!checkControlValue("m_gjdm","String",1,40,null,0,"国籍代码"))
			return false;
		if (!checkControlValue("m_gj","String",1,100,null,0,"国籍"))
			return false;
		if (!checkControlValue("m_qzzldm","String",1,40,null,0,"签证种类代码"))
			return false;
		if (!checkControlValue("m_qzzlmc","String",1,100,null,0,"签证种类名称"))
			return false;
		if (!checkControlValue("m_qzhm","String",1,20,null,0,"签证号码"))
			return false;
		if (!checkControlValue("m_hzzldm","String",1,40,null,0,"护照种类代码"))
			return false;
		if (!checkControlValue("m_hzzlmc","String",1,100,null,0,"护照种类名称"))
			return false;
		if (!checkControlValue("m_hzhm","String",1,20,null,0,"护照号码"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_wgtzrxxid">
<input type="hidden" id="m_wgtzrxxid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td ><a href="#" id="closeDiv" onclick='$("#Wgtzrxx_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">境外投资人信息ID</td>
		<td class="detailtd"><input type="text" id="m_wgtzrxxid" value="0"></td>
		<td class="distd">企业ID</td>
		<td class="detailtd"><input type="text" id="m_qyid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">境外投资者名称</td>
		<td class="detailtd"><input type="text" id="m_tzzxm" value=""></td>
		<td class="distd">联系电话</td>
		<td class="detailtd"><input type="text" id="m_lxdh" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">国籍代码</td>
		<td class="detailtd"><input type="text" id="m_gjdm" value=""></td>
		<td class="distd">国籍</td>
		<td class="detailtd"><input type="text" id="m_gj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">签证种类代码</td>
		<td class="detailtd"><input type="text" id="m_qzzldm" value=""></td>
		<td class="distd">签证种类名称</td>
		<td class="detailtd"><input type="text" id="m_qzzlmc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">签证号码</td>
		<td class="detailtd"><input type="text" id="m_qzhm" value=""></td>
		<td class="distd">护照种类代码</td>
		<td class="detailtd"><input type="text" id="m_hzzldm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">护照种类名称</td>
		<td class="detailtd"><input type="text" id="m_hzzlmc" value=""></td>
		<td class="distd">护照号码</td>
		<td class="detailtd"><input type="text" id="m_hzhm" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td></tr>
</table>
