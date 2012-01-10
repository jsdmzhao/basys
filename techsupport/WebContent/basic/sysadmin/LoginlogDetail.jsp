<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_loginlogid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#loginlogid").append(setNull(json.LLoginlog[0].loginlogid));
		$("#loginuserid").append(setNull(json.LLoginlog[0].loginuserid));
		$("#useraccount").append(setNull(json.LLoginlog[0].useraccount));
		$("#username").append(setNull(json.LLoginlog[0].username));
		$("#loginunitcode").append(setNull(json.LLoginlog[0].loginunitcode));
		$("#loginunitname").append(setNull(json.LLoginlog[0].loginunitname));
		$("#loginip").append(setNull(json.LLoginlog[0].loginip));
		$("#loginmac").append(setNull(json.LLoginlog[0].loginmac));
		$("#logintiime").append(setNull(json.LLoginlog[0].logintiime));
		$("#quittime").append(setNull(json.LLoginlog[0].quittime));
	}	
</script>
<input type="hidden" id="q_loginlogid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">登录日志详细</td>
      <td align="right" class="title1">
     <a href="#" id="closeDiv" onclick='$("#loginlog_detail").hideAndRemove("show");' class="close"></a>
      </td>
    </tr>
</table>
<table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
	<tr height="20">
		<td width="10%" class="distd1">登录日志ID</td>
	  <td width="90%" class="detailtd2"><span id="loginlogid"></span></td>
  </tr>
	<tr height="20">
		<td class="distd1">登录用户ID</td>
		<td class="detailtd2"><span id="loginuserid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">登录用户名</td>
		<td class="detailtd2"><span id="useraccount"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">姓名</td>
		<td class="detailtd2"><span id="username"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">登录单位代码</td>
		<td class="detailtd2"><span id="loginunitcode"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">登录单位名称</td>
		<td class="detailtd2"><span id="loginunitname"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">登录IP</td>
		<td class="detailtd2"><span id="loginip"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">登录MAC</td>
		<td class="detailtd2"><span id="loginmac"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">登录时间</td>
		<td class="detailtd2"><span id="logintiime"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">退出时间</td>
		<td class="detailtd2"><span id="quittime"></span></td>
	</tr>
</table>