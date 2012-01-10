<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		daggleDiv(detailid);
		$("#q_rybtjid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#rybtjid").append(setNull(json.LRylbtj[0].rybtjid));
		$("#hylbdm").append(setNull(json.LRylbtj[0].hylbdm));
		$("#hylb").append(setNull(json.LRylbtj[0].hylb));
		$("#dsjgdm").append(setNull(json.LRylbtj[0].dsjgdm));
		$("#dsjgmc").append(setNull(json.LRylbtj[0].dsjgmc));
		$("#fxjdm").append(setNull(json.LRylbtj[0].fxjdm));
		$("#fxjmc").append(setNull(json.LRylbtj[0].fxjmc));
		$("#gxdwdm").append(setNull(json.LRylbtj[0].gxdwdm));
		$("#gxdwmc").append(setNull(json.LRylbtj[0].gxdwmc));
		$("#qybm").append(setNull(json.LRylbtj[0].qybm));
		$("#qymc").append(setNull(json.LRylbtj[0].qymc));
		$("#glry").append(setNull(json.LRylbtj[0].glry));
		$("#fddbr").append(setNull(json.LRylbtj[0].fddbr));
		$("#zygdzcry").append(setNull(json.LRylbtj[0].zygdzcry));
		$("#zafzr").append(setNull(json.LRylbtj[0].zafzr));
		$("#qtglry").append(setNull(json.LRylbtj[0].qtglry));
		$("#fwry").append(setNull(json.LRylbtj[0].fwry));
		$("#ybfwry").append(setNull(json.LRylbtj[0].ybfwry));
		$("#lsfwry").append(setNull(json.LRylbtj[0].lsfwry));
		$("#yyry").append(setNull(json.LRylbtj[0].yyry));
		$("#qtfwry").append(setNull(json.LRylbtj[0].qtfwry));
		$("#bary").append(setNull(json.LRylbtj[0].bary));
		$("#aqjcry").append(setNull(json.LRylbtj[0].aqjcry));
		$("#qt").append(setNull(json.LRylbtj[0].qt));
		$("#hj").append(setNull(json.LRylbtj[0].hj));
	}	
</script>
<input type="hidden" id="q_rybtjid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$("#Rylbtj_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" cellpadding="3" cellspacing="0" class="detail" id="detail">
	<tr height="20">
		<td class="distd1">人员类别统计ID</td>
		<td class="detailtd2"><span id="rybtjid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">行业类别代码</td>
		<td class="detailtd2"><span id="hylbdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">行业类别</td>
		<td class="detailtd2"><span id="hylb"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">地市机关代码</td>
		<td class="detailtd2"><span id="dsjgdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">地市机关名称</td>
		<td class="detailtd2"><span id="dsjgmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">分县局代码</td>
		<td class="detailtd2"><span id="fxjdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">分县局名称</td>
		<td class="detailtd2"><span id="fxjmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">管辖单位代码</td>
		<td class="detailtd2"><span id="gxdwdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">管辖单位名称</td>
		<td class="detailtd2"><span id="gxdwmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">企业编码</td>
		<td class="detailtd2"><span id="qybm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">企业名称</td>
		<td class="detailtd2"><span id="qymc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">管理人员</td>
		<td class="detailtd2"><span id="glry"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">法定代表人或主要负责人</td>
		<td class="detailtd2"><span id="fddbr"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">主要股东组成人员</td>
		<td class="detailtd2"><span id="zygdzcry"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">治安负责人</td>
		<td class="detailtd2"><span id="zafzr"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">其他管理人员</td>
		<td class="detailtd2"><span id="qtglry"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">服务人员</td>
		<td class="detailtd2"><span id="fwry"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">一般服务人员</td>
		<td class="detailtd2"><span id="ybfwry"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">临时服务人员</td>
		<td class="detailtd2"><span id="lsfwry"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">演艺人员</td>
		<td class="detailtd2"><span id="yyry"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">其他服务人员</td>
		<td class="detailtd2"><span id="qtfwry"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">保安人员</td>
		<td class="detailtd2"><span id="bary"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">安全检查人员</td>
		<td class="detailtd2"><span id="aqjcry"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">其他</td>
		<td class="detailtd2"><span id="qt"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">合计</td>
		<td class="detailtd2"><span id="hj"></span></td>
	</tr>
</table>