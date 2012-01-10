<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_menucode").attr("value",dataid);
		setDetail();
	});
	function updatediv (json) { 
		$("#menucode").append(setNull(json.LMenu[0].menucode));
		$("#menuname").append(setNull(json.LMenu[0].menuname));
		$("#funcentry").append(setNull(json.LMenu[0].funcentry));
		$("#menufullcode").append(setNull(json.LMenu[0].menufullcode));
		$("#nodeorder").append(setNull(json.LMenu[0].nodeorder));
		$("#dparentmenuname").append(setNull(json.LMenu[0].parentmenuname));
			$("#menuTypeName").append(setNull(json.LMenu[0].menuTypeName));
	}
</script>
<input type="hidden" id="q_menucode">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">菜单详细信息</td>
      <td align="right" class="title1">
      <a href="#" id="closeDiv" onclick='$("#menu_detail").hideAndRemove("show");'class="close"></a>
      </td>
    </tr>
</table>
<table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
	<tr height="20">
		<td class="distd1" width="30%">菜单名称</td>
		<td class="detailtd2" width="70%"><span id="menuname"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">菜单代码</td>
		<td class="detailtd2"><span id="menucode"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">排列顺序</td>
		<td class="detailtd2"><span id="nodeorder"></span></td>
	</tr>
		<tr height="20">
		<td class="distd1">菜单类别</td>
		<td class="detailtd2" width="330px"><span id="menuTypeName"></span></td>
	</tr>
     <tr height="20">
		<td class="distd1">菜单连接</td>
		<td class="detailtd2" width="330px"><span id="funcentry"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">全路径代码</td>
		<td class="detailtd2"><span id="menufullcode"></span></td>
	</tr>
		<tr height="20">
		<td class="distd1">上级菜单</td>
		<td class="detailtd2"><span id="dparentmenuname"></span></td>
	</tr>
</table>