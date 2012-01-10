<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_qyid").attr("value",dataid);
		$("#m_qyid").attr("value",dataid);
		setDetail();
		$("#m_gzkssj").attr("readonly","true");
		$("#m_gzkssj").datepicker();
		$("#m_gzjssj").attr("readonly","true");
		$("#m_gzjssj").datepicker();
	}); 
	function updatediv (json) { 
		$("#m_qyid").attr("value",setNull(json.LQyrygzrz[0].qyid));
		$("#m_ryid").attr("value",setNull(json.LQyrygzrz[0].ryid));
		$("#m_qyrygzrzid").attr("value",setNull(json.LQyrygzrz[0].qyrygzrzid));
		$("#m_gzkssj").attr("value",setNull(json.LQyrygzrz[0].gzkssj));
		$("#m_gzjssj").attr("value",setNull(json.LQyrygzrz[0].gzjssj));
		$("#m_gzdd").attr("value",setNull(json.LQyrygzrz[0].gzdd));
		$("#m_gwxx").attr("value",setNull(json.LQyrygzrz[0].gwxx));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_qyid","Integer",-9999999999,9999999999,null,0,"企业ID"))
			return false;
		if (!checkControlValue("m_ryid","Integer",-9999999999,9999999999,null,0,"从业人员ID"))
			return false;
		if (!checkControlValue("m_qyrygzrzid","Integer",-9999999999,9999999999,null,0,"企业人员工作日志ID"))
			return false;
		if (!checkControlValue("m_gzkssj","Date",null,null,null,0,"工作开始时间"))
			return false;
		if (!checkControlValue("m_gzjssj","Date",null,null,null,0,"工作结束时间"))
			return false;
		if (!checkControlValue("m_gzdd","String",1,100,null,0,"工作地点"))
			return false;
		if (!checkControlValue("m_gwxx","String",1,300,null,0,"岗位信息"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_qyid">
<input type="hidden" id="m_qyid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#qyrygzrz_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">企业ID</td>
		<td class="detailtd"><input type="text" id="m_qyid" value="0"></td>
		<td class="distd">从业人员ID</td>
		<td class="detailtd"><input type="text" id="m_ryid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">企业人员工作日志ID</td>
		<td class="detailtd"><input type="text" id="m_qyrygzrzid" value="0"></td>
		<td class="distd">工作开始时间</td>
		<td class="detailtd"><input type="text" id="m_gzkssj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">工作结束时间</td>
		<td class="detailtd"><input type="text" id="m_gzjssj" value=""></td>
		<td class="distd">工作地点</td>
		<td class="detailtd"><input type="text" id="m_gzdd" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">岗位信息</td>
		<td class="detailtd"><input type="text" id="m_gwxx" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td></tr>
</table>
