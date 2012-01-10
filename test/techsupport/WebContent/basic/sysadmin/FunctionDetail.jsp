<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_funccode").attr("value",dataid);
			setDetail();
	}); 
	function updatediv (json) { 
		$("#funccode").append(setNull(json.LFunction[0].funccode));
		$("#funcname").append(setNull(json.LFunction[0].funcname));
		$("#funcdefine").append(setNull(json.LFunction[0].funcdefine));
		$("#functypename").append(setNull(json.LFunction[0].functypename));
	}	
</script>
<input type="hidden" id="q_funccode">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">功能详细信息</td>
      <td align="right" class="title1">
      <a href="#" id="closeDiv" onclick='$("#function_detail").hideAndRemove("show");'class="close"></a>
      </td>
    </tr>
</table>
<table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
	<tr height="20">
		<td class="distd1" width="30%">功能代码</td>
		<td class="detailtd2" width="70%"><span id="funccode"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">功能名称</td>
		<td class="detailtd2"><span id="funcname"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">功能链接</td>
		<td class="detailtd2" width="270px"><span id="funcdefine"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">功能类别</td>
		<td class="detailtd2"><span id="functypename"></span></td>
	</tr>
</table>