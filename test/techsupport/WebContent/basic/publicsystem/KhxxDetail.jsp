<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		daggleDiv(detailid);
		$("#q_khxxid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#khxxid").append(setNull(json.LKhxx[0].khxxid));
		$("#xm").append(setNull(json.LKhxx[0].xm));
		$("#lxdh").append(setNull(json.LKhxx[0].lxdh));
		$("#mzdm").append(setNull(json.LKhxx[0].mzdm));
		$("#minzu").append(setNull(json.LKhxx[0].minzu));
		$("#xbdm").append(setNull(json.LKhxx[0].xbdm));
		$("#xb").append(setNull(json.LKhxx[0].xb));
		$("#hjdxz").append(setNull(json.LKhxx[0].hjdxz));
		$("#cyzjdm").append(setNull(json.LKhxx[0].cyzjdm));
		$("#cyzj").append(setNull(json.LKhxx[0].cyzj));
		$("#zjhm").append(setNull(json.LKhxx[0].zjhm));
		$("#biduiflag").append(setNull(json.LKhxx[0].biduiflag));
		$("#zt").append(setNull(json.LKhxx[0].zt));
	}	
</script>
<input type="hidden" id="q_khxxid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$("#Khxx_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" cellpadding="3" cellspacing="0" class="detail" id="detail">
	<tr height="20">
		<td class="distd1">客户信息ID</td>
		<td class="detailtd2"><span id="khxxid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">姓名</td>
		<td class="detailtd2"><span id="xm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">联系电话</td>
		<td class="detailtd2"><span id="lxdh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">民族代码</td>
		<td class="detailtd2"><span id="mzdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">民族</td>
		<td class="detailtd2"><span id="minzu"></span></td>
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
		<td class="distd1">户籍地详址</td>
		<td class="detailtd2"><span id="hjdxz"></span></td>
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
		<td class="distd1">比对标志</td>
		<td class="detailtd2"><span id="biduiflag"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">状态</td>
		<td class="detailtd2"><span id="zt"></span></td>
	</tr>
</table>