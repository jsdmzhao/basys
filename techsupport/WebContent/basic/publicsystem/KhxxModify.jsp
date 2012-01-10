<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		daggleDiv(detailid);
		$("#q_khxxid").attr("value",dataid);
		$("#m_khxxid").attr("value",dataid);
		setDetail();
	}); 
	function updatediv (json) { 
		$("#m_khxxid").attr("value",setNull(json.LKhxx[0].khxxid));
		$("#m_xm").attr("value",setNull(json.LKhxx[0].xm));
		$("#m_lxdh").attr("value",setNull(json.LKhxx[0].lxdh));
		$("#m_mzdm").attr("value",setNull(json.LKhxx[0].mzdm));
		$("#m_minzu").attr("value",setNull(json.LKhxx[0].minzu));
		$("#m_xbdm").attr("value",setNull(json.LKhxx[0].xbdm));
		$("#m_xb").attr("value",setNull(json.LKhxx[0].xb));
		$("#m_hjdxz").attr("value",setNull(json.LKhxx[0].hjdxz));
		$("#m_cyzjdm").attr("value",setNull(json.LKhxx[0].cyzjdm));
		$("#m_cyzj").attr("value",setNull(json.LKhxx[0].cyzj));
		$("#m_zjhm").attr("value",setNull(json.LKhxx[0].zjhm));
		$("#m_biduiflag").attr("value",setNull(json.LKhxx[0].biduiflag));
		$("#m_zt").attr("value",setNull(json.LKhxx[0].zt));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_khxxid","Integer",-9999999999,9999999999,null,0,"客户信息ID"))
			return false;
		if (!checkControlValue("m_xm","String",1,100,null,0,"姓名"))
			return false;
		if (!checkControlValue("m_lxdh","String",1,30,null,0,"联系电话"))
			return false;
		if (!checkControlValue("m_mzdm","String",1,40,null,0,"民族代码"))
			return false;
		if (!checkControlValue("m_minzu","String",1,20,null,0,"民族"))
			return false;
		if (!checkControlValue("m_xbdm","String",1,2,null,0,"性别代码"))
			return false;
		if (!checkControlValue("m_xb","String",1,2,null,0,"性别"))
			return false;
		if (!checkControlValue("m_hjdxz","String",1,200,null,0,"户籍地详址"))
			return false;
		if (!checkControlValue("m_cyzjdm","String",1,40,null,0,"常用证件代码"))
			return false;
		if (!checkControlValue("m_cyzj","String",1,100,null,0,"常用证件"))
			return false;
		if (!checkControlValue("m_zjhm","String",1,20,null,0,"证件号码"))
			return false;
		if (!checkControlValue("m_biduiflag","String",1,1,null,0,"比对标志"))
			return false;
		if (!checkControlValue("m_zt","String",1,10,null,0,"状态"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_khxxid">
<input type="hidden" id="m_khxxid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td ><a href="#" id="closeDiv" onclick='$("#Khxx_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">客户信息ID</td>
		<td class="detailtd"><input type="text" id="m_khxxid" value="0"></td>
		<td class="distd">姓名</td>
		<td class="detailtd"><input type="text" id="m_xm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">联系电话</td>
		<td class="detailtd"><input type="text" id="m_lxdh" value=""></td>
		<td class="distd">民族代码</td>
		<td class="detailtd"><input type="text" id="m_mzdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">民族</td>
		<td class="detailtd"><input type="text" id="m_minzu" value=""></td>
		<td class="distd">性别代码</td>
		<td class="detailtd"><input type="text" id="m_xbdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">性别</td>
		<td class="detailtd"><input type="text" id="m_xb" value=""></td>
		<td class="distd">户籍地详址</td>
		<td class="detailtd"><input type="text" id="m_hjdxz" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">常用证件代码</td>
		<td class="detailtd"><input type="text" id="m_cyzjdm" value=""></td>
		<td class="distd">常用证件</td>
		<td class="detailtd"><input type="text" id="m_cyzj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">证件号码</td>
		<td class="detailtd"><input type="text" id="m_zjhm" value=""></td>
		<td class="distd">比对标志</td>
		<td class="detailtd"><input type="text" id="m_biduiflag" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">状态</td>
		<td class="detailtd"><input type="text" id="m_zt" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td></tr>
</table>
