<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_qyzlxxid").attr("value",dataid);
		$("#m_qyzlxxid").attr("value",dataid);
		setDetail();
		$("#m_fbsj").attr("readonly","true");
		$("#m_fbsj").datepicker();
	}); 
	function updatediv (json) { 
		$("#m_qyzlxxid").attr("value",setNull(json.LQyzlxx[0].qyzlxxid));
		$("#m_hylbdm").attr("value",setNull(json.LQyzlxx[0].hylbdm));
		$("#m_hylb").attr("value",setNull(json.LQyzlxx[0].hylb));
		$("#m_fbdwdm").attr("value",setNull(json.LQyzlxx[0].fbdwdm));
		$("#m_fbdwmc").attr("value",setNull(json.LQyzlxx[0].fbdwmc));
		$("#m_fbr").attr("value",setNull(json.LQyzlxx[0].fbr));
		$("#m_fbsj").attr("value",setNull(json.LQyzlxx[0].fbsj));
		$("#m_scbz").attr("value",setNull(json.LQyzlxx[0].scbz));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_qyzlxxid","Integer",-9999999999,9999999999,null,0,"企业质量信息ID"))
			return false;
		if (!checkControlValue("m_hylbdm","String",1,3,null,0,"行业类别代码"))
			return false;
		if (!checkControlValue("m_hylb","String",1,40,null,0,"行业类别"))
			return false;
		if (!checkControlValue("m_fbdwdm","String",1,20,null,0,"发布单位代码"))
			return false;
		if (!checkControlValue("m_fbdwmc","String",1,60,null,0,"发布单位名称"))
			return false;
		if (!checkControlValue("m_fbr","String",1,30,null,0,"发布人"))
			return false;
		if (!checkControlValue("m_fbsj","Date",null,null,null,0,"发布时间"))
			return false;
		if (!checkControlValue("m_scbz","Integer",-99,99,null,0,"删除标志"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_qyzlxxid">
<input type="hidden" id="m_qyzlxxid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#qyzlxx_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">企业质量信息ID</td>
		<td class="detailtd"><input type="text" id="m_qyzlxxid" class="inputstyle" value="0"></td>
		<td class="distd">行业类别代码</td>
		<td class="detailtd"><input type="text" id="m_hylbdm" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">行业类别</td>
		<td class="detailtd"><input type="text" id="m_hylb" class="inputstyle" value=""></td>
		<td class="distd">发布单位代码</td>
		<td class="detailtd"><input type="text" id="m_fbdwdm" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">发布单位名称</td>
		<td class="detailtd"><input type="text" id="m_fbdwmc" class="inputstyle" value=""></td>
		<td class="distd">发布人</td>
		<td class="detailtd"><input type="text" id="m_fbr" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">发布时间</td>
		<td class="detailtd"><input type="text" id="m_fbsj" class="inputstyle" value=""></td>
		<td class="distd">删除标志</td>
		<td class="detailtd"><input type="text" id="m_scbz" class="inputstyle" value="0"></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td></tr>
</table>
