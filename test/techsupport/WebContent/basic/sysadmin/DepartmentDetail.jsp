<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_departid").attr("value",dataid);
			setDetail();
	}); 	
	function updatediv (json) { 
		$("#departcode").append(setNull(json.LDepartment[0].departcode));
		$("#departname").append(setNull(json.LDepartment[0].departname));
		$("#dparentdepartname").append(setNull(json.LDepartment[0].parentdepartname)); 
		$("#nodeorder").append(setNull(json.LDepartment[0].nodeorder));
		$("#departfullcode").append(setNull(json.LDepartment[0].departfullcode)); 
	}	
</script>
<input type="hidden" id="q_departid">

<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">机构详细信息</td>
      <td align="right" class="title1">
      <a href="#" id="closeDiv" onclick='$("#department_detail").hideAndRemove("show");' class="close"></a>
      </td>
    </tr>
</table>
<table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
	<tr height="20">
		<td class="distd1" width="35%">机构名称</td>
		<td class="detailtd2" width="65%"><span id="departname"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">机构代码</td>
		<td class="detailtd2"><span id="departcode"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">上级机构</td>
	  <td class="detailtd2"><span id="dparentdepartname"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">排列顺序</td>
	  <td class="detailtd2"><span id="nodeorder"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">机构全路径代码</td>
		<td class="detailtd2" width="190px"><span id="departfullcode"></span></td>
	</tr>
</table>
