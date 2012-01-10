<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_globalparcode").attr("value",dataid);
			setDetail();
	}); 
	
	function updatediv (json) { 
		$("#globalparcode").append(setNull(json.LGlobalpar[0].globalparcode));
		$("#globalparname").append(setNull(json.LGlobalpar[0].globalparname));
		$("#globalparvalue").append(setNull(json.LGlobalpar[0].globalparvalue));
	}	
</script>
<input type="hidden" id="q_globalparcode">
<div align="right"><table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td align="left" class="title1">全局参数详细</td>
      <td><a href="#" id="closeDiv" onclick='$("#globalpar_detail").hideAndRemove("show");'class="close"></a></td>
    </tr>
     <tr>
      <td align="left"></td>
      <td></td>
    </tr>
</table>	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="3"></td>
		</tr>
	</table></div>
<table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
	<tr height="20">
		<td class="distd1">参数编码</td>
		<td class="detailtd2"><span id="globalparcode"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">参数名称</td>
		<td class="detailtd2"><span id="globalparname"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">参数值</td>
		<td class="detailtd2"><span id="globalparvalue"></span></td>
	</tr>
</table>