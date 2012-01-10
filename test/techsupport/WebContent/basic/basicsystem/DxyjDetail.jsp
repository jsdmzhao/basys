<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_yjgzid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#yjgzid").append(setNull(json.LDxyj[0].yjgzid));
		$("#yjxxid").append(setNull(json.LDxyj[0].yjxxid));
		$("#dxyjid").append(setNull(json.LDxyj[0].dxyjid));
		$("#dxhm").append(setNull(json.LDxyj[0].dxhm));
		$("#dycfssj").append(setNull(json.LDxyj[0].dycfssj));
		$("#zhycfssj").append(setNull(json.LDxyj[0].zhycfssj));
		$("#fscs").append(setNull(json.LDxyj[0].fscs));
		$("#dxzt").append(setNull(json.LDxyj[0].dxzt));
		$("#dxnr").append(setNull(json.LDxyj[0].dxnr));
	}	
</script>
<input type="hidden" id="q_yjgzid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#ylcsjbxx_detail&quot;).hideAndRemove(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>
<table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
	<tr height="20">
		<td class="detailtd2">预警规则ID</td>
		<td class="detailtd1"><span id="yjgzid"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">预警信息ID</td>
		<td class="detailtd1"><span id="yjxxid"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">短信预警ID</td>
		<td class="detailtd1"><span id="dxyjid"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">短信号码</td>
		<td class="detailtd1"><span id="dxhm"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">第一次发送时间</td>
		<td class="detailtd1"><span id="dycfssj"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">最后一次发送时间</td>
		<td class="detailtd1"><span id="zhycfssj"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">发送次数</td>
		<td class="detailtd1"><span id="fscs"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">短信状态</td>
		<td class="detailtd1"><span id="dxzt"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">短信内容</td>
		<td class="detailtd1"><span id="dxnr"></span></td>
	</tr>
</table>