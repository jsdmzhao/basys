<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_bjgzid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#bjgzid").append(setNull(json.LDxbj[0].bjgzid));
		$("#bjxxid").append(setNull(json.LDxbj[0].bjxxid));
		$("#dxbjid").append(setNull(json.LDxbj[0].dxbjid));
		$("#dxhm").append(setNull(json.LDxbj[0].dxhm));
		$("#dycfssj").append(setNull(json.LDxbj[0].dycfssj));
		$("#zhycfssj").append(setNull(json.LDxbj[0].zhycfssj));
		$("#fscs").append(setNull(json.LDxbj[0].fscs));
		$("#dxzt").append(setNull(json.LDxbj[0].dxzt));
		$("#dxnr").append(setNull(json.LDxbj[0].dxnr));
	}	
</script>
<input type="hidden" id="q_bjgzid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#ylcsjbxx_detail&quot;).hideAndRemove(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>
<table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
	<tr height="20">
		<td class="detailtd2">报警规则ID</td>
		<td class="detailtd1"><span id="bjgzid"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">报警信息ID</td>
		<td class="detailtd1"><span id="bjxxid"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">短信报警ID</td>
		<td class="detailtd1"><span id="dxbjid"></span></td>
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