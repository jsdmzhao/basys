<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		daggleDiv(detailid);
		$("#q_garkktbsjid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#garkktbsjid").append(setNull(json.LQyryxxhc[0].garkktbsjid));
		$("#qyid").append(setNull(json.LQyryxxhc[0].qyid));
		$("#ryid").append(setNull(json.LQyryxxhc[0].ryid));
		$("#hcid").append(setNull(json.LQyryxxhc[0].hcid));
		$("#dsjgdm").append(setNull(json.LQyryxxhc[0].dsjgdm));
		$("#dsjgmc").append(setNull(json.LQyryxxhc[0].dsjgmc));
		$("#fxjdm").append(setNull(json.LQyryxxhc[0].fxjdm));
		$("#fxjmc").append(setNull(json.LQyryxxhc[0].fxjmc));
		$("#gxdwdm").append(setNull(json.LQyryxxhc[0].gxdwdm));
		$("#gxdwmc").append(setNull(json.LQyryxxhc[0].gxdwmc));
		$("#qybm").append(setNull(json.LQyryxxhc[0].qybm));
		$("#qymc").append(setNull(json.LQyryxxhc[0].qymc));
		$("#xm").append(setNull(json.LQyryxxhc[0].xm));
		$("#xbdm").append(setNull(json.LQyryxxhc[0].xbdm));
		$("#xb").append(setNull(json.LQyryxxhc[0].xb));
		$("#ywm").append(setNull(json.LQyryxxhc[0].ywm));
		$("#ywx").append(setNull(json.LQyryxxhc[0].ywx));
		$("#wgrjyxkz").append(setNull(json.LQyryxxhc[0].wgrjyxkz));
		$("#cyzjdm").append(setNull(json.LQyryxxhc[0].cyzjdm));
		$("#cyzj").append(setNull(json.LQyryxxhc[0].cyzj));
		$("#zjhm").append(setNull(json.LQyryxxhc[0].zjhm));
		$("#gwbh").append(setNull(json.LQyryxxhc[0].gwbh));
		$("#gemc").append(setNull(json.LQyryxxhc[0].gemc));
		$("#xmpy").append(setNull(json.LQyryxxhc[0].xmpy));
		$("#bdsj").append(setNull(json.LQyryxxhc[0].bdsj));
		$("#hcsj").append(setNull(json.LQyryxxhc[0].hcsj));
		$("#hcwt").append(setNull(json.LQyryxxhc[0].hcwt));
		$("#hcyj").append(setNull(json.LQyryxxhc[0].hcyj));
		$("#hcr").append(setNull(json.LQyryxxhc[0].hcr));
		$("#hcdw").append(setNull(json.LQyryxxhc[0].hcdw));
		$("#hcdwdm").append(setNull(json.LQyryxxhc[0].hcdwdm));
		$("#hczt").append(setNull(json.LQyryxxhc[0].hczt));
	}	
</script>
<input type="hidden" id="q_garkktbsjid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$("#Qyryxxhc_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" cellpadding="3" cellspacing="0" class="detail" id="detail">
	<tr height="20">
		<td class="distd1">公安人口库同步数据ID</td>
		<td class="detailtd2"><span id="garkktbsjid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">企业ID</td>
		<td class="detailtd2"><span id="qyid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">从业人员ID</td>
		<td class="detailtd2"><span id="ryid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">核查ID</td>
		<td class="detailtd2"><span id="hcid"></span></td>
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
		<td class="distd1">姓名</td>
		<td class="detailtd2"><span id="xm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">性别代码</td>
		<td class="detailtd2"><span id="xbdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">性别</td>
		<td class="detailtd2"><span id="xb"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">英文名</td>
		<td class="detailtd2"><span id="ywm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">英文姓</td>
		<td class="detailtd2"><span id="ywx"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">外国人就业许可证号</td>
		<td class="detailtd2"><span id="wgrjyxkz"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">常用证件代码</td>
		<td class="detailtd2"><span id="cyzjdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">常用证件</td>
		<td class="detailtd2"><span id="cyzj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">证件号码</td>
		<td class="detailtd2"><span id="zjhm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">岗位编号</td>
		<td class="detailtd2"><span id="gwbh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">岗位名称</td>
		<td class="detailtd2"><span id="gemc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">姓名拼音</td>
		<td class="detailtd2"><span id="xmpy"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">比对时间</td>
		<td class="detailtd2"><span id="bdsj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">核查时间</td>
		<td class="detailtd2"><span id="hcsj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">核查问题</td>
		<td class="detailtd2"><span id="hcwt"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">核查意见</td>
		<td class="detailtd2"><span id="hcyj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">核查人</td>
		<td class="detailtd2"><span id="hcr"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">核查单位</td>
		<td class="detailtd2"><span id="hcdw"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">核查单位代码</td>
		<td class="detailtd2"><span id="hcdwdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">核查状态</td>
		<td class="detailtd2"><span id="hczt"></span></td>
	</tr>
</table>