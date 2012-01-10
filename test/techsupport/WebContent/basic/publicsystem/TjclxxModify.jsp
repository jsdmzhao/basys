<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		daggleDiv(detailid);
		$("#q_tjclxxid").attr("value",dataid);
		$("#m_tjclxxid").attr("value",dataid);
		setDetail();
		$("#m_tijiaorq").attr("readonly","true");
		$("#m_tijiaorq").datepicker();
	}); 
	function updatediv (json) { 
		$("#m_tjclxxid").attr("value",setNull(json.LTjclxx[0].tjclxxid));
		$("#m_qyid").attr("value",setNull(json.LTjclxx[0].qyid));
		$("#m_qybaxxid").attr("value",setNull(json.LTjclxx[0].qybaxxid));
		$("#m_tjcllxdm").attr("value",setNull(json.LTjclxx[0].tjcllxdm));
		$("#m_tjcllx").attr("value",setNull(json.LTjclxx[0].tjcllx));
		$("#m_tijiaorq").attr("value",setNull(json.LTjclxx[0].tijiaorq));
		$("#m_tjrxm").attr("value",setNull(json.LTjclxx[0].tjrxm));
		$("#m_tjclnr").attr("value",setNull(json.LTjclxx[0].tjclnr));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_tjclxxid","Integer",-9999999999,9999999999,null,0,"提交材料信息ID"))
			return false;
		if (!checkControlValue("m_qyid","Integer",-9999999999,9999999999,null,0,"企业ID"))
			return false;
		if (!checkControlValue("m_qybaxxid","Integer",-9999999999,9999999999,null,0,"企业备案信息ID"))
			return false;
		if (!checkControlValue("m_tjcllxdm","String",1,2,null,0,"提交材料类型代码"))
			return false;
		if (!checkControlValue("m_tjcllx","String",1,100,null,0,"提交材料类型"))
			return false;
		if (!checkControlValue("m_tijiaorq","Date",null,null,null,0,"提交日期"))
			return false;
		if (!checkControlValue("m_tjrxm","String",1,100,null,0,"提交人姓名"))
			return false;
		if (!checkControlValue("m_tjclnr","byte[]",,,,0,"提交材料内容"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_tjclxxid">
<input type="hidden" id="m_tjclxxid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td ><a href="#" id="closeDiv" onclick='$("#Tjclxx_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">提交材料信息ID</td>
		<td class="detailtd"><input type="text" id="m_tjclxxid" value="0"></td>
		<td class="distd">企业ID</td>
		<td class="detailtd"><input type="text" id="m_qyid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">企业备案信息ID</td>
		<td class="detailtd"><input type="text" id="m_qybaxxid" value="0"></td>
		<td class="distd">提交材料类型代码</td>
		<td class="detailtd"><input type="text" id="m_tjcllxdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">提交材料类型</td>
		<td class="detailtd"><input type="text" id="m_tjcllx" value=""></td>
		<td class="distd">提交日期</td>
		<td class="detailtd"><input type="text" id="m_tijiaorq" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">提交人姓名</td>
		<td class="detailtd"><input type="text" id="m_tjrxm" value=""></td>
		<td class="distd">提交材料内容</td>
		<td class="detailtd"><input type="text" id="m_tjclnr" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td></tr>
</table>
