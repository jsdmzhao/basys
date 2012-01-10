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
	}); 
	function updatediv (json) { 
		$("#m_qyid").attr("value",setNull(json.LPmt[0].qyid));
		$("#m_pmtid").attr("value",setNull(json.LPmt[0].pmtid));
		$("#m_pmtlxdm").attr("value",setNull(json.LPmt[0].pmtlxdm));
		$("#m_pmtlxmc").attr("value",setNull(json.LPmt[0].pmtlxmc));
		$("#m_pmtz").attr("value",setNull(json.LPmt[0].pmtz));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_qyid","Integer",-9999999999,9999999999,null,0,"企业ID"))
			return false;
		if (!checkControlValue("m_pmtid","Integer",-9999999999,9999999999,null,0,"平面图ID"))
			return false;
		if (!checkControlValue("m_pmtlxdm","String",1,40,null,0,"平面图类型代码"))
			return false;
		if (!checkControlValue("m_pmtlxmc","String",1,100,null,0,"平面图类型名称"))
			return false;
		if (!checkControlValue("m_pmtz","byte[]",,,,0,"平面图纸"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_qyid">
<input type="hidden" id="m_qyid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td ><a href="#" id="closeDiv" onclick='$("#Pmt_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">企业ID</td>
		<td class="detailtd"><input type="text" id="m_qyid" value="0"></td>
		<td class="distd">平面图ID</td>
		<td class="detailtd"><input type="text" id="m_pmtid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">平面图类型代码</td>
		<td class="detailtd"><input type="text" id="m_pmtlxdm" value=""></td>
		<td class="distd">平面图类型名称</td>
		<td class="detailtd"><input type="text" id="m_pmtlxmc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">平面图纸</td>
		<td class="detailtd"><input type="text" id="m_pmtz" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td></tr>
</table>
