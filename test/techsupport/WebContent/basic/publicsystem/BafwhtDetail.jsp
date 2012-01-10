<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_bafwhtid").attr("value",bafwht_dataid);
		bafwht_setDetail();
	}); 
	function bafwht_updatediv (json) { 
		$("#bafwgsmc").append(setNull(json.LBafwht[0].bafwgsmc));
		$("#baryzgzsmc").append(setNull(json.LBafwht[0].baryzgzsmc));
		$("#barypxjsrq").append(setNull(json.LBafwht[0].barypxjsrq).substr(0,10));
		$("#htbh").append(setNull(json.LBafwht[0].htbh));
		$("#qdrq").append(setNull(json.LBafwht[0].qdrq).substr(0,10));
		$("#jsrq").append(setNull(json.LBafwht[0].jsrq).substr(0,10));
		$("#htyxq").append(setNull(json.LBafwht[0].htyxq));
		$("#barypxnr").append(setNull(json.LBafwht[0].barypxnr));
		$("#balxmc").append(setNull(json.LBafwht[0].balxmc));
		$("#fzjgmc").append(setNull(json.LBafwht[0].fzjgmc));
	}	
</script>
<input type="hidden" id="q_bafwhtid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">保安服务详细信息</td>
      <td align="right" class="title1">
      <a href="#" id="closeDiv" onclick='$("#q_bafwhtid").parent().hideAndRemove("show");'class="close"></a>
      </td>
    </tr>
</table>

<table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
	<tr height="20">
		<td class="distd1" width="40%">保安服务公司名称</td>
		<td class="detailtd2" width="60%"><span id="bafwgsmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">合同编号</td>
		<td class="detailtd2"><span id="htbh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">签订日期</td>
		<td class="detailtd2"><span id="qdrq"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">结束日期</td>
		<td class="detailtd2"><span id="jsrq"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">合同有效期</td>
		<td class="detailtd2"><span id="htyxq"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">保安类型</td>
		<td class="detailtd2"><span id="balxmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">发证机构</td>
		<td class="detailtd2"><span id="fzjgmc"></span></td>
	</tr>
	<tr height="20">
      <td class="distd1">保安人员培训结束日期</td>
	  <td class="detailtd2"><span id="barypxjsrq"></span></td>
	</tr>
	<tr height="20">
      <td class="distd1">保安员资格证书编号</td>
	  <td class="detailtd2"><span id="baryzgzsmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">保安人员培训内容</td>
		<td class="detailtd2"><span id="barypxnr"></span></td>
	</tr>
</table>