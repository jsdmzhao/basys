<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_bkwpjbxxid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#bkwpjbxxid").append(setNull(json.LBksj[0].bkwpjbxxid));
		$("#bksjid").append(setNull(json.LBksj[0].bksjid));
		$("#sjch").append(setNull(json.LBksj[0].sjch));
		$("#pp").append(setNull(json.LBksj[0].pp));
		$("#xh").append(setNull(json.LBksj[0].xh));
		$("#ys").append(setNull(json.LBksj[0].ys));
	}	
</script>
<input type="hidden" id="q_bkwpjbxxid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td ><a href="#" id="closeDiv" onclick='$("#Bksj_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="detail">
	<tr height="20">
		<td class="distd1">布控物品基本信息ID</td>
		<td class="detailtd2"><span id="bkwpjbxxid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">布控手机ID</td>
		<td class="detailtd2"><span id="bksjid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">手机串号</td>
		<td class="detailtd2"><span id="sjch"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">品牌</td>
		<td class="detailtd2"><span id="pp"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">型号</td>
		<td class="detailtd2"><span id="xh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">颜色</td>
		<td class="detailtd2"><span id="ys"></span></td>
	</tr>
</table>