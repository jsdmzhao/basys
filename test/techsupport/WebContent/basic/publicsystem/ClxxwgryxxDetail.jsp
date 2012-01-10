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
		$("#cljbxxid").append(setNull(json.LClxxwgryxx[0].cljbxxid));
		$("#wgrxxid").append(setNull(json.LClxxwgryxx[0].wgrxxid));
		$("#wgrylb").append(setNull(json.LClxxwgryxx[0].wgrylb));
		$("#ywx").append(setNull(json.LClxxwgryxx[0].ywx));
		$("#ywm").append(setNull(json.LClxxwgryxx[0].ywm));
		$("#qzzldm").append(setNull(json.LClxxwgryxx[0].qzzldm));
		$("#qzzl").append(setNull(json.LClxxwgryxx[0].qzzl));
		$("#qzhm").append(setNull(json.LClxxwgryxx[0].qzhm));
		$("#zatlq").append(setNull(json.LClxxwgryxx[0].zatlq));
		$("#qfjg").append(setNull(json.LClxxwgryxx[0].qfjg));
		$("#rjrq").append(setNull(json.LClxxwgryxx[0].rjrq));
		$("#rjka").append(setNull(json.LClxxwgryxx[0].rjka));
	}	
</script>
<input type="hidden" id="q_cljbxxid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$("#Clxxwgryxx_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" cellpadding="3" cellspacing="0" class="detail" id="detail">
	<tr height="20">
		<td class="distd1">车辆基本信息ID</td>
		<td class="detailtd2"><span id="cljbxxid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">外国人信息ID</td>
		<td class="detailtd2"><span id="wgrxxid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">外国人员类别</td>
		<td class="detailtd2"><span id="wgrylb"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">英文姓</td>
		<td class="detailtd2"><span id="ywx"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">英文名</td>
		<td class="detailtd2"><span id="ywm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">签证种类代码</td>
		<td class="detailtd2"><span id="qzzldm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">签证种类</td>
		<td class="detailtd2"><span id="qzzl"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">签证号码</td>
		<td class="detailtd2"><span id="qzhm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">在华停留期至</td>
		<td class="detailtd2"><span id="zatlq"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">签发机关</td>
		<td class="detailtd2"><span id="qfjg"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">入境日期</td>
		<td class="detailtd2"><span id="rjrq"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">入境口岸</td>
		<td class="detailtd2"><span id="rjka"></span></td>
	</tr>
</table>