<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_bjxxid2").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#bjxxid2").append(setNull(json.LBkclkz[0].bjxxid2));
		$("#bkwpjbxxkzid").append(setNull(json.LBkclkz[0].bkwpjbxxkzid));
		$("#bkclkzid").append(setNull(json.LBkclkz[0].bkclkzid));
		$("#cllxdm").append(setNull(json.LBkclkz[0].cllxdm));
		$("#cllx").append(setNull(json.LBkclkz[0].cllx));
		$("#clpp").append(setNull(json.LBkclkz[0].clpp));
		$("#clxh").append(setNull(json.LBkclkz[0].clxh));
		$("#hpzldm").append(setNull(json.LBkclkz[0].hpzldm));
		$("#hpzl").append(setNull(json.LBkclkz[0].hpzl));
		$("#hphm").append(setNull(json.LBkclkz[0].hphm));
		$("#csys").append(setNull(json.LBkclkz[0].csys));
		$("#syr").append(setNull(json.LBkclkz[0].syr));
		$("#ccdjrq").append(setNull(json.LBkclkz[0].ccdjrq));
		$("#fdjh").append(setNull(json.LBkclkz[0].fdjh));
		$("#clsbdh").append(setNull(json.LBkclkz[0].clsbdh));
		$("#cjh").append(setNull(json.LBkclkz[0].cjh));
	}	
</script>
<input type="hidden" id="q_bjxxid2">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td ><a href="#" id="closeDiv" onclick='$("#Bkclkz_detail").hideAndRemove("show");' class="close"></a></td>
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
		<td class="distd1">布控车辆快照ID</td>
		<td class="detailtd2"><span id="bkclkzid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">车辆类型代码</td>
		<td class="detailtd2"><span id="cllxdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">车辆类型</td>
		<td class="detailtd2"><span id="cllx"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">车辆品牌</td>
		<td class="detailtd2"><span id="clpp"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">车辆型号</td>
		<td class="detailtd2"><span id="clxh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">号牌种类代码</td>
		<td class="detailtd2"><span id="hpzldm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">号牌种类</td>
		<td class="detailtd2"><span id="hpzl"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">号牌号码</td>
		<td class="detailtd2"><span id="hphm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">车身颜色</td>
		<td class="detailtd2"><span id="csys"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">机动车所有人</td>
		<td class="detailtd2"><span id="syr"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">初次登记时间</td>
		<td class="detailtd2"><span id="ccdjrq"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">发动机号</td>
		<td class="detailtd2"><span id="fdjh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">车辆识别代号</td>
		<td class="detailtd2"><span id="clsbdh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">车架号</td>
		<td class="detailtd2"><span id="cjh"></span></td>
	</tr>
</table>