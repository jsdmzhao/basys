<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_anjcsbid").attr("value",aqjcsb_dataid);
		aqjcsb_setDetail();
	}); 
	function aqjcsb_updatediv (json) { 
	    $("#aqjcsb_sbmc").append(setNull(json.LAqjcsb[0].sbmc));
	    $("#aqjcsb_ggxh").append(setNull(json.LAqjcsb[0].ggxh));
		$("#aqjcsb_aqjcsbzlmc").append(setNull(json.LAqjcsb[0].aqjcsbzlmc));
		$("#aqjcsb_lrr").append(setNull(json.LAqjcsb[0].lrr));
		$("#aqjcsb_lrsj").append(setNull(json.LAqjcsb[0].lrsj));
		$("#aqjcsb_azsl").append(setNull(json.LAqjcsb[0].azsl));
		$("#aqjcsb_bz").append(setNull(json.LAqjcsb[0].bz));
	}	
	
	
	function aqjksb_updatediv (json) { 
		var sourceVal;
		$("#aqjcsb_sbmc").append(setNull(json.find("td:nth(2)").html()));
	    $("#aqjcsb_ggxh").append(setNull(json.find("td:nth(3)").html()));
		$("#aqjcsb_aqjcsbzlmc").append(setNull(json.find("td:nth(4)").html()));
		$("#aqjcsb_lrr").append(setNull(json.find("td:nth(6)").html()));
		$("#aqjcsb_lrsj").append(setNull(json.find("td:nth(7)").html()));
		$("#aqjcsb_azsl").append(setNull(json.find("td:nth(5)").html()));
		$("#aqjcsb_bz").append(setNull(json.find("td:nth(8)").html()));
	}	
</script>
<input type="hidden" id="q_anjcsbid">
<span id="closeFlag"></span>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">技防设备明细</td>
      <td align="right" >
      <a href="#" id="closeDiv" onclick='$("#closeFlag").parent().hideAndRemove("show");' class="close"></a>
      </td>
    </tr>
</table>

<table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
	<tr height="20">
	    <td class="distd1" width="12%">设备名称</td>
		<td class="detailtd2" width="21%"><span id="aqjcsb_sbmc"></span></td>
		<td class="distd1" width="11%">规格型号</td>
		<td class="detailtd2" width="22%"><span id="aqjcsb_ggxh"></span></td>
		<td class="distd1" width="13%">安全检查设备种类名称</td>
		<td class="detailtd2" width="21%"><span id="aqjcsb_aqjcsbzlmc"></span></td>
	</tr>
	<tr height="20">
	    <td class="distd1">数量</td>
		<td class="detailtd2"><span id="aqjcsb_azsl"></span></td>
		<td class="distd1">填报人</td>
		<td class="detailtd2"><span id="aqjcsb_lrr"></span></td>
		<td class="distd1">填报时间</td>
		<td class="detailtd2"><span id="aqjcsb_lrsj"></span></td>
	</tr>
	<tr height="20">
	    <td class="distd1">备注</td>
		<td class="detailtd2" colspan="5"  style="width:681px"><span id="aqjcsb_bz"></span></td>
	</tr>
</table>