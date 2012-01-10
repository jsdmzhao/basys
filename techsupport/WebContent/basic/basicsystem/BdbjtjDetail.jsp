<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_bdbjtjid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#bdbjtjid").append(setNull(json.LBdbjtj[0].bdbjtjid));
		$("#hylbdm").append(setNull(json.LBdbjtj[0].hylbdm));
		$("#hylb").append(setNull(json.LBdbjtj[0].hylb));
		$("#tjrq").append(setNull(json.LBdbjtj[0].tjrq));
		$("#dsjgdm").append(setNull(json.LBdbjtj[0].dsjgdm));
		$("#dsjgmc").append(setNull(json.LBdbjtj[0].dsjgmc));
		$("#fxjdm").append(setNull(json.LBdbjtj[0].fxjdm));
		$("#fxjmc").append(setNull(json.LBdbjtj[0].fxjmc));
		$("#gxdwmc").append(setNull(json.LBdbjtj[0].gxdwmc));
		$("#gxdwdm").append(setNull(json.LBdbjtj[0].gxdwdm));
		$("#csbm").append(setNull(json.LBdbjtj[0].csbm));
		$("#csmc").append(setNull(json.LBdbjtj[0].csmc));
		$("#clbjcs").append(setNull(json.LBdbjtj[0].clbjcs));
		$("#cyrybjcs").append(setNull(json.LBdbjtj[0].cyrybjcs));
		$("#scrybjcs").append(setNull(json.LBdbjtj[0].scrybjcs));
		$("#kyclbjcs").append(setNull(json.LBdbjtj[0].kyclbjcs));
	}	
</script>
<input type="hidden" id="q_bdbjtjid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$("#Bdbjtj_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" cellpadding="3" cellspacing="0" class="detail" id="detail">
	<tr height="20">
		<td class="distd1">比对报警统计ID</td>
		<td class="detailtd2"><span id="bdbjtjid"></span></td>
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
		<td class="distd1">统计日期</td>
		<td class="detailtd2"><span id="tjrq"></span></td>
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
		<td class="distd1">管辖单位名称</td>
		<td class="detailtd2"><span id="gxdwmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">管辖单位代码</td>
		<td class="detailtd2"><span id="gxdwdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">场所编码</td>
		<td class="detailtd2"><span id="csbm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">场所名称</td>
		<td class="detailtd2"><span id="csmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">车辆报警次数</td>
		<td class="detailtd2"><span id="clbjcs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">从业人员报警次数</td>
		<td class="detailtd2"><span id="cyrybjcs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">涉车人员报警次数</td>
		<td class="detailtd2"><span id="scrybjcs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">可疑车辆报警次数</td>
		<td class="detailtd2"><span id="kyclbjcs"></span></td>
	</tr>
</table>