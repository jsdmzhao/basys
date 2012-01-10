<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		
	}); 
	
	function updatediv_bwryxx(json) { 
		$("#bwry_xm").append(setNull(json.find("td:nth(0)").html()));
		$("#bwry_gmsfhm").append(setNull(json.find("td:nth(1)").html()));
		$("#bwry_hjdxzqh").append(setNull(json.find("td:nth(2)").html()));
		$("#bwry_hjdxzqhdm").append(setNull(json.find("td:nth(5)").html()));
		$("#bwry_hjdxz").append(setNull(json.find("td:nth(3)").html()));
		$("#bwry_sgrq").append(setNull(json.find("td:nth(4)").html()));
		$("#bwry_lrr").append(setNull(json.find("td:nth(6)").html()));
		$("#bwry_lrsj").append(setNull(json.find("td:nth(7)").html()));
		var bwryBz = setNull(json.find("td:nth(8)").html());
		bwryBz.replace(/(&nbsp;)/g,'');
		$("#bwry_bz").append(bwryBz);
	}	

	/*
	function updatediv (json) { 
		$("#qyid").append(setNull(json.LBwryxx[0].qyid));
		$("#bwryid").append(setNull(json.LBwryxx[0].bwryid));
		$("#xm").append(setNull(json.LBwryxx[0].xm));
		$("#csrq").append(setNull(json.LBwryxx[0].csrq));
		$("#xbdm").append(setNull(json.LBwryxx[0].xbdm));
		$("#xb").append(setNull(json.LBwryxx[0].xb));
		$("#hjdxzqhdm").append(setNull(json.LBwryxx[0].hjdxzqhdm));
		$("#hjdxzqh").append(setNull(json.LBwryxx[0].hjdxzqh));
		$("#hjdxz").append(setNull(json.LBwryxx[0].hjdxz));
		$("#gmsfhm").append(setNull(json.LBwryxx[0].gmsfhm));
		$("#sgrq").append(setNull(json.LBwryxx[0].sgrq));
		$("#lzyy").append(setNull(json.LBwryxx[0].lzyy));
		$("#lzrq").append(setNull(json.LBwryxx[0].lzrq));
		$("#bz").append(setNull(json.LBwryxx[0].bz));
		$("#zt").append(setNull(json.LBwryxx[0].zt));
		$("#lrr").append(setNull(json.LBwryxx[0].lrr));
		$("#lrsj").append(setNull(json.LBwryxx[0].lrsj));
	}	
	*/
</script>
<input type="hidden" id="q_qyid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">保卫人员信息明细</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#bwryxx_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" cellpadding="3" cellspacing="0" class="detail" id="detail">
	<tr height="20">
		<td class="distd1" width="12%">姓名</td>
		<td class="detailtd2" width="21%"><span id="bwry_xm"></span></td>
		<td class="distd1" width="11%">身份证号</td>
		<td class="detailtd2" width="22%"><span id="bwry_gmsfhm"></span></td>
		<td class="distd1" width="13%">户籍地省市县</td>
		<td class="detailtd2" width="21%"><span id="bwry_hjdxzqh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">户籍地详址</td>
		<td class="detailtd2" colspan="3" style="width:372px"><span id="bwry_hjdxz"></span></td>
		<td class="distd1">上岗日期</td>
		<td class="detailtd2"><span id="bwry_sgrq"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">填报人</td>
		<td class="detailtd2"><span id="bwry_lrr"></span></td>
		<td class="distd1">填报时间</td>
		<td class="detailtd2" colspan="3"><span id="bwry_lrsj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1" valign="top">备注</td>
		<td class="detailtd2" colspan="5" style="width:681px"><span id="bwry_bz"></span></td>
	</tr>
</table>