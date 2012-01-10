<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_wgtzrxxid").attr("value",wgtzrxx_dataid);
		wgtzrxx_setDetail();
	}); 
	function wgtzrxx_updatediv (json) { 
		$("#tzzxm").append(setNull(json.LWgtzrxx[0].tzzxm));
		$("#wgtzrLxdh").append(setNull(json.LWgtzrxx[0].lxdh));
		$("#gj").append(setNull(json.LWgtzrxx[0].gj));
		if(setNull(json.LWgtzrxx[0].gjdm)!=''){
			$("#gj").append('['+setNull(json.LWgtzrxx[0].gjdm)+']');
		}
		$("#qzzlmc").append(setNull(json.LWgtzrxx[0].qzzlmc));
		if(setNull(json.LWgtzrxx[0].qzzldm)!=''){
			$("#qzzlmc").append('['+setNull(json.LWgtzrxx[0].qzzldm)+']');
		}
		$("#qzhm").append(setNull(json.LWgtzrxx[0].qzhm));
		$("#hzzlmc").append(setNull(json.LWgtzrxx[0].hzzlmc));
		$("#hzhm").append(setNull(json.LWgtzrxx[0].hzhm));
	}	
</script>
<input type="hidden" id="q_wgtzrxxid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">境外投资者详细信息</td>
      <td align="right" class="title1">
      <a href="#" id="closeDiv" onclick='$("#wgtzrxx_detail").hideAndRemove("show");'class="close"></a>
      </td>
    </tr>
</table>

<table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
	<tr height="20">
		<td class="distd1" width="40%">境外投资者名称</td>
		<td class="detailtd2" width="60%"><span id="tzzxm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">国家和地区</td>
		<td class="detailtd2"><span id="gj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">有效证件种类</td>
		<td class="detailtd2"><span id="hzzlmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">有效证件号码</td>
		<td class="detailtd2"><span id="hzhm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">签证签注种类</td>
		<td class="detailtd2"><span id="qzzlmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">签证签注号码</td>
		<td class="detailtd2"><span id="qzhm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1" width="40%">联系电话</td>
		<td class="detailtd2" width="60%"><span id="wgtzrLxdh"></span></td>
	</tr>
</table>