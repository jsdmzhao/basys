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
		$("#m_qyid").attr("value",setNull(json.LQyry_zp[0].qyid));
		$("#m_ryid").attr("value",setNull(json.LQyry_zp[0].ryid));
		$("#m_zpid").attr("value",setNull(json.LQyry_zp[0].zpid));
		$("#m_tpmc").attr("value",setNull(json.LQyry_zp[0].tpmc));
		$("#m_tplx").attr("value",setNull(json.LQyry_zp[0].tplx));
		$("#m_tpnr").attr("value",setNull(json.LQyry_zp[0].tpnr));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_qyid","Integer",-9999999999,9999999999,null,0,"企业ID"))
			return false;
		if (!checkControlValue("m_ryid","Integer",-9999999999,9999999999,null,0,"从业人员ID"))
			return false;
		if (!checkControlValue("m_zpid","Integer",-9999999999,9999999999,null,0,"照片ID"))
			return false;
		if (!checkControlValue("m_tpmc","String",1,100,null,0,"图片名称"))
			return false;
		if (!checkControlValue("m_tplx","String",1,40,null,0,"图片类型"))
			return false;
		if (!checkControlValue("m_tpnr","byte[]",,,,0,"图片内容"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_qyid">
<input type="hidden" id="m_qyid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td ><a href="#" id="closeDiv" onclick='$("#Qyry_zp_detail").hideAndRemove("show");' class="close"></a></td>
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
		<td class="distd">照片ID</td>
		<td class="detailtd"><input type="text" id="m_zpid" value="0"></td>
		<td class="distd">图片名称</td>
		<td class="detailtd"><input type="text" id="m_tpmc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">图片类型</td>
		<td class="detailtd"><input type="text" id="m_tplx" value=""></td>
		<td class="distd">图片内容</td>
		<td class="detailtd"><input type="text" id="m_tpnr" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td></tr>
</table>
