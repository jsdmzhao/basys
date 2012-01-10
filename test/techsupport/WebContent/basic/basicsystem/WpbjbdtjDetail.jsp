<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_bjxxid2").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#bjxxid2").append(setNull(json.LWpbjbdtj[0].bjxxid2));
		$("#wpbjgzid").append(setNull(json.LWpbjbdtj[0].wpbjgzid));
		$("#wpbjbdtjid").append(setNull(json.LWpbjbdtj[0].wpbjbdtjid));
		$("#tjlx").append(setNull(json.LWpbjbdtj[0].tjlx));
		$("#ywbzdm").append(setNull(json.LWpbjbdtj[0].ywbzdm));
		$("#bdbzdm").append(setNull(json.LWpbjbdtj[0].bdbzdm));
		$("#bdgx").append(setNull(json.LWpbjbdtj[0].bdgx));
		$("#gxc").append(setNull(json.LWpbjbdtj[0].gxc));
		$("#zxsx").append(setNull(json.LWpbjbdtj[0].zxsx));
		$("#ljgx").append(setNull(json.LWpbjbdtj[0].ljgx));
		$("#jibie").append(setNull(json.LWpbjbdtj[0].jibie));
	}	
</script>
<input type="hidden" id="q_bjxxid2">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td ><a href="#" id="closeDiv" onclick='$("#Wpbjbdtj_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="detail">
	<tr height="20">
		<td class="distd1">报警信息ID</td>
		<td class="detailtd2"><span id="bjxxid2"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">物品报警规则ID</td>
		<td class="detailtd2"><span id="wpbjgzid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">物品报警比对条件ID</td>
		<td class="detailtd2"><span id="wpbjbdtjid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">条件类型</td>
		<td class="detailtd2"><span id="tjlx"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">业务表字段名</td>
		<td class="detailtd2"><span id="ywbzdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">比对表字段名</td>
		<td class="detailtd2"><span id="bdbzdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">比对关系</td>
		<td class="detailtd2"><span id="bdgx"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">关系串</td>
		<td class="detailtd2"><span id="gxc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">执行顺序</td>
		<td class="detailtd2"><span id="zxsx"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">逻辑关系</td>
		<td class="detailtd2"><span id="ljgx"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">级别</td>
		<td class="detailtd2"><span id="jibie"></span></td>
	</tr>
</table>