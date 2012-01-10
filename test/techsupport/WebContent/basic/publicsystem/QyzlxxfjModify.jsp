<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_qyzlxxfjid").attr("value",dataid);
		$("#m_qyzlxxfjid").attr("value",dataid);
		setDetail();
	}); 
	function updatediv (json) { 
		$("#m_qyzlxxfjid").attr("value",setNull(json.LQyzlxxfj[0].qyzlxxfjid));
		$("#m_qyzlxxid").attr("value",setNull(json.LQyzlxxfj[0].qyzlxxid));
		$("#m_fjmc").attr("value",setNull(json.LQyzlxxfj[0].fjmc));
		$("#m_fjlx").attr("value",setNull(json.LQyzlxxfj[0].fjlx));
		$("#m_fjnr").attr("value",setNull(json.LQyzlxxfj[0].fjnr));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_qyzlxxfjid","Integer",-9999999999,9999999999,null,0,"企业质量信息附件ID"))
			return false;
		if (!checkControlValue("m_qyzlxxid","Integer",-9999999999,9999999999,null,0,"企业质量信息ID"))
			return false;
		if (!checkControlValue("m_fjmc","String",1,100,null,0,"附件名称"))
			return false;
		if (!checkControlValue("m_fjlx","String",1,60,null,0,"附件类型"))
			return false;
		if (!checkControlValue("m_fjnr","byte[]",,,,0,"附件内容"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_qyzlxxfjid">
<input type="hidden" id="m_qyzlxxfjid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#qyzlxxfj_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">企业质量信息附件ID</td>
		<td class="detailtd"><input type="text" id="m_qyzlxxfjid" class="inputstyle" value="0"></td>
		<td class="distd">企业质量信息ID</td>
		<td class="detailtd"><input type="text" id="m_qyzlxxid" class="inputstyle" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">附件名称</td>
		<td class="detailtd"><input type="text" id="m_fjmc" class="inputstyle" value=""></td>
		<td class="distd">附件类型</td>
		<td class="detailtd"><input type="text" id="m_fjlx" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">附件内容</td>
		<td class="detailtd"><input type="text" id="m_fjnr" class="inputstyle" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td></tr>
</table>
