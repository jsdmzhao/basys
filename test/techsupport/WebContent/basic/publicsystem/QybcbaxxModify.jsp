<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		daggleDiv(detailid);
		$("#q_qyid").attr("value",dataid);
		$("#m_qyid").attr("value",dataid);
		setDetail();
		$("#m_bbgzrq").attr("readonly","true");
		$("#m_bbgzrq").datepicker();
		$("#m_bbwcrq").attr("readonly","true");
		$("#m_bbwcrq").datepicker();
	}); 
	function updatediv (json) { 
		$("#m_qyid").attr("value",setNull(json.LQybcbaxx[0].qyid));
		$("#m_qybaxxid").attr("value",setNull(json.LQybcbaxx[0].qybaxxid));
		$("#m_bbgzrq").attr("value",setNull(json.LQybcbaxx[0].bbgzrq));
		$("#m_bbyy").attr("value",setNull(json.LQybcbaxx[0].bbyy));
		$("#m_bbwcrq").attr("value",setNull(json.LQybcbaxx[0].bbwcrq));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_qyid","Integer",-9999999999,9999999999,null,0,"企业ID"))
			return false;
		if (!checkControlValue("m_qybaxxid","Integer",-9999999999,9999999999,null,0,"企业备案信息ID"))
			return false;
		if (!checkControlValue("m_bbgzrq","Date",null,null,null,0,"补备告知日期"))
			return false;
		if (!checkControlValue("m_bbyy","String",1,2000,null,0,"补备原因"))
			return false;
		if (!checkControlValue("m_bbwcrq","Date",null,null,null,0,"补备完成日期"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_qyid">
<input type="hidden" id="m_qyid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td ><a href="#" id="closeDiv" onclick='$("#Qybcbaxx_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">企业ID</td>
		<td class="detailtd"><input type="text" id="m_qyid" value="0"></td>
		<td class="distd">企业备案信息ID</td>
		<td class="detailtd"><input type="text" id="m_qybaxxid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">补备告知日期</td>
		<td class="detailtd"><input type="text" id="m_bbgzrq" value=""></td>
		<td class="distd">补备原因</td>
		<td class="detailtd"><input type="text" id="m_bbyy" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">补备完成日期</td>
		<td class="detailtd"><input type="text" id="m_bbwcrq" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td></tr>
</table>
