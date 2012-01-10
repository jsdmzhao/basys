<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_paramcode").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#paramcode").append(setNull(json.LParam[0].paramcode));
		$("#paramname").append(setNull(json.LParam[0].paramname));
		$("#paramvalue").append(setNull(json.LParam[0].paramvalue));
	}	
</script>
<input type="hidden" id="q_paramcode">
<div align="right"><a href="#" id="closeDiv" onclick='$("#param_detail").hideAndRemove("show");' class="close"></a></div>
<table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
	<tr height="20">
		<td class="distd1">参数编码</td>
		<td class="detailtd2"><span id="paramcode"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">参数名称</td>
		<td class="detailtd2"><span id="paramname"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">参数值</td>
		<td class="detailtd2"><span id="paramvalue"></span></td>
	</tr>
</table>