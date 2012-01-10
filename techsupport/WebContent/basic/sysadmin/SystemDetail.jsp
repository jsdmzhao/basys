<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_systemcode").attr("value",dataid);
		setDetail();
	}); 
	function updatediv (json) { 
		$("#systemcode").append(setNull(json.LSystem[0].systemcode));
		$("#systemname").append(setNull(json.LSystem[0].systemname));
		$("#systemdefine").append(setNull(json.LSystem[0].systemdefine));
		$("#picturepath").append(setNull(json.LSystem[0].picturepath));
		$("#nodeorder").append(setNull(json.LSystem[0].nodeorder));
		$("#fullcode").append(setNull(json.LSystem[0].fullcode));
		$("#dparentsystemname").append(setNull(json.LSystem[0].parentsystemname));
	}
</script>
<input type="hidden" id="q_systemcode">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">系统详细信息</td>
      <td align="right" class="title1">
      <a href="#" id="closeDiv" onclick='$("#system_detail").hideAndRemove("show");'class="close"></a>
      </td>
    </tr>
</table>
<table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
	<tr height="20">
		<td class="distd1" width="30%">系统名称</td>
		<td class="detailtd2" width="70%"><span id="systemname"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">系统代码</td>
		<td class="detailtd2"><span id="systemcode"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">系统定义</td>
	 	<td class="detailtd2"><span id="systemdefine"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">上级系统</td>
	  	<td class="detailtd2"><span id="dparentsystemname"></span></td>
	</tr>
	<tr height="20">
	  	<td class="distd1">排列顺序</td>
    	<td class="detailtd2"><span id="nodeorder"></span></td>
	</tr>
	<tr height="20">
	  	<td height="20" class="distd1">系统全路径代码</td>
	  	<td class="detailtd2" width="340px"><span id="fullcode"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">图片路径</td>
	 	<td class="detailtd2" width="340px"><span id="picturepath"></span></td>
	</tr>
</table>