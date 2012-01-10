<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_bjxxid2").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#bjxxid2").append(setNull(json.LSjbdqxxkz[0].bjxxid2));
		$("#sjbdqxxkzid").append(setNull(json.LSjbdqxxkz[0].sjbdqxxkzid));
		$("#xzqhbm").append(setNull(json.LSjbdqxxkz[0].xzqhbm));
		$("#xzqh").append(setNull(json.LSjbdqxxkz[0].xzqh));
		$("#sjch").append(setNull(json.LSjbdqxxkz[0].sjch));
		$("#pp").append(setNull(json.LSjbdqxxkz[0].pp));
		$("#xh").append(setNull(json.LSjbdqxxkz[0].xh));
		$("#ys").append(setNull(json.LSjbdqxxkz[0].ys));
		$("#ajjbbm").append(setNull(json.LSjbdqxxkz[0].ajjbbm));
		$("#ajjb").append(setNull(json.LSjbdqxxkz[0].ajjb));
		$("#ajlbbm").append(setNull(json.LSjbdqxxkz[0].ajlbbm));
		$("#ajlb").append(setNull(json.LSjbdqxxkz[0].ajlb));
		$("#jyaq").append(setNull(json.LSjbdqxxkz[0].jyaq));
		$("#djrq").append(setNull(json.LSjbdqxxkz[0].djrq));
		$("#djr").append(setNull(json.LSjbdqxxkz[0].djr));
		$("#ladqbm").append(setNull(json.LSjbdqxxkz[0].ladqbm));
		$("#ladq").append(setNull(json.LSjbdqxxkz[0].ladq));
		$("#badwbm").append(setNull(json.LSjbdqxxkz[0].badwbm));
		$("#badw").append(setNull(json.LSjbdqxxkz[0].badw));
		$("#tbr").append(setNull(json.LSjbdqxxkz[0].tbr));
		$("#lxr").append(setNull(json.LSjbdqxxkz[0].lxr));
		$("#lxfs").append(setNull(json.LSjbdqxxkz[0].lxfs));
		$("#lxrsfhm").append(setNull(json.LSjbdqxxkz[0].lxrsfhm));
	}	
</script>
<input type="hidden" id="q_bjxxid2">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td ><a href="#" id="closeDiv" onclick='$("#Sjbdqxxkz_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="detail">
	<tr height="20">
		<td class="distd1">报警信息ID</td>
		<td class="detailtd2"><span id="bjxxid2"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">手机被盗抢信息快照ID</td>
		<td class="detailtd2"><span id="sjbdqxxkzid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">行政区划编码</td>
		<td class="detailtd2"><span id="xzqhbm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">行政区划</td>
		<td class="detailtd2"><span id="xzqh"></span></td>
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
	<tr height="20">
		<td class="distd1">案件级别编码</td>
		<td class="detailtd2"><span id="ajjbbm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">案件级别</td>
		<td class="detailtd2"><span id="ajjb"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">案件类别编码</td>
		<td class="detailtd2"><span id="ajlbbm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">案件类别</td>
		<td class="detailtd2"><span id="ajlb"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">简要案情</td>
		<td class="detailtd2"><span id="jyaq"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">登记日期</td>
		<td class="detailtd2"><span id="djrq"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">登记人</td>
		<td class="detailtd2"><span id="djr"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">立案地区编码</td>
		<td class="detailtd2"><span id="ladqbm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">立案地区</td>
		<td class="detailtd2"><span id="ladq"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">办案单位编码</td>
		<td class="detailtd2"><span id="badwbm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">办案单位</td>
		<td class="detailtd2"><span id="badw"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">填表人</td>
		<td class="detailtd2"><span id="tbr"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">联系人</td>
		<td class="detailtd2"><span id="lxr"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">联系方式</td>
		<td class="detailtd2"><span id="lxfs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">联系人身份号码</td>
		<td class="detailtd2"><span id="lxrsfhm"></span></td>
	</tr>
</table>