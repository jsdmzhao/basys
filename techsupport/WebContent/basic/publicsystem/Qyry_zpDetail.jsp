<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		daggleDiv(detailid);
		$("#q_qyid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#qyid").append(setNull(json.LQyry_zp[0].qyid));
		$("#ryid").append(setNull(json.LQyry_zp[0].ryid));
		$("#zpid").append(setNull(json.LQyry_zp[0].zpid));
		$("#tpmc").append(setNull(json.LQyry_zp[0].tpmc));
		$("#tplx").append(setNull(json.LQyry_zp[0].tplx));
		$("#tpnr").append(setNull(json.LQyry_zp[0].tpnr));
	}	
</script>
<input type="hidden" id="q_qyid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$("#Qyry_zp_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" cellpadding="3" cellspacing="0" class="detail" id="detail">
	<tr height="20">
		<td class="distd1">企业ID</td>
		<td class="detailtd2"><span id="qyid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">从业人员ID</td>
		<td class="detailtd2"><span id="ryid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">照片ID</td>
		<td class="detailtd2"><span id="zpid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">图片名称</td>
		<td class="detailtd2"><span id="tpmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">图片类型</td>
		<td class="detailtd2"><span id="tplx"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">图片内容</td>
		<td class="detailtd2"><span id="tpnr"></span></td>
	</tr>
</table>