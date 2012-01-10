<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_bjxxid2").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#bjxxid2").append(setNull(json.LBksjkz[0].bjxxid2));
		$("#bkwpjbxxkzid").append(setNull(json.LBksjkz[0].bkwpjbxxkzid));
		$("#bksjkzid").append(setNull(json.LBksjkz[0].bksjkzid));
		$("#sjch").append(setNull(json.LBksjkz[0].sjch));
		$("#pp").append(setNull(json.LBksjkz[0].pp));
		$("#xh").append(setNull(json.LBksjkz[0].xh));
		$("#ys").append(setNull(json.LBksjkz[0].ys));
	}	
</script>
<input type="hidden" id="q_bjxxid2">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td ><a href="#" id="closeDiv" onclick='$("#Bksjkz_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="detail">
	<tr height="20">
		<td class="distd1">报警信息ID</td>
		<td class="detailtd2"><span id="bjxxid2"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">布控物品基本信息快照ID</td>
		<td class="detailtd2"><span id="bkwpjbxxkzid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">布控手机快照ID</td>
		<td class="detailtd2"><span id="bksjkzid"></span></td>
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