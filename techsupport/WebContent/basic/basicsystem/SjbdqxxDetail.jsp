<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_sjbdqxxid").attr("value",dataid);
		setDetail();
	}); 
		
	function updatediv (json) { 
		$("#sjbdqxxid").append(setNull(json.LSjbdqxx[0].sjbdqxxid));
		$("#xzqhbm").append(setNull(json.LSjbdqxx[0].xzqhbm));
		$("#xzqh").append(setNull(json.LSjbdqxx[0].xzqh));
		$("#sjch").append(setNull(json.LSjbdqxx[0].sjch));
		$("#pp").append(setNull(json.LSjbdqxx[0].pp));
		$("#xh").append(setNull(json.LSjbdqxx[0].xh));
		$("#ys").append(setNull(json.LSjbdqxx[0].ys));
		$("#ajjbbm").append(setNull(json.LSjbdqxx[0].ajjbbm));
		$("#ajjb").append(setNull(json.LSjbdqxx[0].ajjb));
		$("#ajlbbm").append(setNull(json.LSjbdqxx[0].ajlbbm));
		$("#ajlb").append(setNull(json.LSjbdqxx[0].ajlb));
		$("#jyaq").append(setNull(json.LSjbdqxx[0].jyaq));
		$("#djrq").append(setNull(json.LSjbdqxx[0].djrq).substr(0,10));
		$("#djr").append(setNull(json.LSjbdqxx[0].djr));
		$("#ladqbm").append(setNull(json.LSjbdqxx[0].ladqbm));
		$("#ladq").append(setNull(json.LSjbdqxx[0].ladq));
		$("#badwbm").append(setNull(json.LSjbdqxx[0].badwbm));
		$("#badw").append(setNull(json.LSjbdqxx[0].badw));
		$("#tbr").append(setNull(json.LSjbdqxx[0].tbr));
		$("#lxr").append(setNull(json.LSjbdqxx[0].lxr));
		$("#lxfs").append(setNull(json.LSjbdqxx[0].lxfs));
		$("#lxrsfhm").append(setNull(json.LSjbdqxx[0].lxrsfhm));
	}	
</script>
<input type="hidden" id="q_sjbdqxxid">

<span id="closeFlag"></span>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">&nbsp;明细</td>
      <td align="right" class="title1">
      <a href="#" id="closeDiv" onclick='$("#closeFlag").parent().hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="2" class="detail">
	<tr height="20">
		<td width="18%" class="distd1">手机串号</td>
		<td width="34%" class="detailtd2" width="190px"><span id="sjch"></span></td>
		<td width="15%" class="distd1">品牌</td>
		<td width="33%" class="detailtd2" width="190px"><span id="pp"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">颜色</td>
		<td class="detailtd2" width="190px"><span id="ys"></span></td>
		<td class="distd1">型号</td>
		<td class="detailtd2" width="190px"><span id="xh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">行政区划</td>
		<td class="detailtd2" width="190px"><span id="xzqh"></span></td>
		<td class="distd1">立案地区</td>
		<td class="detailtd2" width="190px"><span id="ladq"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">案件类别</td>
		<td class="detailtd2" width="190px"><span id="ajlb"></span></td>
		<td class="distd1">填表人</td>
		<td class="detailtd2" width="190px"><span id="tbr"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">联系人</td>
		<td class="detailtd2" width="190px"><span id="lxr"></span></td>
		<td class="distd1">联系人身份号码</td>
		<td class="detailtd2" width="190px"><span id="lxrsfhm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">联系方式</td>
		<td class="detailtd2" colspan="3" width="470px"><span id="lxfs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1" valign="top">简要案情</td>
		<td class="detailtd2" colspan="3" width="470px"><span id="jyaq"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">办案单位</td>
		<td class="detailtd2" colspan="3" width="470px"><span id="badw"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">登记人</td>
		<td class="detailtd2" width="190px"><span id="djr"></span></td>
		<td class="distd1">登记日期</td>
		<td class="detailtd2" width="190px"><span id="djrq"></span></td>
	</tr>
</table>