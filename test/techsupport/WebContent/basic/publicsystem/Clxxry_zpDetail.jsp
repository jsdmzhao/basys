<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		daggleDiv(detailid);
		$("#q_cljbxxid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#cljbxxid").append(setNull(json.LClxxry_zp[0].cljbxxid));
		$("#clxxryzpid").append(setNull(json.LClxxry_zp[0].clxxryzpid));
		$("#tpmc").append(setNull(json.LClxxry_zp[0].tpmc));
		$("#tplx").append(setNull(json.LClxxry_zp[0].tplx));
		$("#tpnr").append(setNull(json.LClxxry_zp[0].tpnr));
	}	
</script>
<input type="hidden" id="q_cljbxxid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$("#Clxxry_zp_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" cellpadding="3" cellspacing="0" class="detail" id="detail">
	<tr height="20">
		<td class="distd1">车辆基本信息ID</td>
		<td class="detailtd2"><span id="cljbxxid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">车辆信息人员照片ID</td>
		<td class="detailtd2"><span id="clxxryzpid"></span></td>
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