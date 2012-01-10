<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_anjcsbid").attr("value",aqjcsb_dataid);
		aqjcsb_setDetail();
	}); 
	function aqjcsb_updatediv (json) { 
		$("#aqjcsb_aqjcsbzlbm").append(setNull(json.LAqjcsb[0].aqjcsbzlbm));
		$("#aqjcsb_aqjcsbzlmc").append(setNull(json.LAqjcsb[0].aqjcsbzlmc));
		$("#aqjcsb_sbxh").append(setNull(json.LAqjcsb[0].sbxh));
		$("#aqjcsb_ggxh").append(setNull(json.LAqjcsb[0].ggxh));
		$("#aqjcsb_sbmc").append(setNull(json.LAqjcsb[0].sbmc));
		$("#aqjcsb_azsl").append(setNull(json.LAqjcsb[0].azsl));
	}	
</script>
<input type="hidden" id="q_anjcsbid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">安全检查设备详细信息</td>
      <td align="right" class="title1">
      <a href="#" id="closeDiv" onclick='$("#q_anjcsbid").parent().hideAndRemove("show");' class="close"></a>
      </td>
    </tr>
</table>

<table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
	<tr height="20">
		<td class="distd1" width="40%">设备名称</td>
		<td class="detailtd2" width="60%"><span id="aqjcsb_sbmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">规格型号</td>
		<td class="detailtd2"><span id="aqjcsb_ggxh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">安全检查设备种类名称</td>
		<td class="detailtd2"><span id="aqjcsb_aqjcsbzlmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">安装数量</td>
		<td class="detailtd2"><span id="aqjcsb_azsl"></span></td>
	</tr>
</table>